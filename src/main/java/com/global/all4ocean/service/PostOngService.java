package com.global.all4ocean.service;

import com.global.all4ocean.entity.PostOngEntity;
import com.global.all4ocean.entity.ProjetoOngEntity;
import com.global.all4ocean.repository.PostOngRepository;
import com.global.all4ocean.request.PostOngRequest;
import com.global.all4ocean.response.PostOngResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostOngService {
    @Autowired
    PostOngRepository postRepository;
    @Autowired
    ProjetoOngService projetoOngService;

    public PostOngResponse create(PostOngRequest postOngRequest) {
        var post = PostOngEntity.builder()
                .urlFoto(postOngRequest.urlFoto())
                .descricao(postOngRequest.descricao())
                .dataPost(postOngRequest.dataPost())
                .projetoOng(new ProjetoOngEntity(projetoOngService.findById(postOngRequest.idProjeto())))
                .build();
        return new PostOngResponse(postRepository.save(post));
    }

    public PostOngEntity findById(Long id) {
        return postRepository.getReferenceById(id);
    }
}
