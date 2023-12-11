package br.com.recostura.repository;

import br.com.recostura.entity.ProfissionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, Long> {

}
