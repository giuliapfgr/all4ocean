package com.global.all4ocean.response;

import com.global.all4ocean.entity.CurtidaPostEntity;

public record CurtidaPostResponse(
        Long id,
        Long idPost,
        Long idVoluntario,
        String nomeVoluntario
) {
    public CurtidaPostResponse(CurtidaPostEntity curtida) {
        this(curtida.getId(),
                curtida.getPostOngEntity().getId(),
                curtida.getVoluntarioEntity().getId(),
                curtida.getVoluntarioEntity().getNome());
    }
}
