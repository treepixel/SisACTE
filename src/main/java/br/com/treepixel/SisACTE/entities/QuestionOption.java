package br.com.treepixel.SisACTE.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.treepixel.SisACTE.entities.Question;


@Entity
@Table(name = "question_option")
public class QuestionOption implements Serializable {
	
private static final long serialVersionUID = -3927088463577061326L;
	
	private Long 						id;
	private String 						value;
	private Question					question;
	private List<Indicator>				indicators;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "option_indicator", 
    	joinColumns = { @JoinColumn(name = "optionId") }, 
    	inverseJoinColumns = { @JoinColumn(name = "indicatorId") 
    })
    @JsonIgnoreProperties("options")
	public List<Indicator> getIndicators() {
		return indicators;
	}
	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}
}
