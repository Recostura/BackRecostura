package br.com.recostura.repository;

import br.com.recostura.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <PessoaEntity, Long> {

}
