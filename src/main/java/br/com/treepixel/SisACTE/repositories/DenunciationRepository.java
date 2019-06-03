package br.com.treepixel.SisACTE.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.treepixel.SisACTE.entities.Denunciation;

public interface DenunciationRepository extends PagingAndSortingRepository<Denunciation, Long>, JpaSpecificationExecutor<Denunciation> {

}
