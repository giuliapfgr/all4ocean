package com.global.all4ocean.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "tb_curtida_post")
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class CurtidaPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curtida_post")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_post")
    private PostOngEntity postOngEntity;
    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private VoluntarioEntity voluntarioEntity;
}
