package br.com.treepixel.SisACTE.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.treepixel.SisACTE.entities.Denunciation;

public class City implements Serializable {

	private static final long serialVersionUID = 7107954996958653104L;
	
	private Integer id;
	private String name;
	private Integer uf;
	private Float latitude;
	private Float longitude;
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
	public Integer getUf() {
		return uf;
	}
	public void setUf(Integer uf) {
		this.uf = uf;
	}
	
	@Column
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	
	@Column
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	public List<Denunciation> getDenunciations() {
		return denunciations;
	}
	public void setDenunciations(List<Denunciation> denunciations) {
		this.denunciations = denunciations;
	}
	
}
