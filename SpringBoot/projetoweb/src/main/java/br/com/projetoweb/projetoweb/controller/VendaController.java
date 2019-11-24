package br.com.projetoweb.projetoweb.controller;


import br.com.projetoweb.projetoweb.entity.Venda;
import br.com.projetoweb.projetoweb.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class VendaController {
    @Autowired
    private VendaRepository _vendaRepository;

    // Method GET
    @RequestMapping(value = "/venda", method = RequestMethod.GET)
    public List<Venda> Get() {
        return _vendaRepository.findAll();
    }

    // Method GET ById
    @RequestMapping(value = "/venda/{vendaId}", method = RequestMethod.GET)
    public ResponseEntity<Venda> GetById(@PathVariable(value = "vendaId") long vendaId)
    {
        Optional<Venda> venda = _vendaRepository.findById(vendaId);
        if(venda.isPresent())
            return new ResponseEntity<Venda>(venda.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // Method POST
    @RequestMapping(value = "/venda", method =  RequestMethod.POST)
    public Venda Post(@Valid @RequestBody Venda venda)
    {
        return _vendaRepository.save(venda);
    }

    // Method PUT
    @RequestMapping(value = "/venda/{vendaId}", method =  RequestMethod.PUT)
    public ResponseEntity<Venda> Put(@PathVariable(value = "vendaId") long vendaId, @Valid @RequestBody Venda newVenda)
    {
        Optional<Venda> oldVenda = _vendaRepository.findById(vendaId);
        if(oldVenda.isPresent()){
            Venda venda = oldVenda.get();


            venda.setUsuario(newVenda.getUsuario());
            venda.setDataVenda(newVenda.getDataVenda());
            venda.setProduto(newVenda.getProduto());


            _vendaRepository.save(venda);
            return new ResponseEntity<Venda>(venda, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
