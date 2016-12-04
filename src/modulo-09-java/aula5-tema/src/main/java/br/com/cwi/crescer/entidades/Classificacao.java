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
@Table(name = "CLASSIFICACAO")
@NamedQueries({
    @NamedQuery(name = "Classificacao.findAll", query = "SELECT c FROM Classificacao c")
    , @NamedQuery(name = "Classificacao.findById", query = "SELECT c FROM Classificacao c WHERE c.id = :id")
    , @NamedQuery(name = "Classificacao.findByDescricao", query = "SELECT c FROM Classificacao c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Classificacao.findByIdade", query = "SELECT c FROM Classificacao c WHERE c.idade = :idade")})
public class Classificacao implements Serializable, IEntidade {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLASSIFICACAO")
    @SequenceGenerator(name = "SEQ_CLASSIFICACAO", sequenceName = "SEQ_CLASSIFICACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private BigInteger id;

    @Basic(optional = false)
    @Column(name = "DESCRICAO", nullable = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String descricao;

    @Basic(optional = false)
    @Column(name = "IDADE", nullable = false)
    @NotNull
    private BigInteger idade;

    public Classificacao() {
    }

    public Classificacao(BigInteger id) {
        this.id = id;
    }

    public Classificacao(BigInteger id, String descricao, BigInteger idade) {
        this.id = id;
        this.descricao = descricao;
        this.idade = idade;
    }

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigInteger getIdade() {
        return idade;
    }

    public void setIdade(BigInteger idade) {
        this.idade = idade;
    }
}
