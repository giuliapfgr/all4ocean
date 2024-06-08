package com.global.all4ocean.response;

import com.global.all4ocean.entity.ProjetoOngEntity;

import java.time.LocalDate;

public record ProjetoOngResponse(
        Long id,
        String nome,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFinal,
        String cidade,
        String estado,
        Long idOng
) {
    public ProjetoOngResponse(ProjetoOngEntity projetoOng) {
        this(projetoOng.getId(),
                projetoOng.getNome(),
                projetoOng.getDescricao(),
                projetoOng.getDataInicio(),
                projetoOng.getDataFinal(),
                projetoOng.getCidade(),
                projetoOng.getEstado(),
                projetoOng.getOngEntity().getId());
    }
}
