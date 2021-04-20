package com.pedro.codechallengedocket.service;

import java.util.Optional;

import com.pedro.codechallengedocket.domain.Endereco;
import com.pedro.codechallengedocket.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository repository;

    public Endereco find(Integer id) {
        Optional<Endereco> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public Endereco insert(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco update(Endereco endereco) {
        find(endereco.getId());
        return repository.save(endereco);
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
