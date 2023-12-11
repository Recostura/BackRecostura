package br.com.recostura.controller;

import br.com.recostura.entity.PessoaEntity;
import br.com.recostura.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/pessoa")
@CrossOrigin (origins = "*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Page<PessoaEntity>> buscarTodasPessoas(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarTodasPessoas(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaEntity> buscarPessoaPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaPorId(id));
    }

    @PostMapping
    public ResponseEntity<PessoaEntity> salvarPessoa(@RequestBody PessoaEntity pessoaEntity) {
        pessoaService.salvarPessoa(pessoaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaEntity> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaEntity pessoaEntity){
        pessoaService.atualizarPessoa(id, pessoaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}