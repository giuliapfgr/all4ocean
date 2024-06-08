package com.global.all4ocean.response;

import com.global.all4ocean.entity.VoluntarioPostEntity;

public record VoluntarioPostResponse(
        Long id,
        Long idPost,
        Long idVoluntario,
        String nomeOng
) {
    public VoluntarioPostResponse(VoluntarioPostEntity voluntarioPost) {
        this(
                voluntarioPost.getId(),
                voluntarioPost.getPostOngEntity().getId(),
                voluntarioPost.getVoluntarioEntity().getId(),
                voluntarioPost.getPostOngEntity().getProjetoOng().getOngEntity().getNome()
                );
    }
}
