package com.example.projeto2_web.Classes.ListaEstadoFatura;

import com.example.projeto2_web.Classes.EstadoPagamento.EstadoPagamento;
import com.example.projeto2_web.Classes.Fatura.Fatura;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "\"Projecto1\".\"ListaEstadoFatura\"")
@IdClass(ListaEstadoFaturaPK.class)
public class ListaEstadoFatura {
    @Id
    @Column(name = "idfatura")
    private int idfatura;
    @Id
    @Column(name = "idestado")
    private int idestado;
    @Basic
    @Column(name = "data")
    private Date data;
    @ManyToOne
    @JoinColumn(name = "idfatura", referencedColumnName = "idfatura", nullable = false, updatable = false, insertable = false)
    private Fatura faturaByIdfatura;
    @ManyToOne
    @JoinColumn(name = "idestado", referencedColumnName = "idestado", nullable = false, updatable = false, insertable = false)
    private EstadoPagamento estadoPagamentoByIdestado;

    public int getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(int idfatura) {
        this.idfatura = idfatura;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaEstadoFatura that = (ListaEstadoFatura) o;

        if (idfatura != that.idfatura) return false;
        if (idestado != that.idestado) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfatura;
        result = 31 * result + idestado;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    public Fatura getFaturaByIdfatura() {
        return faturaByIdfatura;
    }

    public void setFaturaByIdfatura(Fatura faturaByIdfatura) {
        this.faturaByIdfatura = faturaByIdfatura;
    }

    public EstadoPagamento getEstadoPagamentoByIdestado() {
        return estadoPagamentoByIdestado;
    }

    public void setEstadoPagamentoByIdestado(EstadoPagamento estadoPagamentoByIdestado) {
        this.estadoPagamentoByIdestado = estadoPagamentoByIdestado;
    }
}
