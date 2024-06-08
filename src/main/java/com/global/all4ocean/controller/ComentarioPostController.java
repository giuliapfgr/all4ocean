package com.global.all4ocean.controller;

import com.global.all4ocean.entity.ComentarioPostEntity;
import com.global.all4ocean.repository.ComentarioPostRepository;
import com.global.all4ocean.request.ComentarioPostRequest;
import com.global.all4ocean.service.ComentarioPostService;
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
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("comentarios")
@CacheConfig(cacheNames = "comentarios")
@Slf4j
@Tag(name = "Comentarios")
public class ComentarioPostController {
    @Autowired
    ComentarioPostRepository comentarioPostRepository;
    @Autowired
    ComentarioPostService comentarioPostService;

    @GetMapping("voluntario/{id}")
    public ResponseEntity getByIdVoluntario(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id
    ){

        Page<ComentarioPostEntity> page = comentarioPostRepository.findByVoluntarioEntityId(id, pageable);

        return ResponseEntity.ok().body(page);
    }

    @GetMapping("post/{id}")
    public ResponseEntity getByIdPost(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id
    ){

        Page<ComentarioPostEntity> page = comentarioPostRepository.findByPostOngEntityId(id, pageable);

        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity create(@RequestBody @Valid ComentarioPostRequest comentarioPostRequest, UriComponentsBuilder uriBuilder){

        var comentarioPostResponse = comentarioPostService.create(comentarioPostRequest);

        var uri = uriBuilder.path("{id}").buildAndExpand(comentarioPostResponse.id().toString()).toUri();
        return ResponseEntity.created(uri).body(comentarioPostResponse);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public ResponseEntity destroy(@PathVariable Long id){
        comentarioPostRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
