package br.com.recostura.controller;

import br.com.recostura.entity.PlanoBotaoEntity;
import br.com.recostura.service.PlanoBotaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/plano_botao")
@CrossOrigin("*")
public class PlanoBotaoController {
    @Autowired
    private PlanoBotaoService planoBotaoService;

    @GetMapping
    public ResponseEntity<Page<PlanoBotaoEntity>> buscarTodosPlanosBotoes(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(planoBotaoService.buscarTodosPlanosBotoes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoBotaoEntity> buscarPlanoBotaoPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(planoBotaoService.buscarPlanoBotaoPorId(id));
    }

    @PostMapping
    public ResponseEntity<PlanoBotaoEntity> salvarPlanoBotao(@RequestBody PlanoBotaoEntity planoBotaoEntity) {
        planoBotaoService.salvarPlanoBotao(planoBotaoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarPlanoBotao(@PathVariable Long id) {
        planoBotaoService.deletarPlanoBotao(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoBotaoEntity> atualizarPlanoBotao(@PathVariable Long id, @RequestBody PlanoBotaoEntity planoBotaoEntity) {
        planoBotaoService.atualizarPlanoBotao(id, planoBotaoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
