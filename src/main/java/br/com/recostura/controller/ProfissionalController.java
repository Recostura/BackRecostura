package br.com.recostura.controller;

import br.com.recostura.entity.ProfissionalEntity;
import br.com.recostura.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/profissional")
@CrossOrigin(origins = "*")
public class ProfissionalController {
    @Autowired
private ProfissionalService profissionalService;

    @GetMapping
    public ResponseEntity<Page<ProfissionalEntity>> buscarTodosProfissionais(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(profissionalService.buscarTodosProfissionais(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalEntity> buscarProfissionalPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(profissionalService.buscarProfissionalPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProfissionalEntity> salvarProfissional(@RequestBody ProfissionalEntity profissionalEntity) {
        profissionalService.salvarProfissional(profissionalEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarProfissional(@PathVariable Long id){
        profissionalService.deletarProfissional(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalEntity> atualizarProfissional(@PathVariable Long id, @RequestBody ProfissionalEntity profissionalEntity){
        profissionalService.atualizarProfissional(id, profissionalEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
