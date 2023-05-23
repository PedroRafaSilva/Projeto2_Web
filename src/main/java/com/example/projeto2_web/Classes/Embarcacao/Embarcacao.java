package com.example.projeto2_web.Classes.Embarcacao;

import com.example.projeto2_web.Classes.Agendamento.Agendamento;
import com.example.projeto2_web.Classes.Comprimento.Comprimento;
import com.example.projeto2_web.Classes.ListaEmbarcacao.ListaEmbarcacao;
import com.example.projeto2_web.Classes.Marina.Marina;
import com.example.projeto2_web.Classes.PedidoManutencao.PedidoManutencao;
import com.example.projeto2_web.Classes.Utilizador.Utilizador;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "\"Projecto1\".\"Embarcacao\"")
public class Embarcacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idembarcacao")
    private int idembarcacao;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "idutilizador")
    private Integer idutilizador;
    @Basic
    @Column(name = "idmarina")
    private Integer idmarina;
    @Basic
    @Column(name = "comprimento")
    private int comprimento;
    @OneToMany(mappedBy = "embarcacaoByIdembarcacao")
    private Collection<Agendamento> agendamentosByIdembarcacao;
    @ManyToOne
    @JoinColumn(name = "idutilizador", referencedColumnName = "idutilizador", updatable = false, insertable = false)
    private Utilizador utilizadorByIdutilizador;
    @ManyToOne
    @JoinColumn(name = "idmarina", referencedColumnName = "idmarina", updatable = false, insertable = false)
    private Marina marinaByIdmarina;
    @ManyToOne
    @JoinColumn(name = "comprimento", referencedColumnName = "comprimento", nullable = false, updatable = false, insertable = false)
    private Comprimento comprimentoByComprimento;
    @OneToMany(mappedBy = "embarcacaoByIdembarcacao")
    private Collection<ListaEmbarcacao> listaEmbarcacaosByIdembarcacao;
    @OneToMany(mappedBy = "embarcacaoByIdembarcacao")
    private Collection<PedidoManutencao> pedidoManutencaosByIdembarcacao;

    public int getIdembarcacao() {
        return idembarcacao;
    }

    public void setIdembarcacao(int idembarcacao) {
        this.idembarcacao = idembarcacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(Integer idutilizador) {
        this.idutilizador = idutilizador;
    }

    public Integer getIdmarina() {
        return idmarina;
    }

    public void setIdmarina(Integer idmarina) {
        this.idmarina = idmarina;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Embarcacao that = (Embarcacao) o;

        if (idembarcacao != that.idembarcacao) return false;
        if (comprimento != that.comprimento) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (idutilizador != null ? !idutilizador.equals(that.idutilizador) : that.idutilizador != null) return false;
        if (idmarina != null ? !idmarina.equals(that.idmarina) : that.idmarina != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idembarcacao;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (idutilizador != null ? idutilizador.hashCode() : 0);
        result = 31 * result + (idmarina != null ? idmarina.hashCode() : 0);
        result = 31 * result + comprimento;
        return result;
    }

    public Collection<Agendamento> getAgendamentosByIdembarcacao() {
        return agendamentosByIdembarcacao;
    }

    public void setAgendamentosByIdembarcacao(Collection<Agendamento> agendamentosByIdembarcacao) {
        this.agendamentosByIdembarcacao = agendamentosByIdembarcacao;
    }

    public Utilizador getUtilizadorByIdutilizador() {
        return utilizadorByIdutilizador;
    }

    public void setUtilizadorByIdutilizador(Utilizador utilizadorByIdutilizador) {
        this.utilizadorByIdutilizador = utilizadorByIdutilizador;
    }

    public Marina getMarinaByIdmarina() {
        return marinaByIdmarina;
    }

    public void setMarinaByIdmarina(Marina marinaByIdmarina) {
        this.marinaByIdmarina = marinaByIdmarina;
    }

    public Comprimento getComprimentoByComprimento() {
        return comprimentoByComprimento;
    }

    public void setComprimentoByComprimento(Comprimento comprimentoByComprimento) {
        this.comprimentoByComprimento = comprimentoByComprimento;
    }

    public Collection<ListaEmbarcacao> getListaEmbarcacaosByIdembarcacao() {
        return listaEmbarcacaosByIdembarcacao;
    }

    public void setListaEmbarcacaosByIdembarcacao(Collection<ListaEmbarcacao> listaEmbarcacaosByIdembarcacao) {
        this.listaEmbarcacaosByIdembarcacao = listaEmbarcacaosByIdembarcacao;
    }

    public Collection<PedidoManutencao> getPedidoManutencaosByIdembarcacao() {
        return pedidoManutencaosByIdembarcacao;
    }

    public void setPedidoManutencaosByIdembarcacao(Collection<PedidoManutencao> pedidoManutencaosByIdembarcacao) {
        this.pedidoManutencaosByIdembarcacao = pedidoManutencaosByIdembarcacao;
    }
}
