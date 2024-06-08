package com.global.all4ocean.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record VoluntarioPostRequest(
        @NotNull(message = "{voluntariado.idPost.notnull}")
        Long idPost,

        @NotNull(message = "{voluntariado.idVoluntario.notnull}")
        Long idVoluntario
) {
}
