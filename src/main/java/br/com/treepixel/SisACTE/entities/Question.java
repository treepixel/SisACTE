package br.com.treepixel.SisACTE.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.treepixel.SisACTE.entities.QuestionCategory;

@Entity
@Table(name = "question")
public class Question implements Serializable {
	
	private static final long serialVersionUID = 8900355407017552296L;
	
	private Long 						id;
	private String 						statement;
	private Boolean						required;
	private String 						type;
	private Integer 					orderPosition;
	private QuestionCategory 			category;
	private List<QuestionOption>		options;
	private Date 						createdAt;
	private Date 						updatedAt;
	private String						status;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	@Column
	public Boolean getRequired() {
		return required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
	}
	
	@Column
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column	
	public Integer getOrderPosition() {
		return orderPosition;
	}
	public void setOrderPosition(Integer orderPosition) {
		this.orderPosition = orderPosition;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	public QuestionCategory getCategory() {
		return category;
	}
	public void setCategory(QuestionCategory category) {
		this.category = category;
	}
	
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true )
	@JsonManagedReference	
	public List<QuestionOption> getOptions() {
		return options;
	}
	public void setOptions(List<QuestionOption> options) {
		this.options = options;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
