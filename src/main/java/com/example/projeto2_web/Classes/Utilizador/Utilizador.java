package com.example.projeto2_web.Classes.Utilizador;

import com.example.projeto2_web.Classes.Agendamento.Agendamento;
import com.example.projeto2_web.Classes.Embarcacao.Embarcacao;
import com.example.projeto2_web.Classes.Fatura.Fatura;
import com.example.projeto2_web.Classes.Pagamento.Pagamento;
import com.example.projeto2_web.Classes.PedidoManutencao.PedidoManutencao;
import com.example.projeto2_web.Classes.TipoUtilizador.TipoUtilizador;
import com.example.projeto2_web.Classes.CodPostal.CodPostal;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "\"Projecto1\".\"Utilizador\"")
public class Utilizador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idutilizador")
    private int idutilizador;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "telefone")
    private String telefone;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "nif")
    private Integer nif;
    @Basic
    @Column(name = "rua")
    private String rua;
    @Basic
    @Column(name = "porta")
    private Integer porta;
    @Basic
    @Column(name = "cpostal")
    private String cpostal;
    @Basic
    @Column(name = "idtipoutilizador")
    private Integer idtipoutilizador;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "utilizadorByIdutilizador", cascade = CascadeType.REMOVE)
    private Collection<Agendamento> agendamentosByIdutilizador;
    @OneToMany(mappedBy = "utilizadorByIdutilizador", cascade = CascadeType.REMOVE)
    private Collection<Embarcacao> embarcacaosByIdutilizador;
    @OneToMany(mappedBy = "utilizadorByIdutilizador", cascade = CascadeType.REMOVE)
    private Collection<Fatura> faturasByIdutilizador;
    @OneToMany(mappedBy = "utilizadorByIdutilizador", cascade = CascadeType.REMOVE)
    private Collection<Pagamento> pagamentosByIdutilizador;
    @OneToMany(mappedBy = "utilizadorByIdutilizador", cascade = CascadeType.REMOVE)
    private Collection<PedidoManutencao> pedidoManutencaosByIdutilizador;
    @ManyToOne
    @JoinColumn(name = "cpostal", referencedColumnName = "cpostal", updatable = false, insertable = false)
    private CodPostal codPostalByCpostal;
    @ManyToOne
    @JoinColumn(name = "idtipoutilizador", referencedColumnName = "idtipoutilizador", updatable = false, insertable = false)
    private TipoUtilizador tipoUtilizadorByIdtipoutilizador;

    public int getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(int idutilizador) {
        this.idutilizador = idutilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    public Integer getIdtipoutilizador() {
        return idtipoutilizador;
    }

    public void setIdtipoutilizador(Integer idtipoutilizador) {
        this.idtipoutilizador = idtipoutilizador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilizador that = (Utilizador) o;

        if (idutilizador != that.idutilizador) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;
        if (rua != null ? !rua.equals(that.rua) : that.rua != null) return false;
        if (porta != null ? !porta.equals(that.porta) : that.porta != null) return false;
        if (cpostal != null ? !cpostal.equals(that.cpostal) : that.cpostal != null) return false;
        if (idtipoutilizador != null ? !idtipoutilizador.equals(that.idtipoutilizador) : that.idtipoutilizador != null)
            return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idutilizador;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (porta != null ? porta.hashCode() : 0);
        result = 31 * result + (cpostal != null ? cpostal.hashCode() : 0);
        result = 31 * result + (idtipoutilizador != null ? idtipoutilizador.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<Agendamento> getAgendamentosByIdutilizador() {
        return agendamentosByIdutilizador;
    }

    public void setAgendamentosByIdutilizador(Collection<Agendamento> agendamentosByIdutilizador) {
        this.agendamentosByIdutilizador = agendamentosByIdutilizador;
    }

    public Collection<Embarcacao> getEmbarcacaosByIdutilizador() {
        return embarcacaosByIdutilizador;
    }

    public void setEmbarcacaosByIdutilizador(Collection<Embarcacao> embarcacaosByIdutilizador) {
        this.embarcacaosByIdutilizador = embarcacaosByIdutilizador;
    }

    public Collection<Fatura> getFaturasByIdutilizador() {
        return faturasByIdutilizador;
    }

    public void setFaturasByIdutilizador(Collection<Fatura> faturasByIdutilizador) {
        this.faturasByIdutilizador = faturasByIdutilizador;
    }

    public Collection<Pagamento> getPagamentosByIdutilizador() {
        return pagamentosByIdutilizador;
    }

    public void setPagamentosByIdutilizador(Collection<Pagamento> pagamentosByIdutilizador) {
        this.pagamentosByIdutilizador = pagamentosByIdutilizador;
    }

    public Collection<PedidoManutencao> getPedidoManutencaosByIdutilizador() {
        return pedidoManutencaosByIdutilizador;
    }

    public void setPedidoManutencaosByIdutilizador(Collection<PedidoManutencao> pedidoManutencaosByIdutilizador) {
        this.pedidoManutencaosByIdutilizador = pedidoManutencaosByIdutilizador;
    }

    public CodPostal getCodPostalByCpostal() {
        return codPostalByCpostal;
    }

    public void setCodPostalByCpostal(CodPostal codPostalByCpostal) {
        this.codPostalByCpostal = codPostalByCpostal;
    }

    public TipoUtilizador getTipoUtilizadorByIdtipoutilizador() {
        return tipoUtilizadorByIdtipoutilizador;
    }

    public void setTipoUtilizadorByIdtipoutilizador(TipoUtilizador tipoUtilizadorByIdtipoutilizador) {
        this.tipoUtilizadorByIdtipoutilizador = tipoUtilizadorByIdtipoutilizador;
    }
}
