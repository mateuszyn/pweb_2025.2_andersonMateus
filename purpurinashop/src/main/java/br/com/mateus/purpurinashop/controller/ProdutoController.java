package br.com.mateus.purpurinashop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.mateus.purpurinashop.model.Produto;
import br.com.mateus.purpurinashop.repositories.ProdutoRepository;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepo;
    

    @GetMapping ("/listarProdutos")
    public ModelAndView listarProdutos(@RequestParam(value = "busca", required = false) String busca) {
        ModelAndView modelAndView = new ModelAndView("listarProdutos");
        List<Produto> produtos;

        if (busca == null || busca.trim().isEmpty()) {
            produtos = produtoRepo.findAllByOrderByMarcaAsc();
        } else {
            String keyword = busca.trim();
            produtos = produtoRepo.findByMarcaContainingIgnoreCaseOrTipoDeMetalContainingIgnoreCaseOrGemasContainingIgnoreCaseOrQuilatesContainingIgnoreCase(
                keyword, keyword, keyword, keyword
            );
            modelAndView.addObject("busca", busca);
        }

        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @GetMapping("/adicionarProduto") 
    public ModelAndView formularioAdicionarProduto() {
        ModelAndView modelAndView = new ModelAndView("adicionarProduto"); 
        modelAndView.addObject("produto", new Produto());
        return modelAndView;
    }

    @PostMapping("/adicionarProduto")
    public String adicionarProduto(Produto produto) {
        produtoRepo.save(produto);
        return "redirect:/listarProdutos";
    }

    @GetMapping("/editarProduto/{id}")
    public ModelAndView formularioEditarProduto(@PathVariable("id") Long id) {
        Optional<Produto> produtoOptional = produtoRepo.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            ModelAndView modelAndView = new ModelAndView("editarProduto");
            modelAndView.addObject("produto", produto);
            return modelAndView;
        }
        return new ModelAndView("redirect:/listarProdutos");
    }

    @PostMapping("/editarProduto")
    public String editarProduto(Produto produto) {
        produtoRepo.save(produto);
        return "redirect:/listarProdutos";
    }
    @GetMapping("/excluirProduto/{id}")
    public String excluirProduto(@PathVariable("id") Long id) {
        produtoRepo.deleteById(id);
        return "redirect:/listarProdutos";
    }
}