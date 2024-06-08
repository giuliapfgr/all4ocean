package com.global.all4ocean.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostOngRequest(
        @NotBlank(message = "{post.urlFoto.notblank}")
        String urlFoto,

        @NotBlank(message = "{post.descricao.notblank}")
        String descricao,

        @NotNull(message = "{post.dataPost.notnull}")
        LocalDate dataPost,

        @NotNull(message = "{post.idProjeto.notnull}")
        Long idProjeto

) {
}
