package com.pedro.codechallengedocket.repository;

import com.pedro.codechallengedocket.domain.Cartorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
    
}
