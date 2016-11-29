/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.entities;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author cfari
 */
@Entity
@Table(name = "CONTRACT_VALUE")
public class ContractValue {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT_VALUE")
    @SequenceGenerator(name = "SEQ_CONTRACT_VALUE", sequenceName = "SEQ_CONTRACT_VALUE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT_VALUE")
    private Long idContractValue;

    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;

    @Basic(optional = false)
    @Column(name = "DS_PERIODICITY")
    private String dsPeriodicity;

    @Basic(optional = false)
    @Column(name = "VL_AMOUNT_CONTRACT_VALUE", precision = 17, scale = 6)
    private BigDecimal vlAmountContractValue;

    @Basic(optional = false)
    @Column(name = "VL_MONTHLY_USD", precision = 17, scale = 6)
    private BigDecimal vlMonthlyUsd;

    @ManyToOne
    @JoinColumn(name = "ID_CONTRACT",
            foreignKey = @ForeignKey(name = "FK_CONTRACT_VALUE_CONTRACT"))
    private Contract contract;

    public Long getIdContractValue() {
        return idContractValue;
    }

    public void setIdContractValue(Long idContractValue) {
        this.idContractValue = idContractValue;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public String getDsPeriodicity() {
        return dsPeriodicity;
    }

    public void setDsPeriodicity(String dsPeriodicity) {
        this.dsPeriodicity = dsPeriodicity;
    }

    public BigDecimal getVlAmountContractValue() {
        return vlAmountContractValue;
    }

    public void setVlAmountContractValue(BigDecimal vlAmountContractValue) {
        this.vlAmountContractValue = vlAmountContractValue;
    }

    public BigDecimal getVlMonthlyUsd() {
        return vlMonthlyUsd;
    }

    public void setVlMonthlyUsd(BigDecimal vlMonthlyUsd) {
        this.vlMonthlyUsd = vlMonthlyUsd;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
