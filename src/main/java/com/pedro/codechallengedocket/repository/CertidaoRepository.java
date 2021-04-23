package com.pedro.codechallengedocket.repository;

import java.util.List;

import com.pedro.codechallengedocket.domain.Cartorio;
import com.pedro.codechallengedocket.domain.Certidao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertidaoRepository extends JpaRepository<Certidao, Integer> {
    
    List<Certidao> findByCartorio(Cartorio cartorio);

}
