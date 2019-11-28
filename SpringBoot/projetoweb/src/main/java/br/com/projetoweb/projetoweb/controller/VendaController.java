package br.com.projetoweb.projetoweb.controller;

import br.com.projetoweb.projetoweb.entity.Usuario;
import br.com.projetoweb.projetoweb.entity.Venda;
import br.com.projetoweb.projetoweb.repository.UsuarioRepository;
import br.com.projetoweb.projetoweb.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/venda")
@CrossOrigin
public class VendaController {
    @Autowired
    private VendaRepository _vendaRepository;
    @Autowired
    private UsuarioRepository _usuarioRepository;

    @GetMapping
    public List<Venda> get() {
        return _vendaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Venda> create(@RequestBody Venda venda) {
        List<Usuario> users = _usuarioRepository.findByIdUsuario(venda.getUsuario().getIdUsuario());
        if (!users.isEmpty()) {
            Usuario usuario = users.get(0);
            venda.setUsuario(usuario);
            venda.setDataVenda(Timestamp.from(Instant.now()));
            _vendaRepository.save(venda);
            return ResponseEntity.ok(venda);
        }
        return ResponseEntity.badRequest().build();
    }


}
