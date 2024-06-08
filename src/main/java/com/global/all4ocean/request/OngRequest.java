package com.global.all4ocean.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record OngRequest(
        @NotBlank(message = "{ong.nome.notblank}")
        String nome,

        @CNPJ(message = "{ong.cnpj.invalid}")
        @NotBlank(message = "{ong.cnpj.notblank}")
        String cnpj,

        @NotBlank(message = "{ong.razaoSocial.notblank}")
        String razaoSocial,

        @Email(message = "{ong.email.invalid}")
        @NotBlank(message = "{ong.email.notblank}")
        String email,

        @NotBlank(message = "{ong.senha.notblank}")
        String senha,

        String telefone,

        @Length(min = 8, max = 8, message = "{ong.cep.length}")
        String cep,

        String rua,
        String numEnd,
        String bairro,
        String complemento,
        String cidade,

        @Length(min = 2, max = 2, message = "{ong.estado.length}")
        String estado
) {
}
