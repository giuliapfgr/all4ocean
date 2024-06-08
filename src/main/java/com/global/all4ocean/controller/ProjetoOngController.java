package com.global.all4ocean.controller;

import com.global.all4ocean.entity.OngEntity;
import com.global.all4ocean.entity.ProjetoOngEntity;
import com.global.all4ocean.repository.OngRepository;
import com.global.all4ocean.repository.ProjetoOngRepository;
import com.global.all4ocean.request.OngRequest;
import com.global.all4ocean.request.ProjetoOngRequest;
import com.global.all4ocean.response.OngResponse;
import com.global.all4ocean.response.ProjetoOngResponse;
import com.global.all4ocean.service.ProjetoOngService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("projeto")
@CacheConfig(cacheNames = "projeto")
@Slf4j
@Tag(name = "Projeto")
public class ProjetoOngController {
    @Autowired
    ProjetoOngRepository projetoOngRepository;

    @Autowired
    ProjetoOngService projetoOngService;
    @GetMapping
    public ResponseEntity getAll(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable
    ){

        Page<ProjetoOngEntity> page = projetoOngRepository.findAll(pageable);

        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getByOng(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id
    ){

        Page<ProjetoOngEntity> page = projetoOngRepository.findByOngEntity(id, pageable);

        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity create(@RequestBody @Valid ProjetoOngRequest projetoOngRequest, UriComponentsBuilder uriBuilder){

        var projetoOngResponse = projetoOngService.create(projetoOngRequest);

        var uri = uriBuilder.path("{id}").buildAndExpand(projetoOngResponse.id().toString()).toUri();
        return ResponseEntity.created(uri).body(projetoOngResponse);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public ResponseEntity destroy(@PathVariable Long id){
        projetoOngRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
