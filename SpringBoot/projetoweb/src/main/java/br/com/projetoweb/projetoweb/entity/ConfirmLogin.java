package br.com.projetoweb.projetoweb.entity;

import javax.persistence.Column;

public class ConfirmLogin {

    @Column(name = "login")
    public String login;

    @Column(name = "senha")
    public String senha;

    public String getLogin() {
        return login;
    }
    public void setLogin(String email) {
        this.login = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
