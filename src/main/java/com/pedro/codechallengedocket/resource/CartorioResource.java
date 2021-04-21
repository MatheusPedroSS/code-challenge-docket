package com.pedro.codechallengedocket.resource;

import java.net.URI;

import com.pedro.codechallengedocket.domain.Cartorio;
import com.pedro.codechallengedocket.domain.dao.CartorioDAO;
import com.pedro.codechallengedocket.service.CartorioService;
import com.pedro.codechallengedocket.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CartorioResource {
    
    @Autowired
    private CartorioService cartService;

    @Autowired
    private EnderecoService endService;

    @PostMapping(value = "/cartorio")
    public ResponseEntity<Cartorio> insert(@RequestBody CartorioDAO cartorioDAO){
        endService.insert(cartorioDAO.getEndereco());
        Cartorio cartorio = cartService.insert(cartorioDAO.daoToClass());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(cartorio.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/cartorio/{id}")
    public ResponseEntity<Cartorio> getById(@PathVariable Integer id) {
        Cartorio cartorio = cartService.find(id);
        return ResponseEntity.ok().body(cartorio);
    }
}
