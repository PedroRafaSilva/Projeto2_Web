package com.example.projeto2_web.Classes.AgendamentoExtra;

import com.example.projeto2_web.Classes.Agendamento.Agendamento;
import com.example.projeto2_web.Classes.Extra.Extra;
import jakarta.persistence.*;

@Entity
@IdClass(AgendamentoExtraPK.class)
@Table(name = "\"Projecto1\".\"AgendamentoExtra\"")
public class AgendamentoExtra {

    @Id
    @Column(name = "idagendamento")
    private int idagendamento;
    @Id
    @Column(name = "idextra")
    private int idextra;
    @Basic
    @Column(name = "valorextra")
    private Float valorextra;
    @Basic
    @Column(name = "qtd")
    private Integer qtd;
    @ManyToOne
    @JoinColumn(name = "idagendamento", referencedColumnName = "idagendamento", nullable = false, updatable = false, insertable = false)
    private Agendamento agendamentoByIdagendamento;
    @ManyToOne
    @JoinColumn(name = "idextra", referencedColumnName = "idextra", nullable = false, updatable = false, insertable = false)
    private Extra extraByIdextra;

    public int getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(int idagendamento) {
        this.idagendamento = idagendamento;
    }

    public int getIdextra() {
        return idextra;
    }

    public void setIdextra(int idextra) {
        this.idextra = idextra;
    }

    public Float getValorextra() {
        return valorextra;
    }

    public void setValorextra(Float valorextra) {
        this.valorextra = valorextra;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgendamentoExtra that = (AgendamentoExtra) o;

        if (idagendamento != that.idagendamento) return false;
        if (idextra != that.idextra) return false;
        if (valorextra != null ? !valorextra.equals(that.valorextra) : that.valorextra != null) return false;
        if (qtd != null ? !qtd.equals(that.qtd) : that.qtd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idagendamento;
        result = 31 * result + idextra;
        result = 31 * result + (valorextra != null ? valorextra.hashCode() : 0);
        result = 31 * result + (qtd != null ? qtd.hashCode() : 0);
        return result;
    }

    public Agendamento getAgendamentoByIdagendamento() {
        return agendamentoByIdagendamento;
    }

    public void setAgendamentoByIdagendamento(Agendamento agendamentoByIdagendamento) {
        this.agendamentoByIdagendamento = agendamentoByIdagendamento;
    }

    public Extra getExtraByIdextra() {
        return extraByIdextra;
    }

    public void setExtraByIdextra(Extra extraByIdextra) {
        this.extraByIdextra = extraByIdextra;
    }
}
