package br.com.recostura.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Table(name = "TB_Cliente")
@Entity
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "clienteEntities")
    private Collection<PedidoEntity> pedidoEntity;

    @OneToMany(mappedBy = "clienteEntity")
    private Collection<AvaliacaoEntity> avaliacaoEntity;
}
