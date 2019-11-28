package br.com.projetoweb.projetoweb.controller;

import br.com.projetoweb.projetoweb.AuthHandler;
import br.com.projetoweb.projetoweb.entity.PerfilUsuario;
import br.com.projetoweb.projetoweb.entity.Produto;
import br.com.projetoweb.projetoweb.entity.Usuario;
import br.com.projetoweb.projetoweb.entity.Venda;
import br.com.projetoweb.projetoweb.repository.PerfilUsuarioRepository;
import br.com.projetoweb.projetoweb.repository.ProdutoRepository;
import br.com.projetoweb.projetoweb.repository.UsuarioRepository;
import br.com.projetoweb.projetoweb.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioRepository _usuarioRepository;
    @Autowired
    private PerfilUsuarioRepository _perfilUsuarioRepository;
    @Autowired
    private VendaRepository _vendaRepository;
    @Autowired
    private ProdutoRepository _produtoRepository;


    // Method GET
    @GetMapping
    public List<Usuario> Get() {
        return _usuarioRepository.findAll();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
        //TODO: verificar se login e/ou senha já existem
        List<PerfilUsuario> perfis = _perfilUsuarioRepository.findByNome(usuario.getPerfilUsuario().getNome());
        if (!perfis.isEmpty()) {
            usuario.setPerfilUsuario(perfis.get(0));
        }
        Usuario createdUser = _usuarioRepository.save(usuario);
        if (_usuarioRepository.findById(createdUser.getIdUsuario()).isPresent()) {
            return ResponseEntity.ok(createdUser);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Usuario> editar(@RequestBody @Valid Usuario usuario) {
        if (usuario.getIdUsuario() == 0) {
            return ResponseEntity.notFound().build();
        }
        if (!_usuarioRepository.findById(usuario.getIdUsuario()).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Usuario editedUser = _usuarioRepository.save(usuario);
        if (editedUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(editedUser);
    }

    @PostMapping("/excluir")
    public ResponseEntity<Usuario> delete(@RequestBody Usuario usuario) {
        if(usuario.getIdUsuario() == 0){
            return ResponseEntity.badRequest().build();
        }
        _usuarioRepository.delete(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/perfil")
    public List<PerfilUsuario> listPerfil() {
        return _perfilUsuarioRepository.findAll();
    }


}
