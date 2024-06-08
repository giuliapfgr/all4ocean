package com.global.all4ocean.service;

import com.global.all4ocean.entity.OngEntity;
import com.global.all4ocean.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OngService {
    @Autowired
    OngRepository ongRepository;

    public Optional<OngEntity> findById(Long id){
        return ongRepository.findById(id);
    }
}
