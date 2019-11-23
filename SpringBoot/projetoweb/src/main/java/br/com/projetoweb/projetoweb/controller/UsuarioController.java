package br.com.projetoweb.projetoweb.controller;

import br.com.projetoweb.projetoweb.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.projetoweb.projetoweb.repository.UsuarioRepository;
import java.util.List;


@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository _usuarioRepository;


    // Method GET
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> Get() { return _usuarioRepository.findAll(); }




}
