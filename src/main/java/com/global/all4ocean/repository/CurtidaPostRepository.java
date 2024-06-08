package com.global.all4ocean.repository;

import com.global.all4ocean.entity.ComentarioPostEntity;
import com.global.all4ocean.entity.CurtidaPostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CurtidaPostRepository extends JpaRepository<CurtidaPostEntity, Long> {

    Page<CurtidaPostEntity> findByPostOngEntityId(Long postId, Pageable pageable);

    Page<CurtidaPostEntity> findByVoluntarioEntityId(Long id, Pageable pageable);
}
