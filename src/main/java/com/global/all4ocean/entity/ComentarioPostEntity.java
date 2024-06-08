package com.global.all4ocean.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "tb_comentario_post")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ComentarioPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario_post")
    private Long id;
    @Column(name = "comentario_post")
    @Length(min = 1, max = 300)
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "id_post", nullable = false)
    private PostOngEntity postOngEntity;
    @ManyToOne
    @JoinColumn(name = "id_voluntario", nullable = false)
    private VoluntarioEntity voluntarioEntity;
}
