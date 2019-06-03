package br.com.treepixel.SisACTE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treepixel.SisACTE.entities.QuestionCategory;

public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, Long> {

}
