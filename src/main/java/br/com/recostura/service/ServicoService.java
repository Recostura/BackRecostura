package br.com.recostura.service;

import br.com.recostura.entity.ServicoEntiy;
import br.com.recostura.repository.ServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional
    public ServicoEntiy salvarServico(ServicoEntiy servicoEntity) {
        ServicoEntiy servico = new ServicoEntiy();
        servico.setAcompanhamento(servicoEntity.getAcompanhamento());
        return servicoRepository.save(servico);
    }

    public Page<ServicoEntiy> buscarTodosServicos(Pageable pageable) {
        return servicoRepository.findAll(pageable);
    }

    public ServicoEntiy buscarServicoPorId(Long id) {
        Optional<ServicoEntiy> servico = Optional.of(servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O serviço informado não foi encontrado")));
        ServicoEntiy servicoEntity = servico.get();
        return servicoEntity;
    }

    @Transactional
    public void deletarServico(Long id) {
        buscarServicoPorId(id);
        servicoRepository.deleteById(id);
    }

    @Transactional
    public ServicoEntiy atualizarServico(Long id, ServicoEntiy servicoEntity) {
        Optional<ServicoEntiy> servico = Optional.of(servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O serviço não foi encontrado")));
        ServicoEntiy entity = new ServicoEntiy();
        entity.setAcompanhamento(servicoEntity.getAcompanhamento());
        return servicoRepository.save(servico.get());
    }




}
