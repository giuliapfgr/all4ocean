package com.global.all4ocean.service;

import com.global.all4ocean.entity.CurtidaPostEntity;
import com.global.all4ocean.entity.PostOngEntity;
import com.global.all4ocean.entity.VoluntarioPostEntity;
import com.global.all4ocean.repository.VoluntarioPostRepository;
import com.global.all4ocean.request.VoluntarioPostRequest;
import com.global.all4ocean.response.VoluntarioPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntarioPostService {
    @Autowired
    VoluntarioPostRepository voluntarioPostRepository;
    @Autowired
    PostOngService postOngService;
    @Autowired
    VoluntarioEntityService voluntarioEntityService;
    public VoluntarioPostResponse create(VoluntarioPostRequest voluntarioPostRequest) {
        var voluntario = VoluntarioPostEntity.builder()
                .postOngEntity(postOngService.findById(voluntarioPostRequest.idPost()))
                .voluntarioEntity(voluntarioEntityService.findById(voluntarioPostRequest.idVoluntario()))
                .build();
        return new VoluntarioPostResponse(voluntarioPostRepository.save(voluntario));
    }
}
