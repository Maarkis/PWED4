package br.com.projetoweb.projetoweb.controller;


import br.com.projetoweb.projetoweb.entity.ConfirmLogin;
import br.com.projetoweb.projetoweb.entity.ResponseUsuario;
import br.com.projetoweb.projetoweb.entity.Usuario;
import br.com.projetoweb.projetoweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UsuarioRepository _usuarioRepository;

//    // Method POST findByUsuario
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity<?> findByUsuario(@Valid @RequestBody Map<String, String> body) {
//        System.out.println(body);
//        List<Usuario> usuario = _usuarioRepository.findByUsuario(body.get("user"), body.get("senha"));
//        try {
//            return new ResponseEntity<>(ResponseUsuario.converter(usuario), HttpStatus.OK);
//        }catch (Exception ex){
//            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
//        }
//    }

    // Method POST findByLoginAndSenha
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> findByUsuario(@Valid @RequestBody ConfirmLogin confirmLogin) {
        List<Usuario> usuario = _usuarioRepository.findByLoginAndSenha(confirmLogin.getLogin(), confirmLogin.getSenha());
        try {
            if (usuario.isEmpty())
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
              return new ResponseEntity<>(ResponseUsuario.converter(usuario), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }

    }
}
