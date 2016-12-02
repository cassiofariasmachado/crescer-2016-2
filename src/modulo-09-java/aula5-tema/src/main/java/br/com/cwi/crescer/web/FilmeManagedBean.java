/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.web;

import br.com.cwi.crescer.beans.ClassificacaoBean;
import br.com.cwi.crescer.beans.ElencoBean;
import br.com.cwi.crescer.beans.FilmeBean;
import br.com.cwi.crescer.beans.GeneroBean;
import br.com.cwi.crescer.beans.IdiomaBean;
import br.com.cwi.crescer.entidades.Classificacao;
import br.com.cwi.crescer.entidades.Elenco;
import br.com.cwi.crescer.entidades.Filme;
import br.com.cwi.crescer.entidades.Genero;
import br.com.cwi.crescer.entidades.Idioma;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cfari
 */
@ManagedBean
@ViewScoped
public class FilmeManagedBean {

    private static final SimpleDateFormat FORMATO_DATA_ENTRADA = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat FORMATO_DATA_SAIDA = new SimpleDateFormat("dd-MM-yyyy");

    @EJB
    private FilmeBean filmeBean;
    @EJB
    private ClassificacaoBean classificacaoBean;
    @EJB
    private ElencoBean elencoBean;
    @EJB
    private GeneroBean generoBean;
    @EJB
    private IdiomaBean idiomaBean;

    private Filme filme;
    private List<Filme> filmes;

    private String dataLancamento;
    private List<Classificacao> classificacoes;
    private List<Elenco> elencos;
    private List<Genero> generos;
    private List<Idioma> idiomas;

    private String idClassificacao;
    private String idElenco;
    private String idGenero;
    private String idIdiomas;

    @PostConstruct
    public void init() {
        this.filme = new Filme();

        this.filmes = filmeBean.findAll();
        this.filmes.sort((a, b) -> a.getId().compareTo(b.getId()));

        this.classificacoes = classificacaoBean.findAll();
        this.elencos = elencoBean.findAll();
        this.generos = generoBean.findAll();
        this.idiomas = idiomaBean.findAll();
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public String getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(String idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public String getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(String idElenco) {
        this.idElenco = idElenco;
    }

    public String getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(String idGenero) {
        this.idGenero = idGenero;
    }

    public String getIdIdiomas() {
        return idIdiomas;
    }

    public void setIdIdiomas(String idIdiomas) {
        this.idIdiomas = idIdiomas;
    }

    public void adicionar() {
        Date dataLancamento = this.converterDataLancamento();
        Classificacao classificacao = classificacoes.stream().filter(c -> c.getId().equals(new BigInteger(idClassificacao))).findFirst().get();
        Elenco elenco = elencos.stream().filter(e -> e.getId().equals(new BigInteger(idElenco))).findFirst().get();
        Genero genero = generos.stream().filter(g -> g.getId().equals(new BigInteger(idGenero))).findFirst().get();
        Idioma idioma = idiomas.stream().filter(i -> i.getId().equals(new BigInteger(idIdiomas))).findFirst().get();

        filme.setDatalancamento(dataLancamento);
        filme.setClassificacao(classificacao);
        filme.setElenco(elenco);
        filme.setGenero(genero);
        filme.setIdioma(idioma);

        filmeBean.insert(filme);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme cadastrado com sucesso!", "filme"));
    }

    public Date converterDataLancamento() {
        try {
            Date data = FORMATO_DATA_ENTRADA.parse(this.dataLancamento);
            return data;
        } catch (ParseException e) {
            System.err.format("Erro: %s", e.getMessage());
        }
        return null;
    }

    public String converterDataLancamento(Filme filme) {
        Date data = filme.getDatalancamento();

        if (data == null) {
            return "";
        }

        String dataSaida = FORMATO_DATA_SAIDA.format(data);
        return dataSaida;
    }
}
