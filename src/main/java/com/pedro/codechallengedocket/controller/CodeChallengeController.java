package com.pedro.codechallengedocket.controller;

import com.pedro.codechallengedocket.domain.Cartorio;
import com.pedro.codechallengedocket.domain.Endereco;
import com.pedro.codechallengedocket.service.CartorioService;
import com.pedro.codechallengedocket.service.CertidaoService;
import com.pedro.codechallengedocket.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CodeChallengeController {

    @Autowired
    private CartorioService serviceCart;

    @Autowired
    private EnderecoService serviceEnd;

    @Autowired 
    private CertidaoService serviceCert;
    
    @RequestMapping(method = RequestMethod.GET, value = "/cadastro-cartorio")
    public String redirect() {

        return "cadastro/cadcartorio";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert-cartorio")
    public String insert(Cartorio cartorio, Endereco endereco) {
        cartorio.setEndereco(endereco);

        serviceEnd.insert(endereco);
        serviceCart.insert(cartorio);
        return "cadastro/cadcartorio";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/view-cartorio")
    public String viewCartorio(Cartorio cartorio) {
        return "view/viewcartorio";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCartorios() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("cartorios", serviceCart.findAll());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/view-cartorio")
    public ModelAndView getCertidoes() {
        ModelAndView modelAndView = new ModelAndView("/view/viewcartorio");
        modelAndView.addObject("certidoes", serviceCert.findAll());
        return modelAndView;
    }
}
