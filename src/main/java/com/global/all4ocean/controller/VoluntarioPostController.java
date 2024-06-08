package com.global.all4ocean.controller;

import com.global.all4ocean.entity.VoluntarioPostEntity;
import com.global.all4ocean.repository.CurtidaPostRepository;
import com.global.all4ocean.repository.VoluntarioPostRepository;
import com.global.all4ocean.request.VoluntarioPostRequest;
import com.global.all4ocean.service.CurtidaPostService;
import com.global.all4ocean.service.VoluntarioPostService;
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
@RequestMapping("voluntariopost")
@CacheConfig(cacheNames = "voluntariopost")
@Slf4j
@Tag(name = "Voluntario projeto")
public class VoluntarioPostController {
    @Autowired
    VoluntarioPostRepository voluntarioPostRepository;
    @Autowired
    VoluntarioPostService voluntarioPostService;

    @GetMapping("voluntario/{id}")
    public ResponseEntity getByIdVoluntario(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id
    ){

        Page<VoluntarioPostEntity> page = voluntarioPostRepository.findByVoluntarioEntityId(id, pageable);

        return ResponseEntity.ok().body(page);
    }

    @GetMapping("post/{id}")
    public ResponseEntity getByIdPost(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id
    ){

        Page<VoluntarioPostEntity> page = voluntarioPostRepository.findByPostOngEntityId(id, pageable);

        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity create(@RequestBody @Valid VoluntarioPostRequest voluntarioPostRequest, UriComponentsBuilder uriBuilder){

        var curtidaPostResponse = voluntarioPostService.create(voluntarioPostRequest);

        var uri = uriBuilder.path("{id}").buildAndExpand(curtidaPostResponse.id().toString()).toUri();
        return ResponseEntity.created(uri).body(curtidaPostResponse);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public ResponseEntity destroy(@PathVariable Long id){
        voluntarioPostRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
