package com.pedro.codechallengedocket.service;

import java.util.Optional;

import com.pedro.codechallengedocket.domain.Endereco;
import com.pedro.codechallengedocket.repository.EnderecoRepository;
import com.pedro.codechallengedocket.service.exception.DataIntegrityException;

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
        try{
            return repository.save(endereco);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não pode ser registrado mais de um cartorio no mesmo endereço");
        }
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
