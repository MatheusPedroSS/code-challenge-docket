package com.pedro.codechallengedocket.service;

import java.util.List;
import java.util.Optional;

import com.pedro.codechallengedocket.domain.Cartorio;
import com.pedro.codechallengedocket.domain.Certidao;
import com.pedro.codechallengedocket.repository.CertidaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CertidaoService {
    
    @Autowired
    private CertidaoRepository repository;

    public Certidao find(Integer id) {
        Optional<Certidao> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public Certidao insert(Certidao certidao) {
        return repository.save(certidao);
    }

    public Certidao update(Certidao certidao) {
        find(certidao.getId());
        return repository.save(certidao);
    }

    public void delete(Integer id) {
        find(id);
        try{
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Não e possivel excluir um cartorio que contenha endereços!");
        }
    }

    public List<Certidao> findAll() {
        return repository.findAll();
    }

    public List<Certidao> findByCartorio(Cartorio cartorio) {
        return repository.findByCartorio(cartorio);
    }
}
