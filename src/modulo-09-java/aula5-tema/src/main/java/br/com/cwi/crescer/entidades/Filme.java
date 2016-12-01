/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cfari
 */
@Entity
@Table(name = "FILME")
@NamedQueries({
    @NamedQuery(name = "Filme.findAll", query = "SELECT f FROM Filme f")
    , @NamedQuery(name = "Filme.findById", query = "SELECT f FROM Filme f WHERE f.id = :id")
    , @NamedQuery(name = "Filme.findByTitulo", query = "SELECT f FROM Filme f WHERE f.titulo = :titulo")
    , @NamedQuery(name = "Filme.findByDatalancamento", query = "SELECT f FROM Filme f WHERE f.dataLancamento = :dataLancamento")})
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigInteger id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITULO")
    private String titulo;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO")
    private Date dataLancamento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DIRETOR")
    private String diretor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CLASSIFICACAO", referencedColumnName = "ID")
    private Classificacao classificacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_ELENCO", referencedColumnName = "ID")
    private Elenco elenco;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_GENERO", referencedColumnName = "ID")
    private Genero genero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_IDIOMA", referencedColumnName = "ID")
    private Idioma idioma;

    public Filme() {
    }

    public Filme(BigInteger id) {
        this.id = id;
    }

    public Filme(BigInteger id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDatalancamento() {
        return dataLancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.dataLancamento = datalancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
}
