package br.com.recostura.entity;

import br.com.recostura.enumeration.ClassificacaoEnum;
import jakarta.persistence.*;

@Entity
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ClassificacaoEnum Classificacao;
    private String comentario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servico_id")
    private ServicoEntity servico;

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
