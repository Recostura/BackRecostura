package br.com.recostura.service;

import br.com.recostura.entity.PlanoBotaoEntity;
import br.com.recostura.repository.PlanoBotaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanoBotaoService {

    @Autowired
    private PlanoBotaoRepository planoBotaoRepository;

    @Transactional
    public PlanoBotaoEntity salvarPlanoBotao(PlanoBotaoEntity planoBotaoEntity) {
        PlanoBotaoEntity planoBotao = new PlanoBotaoEntity();
        return planoBotaoRepository.save(planoBotao);
    }

    public Page<PlanoBotaoEntity> buscarTodosPlanosBotoes(Pageable pageable) {
        return planoBotaoRepository.findAll(pageable);
    }

    public PlanoBotaoEntity buscarPlanoBotaoPorId(Long id) {
        Optional<PlanoBotaoEntity> planoBotao = Optional.of(planoBotaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O PlanoBotao solicitado não foi encontrado")));
        PlanoBotaoEntity planoBotaoEntity = planoBotao.get();
        return planoBotaoEntity;
    }

    @Transactional
    public void deletarPlanoBotao(Long id) {
        buscarPlanoBotaoPorId(id);
        planoBotaoRepository.deleteById(id);
    }

    @Transactional
    public PlanoBotaoEntity atualizarPlanoBotao(Long id, PlanoBotaoEntity planoBotaoEntity) {
        Optional<PlanoBotaoEntity> planoBotao = Optional.of(planoBotaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O PlanoBotao solicitado não foi encontrado")));
        PlanoBotaoEntity entity = new PlanoBotaoEntity();
        return planoBotaoRepository.save(planoBotao.get());
    }

}
