package br.com.recostura.repository;

import br.com.recostura.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Long> {

}
