/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author cfari
 */
@Entity
@Table(name = "COTACAO")
public class Cotacao implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_COTACAO")
    @SequenceGenerator(name = "SEQ_COTACAO", sequenceName = "SEQ_COTACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_COTACAO")
    private Long idCotacao;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_AUSTRALIANO", precision = 9, scale = 6)
    private BigDecimal dsCotacaoDollarAustraliano;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_CANADENSE", precision = 9, scale = 6)
    private BigDecimal dsCotacaoDollarCanadense;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_EURO", precision = 9, scale = 6)
    private BigDecimal dsCotacaoEuro;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_FRANCO_SUICO", precision = 9, scale = 6)
    private BigDecimal dsCotacaoFrancoSuico;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_LIBRA", precision = 9, scale = 6)
    private BigDecimal dsCotacaoLibra;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_REAL", precision = 9, scale = 6)
    private BigDecimal dsCotacaoReal;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YEN", precision = 9, scale = 6)
    private BigDecimal dsCotacaoYen;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YUAN", precision = 9, scale = 6)
    private BigDecimal dsCotacaoYuan;

    @Basic(optional = false)
    @Column(name = "DT_COTACAO")
    private byte[] dtCotacao;

    public Long getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(Long idCotacao) {
        this.idCotacao = idCotacao;
    }

    public BigDecimal getDsCotacaoDollarAustraliano() {
        return dsCotacaoDollarAustraliano;
    }

    public void setDsCotacaoDollarAustraliano(BigDecimal dsCotacaoDollarAustraliano) {
        this.dsCotacaoDollarAustraliano = dsCotacaoDollarAustraliano;
    }

    public BigDecimal getDsCotacaoDollarCanadense() {
        return dsCotacaoDollarCanadense;
    }

    public void setDsCotacaoDollarCanadense(BigDecimal dsCotacaoDollarCanadense) {
        this.dsCotacaoDollarCanadense = dsCotacaoDollarCanadense;
    }

    public BigDecimal getDsCotacaoEuro() {
        return dsCotacaoEuro;
    }

    public void setDsCotacaoEuro(BigDecimal dsCotacaoEuro) {
        this.dsCotacaoEuro = dsCotacaoEuro;
    }

    public BigDecimal getDsCotacaoFrancoSuico() {
        return dsCotacaoFrancoSuico;
    }

    public void setDsCotacaoFrancoSuico(BigDecimal dsCotacaoFrancoSuico) {
        this.dsCotacaoFrancoSuico = dsCotacaoFrancoSuico;
    }

    public BigDecimal getDsCotacaoLibra() {
        return dsCotacaoLibra;
    }

    public void setDsCotacaoLibra(BigDecimal dsCotacaoLibra) {
        this.dsCotacaoLibra = dsCotacaoLibra;
    }

    public BigDecimal getDsCotacaoReal() {
        return dsCotacaoReal;
    }

    public void setDsCotacaoReal(BigDecimal dsCotacaoReal) {
        this.dsCotacaoReal = dsCotacaoReal;
    }

    public BigDecimal getDsCotacaoYen() {
        return dsCotacaoYen;
    }

    public void setDsCotacaoYen(BigDecimal dsCotacaoYen) {
        this.dsCotacaoYen = dsCotacaoYen;
    }

    public BigDecimal getDsCotacaoYuan() {
        return dsCotacaoYuan;
    }

    public void setDsCotacaoYuan(BigDecimal dsCotacaoYuan) {
        this.dsCotacaoYuan = dsCotacaoYuan;
    }

    public byte[] getDtCotacao() {
        return dtCotacao;
    }

    public void setDtCotacao(byte[] dtCotacao) {
        this.dtCotacao = dtCotacao;
    }
}
