package com.pedro.codechallengedocket.service;

import java.util.Optional;

import com.pedro.codechallengedocket.domain.Cartorio;
import com.pedro.codechallengedocket.repository.CartorioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CartorioService {
    
    @Autowired
    private CartorioRepository repository;

    public Cartorio find(Integer id) {
        Optional<Cartorio> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Cartorio não encontrado"));
    }

    public Cartorio insert(Cartorio cartorio) {
        return repository.save(cartorio);
    }

    public Cartorio update(Cartorio cartorio) {
        find(cartorio.getId());
        return repository.save(cartorio);
    }

    public void delete(Integer id) {
        find(id);
        try{
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Não e possivel excluir um cartorio que contenha endereços!");
        }
    }
}
