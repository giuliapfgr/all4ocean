package com.global.all4ocean.service;

import com.global.all4ocean.entity.*;
import com.global.all4ocean.repository.CurtidaPostRepository;
import com.global.all4ocean.request.CurtidaPostRequest;
import com.global.all4ocean.response.CurtidaPostResponse;
import com.global.all4ocean.response.PostOngResponse;
import com.global.all4ocean.service.PostOngService;
import com.global.all4ocean.service.VoluntarioEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtidaPostService {
    @Autowired
    CurtidaPostRepository curtidaPostRepository;

    @Autowired
    PostOngService postOngService;
    @Autowired
    VoluntarioEntityService voluntarioEntityService;
    public CurtidaPostResponse create(CurtidaPostRequest curtidaPostRequest) {
        var curtida = CurtidaPostEntity.builder()
                .postOngEntity(postOngService.findById(curtidaPostRequest.idPost()))
                .voluntarioEntity(voluntarioEntityService.findById(curtidaPostRequest.idVoluntario()))
                .build();
        return new CurtidaPostResponse(curtidaPostRepository.save(curtida));
    }
}
