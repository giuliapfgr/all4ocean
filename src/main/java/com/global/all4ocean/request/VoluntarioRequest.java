package com.global.all4ocean.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record VoluntarioRequest(
        @NotNull(message = "{user.nome.notnull}")
        @NotBlank(message = "{user.nome.notblank}")
        @Length(min = 3, max = 60, message = "{user.nome.length}")
        String nome,

        @CPF(message = "{user.cpf.invalid}")
        String cpf,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNasc,

        @Email(message = "{user.email.invalid}")
        @NotNull(message = "{user.email.notnull}")
        @NotBlank(message = "{user.email.notblank}")
        String email,

        @NotNull(message = "{user.senha.notnull}")
        @NotBlank(message = "{user.senha.notblank}")
        String senha,

        String telefone,

        @Length(max = 8, min = 8, message = "{user.cep.length}")
        String cep,

        String rua,
        String numEnd,
        String bairro,
        String complemento,
        String cidade,

        @Length(max = 2, min = 2, message = "{user.estado.length}")
        String estado

) {

}
