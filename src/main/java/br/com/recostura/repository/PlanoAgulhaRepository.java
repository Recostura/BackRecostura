package br.com.recostura.repository;

import br.com.recostura.entity.PlanoAgulhaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoAgulhaRepository extends JpaRepository<PlanoAgulhaEntity, Long> {
}
