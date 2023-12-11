package br.com.recostura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlanoRetalhoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//  bot_portifolio_imagem_profis1
//  bot_portifolio_imagem_profis2
//  bot_portifolio_imagem_profis3
//  bot_portifolio_imagem_profis4
//  bot_portifolio_imagem_profis5
//  bot_portifolio_imagem_profis6
//  bot_portifolio_imagem_profis7
//  bot_portifolio_imagem_profis8


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
