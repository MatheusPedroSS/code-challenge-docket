package com.pedro.codechallengedocket.domain.dao;

import com.pedro.codechallengedocket.domain.Cartorio;
import com.pedro.codechallengedocket.domain.Certidao;

public class CertidaoDAO {
    private String nome;
    private Integer cartorioId;
    
    public CertidaoDAO() {}

    public CertidaoDAO(String nome, Integer cartorioId){
        this.nome = nome;
        this.cartorioId = cartorioId;
    }

    public Certidao daoToClass() {
        return new Certidao(nome, new Cartorio());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCartorioId() {
        return cartorioId;
    }

    public void setCartorioId(Integer cartorioId) {
        this.cartorioId = cartorioId;
    }

    
}
