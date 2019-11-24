package br.com.projetoweb.projetoweb.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;


@Entity
@Table(name = "tbl_Vendas")
public class Venda {
    @Id
    @Column(name = "idVenda")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idVenda;

    @JsonProperty("dataVenda")
    @Column(name = "dataVenda")
    private Date dataVenda;

    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "pessoa_usuario_id", referencedColumnName = "idUsuario")


    @JoinTable(name="tbl_Produto_Venda",
            joinColumns = {@JoinColumn(name="idVenda", referencedColumnName = "idVenda")},
            inverseJoinColumns = {@JoinColumn(name="idProduto", referencedColumnName = "idProduto")})
    private List<Produto> produto;

    public long getIdVenda() { return idVenda; }
    public void setIdVenda(long idVenda) { this.idVenda = idVenda; }

    public Date getDataVenda() { return dataVenda; }
    public void setDataVenda(Date dataVenda) { this.dataVenda = dataVenda; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Produto> getProduto() { return produto; }
    public void setProduto(List<Produto> produto) { this.produto = produto; }
}
