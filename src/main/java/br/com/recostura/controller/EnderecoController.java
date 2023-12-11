package br.com.recostura.controller;


import br.com.recostura.entity.EnderecoEntity;
import br.com.recostura.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/endereco")
@CrossOrigin (origins = "*")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<Page<EnderecoEntity>> buscarTodosEnderecos(@PageableDefault(size = 20)Pageable pageable) {
    return  ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarTodosEnderecos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoEntity> buscarEnderecosPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecoPorId(id));
    }

    @PostMapping
    public ResponseEntity<EnderecoEntity> salvarEndereco(@RequestBody EnderecoEntity enderecoEntity) {
        enderecoService.salvarEndereco(enderecoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarEndereco(@PathVariable Long id){
        enderecoService.deletarEndereco(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoEntity> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoEntity enderecoEntity) {
        enderecoService.atualizarEndereco(id, enderecoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
