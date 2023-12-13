package br.com.recostura.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataEntrega;
    private String valorPedido;
    private String descricaoPedido;
//    imagem

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntities;

    @OneToOne(mappedBy = "pedidoEntity")
    private CandidaturaEntity candidaturaEntity;
}
