package com.global.all4ocean.controller;

import com.global.all4ocean.entity.PostOngEntity;
import com.global.all4ocean.repository.PostOngRepository;
import com.global.all4ocean.request.PostOngRequest;
import com.global.all4ocean.service.PostOngService;
import com.global.all4ocean.service.ProjetoOngService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("post")
@CacheConfig(cacheNames = "post")
@Slf4j
@Tag(name = "Post")
public class PostOngController {

    @Autowired
    PostOngRepository postRepository;

    @Autowired
    PostOngService postOngService;

    @GetMapping
    public ResponseEntity getAll(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable
    ){

        Page<PostOngEntity> page = postRepository.findAll(pageable);

        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getByIdProjeto(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id
    ){

        Page<PostOngEntity> page = postRepository.findById(id, pageable);

        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity create(@RequestBody @Valid PostOngRequest postOngRequest, UriComponentsBuilder uriBuilder){

        var postOngResponse = postOngService.create(postOngRequest);

        var uri = uriBuilder.path("{id}").buildAndExpand(postOngResponse.id().toString()).toUri();
        return ResponseEntity.created(uri).body(postOngResponse);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public ResponseEntity destroy(@PathVariable Long id){
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
