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
import br.com.cwi.crescer.utils.FacesUtils;
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

    private List<Classificacao> classificacoes;
    private List<Elenco> elencos;
    private List<Genero> generos;
    private List<Idioma> idiomas;

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

    public void adicionar() {
        filmeBean.insert(filme);
        this.init();
        FacesUtils.addSuccessMessage("Filme cadastrado com sucesso!");
    }
}
