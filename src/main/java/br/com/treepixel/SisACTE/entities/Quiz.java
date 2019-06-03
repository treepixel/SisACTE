package br.com.treepixel.SisACTE.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;

@Entity
@Table(name = "quiz")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class Quiz implements Serializable{
	
	private static final long serialVersionUID = 2574755660892810925L;

    private Long 					id;
	private Denunciation	 		denunciation;
	private String 					question;
	private JsonNode	 			answer;
	private String					category;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	public Denunciation getDenunciation() {
		return denunciation;
	}
	public void setDenunciation(Denunciation denunciation) {
		this.denunciation = denunciation;
	}
	
	@Column
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Type( type = "jsonb-node" )
    @Column(columnDefinition = "jsonb")
	public JsonNode getAnswer() {
		return answer;
	}
	public void setAnswer(JsonNode answer) {
		this.answer = answer;
	}
	
	@Column
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
