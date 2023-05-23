package com.example.projeto2_web.Classes.PedidoManutencao;

import com.example.projeto2_web.Classes.Embarcacao.Embarcacao;
import com.example.projeto2_web.Classes.Fatura.Fatura;
import com.example.projeto2_web.Classes.Oficina.Oficina;
import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import com.example.projeto2_web.Classes.PedidoDescricao.PedidoDescricao;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "\"Projecto1\".\"PedidoManutencao\"")
public class PedidoManutencao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpedido")
    private int idpedido;
    @Basic
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "valor")
    private float valor;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "idembarcacao")
    private int idembarcacao;
    @Basic
    @Column(name = "idoficina")
    private int idoficina;
    @Basic
    @Column(name = "idutilizador")
    private int idutilizador;
    @Basic
    @Column(name = "idfatura")
    private int idfatura;
    @ManyToOne
    @JoinColumn(name = "descricao", referencedColumnName = "descricao", nullable = false, updatable = false, insertable = false)
    private PedidoDescricao pedidoDescricaoByDescricao;
    @ManyToOne
    @JoinColumn(name = "idembarcacao", referencedColumnName = "idembarcacao", nullable = false, updatable = false, insertable = false)
    private Embarcacao embarcacaoByIdembarcacao;
    @ManyToOne
    @JoinColumn(name = "idoficina", referencedColumnName = "idoficina", nullable = false, updatable = false, insertable = false)
    private Oficina oficinaByIdoficina;
    @ManyToOne
    @JoinColumn(name = "idutilizador", referencedColumnName = "idutilizador", nullable = false, updatable = false, insertable = false)
    private Utilizador utilizadorByIdutilizador;
    @ManyToOne
    @JoinColumn(name = "idfatura", referencedColumnName = "idfatura", nullable = false, updatable = false, insertable = false)
    private Fatura faturaByIdfatura;

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdembarcacao() {
        return idembarcacao;
    }

    public void setIdembarcacao(int idembarcacao) {
        this.idembarcacao = idembarcacao;
    }

    public int getIdoficina() {
        return idoficina;
    }

    public void setIdoficina(int idoficina) {
        this.idoficina = idoficina;
    }

    public int getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(int idutilizador) {
        this.idutilizador = idutilizador;
    }

    public int getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(int idfatura) {
        this.idfatura = idfatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoManutencao that = (PedidoManutencao) o;

        if (idpedido != that.idpedido) return false;
        if (Float.compare(that.valor, valor) != 0) return false;
        if (idembarcacao != that.idembarcacao) return false;
        if (idoficina != that.idoficina) return false;
        if (idutilizador != that.idutilizador) return false;
        if (idfatura != that.idfatura) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpedido;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valor != +0.0f ? Float.floatToIntBits(valor) : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + idembarcacao;
        result = 31 * result + idoficina;
        result = 31 * result + idutilizador;
        result = 31 * result + idfatura;
        return result;
    }

    public PedidoDescricao getPedidoDescricaoByDescricao() {
        return pedidoDescricaoByDescricao;
    }

    public void setPedidoDescricaoByDescricao(PedidoDescricao pedidoDescricaoByDescricao) {
        this.pedidoDescricaoByDescricao = pedidoDescricaoByDescricao;
    }

    public Embarcacao getEmbarcacaoByIdembarcacao() {
        return embarcacaoByIdembarcacao;
    }

    public void setEmbarcacaoByIdembarcacao(Embarcacao embarcacaoByIdembarcacao) {
        this.embarcacaoByIdembarcacao = embarcacaoByIdembarcacao;
    }

    public Oficina getOficinaByIdoficina() {
        return oficinaByIdoficina;
    }

    public void setOficinaByIdoficina(Oficina oficinaByIdoficina) {
        this.oficinaByIdoficina = oficinaByIdoficina;
    }

    public Utilizador getUtilizadorByIdutilizador() {
        return utilizadorByIdutilizador;
    }

    public void setUtilizadorByIdutilizador(Utilizador utilizadorByIdutilizador) {
        this.utilizadorByIdutilizador = utilizadorByIdutilizador;
    }

    public Fatura getFaturaByIdfatura() {
        return faturaByIdfatura;
    }

    public void setFaturaByIdfatura(Fatura faturaByIdfatura) {
        this.faturaByIdfatura = faturaByIdfatura;
    }
}
