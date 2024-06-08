package com.global.all4ocean.response;

import com.global.all4ocean.entity.PostOngEntity;

import java.time.LocalDate;

public record PostOngResponse(
        Long id,
        String urlFoto,
        String descricao,
        LocalDate dataPost,
        Long idProjeto
) {
    public PostOngResponse(PostOngEntity postOngEntity) {
        this(postOngEntity.getId(),
                postOngEntity.getUrlFoto(),
                postOngEntity.getDescricao(),
                postOngEntity.getDataPost(),
                postOngEntity.getProjetoOng().getId());
    }
}
