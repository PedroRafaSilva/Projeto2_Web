package com.example.projeto2_web.Classes.EstadoPagamento;

import com.example.projeto2_web.Classes.ListaEstadoFatura.ListaEstadoFatura;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "\"Projecto1\".\"EstadoPagamento\"")
public class EstadoPagamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idestado")
    private int idestado;
    @Basic
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "estadoPagamentoByIdestado", cascade = CascadeType.REMOVE)
    private Collection<ListaEstadoFatura> listaEstadoFaturasByIdestado;

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoPagamento that = (EstadoPagamento) o;

        if (idestado != that.idestado) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idestado;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<ListaEstadoFatura> getListaEstadoFaturasByIdestado() {
        return listaEstadoFaturasByIdestado;
    }

    public void setListaEstadoFaturasByIdestado(Collection<ListaEstadoFatura> listaEstadoFaturasByIdestado) {
        this.listaEstadoFaturasByIdestado = listaEstadoFaturasByIdestado;
    }
}
