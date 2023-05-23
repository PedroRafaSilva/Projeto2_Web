package com.example.projeto2_web.Classes.Comprimento;

import com.example.projeto2_web.Classes.Embarcacao.Embarcacao;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "\"Projecto1\".\"Comprimento\"")
public class Comprimento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "comprimento")
    private int comprimento;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "valorcomprimento")
    private Float valorcomprimento;
    @OneToMany(mappedBy = "comprimentoByComprimento")
    private Collection<Embarcacao> embarcacaosByComprimento;

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValorcomprimento() {
        return valorcomprimento;
    }

    public void setValorcomprimento(Float valorcomprimento) {
        this.valorcomprimento = valorcomprimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comprimento that = (Comprimento) o;

        if (comprimento != that.comprimento) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (valorcomprimento != null ? !valorcomprimento.equals(that.valorcomprimento) : that.valorcomprimento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = comprimento;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (valorcomprimento != null ? valorcomprimento.hashCode() : 0);
        return result;
    }

    public Collection<Embarcacao> getEmbarcacaosByComprimento() {
        return embarcacaosByComprimento;
    }

    public void setEmbarcacaosByComprimento(Collection<Embarcacao> embarcacaosByComprimento) {
        this.embarcacaosByComprimento = embarcacaosByComprimento;
    }
}
