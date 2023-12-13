package br.com.recostura.entity;

import jakarta.persistence.*;

@Entity
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String acompanhamento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profissional_id")
    private ProfissionalEntity profissionalEntities;

    @OneToOne(mappedBy = "servico")
    private AvaliacaoEntity avaliacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }
}