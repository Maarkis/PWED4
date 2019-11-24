package br.com.projetoweb.projetoweb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "tbl_PerfilUsuario")
public class PerfilUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerfilUsuario")
    private long idPerfilUsuario;

    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;

    @JsonProperty("descricao")
    @Column(nullable = false)
    private String descricao;

    public long getIdPerfilUsuario() { return idPerfilUsuario; }
    public void setIdPerfilUsuario(long idPerfilUsuario) { this.idPerfilUsuario = idPerfilUsuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
