package com.pedro.codechallengedocket.repository;

import com.pedro.codechallengedocket.domain.Certidao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertidaoRepository extends JpaRepository<Certidao, Integer> {
    
}
