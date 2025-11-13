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
import br.com.mateus.purpurinashop.repositories.ClienteRepository;

@Controller
public class ClienteController {

    @Autowired 
    private ClienteRepository clienteRepo;

   
    @GetMapping("/listarClientes")
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

    @PostMapping("/adicionarCliente")
    public String adicionarCliente(Cliente cliente) {

        clienteRepo.save(cliente);

        return "redirect:/listarClientes";
    }

    @GetMapping("/excluirCliente/{id}")
    public String excluirCliente(@PathVariable("id") Long id) {

        clienteRepo.deleteById(id);

        return "redirect:/listarClientes";
    }

    @GetMapping("/editarCliente/{id}")
    public ModelAndView formularioEditarCliente(@PathVariable("id") Long id) {
        Optional<Cliente> clienteOptional = clienteRepo.findById(id);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get(); 

            ModelAndView modelAndView = new ModelAndView("editarCliente"); 
            modelAndView.addObject("cliente", cliente); 

            return modelAndView;
        } else {
            return new ModelAndView("redirect:/listarClientes"); 
        }
    }
    @PostMapping("/editarCliente")
    public String editarCliente(Cliente cliente) {

        clienteRepo.save(cliente);

        return "redirect:/listarClientes";
    }
}