package com.pedro.codechallengedocket.domain.dao;

import com.pedro.codechallengedocket.domain.Cartorio;
import com.pedro.codechallengedocket.domain.Endereco;

public class CartorioDAO {
    
    private Integer id;
    private String nome;
    private Endereco endereco;

    public CartorioDAO(){}
    
    public CartorioDAO(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = new Endereco(endereco.getLogradouro(), endereco.getNumero(),
            endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
    }

    public Cartorio daoToClass() {
        Cartorio cartorio = new Cartorio(nome);
        cartorio.setEndereco(endereco);
        return cartorio;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
