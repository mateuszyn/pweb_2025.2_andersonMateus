package br.com.mateus.purpurinashop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mateus.purpurinashop.model.Cliente;
import br.com.mateus.purpurinashop.model.Dependente;
import br.com.mateus.purpurinashop.repositories.ClienteRepository;
import br.com.mateus.purpurinashop.repositories.DependenteRepository;

@Controller
public class DependenteController{

    @Autowired
    private DependenteRepository dependenteRepo;

    @Autowired
    private ClienteRepository clienteRepo; 

    @GetMapping("/listarDependentes")
    public ModelAndView listarDependentes() {
        ModelAndView modelAndView = new ModelAndView("listarDependentes");
        List<Dependente> dependentes = dependenteRepo.findAll();
        modelAndView.addObject("dependentes", dependentes);
        return modelAndView;
    }

    @GetMapping("/adicionarDependente")
    public ModelAndView formularioAdicionarDependente() {
        ModelAndView modelAndView = new ModelAndView("adicionarDependente");
        
        modelAndView.addObject("dependente", new Dependente()); 
        
        List<Cliente> clientes = clienteRepo.findAll();
        modelAndView.addObject("clientes", clientes);
        
        return modelAndView;
    }

    @PostMapping("/adicionarDependente")
    public String adicionarDependente(Dependente dependente) {
        dependenteRepo.save(dependente);
        return "redirect:/listarDependentes";
    }

    @GetMapping("/editarDependente/{id}")
    public ModelAndView formularioEditarDependente(@PathVariable("id") Long id) {
        Optional<Dependente> dependenteOptional = dependenteRepo.findById(id);
        
        if (dependenteOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("editarDependente");
            modelAndView.addObject("dependente", dependenteOptional.get());
            
            List<Cliente> clientes = clienteRepo.findAll();
            modelAndView.addObject("clientes", clientes);
            
            return modelAndView;
        }
        return new ModelAndView("redirect:/listarDependentes");
    }

    @PostMapping("/editarDependente")
    public String editarDependente(Dependente dependente) {
        dependenteRepo.save(dependente);
        return "redirect:/listarDependentes";
    }

    @GetMapping("/excluirDependente/{id}")
    public String excluirDependente(@PathVariable("id") Long id) {
        dependenteRepo.deleteById(id);
        return "redirect:/listarDependentes";
    }
}
