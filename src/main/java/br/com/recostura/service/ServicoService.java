package br.com.recostura.service;

import br.com.recostura.entity.ServicoEntity;
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
    public ServicoEntity salvarServico(ServicoEntity servicoEntity) {
        ServicoEntity servico = new ServicoEntity();
        servico.setAcompanhamento(servicoEntity.getAcompanhamento());
        return servicoRepository.save(servico);
    }

    public Page<ServicoEntity> buscarTodosServicos(Pageable pageable) {
        return servicoRepository.findAll(pageable);
    }

    public ServicoEntity buscarServicoPorId(Long id) {
        Optional<ServicoEntity> servico = Optional.of(servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O serviço informado não foi encontrado")));
        ServicoEntity servicoEntity = servico.get();
        return servicoEntity;
    }

    @Transactional
    public void deletarServico(Long id) {
        buscarServicoPorId(id);
        servicoRepository.deleteById(id);
    }

    @Transactional
    public ServicoEntity atualizarServico(Long id, ServicoEntity servicoEntity) {
        Optional<ServicoEntity> servico = Optional.of(servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O serviço não foi encontrado")));
        ServicoEntity entity = new ServicoEntity();
        entity.setAcompanhamento(servicoEntity.getAcompanhamento());
        return servicoRepository.save(servico.get());
    }




}
