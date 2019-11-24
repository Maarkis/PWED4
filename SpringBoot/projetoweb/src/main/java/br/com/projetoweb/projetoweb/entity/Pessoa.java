package br.com.projetoweb.projetoweb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "tbl_Pessoas")
public class Pessoa {
    @Id
    @Column(name = "idPessoa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPessoa;

    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;

    @JsonProperty("sobrenome")
    @Column(nullable = false)
    private String sobrenome;

    @JsonProperty("cpf")
    @Column(nullable = false)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "pessoa_usuario_id", referencedColumnName = "idUsuario")
    @JoinTable(name = "tbl_pessoa_usuario",
            joinColumns =
                    { @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa") },
            inverseJoinColumns =
                    { @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario") })
    private Usuario usuario;



    // Getters e Setters
    public long getIdPessoa() { return idPessoa; }
    public void setIdPessoa(long idPessoa) { this.idPessoa = idPessoa; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}