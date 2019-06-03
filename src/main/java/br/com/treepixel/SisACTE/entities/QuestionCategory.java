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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.treepixel.SisACTE.entities.Question;

@Entity
@Table(name = "question_category")
public class QuestionCategory implements Serializable  {
	
private static final long serialVersionUID = 1015220928491622057L;
	
	private Long 					id;
	private String					title;
	private List<Question> 			questions;
	
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
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER )
	@JsonManagedReference
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
