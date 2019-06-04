package br.com.treepixel.SisACTE.controllers;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.treepixel.SisACTE.dtos.DenunciationDto;
import br.com.treepixel.SisACTE.entities.Denunciation;
import br.com.treepixel.SisACTE.services.DenunciationService;

@RestController
@RequestMapping("/api")
public class DenunciationController {
	
	@Autowired
	private DenunciationService denunciationService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@RequestMapping(value ="/denunciations", method = RequestMethod.GET)
	public ResponseEntity<?> listAll(@RequestParam Map<String, String> queryParameters, HttpServletRequest request, Pageable pageable) {
		return new ResponseEntity<>(denunciationService.getAll(queryParameters, pageable), HttpStatus.OK );
	}
	
	@RequestMapping(value ="/denunciation", method = RequestMethod.POST)
    @ResponseBody
	public ResponseEntity<?> create(@RequestBody DenunciationDto denunciationDto,  HttpServletRequest request) throws ParseException{	
		Denunciation denunciation = convertToEntity(denunciationDto);
		Denunciation denunciationCreated = denunciationService.save(denunciation);
		return new ResponseEntity<>(convertToDto(denunciationCreated), HttpStatus.OK );
	}
	
	private DenunciationDto convertToDto(Denunciation denunciation) {
	    DenunciationDto denunciationDto = modelMapper.map(denunciation, DenunciationDto.class);
	    return denunciationDto;
	}
	
	private Denunciation convertToEntity(DenunciationDto denunciationDto) throws ParseException {
	    Denunciation denunciation = modelMapper.map(denunciationDto, Denunciation.class);
	    return denunciation;
	}
}
