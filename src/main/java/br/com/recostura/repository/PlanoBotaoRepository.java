package br.com.recostura.repository;


import br.com.recostura.entity.PlanoBotaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoBotaoRepository extends JpaRepository<PlanoBotaoEntity, Long> {
}
