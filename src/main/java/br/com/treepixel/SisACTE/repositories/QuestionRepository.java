package br.com.treepixel.SisACTE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treepixel.SisACTE.entities.Question;

public interface QuestionRepository  extends JpaRepository<Question, Long> {

}
