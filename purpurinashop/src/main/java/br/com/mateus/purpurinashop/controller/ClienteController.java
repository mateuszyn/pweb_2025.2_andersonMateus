package br.com.mateus.purpurinashop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mateus.purpurinashop.model.Cliente;
import br.com.mateus.purpurinashop.repositories.ClienteRepository;

@Controller
public class ClienteController {

    @Autowired 
    private ClienteRepository clienteRepo;

   
    @GetMapping("/clientes")
    public ModelAndView listarClientes() {
       
        ModelAndView modelAndView = new ModelAndView("listarClientes"); 

        List<Cliente> clientes = clienteRepo.findAll();

        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }

    @GetMapping("/adicionarCliente")
    public ModelAndView formularioAdicionarCliente() {

        ModelAndView modelAndView = new ModelAndView("adicionarCliente");

        modelAndView.addObject("cliente", new Cliente());

        return modelAndView;
    }

    @SuppressWarnings("null")
    @PostMapping("/adicionarCliente")
    public String adicionarCliente(Cliente cliente) {

        clienteRepo.save(cliente);

        return "redirect:/clientes";
    }
}