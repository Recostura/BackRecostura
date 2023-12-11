package br.com.recostura.service;

import br.com.recostura.entity.CandidaturaEntity;
import br.com.recostura.repository.CandidaturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Transactional
    public CandidaturaEntity salvarCandidatura(CandidaturaEntity candidaturaEntity) {
        CandidaturaEntity candidatura = new CandidaturaEntity();
        return candidaturaRepository.save(candidatura);
    }

    public Page<CandidaturaEntity> buscarTodasCandidaturas(Pageable pageable) {
        return candidaturaRepository.findAll(pageable);
    }

    public CandidaturaEntity buscarCandidaturaPorId(Long id) {
        Optional<CandidaturaEntity> candidatura = Optional.of(candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("A candidatura solicitada não foi encontrada")));
        CandidaturaEntity candidaturaEntity = candidatura.get();
        return candidaturaEntity;
    }

    @Transactional
    public void deletarCandidatura(Long id) {
        buscarCandidaturaPorId(id);
        candidaturaRepository.deleteById(id);
    }

    @Transactional
    public CandidaturaEntity atualizarCandidatura(Long id, CandidaturaEntity candidaturaEntity) {
        Optional<CandidaturaEntity> candidatura = Optional.of(candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("A candidatura solicitada não foi encontrada")));
        CandidaturaEntity entity = new CandidaturaEntity();
        return candidaturaRepository.save(candidatura.get());
    }
}
