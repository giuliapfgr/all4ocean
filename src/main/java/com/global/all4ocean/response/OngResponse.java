package com.global.all4ocean.response;

import com.global.all4ocean.entity.OngEntity;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

public record OngResponse(
        Long id,
        String nome,
        String cnpj,
        String razaoSocial,
        String email,
        String senha,
        String telefone,
        String cep,
        String rua,
        String numEnd,
        String bairro,
        String complemento,
        String cidade,
        String estado
) {
    public OngResponse(OngEntity ong) {
        this( ong.getId(),
                ong.getNome(),
                ong.getCnpj(),
                ong.getRazaoSocial(),
                ong.getEmail(),
                ong.getSenha(),
                ong.getTelefone(),
                ong.getCep(),
                ong.getRua(),
                ong.getNumEnd(),
                ong.getBairro(),
                ong.getComplemento(),
                ong.getCidade(),
                ong.getEstado());
    }
}
