package br.com.recostura.repository;

import br.com.recostura.entity.ServicoEntiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<ServicoEntiy, Long> {

}
