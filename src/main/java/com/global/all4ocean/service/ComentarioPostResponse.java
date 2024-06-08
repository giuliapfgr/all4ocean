package com.global.all4ocean.service;

import com.global.all4ocean.entity.ComentarioPostEntity;

public record ComentarioPostResponse(
        Long id,
        String nomeVoluntario,
        String comentario,
        Long idPost,
        Long idVoluntario

) {

    public ComentarioPostResponse(ComentarioPostEntity comentario) {
        this(comentario.getId(),
                comentario.getVoluntarioEntity().getNome(),
                comentario.getComentario(),
                comentario.getPostOngEntity().getId(),
                comentario.getVoluntarioEntity().getId());
    }
}
