package com.global.all4ocean.service;

import com.global.all4ocean.entity.OngEntity;
import com.global.all4ocean.entity.ProjetoOngEntity;
import com.global.all4ocean.repository.ProjetoOngRepository;
import com.global.all4ocean.request.ProjetoOngRequest;
import com.global.all4ocean.response.ProjetoOngResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjetoOngService {
    @Autowired
    ProjetoOngRepository projetoOngRepository;

    @Autowired
    OngService ongService;


    public ProjetoOngResponse create(ProjetoOngRequest projetoOngRequest) {
        var projetoOng = ProjetoOngEntity.builder()
                .nome(projetoOngRequest.nome())
                .descricao(projetoOngRequest.descricao())
                .dataFinal(projetoOngRequest.dataFinal())
                .dataInicio(projetoOngRequest.dataInicio())
                .cidade(projetoOngRequest.cidade())
                .estado(projetoOngRequest.estado())
                .ongEntity(new OngEntity(ongService.findById(projetoOngRequest.idOng())))
                .build();
        return new ProjetoOngResponse(projetoOngRepository.save(projetoOng));
    }


    public Optional<ProjetoOngEntity> findById(Long id) {
        return projetoOngRepository.findById(id);
    }
}
