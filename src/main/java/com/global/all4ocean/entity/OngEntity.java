package com.global.all4ocean.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Optional;

@Entity
@Data
@Table(name = "tb_ong")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class OngEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ong")
    private Long id;
    @Column(name = "nome_ong")
    private String nome;
    @Column(name = "cnpj_ong")
    @Length(max = 18, min = 14)
    private String cnpj;
    @Column(name = "razao_social_ong")
    private String razaoSocial;
    @Column(name = "email_ong")
    private String email;
    @Column(name = "senha_ong")
    private String senha;
    @Column(name = "cep_ong")
    private String cep;
    @Column(name = "rua_ong")
    private String rua;
    @Column(name = "num_end_ong")
    private String numEnd;
    @Column(name = "bairro_ong")
    private String bairro;
    @Column(name = "complemento_ong")
    private String complemento;
    @Column(name = "cidade_ong")
    private String cidade;
    @Column(name = "estado_ong")
    private String estado;
    @Column(name = "telefone_ong")
    private String telefone;

    public OngEntity(Optional<OngEntity> ong) {
    }
}
