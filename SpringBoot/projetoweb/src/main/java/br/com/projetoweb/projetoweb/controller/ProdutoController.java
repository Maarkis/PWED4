package br.com.projetoweb.projetoweb.controller;

import br.com.projetoweb.projetoweb.entity.Produto;
import br.com.projetoweb.projetoweb.entity.Venda;
import br.com.projetoweb.projetoweb.repository.ProdutoRepository;
import br.com.projetoweb.projetoweb.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
@CrossOrigin
public class ProdutoController {
    @Autowired
    private ProdutoRepository _produtoRepository;

    @GetMapping
    public List<Produto> get() {
        return _produtoRepository.findAll();
    }




}
