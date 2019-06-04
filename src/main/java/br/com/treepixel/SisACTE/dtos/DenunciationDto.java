package br.com.treepixel.SisACTE.dtos;

import java.util.Date;
import java.util.List;

import com.vividsolutions.jts.geom.Point;

import br.com.treepixel.SisACTE.entities.City;
import br.com.treepixel.SisACTE.entities.Indicator;
import br.com.treepixel.SisACTE.entities.Quiz;
import br.com.treepixel.SisACTE.entities.State;

public class DenunciationDto {
	
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
    private List<Quiz> 							quiz;
    private List<Indicator>						indicators;
    private Integer								score;
    private String								status;
    private Boolean								archived;
    private Date 								createdAt;
    private Date 								updatedAt;
    private String								updatedBy;
	
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getEmployerAddress() {
		return employerAddress;
	}
	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}
	public City getEmployerCity() {
		return employerCity;
	}
	public void setEmployerCity(City employerCity) {
		this.employerCity = employerCity;
	}
	public State getEmployerUf() {
		return employerUf;
	}
	public void setEmployerUf(State employerUf) {
		this.employerUf = employerUf;
	}
	public Double getEmployerLong() {
		return employerLong;
	}
	public void setEmployerLong(Double employerLong) {
		this.employerLong = employerLong;
	}
	public Double getEmployerLat() {
		return employerLat;
	}
	public void setEmployerLat(Double employerLat) {
		this.employerLat = employerLat;
	}
	public Point getEmployerPosition() {
		return employerPosition;
	}
	public void setEmployerPosition(Point employerPosition) {
		this.employerPosition = employerPosition;
	}
	public Date getEmployerFinishActivity() {
		return employerFinishActivity;
	}
	public void setEmployerFinishActivity(Date employerFinishActivity) {
		this.employerFinishActivity = employerFinishActivity;
	}
	public String getEmployerMoreInformation() {
		return employerMoreInformation;
	}
	public void setEmployerMoreInformation(String employerMoreInformation) {
		this.employerMoreInformation = employerMoreInformation;
	}
	public String getDenunciatorName() {
		return denunciatorName;
	}
	public void setDenunciatorName(String denunciatorName) {
		this.denunciatorName = denunciatorName;
	}
	public String getDenunciatorCPF() {
		return denunciatorCPF;
	}
	public void setDenunciatorCPF(String denunciatorCPF) {
		this.denunciatorCPF = denunciatorCPF;
	}
	public String getDenunciatorGenre() {
		return denunciatorGenre;
	}
	public void setDenunciatorGenre(String denunciatorGenre) {
		this.denunciatorGenre = denunciatorGenre;
	}
	public String getDenunciatorAddress() {
		return denunciatorAddress;
	}
	public void setDenunciatorAddress(String denunciatorAddress) {
		this.denunciatorAddress = denunciatorAddress;
	}
	public String getDenunciatorNeighborhood() {
		return denunciatorNeighborhood;
	}
	public void setDenunciatorNeighborhood(String denunciatorNeighborhood) {
		this.denunciatorNeighborhood = denunciatorNeighborhood;
	}
	public String getDenunciatorPhone() {
		return denunciatorPhone;
	}
	public void setDenunciatorPhone(String denunciatorPhone) {
		this.denunciatorPhone = denunciatorPhone;
	}
	public String getDenunciatorCelphone() {
		return denunciatorCelphone;
	}
	public void setDenunciatorCelphone(String denunciatorCelphone) {
		this.denunciatorCelphone = denunciatorCelphone;
	}
	public String getDenunciatorEmail() {
		return denunciatorEmail;
	}
	public void setDenunciatorEmail(String denunciatorEmail) {
		this.denunciatorEmail = denunciatorEmail;
	}
	public String getDenunciatorMoreInformation() {
		return denunciatorMoreInformation;
	}
	public void setDenunciatorMoreInformation(String denunciatorMoreInformation) {
		this.denunciatorMoreInformation = denunciatorMoreInformation;
	}
	public List<Quiz> getQuiz() {
		return quiz;
	}
	public void setQuiz(List<Quiz> quiz) {
		this.quiz = quiz;
	}
	public List<Indicator> getIndicators() {
		return indicators;
	}
	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getArchived() {
		return archived;
	}
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
