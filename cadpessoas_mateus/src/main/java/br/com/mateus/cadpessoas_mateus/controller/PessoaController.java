package br.com.mateus.cadpessoas_mateus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mateus.cadpessoas_mateus.model.Pessoa;
import br.com.mateus.cadpessoas_mateus.repositories.PessoaRepoitory;

@Controller
@RequestMapping("/")

public class PessoaController {

    @Autowired
    private PessoaRepoitory pessoaRepo;

    @GetMapping("/adicionarPessoas")
    public ModelAndView formularioAdcionarPessoa () {
        ModelAndView modelAndView = new ModelAndView("adicionarPessoas");

        modelAndView.addObject("pessoa", new Pessoa());

        return modelAndView;
    }

    @PostMapping("/adicionarPessoa")
    public String adicionaPessoaPost (Pessoa p){

        pessoaRepo.save(p);

        return "redirect:/listarPessoas";
    }

    @GetMapping("/remover/{id}")
    public String removerPessoa (@PathVariable("id") Long id) {

        pessoaRepo.deleteById(id);

        return "redirect:/listarPessoas";
    }

    @GetMapping("/editarPessoas/{id}")
    public ModelAndView formularioEditarPessoa(@PathVariable("id") Long id) {

        Optional<Pessoa> pessoaOptional = pessoaRepo.findById(id);

        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();

            ModelAndView modelAndView = new ModelAndView("editarPessoas");

            modelAndView.addObject("pessoa", pessoa);

            return modelAndView;
        } else {
            
            return new ModelAndView("redirect:/listarPessoas");
        }
    }

    @PostMapping("/editarPessoas")
    public String salvarPessoaEditada (Pessoa pessoa) {

        pessoaRepo.save(pessoa);

        return "redirect:/listarPessoas";
    }

    @GetMapping({"/", "/index", ""})
    public String index() {
        return "index";
    }

    @GetMapping("/listarPessoas")
    public ModelAndView listarPessoas() {

        List<Pessoa> todasAsPessoas = pessoaRepo.findAll();

        ModelAndView modelAndView = new ModelAndView("listarPessoas");

        modelAndView.addObject ("pessoas", todasAsPessoas);

        return modelAndView;
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
    public String noticias() {
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