package br.com.recostura.service;

import br.com.recostura.entity.PlanoAgulhaEntity;
import br.com.recostura.repository.PlanoAgulhaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanoAgulhaService {

    @Autowired
    private PlanoAgulhaRepository planoAgulhaRepository;

    @Transactional
    public PlanoAgulhaEntity salvarPlanoAgulha(PlanoAgulhaEntity planoAgulhaEntity) {
        PlanoAgulhaEntity planoAgulha = new PlanoAgulhaEntity();
        return planoAgulhaRepository.save(planoAgulha);
    }

    public Page<PlanoAgulhaEntity> buscarTodosPlanosAgulha(Pageable pageable) {
        return planoAgulhaRepository.findAll(pageable);
    }

    public PlanoAgulhaEntity buscarPlanoAgulhaPorId(Long id) {
        Optional<PlanoAgulhaEntity> planoAgulha = Optional.of(planoAgulhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O PlanoAgulha solicitado não foi encontrado")));
        PlanoAgulhaEntity planoAgulhaEntity = planoAgulha.get();
        return planoAgulhaEntity;
    }

    @Transactional
    public void deletarPlanoAgulha(Long id) {
        buscarPlanoAgulhaPorId(id);
        planoAgulhaRepository.deleteById(id);
    }

    @Transactional
    public PlanoAgulhaEntity atualizarPlanoAgulha(Long id, PlanoAgulhaEntity planoAgulhaEntity) {
        Optional<PlanoAgulhaEntity> planoAgulha = Optional.of(planoAgulhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O PlanoAgulha solicitado não foi encontrado")));
        PlanoAgulhaEntity entity = new PlanoAgulhaEntity();
        return planoAgulhaRepository.save(planoAgulha.get());
    }
}