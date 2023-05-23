package com.example.projeto2_web.Classes.Marina;

import com.example.projeto2_web.Classes.Embarcacao.Embarcacao;
import com.example.projeto2_web.Classes.CodPostal.CodPostal;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "\"Projecto1\".\"Marina\"")
public class Marina {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmarina")
    private int idmarina;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "cpostal")
    private String cpostal;
    @OneToMany(mappedBy = "marinaByIdmarina")
    private Collection<Embarcacao> embarcacaosByIdmarina;
    @ManyToOne
    @JoinColumn(name = "cpostal", referencedColumnName = "cpostal", updatable = false, insertable = false)
    private CodPostal codPostalByCpostal;

    public int getIdmarina() {
        return idmarina;
    }

    public void setIdmarina(int idmarina) {
        this.idmarina = idmarina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Marina marina = (Marina) o;

        if (idmarina != marina.idmarina) return false;
        if (nome != null ? !nome.equals(marina.nome) : marina.nome != null) return false;
        if (cpostal != null ? !cpostal.equals(marina.cpostal) : marina.cpostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmarina;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cpostal != null ? cpostal.hashCode() : 0);
        return result;
    }

    public Collection<Embarcacao> getEmbarcacaosByIdmarina() {
        return embarcacaosByIdmarina;
    }

    public void setEmbarcacaosByIdmarina(Collection<Embarcacao> embarcacaosByIdmarina) {
        this.embarcacaosByIdmarina = embarcacaosByIdmarina;
    }

    public CodPostal getCodPostalByCpostal() {
        return codPostalByCpostal;
    }

    public void setCodPostalByCpostal(CodPostal codPostalByCpostal) {
        this.codPostalByCpostal = codPostalByCpostal;
    }
}
