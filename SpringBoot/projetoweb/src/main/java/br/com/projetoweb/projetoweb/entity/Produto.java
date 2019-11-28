package br.com.projetoweb.projetoweb.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idProduto")
    private long idProduto;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "descricao")
    private String descricao;

    @Column(nullable = false, name = "preco")
    private float preco;

//    @ManyToMany(mappedBy = "produtos")
//    private Set<Venda> vendas = new HashSet<Venda>();

    public long getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

//    public Set<Venda> getVendas() {
//        return vendas;
//    }
}
