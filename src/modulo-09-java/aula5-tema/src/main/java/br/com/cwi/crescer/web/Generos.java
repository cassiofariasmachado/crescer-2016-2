/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.web;

import br.com.cwi.crescer.beans.GeneroBean;
import br.com.cwi.crescer.entidades.Genero;
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
public class Generos {

    @EJB
    private GeneroBean generoBean;

    private Genero genero;
    private List<Genero> generos;

    @PostConstruct
    public void init() {
        this.genero = new Genero();
        this.generos = generoBean.findAll();
        this.generos.sort((a, b) -> a.getId().compareTo(b.getId()));
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public void adicionar() {
        generoBean.insert(genero);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Genero cadastrado com sucesso!", "genero"));
    }
}
