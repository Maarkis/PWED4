package br.com.projetoweb.projetoweb.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "tbl_Venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idVenda")
    private long idVenda;

    @ManyToOne
    @JoinColumn
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "tbl_venda_produto",
            joinColumns = {@JoinColumn(name = "idVenda")},
            inverseJoinColumns = {@JoinColumn(name = "idProduto")}
    )
    private Set<Produto> produtos = new HashSet<Produto>();


    @Column(name = "dataVenda")
    private Timestamp dataVenda;

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Timestamp getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Timestamp dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
    }
}
