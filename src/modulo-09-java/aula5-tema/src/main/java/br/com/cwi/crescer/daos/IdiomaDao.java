/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.daos;

import br.com.cwi.crescer.entidades.Idioma;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cfari
 */
public class IdiomaDao extends AbstractDao<Idioma, BigInteger> {

    final EntityManager entityManager;

    public IdiomaDao(EntityManager entityManager) {
        super(Idioma.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Idioma> findAll() {
        return this.getEntityManager().createQuery("select p from Pessoa p").getResultList();
    }
}
