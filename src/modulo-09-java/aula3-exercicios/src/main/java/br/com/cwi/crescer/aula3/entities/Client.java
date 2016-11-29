/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author cfari
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENT")
    @SequenceGenerator(name = "SEQ_CLIENT", sequenceName = "SEQ_CLIENT", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CLIENT")
    private Long idClient;

    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Basic(optional = false)
    @Column(name = "DS_PASSWORD")
    private String dsPassword;

    @Basic(optional = false)
    @Column(name = "DS_PREFERRED_COIN")
    private String dsPreferredCoin;

    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;

    @Basic(optional = false)
    @Column(name = "DS_USER_NAME")
    private String dsUserName;

    @Basic(optional = false)
    @Column(name = "NM_CLIENT")
    private String nmClient;

    @Basic(optional = false)
    @Column(name = "TP_PERMISSION")
    private String tpPermission;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }

    public String getDsPreferredCoin() {
        return dsPreferredCoin;
    }

    public void setDsPreferredCoin(String dsPreferredCoin) {
        this.dsPreferredCoin = dsPreferredCoin;
    }

    public String getDsState() {
        return dsState;
    }

    public void setDsState(String dsState) {
        this.dsState = dsState;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public String getNmClient() {
        return nmClient;
    }

    public void setNmClient(String nmClient) {
        this.nmClient = nmClient;
    }

    public String getTpPermission() {
        return tpPermission;
    }

    public void setTpPermission(String tpPermission) {
        this.tpPermission = tpPermission;
    }
}
