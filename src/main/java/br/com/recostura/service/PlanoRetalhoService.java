package br.com.recostura.service;

import br.com.recostura.entity.PlanoRetalhoEntity;
import br.com.recostura.repository.PlanoRetalhoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanoRetalhoService {

 @Autowired
 private PlanoRetalhoRepository planoRetalhoRepository;

 @Transactional
 public PlanoRetalhoEntity salvarPlanoRetalho(PlanoRetalhoEntity planoRetalhoEntity) {
  PlanoRetalhoEntity planoRetalho = new PlanoRetalhoEntity();
  return planoRetalhoRepository.save(planoRetalho);
 }

 public Page<PlanoRetalhoEntity> buscarTodosPlanosRetalho(Pageable pageable) {
  return planoRetalhoRepository.findAll(pageable);
 }

 public PlanoRetalhoEntity buscarPlanoRetalhoPorId(Long id) {
  Optional<PlanoRetalhoEntity> planoRetalho = Optional.of(planoRetalhoRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("O PlanoRetalho solicitado não foi encontrado")));
  PlanoRetalhoEntity planoRetalhoEntity = planoRetalho.get();
  return planoRetalhoEntity;
 }

 @Transactional
 public void deletarPlanoRetalho(Long id) {
  buscarPlanoRetalhoPorId(id);
  planoRetalhoRepository.deleteById(id);
 }

 @Transactional
 public PlanoRetalhoEntity atualizarPlanoRetalho(Long id, PlanoRetalhoEntity planoRetalhoEntity) {
  Optional<PlanoRetalhoEntity> planoRetalho = Optional.of(planoRetalhoRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("O PlanoRetalho solicitado não foi encontrado")));
  PlanoRetalhoEntity entity = new PlanoRetalhoEntity();
  return planoRetalhoRepository.save(planoRetalho.get());
 }
}
