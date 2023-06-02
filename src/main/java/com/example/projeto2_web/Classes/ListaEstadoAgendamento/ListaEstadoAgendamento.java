package com.example.projeto2_web.Classes.ListaEstadoAgendamento;

import com.example.projeto2_web.Classes.Agendamento.Agendamento;
import com.example.projeto2_web.Classes.EstadoAgendamento.EstadoAgendamento;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "\"Projecto1\".\"ListaEstadoAgendamento\"")
@IdClass(ListaEstadoAgendamentoPK.class)
public class ListaEstadoAgendamento {
    @Id
    @Column(name = "idagendamento")
    private int idagendamento;
    @Id
    @Column(name = "idestado")
    private int idestado;
    @Basic
    @Column(name = "data")
    private Date data;
    @ManyToOne
    @JoinColumn(name = "idagendamento", referencedColumnName = "idagendamento", nullable = false, updatable = false, insertable = false)
    private Agendamento agendamentoByIdagendamento;
    @ManyToOne
    @JoinColumn(name = "idestado", referencedColumnName = "idestado", nullable = false, updatable = false, insertable = false)
    private EstadoAgendamento estadoAgendamentoByIdestado;

    public int getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(int idagendamento) {
        this.idagendamento = idagendamento;
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

        ListaEstadoAgendamento that = (ListaEstadoAgendamento) o;

        if (idagendamento != that.idagendamento) return false;
        if (idestado != that.idestado) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idagendamento;
        result = 31 * result + idestado;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    public Agendamento getAgendamentoByIdagendamento() {
        return agendamentoByIdagendamento;
    }

    public void setAgendamentoByIdagendamento(Agendamento agendamentoByIdagendamento) {
        this.agendamentoByIdagendamento = agendamentoByIdagendamento;
    }

    public EstadoAgendamento getEstadoAgendamentoByIdestado() {
        return estadoAgendamentoByIdestado;
    }

    public void setEstadoAgendamentoByIdestado(EstadoAgendamento estadoAgendamentoByIdestado) {
        this.estadoAgendamentoByIdestado = estadoAgendamentoByIdestado;
    }
}
