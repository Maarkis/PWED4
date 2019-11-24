package br.com.projetoweb.projetoweb.controller;


import br.com.projetoweb.projetoweb.entity.Produto;
import br.com.projetoweb.projetoweb.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository _produtoRepository;

    // Method GET
    @RequestMapping(value = "/produto", method = RequestMethod.GET)
    public List<Produto> Get() {
        return _produtoRepository.findAll();
    }


    // Method GET ById
    @RequestMapping(value = "/produto/{produtoId}", method = RequestMethod.GET)
    public ResponseEntity<Produto> GetById(@PathVariable(value = "produtoId") long produtoId)
    {
        Optional<Produto> produto = _produtoRepository.findById(produtoId);
        if(produto.isPresent())
            return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // Method POST
    @RequestMapping(value = "/produto", method =  RequestMethod.POST)
    public Produto Post(@Valid @RequestBody Produto produto)
    {
        return _produtoRepository.save(produto);
    }

    // Method PUT
    @RequestMapping(value = "/produto/{produtoId}", method =  RequestMethod.PUT)
    public ResponseEntity<Produto> Put(@PathVariable(value = "produtoId") long produtoId, @Valid @RequestBody Produto newProduto)
    {
        Optional<Produto> oldProduto = _produtoRepository.findById(produtoId);
        if(oldProduto.isPresent()){
            Produto produto = oldProduto.get();
            produto.setNome(newProduto.getNome());
            produto.setPreco(newProduto.getPreco());
            produto.setDescricao(newProduto.getDescricao());
            _produtoRepository.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Method DELETE ById
    @RequestMapping(value = "/produto/{produtoId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "produtoId") long produtoId)
    {
        Optional<Produto> produto = _produtoRepository.findById(produtoId);
        if(produto.isPresent()){
            _produtoRepository.delete(produto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
