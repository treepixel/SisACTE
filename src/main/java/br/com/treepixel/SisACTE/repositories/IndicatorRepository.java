package br.com.treepixel.SisACTE.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.treepixel.SisACTE.entities.Indicator;

public interface IndicatorRepository extends PagingAndSortingRepository<Indicator, Long>, JpaSpecificationExecutor<Indicator> {

}
