package com.global.all4ocean.service;

import com.global.all4ocean.entity.ComentarioPostEntity;
import com.global.all4ocean.entity.CurtidaPostEntity;
import com.global.all4ocean.entity.PostOngEntity;
import com.global.all4ocean.repository.ComentarioPostRepository;
import com.global.all4ocean.request.ComentarioPostRequest;
import com.global.all4ocean.request.CurtidaPostRequest;
import com.global.all4ocean.response.CurtidaPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioPostService {
    @Autowired
    ComentarioPostRepository comentarioPostRepository;
    @Autowired
    PostOngService postOngService;
    @Autowired
    VoluntarioEntityService voluntarioEntityService;
    public ComentarioPostResponse create(ComentarioPostRequest comentarioPostRequest) {
        var comentario = ComentarioPostEntity.builder()
                .postOngEntity(postOngService.findById(comentarioPostRequest.idPost()))
                .voluntarioEntity(voluntarioEntityService.findById(comentarioPostRequest.idVoluntario()))
                .comentario(comentarioPostRequest.comentario())
                .build();
        return new ComentarioPostResponse(comentarioPostRepository.save(comentario));
    }
}
