package com.global.all4ocean.entity;

import com.global.all4ocean.controller.VoluntarioController;
import com.global.all4ocean.response.VoluntarioResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Data
@Table(name = "tb_voluntario")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class VoluntarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vol")
    private Long id;
    @Column(name = "nome_vol")
    private String nome;
    @Column(name = "cpf_vol")

    private String cpf;
    @Column(name = "data_nasc_vol")
    private LocalDate dataNasc;
    @Column(name = "email_vol")
    private String email;
    @Column(name = "senha_vol")
    private String senha;
    @Column(name = "cep_vol")

    private String cep;
    @Column(name = "rua_vol")
    private String rua;
    @Column(name = "num_end_vol")
    private String numEnd;
    @Column(name = "bairro_vol")
    private String bairro;
    @Column(name = "complemento_vol")
    private String complemento;
    @Column(name = "cidade_vol")
    private String cidade;
    @Column(name = "estado_vol")

    private String estado;
    @Column(name = "telefone_vol")
    private String telefone;


}
