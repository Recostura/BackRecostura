package br.com.recostura.repository;

import br.com.recostura.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteEntity, Long> {

}
