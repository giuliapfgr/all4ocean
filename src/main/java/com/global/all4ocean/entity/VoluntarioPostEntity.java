package com.global.all4ocean.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_voluntario_post")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class VoluntarioPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voluntario_post")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_post", nullable = false)
    private PostOngEntity postOngEntity;
    @ManyToOne
    @JoinColumn(name = "id_voluntario", nullable = false)
    private VoluntarioEntity voluntarioEntity;
}
