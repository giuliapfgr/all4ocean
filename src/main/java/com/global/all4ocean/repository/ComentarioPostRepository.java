package com.global.all4ocean.repository;

import com.global.all4ocean.entity.ComentarioPostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ComentarioPostRepository extends JpaRepository<ComentarioPostEntity, Long> {
    Page<ComentarioPostEntity> findByPostOngEntityId(Long postId, Pageable pageable);

    Page<ComentarioPostEntity> findByVoluntarioEntityId(Long voluntarioId, Pageable pageable);
}
