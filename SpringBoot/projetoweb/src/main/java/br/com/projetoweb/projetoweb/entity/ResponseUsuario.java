package br.com.projetoweb.projetoweb.entity;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseUsuario {

    private String nome;
    private Boolean ativo;
    private String role;

    public ResponseUsuario(Usuario usuario) {
        this.nome = usuario.getNome();
        this.ativo = usuario.getAtivo();
        this.role = usuario.getUserProfile().getRole();
    }


    public static List<ResponseUsuario> converter(List<Usuario> usuario) {
        return usuario.stream().map(ResponseUsuario::new).collect(Collectors.toList());
    }



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}


