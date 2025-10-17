package br.com.mateus.cadpessoas_mateus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PessoaController {

    @GetMapping("/adicionarPessoas")
    public String adicionarPessoas () {
        return "adicionarPessoas";
    }
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
    @GetMapping("/listarPessoas")
    public String listarPessoas() {
        return "listarPessoas";
    }
     @GetMapping("/editarPessoas")
    public String editarPessoas() {
        return "editarPessoas";
    }
     @GetMapping("/adicionadaComSucesso")
    public String adicionadaComSucesso() {
        return "adicionadaComSucesso";
    }
     @GetMapping("/noticias")
    public String noricias() {
        return "noticias";
    }
     @GetMapping("/contato")
    public String contato() {
        return "contato";
    }
     @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }
}