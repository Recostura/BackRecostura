package br.com.recostura.repository;

import br.com.recostura.entity.PlanoBotaoEntity;
import br.com.recostura.entity.PlanoRetalhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRetalhoRepository extends JpaRepository<PlanoRetalhoEntity, Long> {

}
