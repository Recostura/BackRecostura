package br.com.recostura.controller;

import br.com.recostura.entity.AvaliacaoEntity;
import br.com.recostura.entity.ProfissionalEntity;
import br.com.recostura.service.AvaliacaoService;
import br.com.recostura.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/avaliacao")
@CrossOrigin(origins = "*")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<Page<AvaliacaoEntity>> buscarTodasAvaliacoes(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoService.buscarTodasAvaliacoes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoEntity> buscarAvaliacaoPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoService.buscarAvaliacaoPorId(id));
    }

    @PostMapping
    public ResponseEntity<AvaliacaoEntity> salvarAvaliacao(@RequestBody AvaliacaoEntity avaliacaoEntity) {
        avaliacaoService.salvarAvaliacao(avaliacaoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarAvaliacao(@PathVariable Long id) {
        avaliacaoService.deletarAvaliacao(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoEntity> atualizarAvaliacao(@PathVariable Long id, @RequestBody AvaliacaoEntity avaliacaoEntity) {
        avaliacaoService.atualizarAvaliacao(id, avaliacaoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
