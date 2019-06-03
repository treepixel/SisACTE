package br.com.treepixel.SisACTE.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.treepixel.SisACTE.entities.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	@Query("SELECT p FROM City p WHERE  LOWER(unaccent(p.name)) like LOWER(unaccent(CONCAT('%',:name, '%'))) AND p.uf = :uf")
	public List<City> findByName(@Param("name") String nome, @Param("uf") Integer uf); 
}

