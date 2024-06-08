package com.global.all4ocean.controller;

import com.global.all4ocean.entity.VoluntarioEntity;
import com.global.all4ocean.repository.VoluntarioRepository;
import com.global.all4ocean.request.VoluntarioRequest;
import com.global.all4ocean.response.VoluntarioResponse;
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
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("voluntario")
@CacheConfig(cacheNames = "voluntario")
@Slf4j
@Tag(name = "Voluntario")
public class VoluntarioController {
    @Autowired
    VoluntarioRepository voluntarioRepository;

    @GetMapping
    public ResponseEntity getAll(
            @PageableDefault(size = 5, sort = "data", direction = Sort.Direction.DESC) Pageable pageable
    ){

        Page<VoluntarioEntity> page = voluntarioRepository.findAll(pageable);

        return ResponseEntity.ok().body(page);
    }


    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity create(@RequestBody @Valid VoluntarioRequest voluntarioRequest, UriComponentsBuilder uriBuilder){
        var voluntario = VoluntarioEntity.builder()
                .email(voluntarioRequest.email())
                .cpf(voluntarioRequest.cpf())
                .senha(voluntarioRequest.senha())
                .nome(voluntarioRequest.nome())
                .dataNasc(voluntarioRequest.dataNasc())
                .telefone(voluntarioRequest.telefone())
                        .build();
        var voluntarioResponse = new VoluntarioResponse(voluntarioRepository.save(voluntario));

        var uri = uriBuilder.path("{id}").buildAndExpand(voluntarioResponse.id().toString()).toUri();
        return ResponseEntity.created(uri).body(voluntarioResponse);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public ResponseEntity destroy(@PathVariable Long id){
        voluntarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody VoluntarioRequest voluntarioRequest) {
        var voluntario =VoluntarioEntity.builder()
                .email(voluntarioRequest.email())
                .cpf(voluntarioRequest.cpf())
                .senha(voluntarioRequest.senha())
                .nome(voluntarioRequest.nome())
                .dataNasc(voluntarioRequest.dataNasc())
                .telefone(voluntarioRequest.telefone())
                .cep(voluntarioRequest.cep())
                .rua(voluntarioRequest.rua())
                .bairro(voluntarioRequest.bairro())
                .cidade(voluntarioRequest.cidade())
                .estado(voluntarioRequest.estado())
                .numEnd(voluntarioRequest.numEnd())
                .complemento(voluntarioRequest.complemento())
                .id(id)
                .build();
        return ResponseEntity.ok().body(new VoluntarioResponse(voluntarioRepository.save(voluntario)));
    }
}
