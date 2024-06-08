package com.global.all4ocean.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CurtidaPostRequest (
        @NotNull(message = "{curtida.idPost.notnull}")
        Long idPost,

        @NotNull(message = "{curtida.idVoluntario.notnull}")
        Long idVoluntario
){
}
