package br.com.recostura.entity;

import jakarta.persistence.*;

@Table(name = "TB_Cliente")
@Entity
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




}
