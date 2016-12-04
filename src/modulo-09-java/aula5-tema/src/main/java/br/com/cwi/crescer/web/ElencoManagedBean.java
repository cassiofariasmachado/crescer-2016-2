/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.web;

import br.com.cwi.crescer.beans.AtorBean;
import br.com.cwi.crescer.beans.ElencoBean;
import br.com.cwi.crescer.entidades.Ator;
import br.com.cwi.crescer.entidades.Elenco;
import br.com.cwi.crescer.utils.FacesUtils;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author cassio.machado
 */
@ManagedBean
@ViewScoped
public class ElencoManagedBean {

    @EJB
    private ElencoBean elencoBean;

    private Elenco elenco;
    private List<Elenco> elencos;

    @EJB
    private AtorBean atorBean;

    private List<Ator> atores;

    @PostConstruct
    public void init() {
        this.elenco = new Elenco();

        this.elencos = elencoBean.findAll();
        this.elencos.sort((a, b) -> a.getId().compareTo(b.getId()));

        this.atores = atorBean.findAll();
        this.atores.sort((a, b) -> a.getNome().compareTo(b.getNome()));
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void adicionar() {
        elencoBean.insert(elenco);
        this.init();
        FacesUtils.addSuccessMessage("Elenco cadastrado com sucesso!");
    }
}
