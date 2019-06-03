package br.com.treepixel.SisACTE.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "denunciation")
public class Denunciation implements Serializable {

	private static final long serialVersionUID = 5696897952182823517L;
	
	private Long 								id;
    private String 								employerName;
    private String 								employerAddress;
    private City								employerCity;
    private State								employerUf;
    private Double 								employerLong;
    private Double 								employerLat;
    private Point 								employerPosition;
    private Date								employerFinishActivity;
    private String 								employerMoreInformation;
    private String 								denunciatorName;
    private String 								denunciatorCPF;
    private String 								denunciatorGenre;
    private String 								denunciatorAddress;
    private String 								denunciatorNeighborhood;
    private String								denunciatorPhone;
    private String								denunciatorCelphone;
    private String								denunciatorEmail;
    private String								denunciatorMoreInformation;
    private String								status;
    private Boolean								archived;
    private Date 								createdAt;
    private Date 								updatedAt;
    private String								updatedBy;
	
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	
	@Column
	public String getEmployerAddress() {
		return employerAddress;
	}
	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public City getEmployerCity() {
		return employerCity;
	}
	public void setEmployerCity(City employerCity) {
		this.employerCity = employerCity;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public State getEmployerUf() {
		return employerUf;
	}
	public void setEmployerUf(State employerUf) {
		this.employerUf = employerUf;
	}
	
	@Column
	public Double getEmployerLong() {
		return employerLong;
	}
	public void setEmployerLong(Double employerLong) {
		this.employerLong = employerLong;
	}
	
	@Column
	public Double getEmployerLat() {
		return employerLat;
	}
	public void setEmployerLat(Double employerLat) {
		this.employerLat = employerLat;
	}
	
	@Column
	@JsonIgnore
	public Point getEmployerPosition() {
		return employerPosition;
	}
	public void setEmployerPosition(Point employerPosition) {
		this.employerPosition = employerPosition;
	}
	
	@Column
	public Date getEmployerFinishActivity() {
		return employerFinishActivity;
	}
	public void setEmployerFinishActivity(Date employerFinishActivity) {
		this.employerFinishActivity = employerFinishActivity;
	}
	
	@Column
	public String getEmployerMoreInformation() {
		return employerMoreInformation;
	}
	public void setEmployerMoreInformation(String employerMoreInformation) {
		this.employerMoreInformation = employerMoreInformation;
	}
	
	@Column
	public String getDenunciatorName() {
		return denunciatorName;
	}
	public void setDenunciatorName(String denunciatorName) {
		this.denunciatorName = denunciatorName;
	}
	
	@Column
	public String getDenunciatorCPF() {
		return denunciatorCPF;
	}
	public void setDenunciatorCPF(String denunciatorCPF) {
		this.denunciatorCPF = denunciatorCPF;
	}
	
	@Column
	public String getDenunciatorGenre() {
		return denunciatorGenre;
	}
	public void setDenunciatorGenre(String denunciatorGenre) {
		this.denunciatorGenre = denunciatorGenre;
	}
	
	@Column
	public String getDenunciatorAddress() {
		return denunciatorAddress;
	}
	public void setDenunciatorAddress(String denunciatorAddress) {
		this.denunciatorAddress = denunciatorAddress;
	}
	
	@Column
	public String getDenunciatorNeighborhood() {
		return denunciatorNeighborhood;
	}
	public void setDenunciatorNeighborhood(String denunciatorNeighborhood) {
		this.denunciatorNeighborhood = denunciatorNeighborhood;
	}
	
	@Column
	public String getDenunciatorPhone() {
		return denunciatorPhone;
	}
	public void setDenunciatorPhone(String denunciatorPhone) {
		this.denunciatorPhone = denunciatorPhone;
	}
	
	@Column
	public String getDenunciatorCelphone() {
		return denunciatorCelphone;
	}
	public void setDenunciatorCelphone(String denunciatorCelphone) {
		this.denunciatorCelphone = denunciatorCelphone;
	}
	
	@Column
	public String getDenunciatorEmail() {
		return denunciatorEmail;
	}
	public void setDenunciatorEmail(String denunciatorEmail) {
		this.denunciatorEmail = denunciatorEmail;
	}
	
	@Column
	public String getDenunciatorMoreInformation() {
		return denunciatorMoreInformation;
	}
	public void setDenunciatorMoreInformation(String denunciatorMoreInformation) {
		this.denunciatorMoreInformation = denunciatorMoreInformation;
	}
	
	@Column
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column
	public Boolean getArchived() {
		return archived;
	}
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	
	@Column
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Column
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Column
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		createdAt = atual;
		updatedAt = atual;
	}
}
