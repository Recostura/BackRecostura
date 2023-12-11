package br.com.recostura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlanoBotaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//  bot_portifolio_imagem_profis1
//  bot_portifolio_imagem_profis2
//  bot_portifolio_imagem_profis3
//  bot_divulgacao_profis

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
