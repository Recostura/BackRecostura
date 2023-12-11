package br.com.recostura.controller;

import br.com.recostura.entity.CandidaturaEntity;
import br.com.recostura.service.CandidaturaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/candidatura")
@CrossOrigin("*")
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    @GetMapping
    public ResponseEntity<Page<CandidaturaEntity>> buscarTodasCandidaturas(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(candidaturaService.buscarTodasCandidaturas(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidaturaEntity> buscarCandidaturaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(candidaturaService.buscarCandidaturaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CandidaturaEntity> salvarCandidatura(@RequestBody CandidaturaEntity candidaturaEntity) {
        candidaturaService.salvarCandidatura(candidaturaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarCandidatura(@PathVariable Long id) {
        candidaturaService.deletarCandidatura(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidaturaEntity> atualizarCandidatura(@PathVariable Long id, @RequestBody CandidaturaEntity candidaturaEntity) {
        candidaturaService.atualizarCandidatura(id, candidaturaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
