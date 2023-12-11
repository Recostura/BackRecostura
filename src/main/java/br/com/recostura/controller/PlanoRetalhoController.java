package br.com.recostura.controller;

import br.com.recostura.entity.PlanoRetalhoEntity;
import br.com.recostura.service.PlanoRetalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/planoretalho")
@CrossOrigin("*")
public class PlanoRetalhoController {

    @Autowired
    private PlanoRetalhoService planoRetalhoService;

    @GetMapping
    public ResponseEntity<Page<PlanoRetalhoEntity>> buscarTodosPlanosRetalho(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(planoRetalhoService.buscarTodosPlanosRetalho(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoRetalhoEntity> buscarPlanoRetalhoPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(planoRetalhoService.buscarPlanoRetalhoPorId(id));
    }

    @PostMapping
    public ResponseEntity<PlanoRetalhoEntity> salvarPlanoRetalho(@RequestBody PlanoRetalhoEntity planoRetalhoEntity) {
        planoRetalhoService.salvarPlanoRetalho(planoRetalhoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarPlanoRetalho(@PathVariable Long id) {
        planoRetalhoService.deletarPlanoRetalho(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoRetalhoEntity> atualizarPlanoRetalho(@PathVariable Long id, @RequestBody PlanoRetalhoEntity planoRetalhoEntity) {
        planoRetalhoService.atualizarPlanoRetalho(id, planoRetalhoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
