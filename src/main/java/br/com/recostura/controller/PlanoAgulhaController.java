package br.com.recostura.controller;

import br.com.recostura.entity.PlanoAgulhaEntity;
import br.com.recostura.service.PlanoAgulhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/plano_agulha")
@CrossOrigin("*")
public class PlanoAgulhaController {

    @Autowired
    private PlanoAgulhaService planoAgulhaService;

    @GetMapping
    public ResponseEntity<Page<PlanoAgulhaEntity>> buscarTodosPlanosAgulha(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(planoAgulhaService.buscarTodosPlanosAgulha(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoAgulhaEntity> buscarPlanoAgulhaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(planoAgulhaService.buscarPlanoAgulhaPorId(id));
    }

    @PostMapping
    public ResponseEntity<PlanoAgulhaEntity> salvarPlanoAgulha(@RequestBody PlanoAgulhaEntity planoAgulhaEntity) {
        planoAgulhaService.salvarPlanoAgulha(planoAgulhaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarPlanoAgulha(@PathVariable Long id) {
        planoAgulhaService.deletarPlanoAgulha(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoAgulhaEntity> atualizarPlanoAgulha(@PathVariable Long id, @RequestBody PlanoAgulhaEntity planoAgulhaEntity) {
        planoAgulhaService.atualizarPlanoAgulha(id, planoAgulhaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
