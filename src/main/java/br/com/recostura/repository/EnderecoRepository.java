package br.com.recostura.repository;

import br.com.recostura.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository <EnderecoEntity, Long> {

}
