package br.com.projetoweb.projetoweb.entity;


import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario")
    private long idUsuario;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "login")
    private String login;

    @Column(nullable = false, name = "senha")
    private String senha;

    @ManyToOne
    @JoinColumn
    private PerfilUsuario perfilUsuario;

    @Column(nullable = false, name = "ativo")
    private Boolean ativo = true;


    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
