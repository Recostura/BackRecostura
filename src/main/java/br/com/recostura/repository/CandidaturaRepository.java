package br.com.recostura.repository;

import br.com.recostura.entity.CandidaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidaturaRepository extends JpaRepository<CandidaturaEntity, Long> {
}
