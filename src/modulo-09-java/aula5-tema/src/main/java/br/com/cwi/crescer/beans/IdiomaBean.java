/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.beans;

import br.com.cwi.crescer.daos.AbstractDao;
import br.com.cwi.crescer.entidades.Ator;
import br.com.cwi.crescer.entidades.Idioma;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cfari
 */
@Stateless
public class IdiomaBean extends AbstractDao<Idioma, BigInteger> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public IdiomaBean() {
        super(Idioma.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Idioma> findAll() {
        return this.getEntityManager().createQuery("select i from Idioma i").getResultList();
    }
}
