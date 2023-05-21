package spring.algaworks.palestra.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GpController {


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index(){
        return "index";
    }

    @GetMapping( "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/projetos")
    public String projetos(){
        return "projetos";
    }
//
//    @RequestMapping(method = RequestMethod.GET, path = "/relatorio-custos\"")
//    public String relatorioCustos(){
//        return "relatorio-custos";
//    }
//
//    @RequestMapping(method = RequestMethod.GET, path = "/relatorio-equipe")
//    public String relatorioEquipe(){
//        return "relatorio-equipe";
//    }

}
