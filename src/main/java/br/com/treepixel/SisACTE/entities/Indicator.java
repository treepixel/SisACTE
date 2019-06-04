package br.com.treepixel.SisACTE.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "indicator")
public class Indicator implements Serializable {
	
	private static final long serialVersionUID = -1358101016316089831L;

	private Long 						id;
	private String 						text;
	private Integer 					weight;
	private String 						status;
	private IndicatorCategory			category;
	private List<Denunciation>			denunciation;
	private List<QuestionOption>		options;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Column
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	@Column
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public IndicatorCategory getCategory() {
		return category;
	}
	public void setCategory(IndicatorCategory category) {
		this.category = category;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "indicators")
	@JsonIgnore
	public List<Denunciation> getDenunciation() {
		return denunciation;
	}
	public void setDenunciation(List<Denunciation> denunciation) {
		this.denunciation = denunciation;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "indicators")
	@JsonIgnoreProperties("indicators")
	public List<QuestionOption> getOptions() {
		return options;
	}
	public void setOptions(List<QuestionOption> options) {
		this.options = options;
	}	
	
}
