package br.com.recostura.service;

import br.com.recostura.entity.PessoaEntity;
import br.com.recostura.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public PessoaEntity salvarPessoa(PessoaEntity pessoaEntity){
        PessoaEntity pessoa = new PessoaEntity();
        pessoa.setNomeCompleto(pessoaEntity.getNomeCompleto());
        pessoa.setEmail(pessoaEntity.getEmail());
        pessoa.setSenha(pessoaEntity.getSenha());
        pessoa.setDataNascimento(pessoaEntity.getDataNascimento());
        pessoa.setGenero(pessoaEntity.getGenero());
        pessoa.setTelefone(pessoaEntity.getTelefone());
        pessoa.setEmail(pessoaEntity.getEmail());
        pessoa.setNacionalidade(pessoaEntity.getNacionalidade());
        pessoa.setProfissao(pessoaEntity.getProfissao());
        pessoa.setIdentidade(pessoaEntity.getIdentidade());
        pessoa.setCpf(pessoaEntity.getCpf());
        return pessoaRepository.save(pessoa);
    }

    public Page<PessoaEntity> buscarTodasPessoas(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    public PessoaEntity buscarPessoaPorId(Long id){
        Optional<PessoaEntity> pessoa = Optional.of(pessoaRepository.findById(id).orElseThrow(()->new RuntimeException("A pessoa informada nao foi encontrada")));
        PessoaEntity pessoaEntity = pessoa.get();
        return pessoaEntity;
    }

    @Transactional
    public void deletarPessoa(Long id){
        buscarPessoaPorId(id);
        pessoaRepository.deleteById(id);
    }

    @Transactional
    public PessoaEntity atualizarPessoa(Long id, PessoaEntity pessoaEntity){
        Optional<PessoaEntity> pessoa = Optional.of(pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("A pessoa informada nao foi encontrada")));
        PessoaEntity entity = new PessoaEntity();
        entity.setNomeCompleto(pessoaEntity.getNomeCompleto());
        entity.setDataNascimento(pessoaEntity.getDataNascimento());
        entity.setGenero(pessoaEntity.getGenero());
        entity.setTelefone(pessoaEntity.getTelefone());
        entity.setEmail(pessoaEntity.getEmail());
        entity.setNacionalidade(pessoaEntity.getNacionalidade());
        entity.setProfissao(pessoaEntity.getProfissao());
        entity.setIdentidade(pessoaEntity.getIdentidade());
        entity.setCpf(pessoaEntity.getCpf());
        return pessoaRepository.save(pessoa.get());
    }
}
