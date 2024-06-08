package com.global.all4ocean.controller;

import com.global.all4ocean.entity.CurtidaPostEntity;
import com.global.all4ocean.repository.CurtidaPostRepository;
import com.global.all4ocean.request.CurtidaPostRequest;
import com.global.all4ocean.service.CurtidaPostService;
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
@RequestMapping("curtidas")
@CacheConfig(cacheNames = "curtidas")
@Slf4j
@Tag(name = "Curtidas")
public class CurtidaPostController {
    @Autowired
    CurtidaPostRepository curtidaPostRepository;
    @Autowired
    CurtidaPostService curtidaPostService;

    @GetMapping("voluntario/{id}")
    public ResponseEntity getByIdVoluntario(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id
    ){

        Page<CurtidaPostEntity> page = curtidaPostRepository.findByVoluntarioEntityId(id, pageable);

        return ResponseEntity.ok().body(page);
    }

    @GetMapping("post/{id}")
    public ResponseEntity getByIdPost(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id
    ){

        Page<CurtidaPostEntity> page = curtidaPostRepository.findByPostOngEntityId(id, pageable);

        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity create(@RequestBody @Valid CurtidaPostRequest curtidaPostRequest, UriComponentsBuilder uriBuilder){

        var curtidaPostResponse = curtidaPostService.create(curtidaPostRequest);

        var uri = uriBuilder.path("{id}").buildAndExpand(curtidaPostResponse.id().toString()).toUri();
        return ResponseEntity.created(uri).body(curtidaPostResponse);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public ResponseEntity destroy(@PathVariable Long id){
        curtidaPostRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
