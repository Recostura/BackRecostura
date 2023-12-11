package br.com.recostura.service;

import br.com.recostura.entity.ClienteEntity;
import br.com.recostura.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ClienteEntity salvarCliente(ClienteEntity clienteEntity){
        ClienteEntity cliente = new ClienteEntity();
        return clienteRepository.save(cliente);
    }

    public Page<ClienteEntity> buscarTodosClientes(Pageable pageable) {return clienteRepository.findAll(pageable);}

    public ClienteEntity buscarClientePorId(Long id){
        Optional<ClienteEntity> cliente = Optional.of(clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("O cliente solicitado nao foi encontrado")));
        ClienteEntity clienteEntity = cliente.get();
        return clienteEntity;
    }

    @Transactional
    public void deletarCliente(Long id){
        buscarClientePorId(id);
        clienteRepository.deleteById(id);
    }

    @Transactional
    public ClienteEntity atualizarCliente(Long id, ClienteEntity clienteEntity){
        Optional<ClienteEntity> cliente = Optional.of(clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O cliente solicitado nao foi encontrado")));
        ClienteEntity entity = new ClienteEntity();
        return clienteRepository.save(cliente.get());

    }
}
