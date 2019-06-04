package br.com.treepixel.SisACTE.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.treepixel.SisACTE.entities.Denunciation;
import br.com.treepixel.SisACTE.entities.Indicator;
import br.com.treepixel.SisACTE.entities.Quiz;
import br.com.treepixel.SisACTE.repositories.DenunciationRepository;
import br.com.treepixel.SisACTE.specifications.DenunciationSpecification;


@Service(value = "DenunciationService")
public class DenunciationService {
	
	@Autowired
	private DenunciationRepository denunciationRepository;
	
	private Integer score;
	
	public Denunciation save(Denunciation denunciation) {
		
		score = 0;	
		
		List<Quiz> quiz = new ArrayList<>();
		for(Quiz question : denunciation.getQuiz()) {
			question.setDenunciation(denunciation);
			quiz.add(question);
		}
		
		List<Indicator> indicators = new ArrayList<>();
		for(Indicator indicator : denunciation.getIndicators()) {
			indicator.getDenunciation().add(denunciation);
			indicators.add(indicator);
			score += indicator.getWeight();
		}
		
		denunciation.setScore(score);
		denunciation.setQuiz(quiz);
		denunciation.setIndicators(indicators);
		
		return denunciationRepository.save(denunciation);
	}
	
	public Page<Denunciation> getAll(Map<String, String> queryParameters, Pageable pageable){
		Specification<Denunciation> spec = new DenunciationSpecification(queryParameters);
		return denunciationRepository.findAll(spec, pageable);
	}
}
