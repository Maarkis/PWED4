package br.com.projetoweb.projetoweb.entity;


import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "tbl_Usuario")
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
    private UserProfile userProfile;

    @Column(nullable = false, name = "ativo")
    private Boolean ativo = true;


    public long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(long idUsuario) {
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

    public UserProfile getUserProfile() {
        return userProfile;
    }
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    public Boolean getAtivo() {
        return ativo;
    }


}
