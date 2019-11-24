package br.com.projetoweb.projetoweb.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_Produtos")
public class Produto {
    @Id
    @Column(name = "idProduto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProduto;

    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;

    @JsonProperty("descricao")
    @Column(nullable = false)
    private String descricao;

    @JsonProperty("preco")
    @Column(nullable = false)
    private float preco;

    @ManyToMany(mappedBy="produto")
    private List<Venda> venda;




    public long getIdProduto() { return idProduto; }
    public void setIdProduto(long idProduto) { this.idProduto = idProduto; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public float getPreco() { return preco; }
    public void setPreco(float preco) { this.preco = preco; }

    public List<Venda> getVenda() { return venda; }
    public void setVenda(List<Venda> venda) { this.venda = venda; }
}
