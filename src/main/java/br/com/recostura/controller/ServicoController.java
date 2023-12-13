package br.com.recostura.controller;

import br.com.recostura.entity.ServicoEntity;
import br.com.recostura.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/servico")
@CrossOrigin(origins = "*")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Page<ServicoEntity>> buscarTodosServicos(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.buscarTodosServicos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoEntity> buscarServicoPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.buscarServicoPorId(id));
    }

    @PostMapping
    public ResponseEntity<ServicoEntity> salvarServico(@RequestBody ServicoEntity servicoEntity) {
        servicoService.salvarServico(servicoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarServico(@PathVariable Long id) {
        servicoService.deletarServico(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoEntity> atualizarServico(@PathVariable Long id, @RequestBody ServicoEntity servicoEntity) {
        servicoService.atualizarServico(id, servicoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
