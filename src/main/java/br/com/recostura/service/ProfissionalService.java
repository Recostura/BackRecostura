package br.com.recostura.service;

import br.com.recostura.entity.ProfissionalEntity;
import br.com.recostura.repository.ProfissionalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Transactional
    public ProfissionalEntity salvarProfissional(ProfissionalEntity profissionalEntity){
    ProfissionalEntity profissional = new ProfissionalEntity();
    profissional.setBiografia(profissionalEntity.getBiografia());
    profissional.setMediaValor(profissionalEntity.getMediaValor());
    profissional.setPlanoContratado(profissionalEntity.getPlanoContratado());
    profissional.setServicoOferecido(profissionalEntity.getServicoOferecido());
    profissional.setUserName(profissionalEntity.getUserName());
    return profissionalRepository.save(profissional);
    }
    public Page<ProfissionalEntity> buscarTodosProfissionais(Pageable pageable) {return profissionalRepository.findAll(pageable);}

    public ProfissionalEntity buscarProfissionalPorId(Long id){
        Optional<ProfissionalEntity> profissional = Optional.of(profissionalRepository.findById(id).orElseThrow(()->new RuntimeException("O profissinoal informado nao foi encontrado")));
        ProfissionalEntity profissionalEntity = profissional.get();
        return profissionalEntity;
    }

    @Transactional
    public void deletarProfissional(Long id){
        buscarProfissionalPorId(id);
        profissionalRepository.deleteById(id);
    }

    @Transactional
    public ProfissionalEntity atualizarProfissional(Long id, ProfissionalEntity profissionalEntity){
        Optional<ProfissionalEntity> profissional = Optional.of(profissionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O profissional nao foi encontrado")));
        ProfissionalEntity entity = new ProfissionalEntity();
        entity.setBiografia(profissionalEntity.getBiografia());
        entity.setMediaValor(profissionalEntity.getMediaValor());
        entity.setPlanoContratado(profissionalEntity.getPlanoContratado());
        entity.setServicoOferecido(profissionalEntity.getServicoOferecido());
        entity.setUserName(profissionalEntity.getUserName());
        return profissionalRepository.save(profissional.get());
    }
}