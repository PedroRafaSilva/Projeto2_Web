package com.example.projeto2_web.Classes.Agendamento;

import com.example.projeto2_web.Classes.AgendamentoExtra.AgendamentoExtra;
import com.example.projeto2_web.Classes.Embarcacao.Embarcacao;
import com.example.projeto2_web.Classes.Fatura.Fatura;
import com.example.projeto2_web.Classes.ListaEstadoAgendamento.ListaEstadoAgendamento;
import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "\"Projecto1\".\"Agendamento\"")
public class Agendamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idagendamento")
    private int idagendamento;
    @Basic
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "valorextras")
    private Float valorextras;
    @Basic
    @Column(name = "idembarcacao")
    private Integer idembarcacao;
    @Basic
    @Column(name = "idfatura")
    private Integer idfatura;
    @Basic
    @Column(name = "horainicio")
    private Time horainicio;
    @Basic
    @Column(name = "idutilizador")
    private Integer idutilizador;
    @Basic
    @Column(name = "horafim")
    private Time horafim;
    @ManyToOne
    @JoinColumn(name = "idembarcacao", referencedColumnName = "idembarcacao", updatable = false, insertable = false)
    private Embarcacao embarcacaoByIdembarcacao;
    @ManyToOne
    @JoinColumn(name = "idfatura", referencedColumnName = "idfatura", updatable = false, insertable = false)
    private Fatura faturaByIdfatura;
    @ManyToOne
    @JoinColumn(name = "idutilizador", referencedColumnName = "idutilizador", updatable = false, insertable = false)
    private Utilizador utilizadorByIdutilizador;
    @OneToMany(mappedBy = "agendamentoByIdagendamento", cascade = CascadeType.REMOVE)
    private Collection<AgendamentoExtra> agendamentoExtrasByIdagendamento;
    @OneToMany(mappedBy = "agendamentoByIdagendamento" , cascade = CascadeType.REMOVE)
    @OrderBy("data DESC")
    private Collection<ListaEstadoAgendamento> listaEstadoAgendamentosByIdagendamento;

    public int getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(int idagendamento) {
        this.idagendamento = idagendamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getValorextras() {
        return valorextras;
    }

    public void setValorextras(Float valorextras) {
        this.valorextras = valorextras;
    }

    public Integer getIdembarcacao() {
        return idembarcacao;
    }

    public void setIdembarcacao(Integer idembarcacao) {
        this.idembarcacao = idembarcacao;
    }

    public Integer getIdfatura() {
        return idfatura;
    }

    public void setIdfatura(Integer idfatura) {
        this.idfatura = idfatura;
    }

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {
        this.horainicio = horainicio;
    }

    public Integer getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(Integer idutilizador) {
        this.idutilizador = idutilizador;
    }

    public Time getHorafim() {
        return horafim;
    }

    public void setHorafim(Time horafim) {
        this.horafim = horafim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agendamento that = (Agendamento) o;

        if (idagendamento != that.idagendamento) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (valorextras != null ? !valorextras.equals(that.valorextras) : that.valorextras != null) return false;
        if (idembarcacao != null ? !idembarcacao.equals(that.idembarcacao) : that.idembarcacao != null) return false;
        if (idfatura != null ? !idfatura.equals(that.idfatura) : that.idfatura != null) return false;
        if (horainicio != null ? !horainicio.equals(that.horainicio) : that.horainicio != null) return false;
        if (idutilizador != null ? !idutilizador.equals(that.idutilizador) : that.idutilizador != null) return false;
        if (horafim != null ? !horafim.equals(that.horafim) : that.horafim != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idagendamento;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valorextras != null ? valorextras.hashCode() : 0);
        result = 31 * result + (idembarcacao != null ? idembarcacao.hashCode() : 0);
        result = 31 * result + (idfatura != null ? idfatura.hashCode() : 0);
        result = 31 * result + (horainicio != null ? horainicio.hashCode() : 0);
        result = 31 * result + (idutilizador != null ? idutilizador.hashCode() : 0);
        result = 31 * result + (horafim != null ? horafim.hashCode() : 0);
        return result;
    }

    public Embarcacao getEmbarcacaoByIdembarcacao() {
        return embarcacaoByIdembarcacao;
    }

    public void setEmbarcacaoByIdembarcacao(Embarcacao embarcacaoByIdembarcacao) {
        this.embarcacaoByIdembarcacao = embarcacaoByIdembarcacao;
    }

    public Fatura getFaturaByIdfatura() {
        return faturaByIdfatura;
    }

    public void setFaturaByIdfatura(Fatura faturaByIdfatura) {
        this.faturaByIdfatura = faturaByIdfatura;
    }

    public Utilizador getUtilizadorByIdutilizador() {
        return utilizadorByIdutilizador;
    }

    public void setUtilizadorByIdutilizador(Utilizador utilizadorByIdutilizador) {
        this.utilizadorByIdutilizador = utilizadorByIdutilizador;
    }

    public Collection<AgendamentoExtra> getAgendamentoExtrasByIdagendamento() {
        return agendamentoExtrasByIdagendamento;
    }

    public void setAgendamentoExtrasByIdagendamento(Collection<AgendamentoExtra> agendamentoExtrasByIdagendamento) {
        this.agendamentoExtrasByIdagendamento = agendamentoExtrasByIdagendamento;
    }

    public Collection<ListaEstadoAgendamento> getListaEstadoAgendamentosByIdagendamento() {
        return listaEstadoAgendamentosByIdagendamento;
    }

    public void setListaEstadoAgendamentosByIdagendamento(Collection<ListaEstadoAgendamento> listaEstadoAgendamentosByIdagendamento) {
        this.listaEstadoAgendamentosByIdagendamento = listaEstadoAgendamentosByIdagendamento;
    }
}
