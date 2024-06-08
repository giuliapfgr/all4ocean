package com.global.all4ocean.service;

import com.global.all4ocean.entity.VoluntarioEntity;
import com.global.all4ocean.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntarioEntityService {
    @Autowired
    VoluntarioRepository voluntarioRepository;
     public VoluntarioEntity findById(Long id){
         return voluntarioRepository.getReferenceById(id);
     }
}
