package br.com.projetoweb.projetoweb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idPerfilUsuario", nullable = false)
    private long idPerfilUsuario;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "perfilUsuario", cascade = CascadeType.ALL)
    private Set<Usuario> usuarios;

    public long getIdPerfilUsuario() {
        return idPerfilUsuario;
    }

    public void setIdPerfilUsuario(int idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
