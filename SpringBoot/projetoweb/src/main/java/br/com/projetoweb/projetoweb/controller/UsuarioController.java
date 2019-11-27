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

@CrossOrigin
@RestController
@RequestMapping(value = "/usuario")
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
        //TODO: verificar se login e/ou seja já existem
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

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, Object> credentials, HttpSession session) {
        String login = (String) credentials.get("login");
        String password = (String) credentials.get("password");
        List<Usuario> users = _usuarioRepository.findByLoginAndSenha(login, password);
        if (!users.isEmpty()) {
            Usuario foundUser = users.get(0);
            UUID sessionId = UUID.randomUUID();
            session.setAttribute(sessionId.toString(), foundUser);
            Map<String, String> map = new HashMap<String, String>();
            map.put("username", foundUser.getNome());
            map.put("profile", foundUser.getPerfilUsuario().getNome());
            map.put("token", sessionId.toString());
            return ResponseEntity.ok(map);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/usuario/new", method = RequestMethod.GET)
    public void insert() {
        PerfilUsuario pu = new PerfilUsuario();
        pu.setNome("Administrador");
        _perfilUsuarioRepository.save(pu);

        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");
        usuario.setPerfilUsuario(pu);
        usuario.setLogin("pedro");
        usuario.setSenha("senhaTeste");
        _usuarioRepository.save(usuario);
    }


    @RequestMapping(value = "/usuario/venda", method = RequestMethod.GET)
    public void newVenda() {
        Venda venda = new Venda();

        List<Usuario> usuarios = _usuarioRepository.findAll();
        Usuario usuario = usuarios.get(0);
        Produto produto = new Produto();


        produto.setNome("p1");
        produto.setDescricao("p1");
        produto.setPreco((float) 1.10);
        _produtoRepository.save(produto);
        venda.addProduto(produto);
        produto = new Produto();

        produto.setNome("p2");
        produto.setDescricao("p2");
        produto.setPreco((float) 2.10);
        _produtoRepository.save(produto);
        venda.addProduto(produto);
        produto = new Produto();

        produto.setNome("p3");
        produto.setDescricao("p3");
        produto.setPreco((float) 3.10);
        _produtoRepository.save(produto);
        venda.addProduto(produto);
        produto = new Produto();

        produto.setNome("p4");
        produto.setDescricao("p4");
        produto.setPreco((float) 4.10);
        _produtoRepository.save(produto);
        venda.addProduto(produto);

        venda.setUsuario(usuario);
        venda.setDataVenda(Timestamp.from(Instant.now()));
        _vendaRepository.save(venda);

    }


}
