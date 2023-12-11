package br.com.recostura.entity;

import br.com.recostura.enumeration.ClassificacaoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ClassificacaoEnum Classificacao;
    private String comentario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassificacaoEnum getClassificacao() {
        return Classificacao;
    }

    public void setClassificacao(ClassificacaoEnum classificacao) {
        Classificacao = classificacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
