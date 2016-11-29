/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula2.utils.MeuSQLUtils;
import br.com.cwi.crescer.aula3.entities.CurrencyExchange;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cfari
 */
public class CurrencyExchangeDao implements Dao<CurrencyExchange, Long>, Exportable {

    private final EntityManager entityManager;

    public CurrencyExchangeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(CurrencyExchange currencyExchange) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(currencyExchange);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(CurrencyExchange currencyExchange) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(currencyExchange);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(CurrencyExchange currencyExchange) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(currencyExchange);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public CurrencyExchange find(Long id) {
        return entityManager.find(CurrencyExchange.class, id);
    }

    @Override
    public List<CurrencyExchange> list() {
        return entityManager.createQuery("SELECT C FROM CurrencyExchange C").getResultList();
    }

    @Override
    public void exportToCsv(String arquivo) {
        MeuSQLUtils.exportarCsv("SELECT * FROM CurrencyExchange", arquivo);
    }
}
