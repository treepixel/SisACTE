package br.com.treepixel.SisACTE.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "indicator_category")
public class IndicatorCategory implements Serializable {
	
private static final long serialVersionUID = 8058000928240137107L;
	
	private Long					id;
	private String					title;
	private List<Indicator>			indicators;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("category")
	public List<Indicator> getIndicators() {
		return indicators;
	}
	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}
	
}
