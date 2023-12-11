package br.com.recostura.controller;

import br.com.recostura.entity.ClienteEntity;
import br.com.recostura.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recostura/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<ClienteEntity>> buscarTodosClientes(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarTodosClientes(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> buscarClientesPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarClientePorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> salvarCliente(@RequestBody ClienteEntity clienteEntity) {
        clienteService.salvarCliente(clienteEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> atualizarCliente(@PathVariable Long id, @RequestBody ClienteEntity clienteEntity) {
        clienteService.atualizarCliente(id, clienteEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
