package com.example.projeto2_web.Classes.ListaEmbarcacao;

import com.example.projeto2_web.Classes.Embarcacao.Embarcacao;
import com.example.projeto2_web.Classes.Fatura.Fatura;
import jakarta.persistence.*;

@Entity
@Table(name = "\"Projecto1\".\"ListaEmbarcacao\"")
@IdClass(ListaEmbarcacaoPK.class)
public class ListaEmbarcacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfatura")
    private int idfatura;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idembarcacao")
    private int idembarcacao;
    @Basic
    @Column(name = "valorpagar")
    private Float valorpagar;
    @ManyToOne
    @JoinColumn(name = "idfatura", referencedColumnName = "idfatura", nullable = false, updatable = false, insertable = false)
    private Fatura faturaByIdfatura;
    @ManyToOne
    @JoinColumn(name = "idembarcacao", referencedColumnName = "idembarcacao", nullable = false, updatable = false, insertable = false)
    private Embarcacao embarcacaoByIdembarcacao;

    public int getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(int idfatura) {
        this.idfatura = idfatura;
    }

    public int getIdembarcacao() {
        return idembarcacao;
    }

    public void setIdembarcacao(int idembarcacao) {
        this.idembarcacao = idembarcacao;
    }

    public Float getValorpagar() {
        return valorpagar;
    }

    public void setValorpagar(Float valorpagar) {
        this.valorpagar = valorpagar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEmbarcacao that = (ListaEmbarcacao) o;

        if (idfatura != that.idfatura) return false;
        if (idembarcacao != that.idembarcacao) return false;
        if (valorpagar != null ? !valorpagar.equals(that.valorpagar) : that.valorpagar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfatura;
        result = 31 * result + idembarcacao;
        result = 31 * result + (valorpagar != null ? valorpagar.hashCode() : 0);
        return result;
    }

    public Fatura getFaturaByIdfatura() {
        return faturaByIdfatura;
    }

    public void setFaturaByIdfatura(Fatura faturaByIdfatura) {
        this.faturaByIdfatura = faturaByIdfatura;
    }

    public Embarcacao getEmbarcacaoByIdembarcacao() {
        return embarcacaoByIdembarcacao;
    }

    public void setEmbarcacaoByIdembarcacao(Embarcacao embarcacaoByIdembarcacao) {
        this.embarcacaoByIdembarcacao = embarcacaoByIdembarcacao;
    }
}
