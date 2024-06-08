package com.global.all4ocean.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProjetoOngRequest(
        @NotNull(message = "{projeto.nome.notnull}")
        @NotBlank(message = "{projeto.nome.notblank}")
        String nome,

        String descricao,

        @NotNull(message = "{projeto.dataInicio.notnull}")
        LocalDate dataInicio,

        @NotNull(message = "{projeto.dataFinal.notnull}")
        LocalDate dataFinal,

        String cidade,
        String estado,

        @NotNull(message = "{projeto.idOng.notnull}")
        Long idOng
) {
}
