package com.pedro.codechallengedocket.resource;

import java.net.URI;
import java.util.List;

import com.pedro.codechallengedocket.domain.Cartorio;
import com.pedro.codechallengedocket.domain.Certidao;
import com.pedro.codechallengedocket.domain.dao.CertidaoDAO;
import com.pedro.codechallengedocket.service.CartorioService;
import com.pedro.codechallengedocket.service.CertidaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin
public class CertidaoResource {

    @Autowired
    private CertidaoService certService;

    @Autowired
    private CartorioService cartService;
    
    @PostMapping(value = "/certidao")
    public ResponseEntity<Certidao> insert(@RequestBody CertidaoDAO certidaoDAO){
        Cartorio cart = cartService.find(certidaoDAO.getCartorioId());
        Certidao cer = certidaoDAO.daoToClass();
        cer.setCartorio(cart);
        certService.insert(cer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(cer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/certidao/{id}")
    public ResponseEntity<Certidao> getById(@PathVariable Integer id) {
        Certidao certidao = certService.find(id);
        return ResponseEntity.ok().body(certidao);
    }

    @GetMapping(value = "/certidoes/{cartorioId}")
    public ResponseEntity<List<Certidao>> getByCartorio(@PathVariable Integer cartorioId) {
        Cartorio cartorio = cartService.find(cartorioId);
        return ResponseEntity.ok().body(certService.findByCartorio(cartorio));
    }

    @GetMapping(value = "/certidoes")
    public ResponseEntity<List<Certidao>> findAll() {
        return ResponseEntity.ok().body(certService.findAll());
    }
}
