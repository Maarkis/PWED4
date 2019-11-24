package br.com.projetoweb.projetoweb.controller;

import br.com.projetoweb.projetoweb.entity.PerfilUsuario;
import br.com.projetoweb.projetoweb.entity.Produto;
import br.com.projetoweb.projetoweb.entity.Usuario;
import br.com.projetoweb.projetoweb.entity.Venda;
import br.com.projetoweb.projetoweb.repository.PerfilUsuarioRepository;
import br.com.projetoweb.projetoweb.repository.ProdutoRepository;
import br.com.projetoweb.projetoweb.repository.UsuarioRepository;
import br.com.projetoweb.projetoweb.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;


@RestController
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
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> Get() {
        return _usuarioRepository.findAll();
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

        Usuario usuario = _usuarioRepository.getOne(1L);
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
