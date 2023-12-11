package br.com.recostura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlanoAgulhaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    portifolio_imagem1_profis1
    //    portifolio_imagem1_profis2
    //    portifolio_imagem1_profis3
    //    portifolio_imagem1_profis4
    //    portifolio_imagem1_profis5
//    destaque_feed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
