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
import javax.validation.constraints.Size;

/**
 *
 * @author cfari
 */
@Entity
@Table(name = "ATOR")
@NamedQueries({
    @NamedQuery(name = "Ator.findAll", query = "SELECT a FROM Ator a")
    ,
    @NamedQuery(name = "Ator.findById", query = "SELECT a FROM Ator a WHERE a.id = :id")
    ,
    @NamedQuery(name = "Ator.findByNome", query = "SELECT a FROM Ator a WHERE a.nome = :nome")})
public class Ator implements Serializable, IEntidade {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ATOR")
    @SequenceGenerator(name = "SEQ_ATOR", sequenceName = "SEQ_ATOR", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private BigInteger id;

    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "NOME", nullable = false)
    private String nome;

    public Ator() {
    }

    public Ator(BigInteger id) {
        this.id = id;
    }

    public Ator(BigInteger id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
