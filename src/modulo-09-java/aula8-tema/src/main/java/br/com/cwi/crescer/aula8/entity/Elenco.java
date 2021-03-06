/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cfari
 */
@Entity
@Table(name = "ELENCO")
@NamedQueries({
    @NamedQuery(name = "Elenco.findAll", query = "SELECT e FROM Elenco e")
    ,
    @NamedQuery(name = "Elenco.findById", query = "SELECT e FROM Elenco e WHERE e.id = :id")
    ,
    @NamedQuery(name = "Elenco.findByNome", query = "SELECT e FROM Elenco e WHERE e.nome = :nome")})
public class Elenco implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ELENCO")
    @SequenceGenerator(name = "SEQ_ELENCO", sequenceName = "SEQ_ELENCO", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private BigInteger id;

    @Basic(optional = false)
    @Column(name = "NOME", nullable = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;

    @OneToMany
    @NotNull
    private List<Ator> atores;

    public Elenco() {
    }

    public Elenco(BigInteger id) {
        this.id = id;
    }

    public Elenco(BigInteger id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
}
