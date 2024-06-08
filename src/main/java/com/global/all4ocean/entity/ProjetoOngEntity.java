package com.global.all4ocean.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Data
@Table(name = "tb_projeto")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProjetoOngEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Long id;
    @Column(name = "nome_projeto")
    private String nome;
    @Column(name = "descricao_projeto")
    private String descricao;
    @Column(name = "data_inicio_projeto")
    private LocalDate dataInicio;
    @Column(name = "data_final_projeto")
    private LocalDate dataFinal;
    @Column(name = "cidade_projeto")
    private String cidade;
    @Column(name = "estado_projeto")
    private String estado;
    @ManyToOne
    @JoinColumn(name = "id_ong", nullable = false)
    private OngEntity ongEntity;

    public ProjetoOngEntity(Optional<ProjetoOngEntity> pjt) {
    }
}
