package com.global.all4ocean.repository;

import com.global.all4ocean.entity.OngEntity;
import com.global.all4ocean.entity.ProjetoOngEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoOngRepository extends JpaRepository<ProjetoOngEntity, Long> {
    Page<ProjetoOngEntity> findAll(Pageable pageable);

    Page<ProjetoOngEntity> findByOngEntity(Long id, Pageable pageable);
}
