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
public class Filme implements Serializable, IEntidade {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private BigInteger id;

    @Basic(optional = false)
    @Column(name = "TITULO", nullable = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String titulo;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO")
    private Date dataLancamento;

    @Basic(optional = false)
    @Column(name = "DIRETOR", nullable = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String diretor;

    @Basic(optional = false)
    @Column(name = "URL_THUMBNAIL", nullable = false)
    @NotNull
    private String urlThumbnail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CLASSIFICACAO", referencedColumnName = "ID", nullable = false)
    @NotNull
    private Classificacao classificacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_ELENCO", referencedColumnName = "ID", nullable = false)
    @NotNull
    private Elenco elenco;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_GENERO", referencedColumnName = "ID", nullable = false)
    @NotNull
    private Genero genero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_IDIOMA", referencedColumnName = "ID", nullable = false)
    @NotNull
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

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getUrlThumbnail() {
        return urlThumbnail;
    }

    public void setUrlThumbnail(String urlThumbnail) {
        this.urlThumbnail = urlThumbnail;
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
