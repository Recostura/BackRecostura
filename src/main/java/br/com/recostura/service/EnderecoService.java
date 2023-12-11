package br.com.recostura.service;

import br.com.recostura.entity.EnderecoEntity;
import br.com.recostura.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public EnderecoEntity salvarEndereco(EnderecoEntity enderecoEntity){
        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setCep(enderecoEntity.getCep());
        endereco.setCidade(enderecoEntity.getCidade());
        endereco.setEstado(enderecoEntity.getEstado());
        endereco.setLogradouro(enderecoEntity.getLogradouro());
        return enderecoRepository.save(endereco);
    }

    public Page<EnderecoEntity> buscarTodosEnderecos(Pageable pageable) {
        return enderecoRepository.findAll(pageable);
    }

    public EnderecoEntity buscarEnderecoPorId(Long id) {
        Optional<EnderecoEntity> endereco = Optional.of(enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("O endereco nao foi encontrado")));
        EnderecoEntity enderecoEntity = endereco.get();
        return enderecoEntity;
    }

        @Transactional
        public void deletarEndereco(Long id){
            buscarEnderecoPorId(id);
            enderecoRepository.deleteById(id);
        }

    @Transactional
    public EnderecoEntity atualizarEndereco(Long id, EnderecoEntity enderecoEntity){
        Optional<EnderecoEntity> endereco = Optional.of(enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O endereco informado nao foi encontrado")));
        EnderecoEntity entity = new EnderecoEntity();
        entity.setCep(enderecoEntity.getCep());
        entity.setCidade(enderecoEntity.getCidade());
        entity.setEstado(enderecoEntity.getEstado());
        entity.setLogradouro(enderecoEntity.getLogradouro());
        return enderecoRepository.save(endereco.get());
    }

}