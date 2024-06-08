package com.global.all4ocean.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.global.all4ocean.controller.VoluntarioController;
import com.global.all4ocean.entity.VoluntarioEntity;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDate;

import static java.awt.AWTEventMulticaster.add;

public record VoluntarioResponse(
        Long id,
        String nome,
        String cpf,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNasc,
        String email,
        String senha,
        String telefone,
        String cep,
        String rua,
        String numEnd,
        String bairro,
        String complemento,
        String cidade,
        String estado
) {
    public VoluntarioResponse(VoluntarioEntity voluntarioEntity) {
        this( voluntarioEntity.getId(),
                voluntarioEntity.getNome(),
                voluntarioEntity.getCpf(),
                voluntarioEntity.getDataNasc(),
                voluntarioEntity.getEmail(),
                voluntarioEntity.getSenha(),
                voluntarioEntity.getTelefone(),
                voluntarioEntity.getCep(),
                voluntarioEntity.getRua(),
                voluntarioEntity.getNumEnd(),
                voluntarioEntity.getBairro(),
                voluntarioEntity.getComplemento(),
                voluntarioEntity.getCidade(),
                voluntarioEntity.getEstado());
    }
}
