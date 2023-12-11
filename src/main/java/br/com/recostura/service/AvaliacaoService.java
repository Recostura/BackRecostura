package br.com.recostura.service;

import br.com.recostura.entity.AvaliacaoEntity;
import br.com.recostura.repository.AvaliacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Transactional
    public AvaliacaoEntity salvarAvaliacao(AvaliacaoEntity avaliacaoEntity) {
        AvaliacaoEntity avaliacao = new AvaliacaoEntity();
        avaliacao.setClassificacao(avaliacaoEntity.getClassificacao());
        avaliacao.setComentario(avaliacaoEntity.getComentario());
        return avaliacaoRepository.save(avaliacao);
    }
    public Page<AvaliacaoEntity> buscarTodasAvaliacoes(Pageable pageable) {
        return avaliacaoRepository.findAll(pageable);
    }
    public AvaliacaoEntity buscarAvaliacaoPorId(Long id) {
        Optional<AvaliacaoEntity> avaliacao = Optional.of(avaliacaoRepository.findById(id).orElseThrow(() -> new RuntimeException(" nao encontrado")));
        AvaliacaoEntity avaliacaoEntity = avaliacao.get();
        return avaliacaoEntity;
    }
    @Transactional
    public void deletarAvaliacao(Long id) {
        buscarAvaliacaoPorId(id);
        avaliacaoRepository.deleteById(id);
    }

    @Transactional
    public AvaliacaoEntity atualizarAvaliacao(Long id, AvaliacaoEntity avaliacaoEntity) {
        Optional<AvaliacaoEntity> avaliacao = Optional.of(avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("nao encontrada")));
        AvaliacaoEntity entity = new AvaliacaoEntity();
        entity.setClassificacao(avaliacaoEntity.getClassificacao());
        entity.setComentario(avaliacaoEntity.getComentario());
        return avaliacaoRepository.save(avaliacao.get());
    }
}
