package com.global.all4ocean.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ComentarioPostRequest(
        @NotBlank(message = "{comentario.notblank}")
        @Length(min = 1, max = 300, message = "{comentario.length}")
        String comentario,

        @NotNull(message = "{idPost.notnull}")
        Long idPost,

        @NotNull(message = "{idVoluntario.notnull}")
        Long idVoluntario
) {
}
