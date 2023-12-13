package br.com.recostura.entity;

import jakarta.persistence.*;

@Entity
public class CandidaturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedidoEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profissional_id")
    private ProfissionalEntity profissionalEntity;
}
