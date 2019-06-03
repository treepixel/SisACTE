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
import br.com.treepixel.SisACTE.entities.Denunciation;


@Entity
@Table(name = "state")
@JsonIgnoreProperties({ "denunciations"})
public class State implements Serializable {

	private static final long serialVersionUID = 7614269641082723826L;
	
	private Integer id;
	private String name;
	private String uf;
	private List<Denunciation> denunciations;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@OneToMany(mappedBy = "employerUf", fetch = FetchType.LAZY )
	public List<Denunciation> getDenunciations() {
		return denunciations;
	}

	public void setDenunciations(List<Denunciation> denunciations) {
		this.denunciations = denunciations;
	}
	
}