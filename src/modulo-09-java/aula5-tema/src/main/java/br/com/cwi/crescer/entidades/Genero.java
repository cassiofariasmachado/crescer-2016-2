/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cfari
 */
@Entity
@Table(name = "GENERO")
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g")
    , @NamedQuery(name = "Genero.findById", query = "SELECT g FROM Genero g WHERE g.id = :id")
    , @NamedQuery(name = "Genero.findByDescricao", query = "SELECT g FROM Genero g WHERE g.descricao = :descricao")})
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigInteger id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRICAO")
    private String descricao;

    public Genero() {
    }

    public Genero(BigInteger id) {
        this.id = id;
    }

    public Genero(BigInteger id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
