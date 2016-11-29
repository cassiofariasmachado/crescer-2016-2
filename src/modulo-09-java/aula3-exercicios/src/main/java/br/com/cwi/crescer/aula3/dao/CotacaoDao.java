/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula2.utils.MeuSQLUtils;
import br.com.cwi.crescer.aula3.entities.Cotacao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cfari
 */
public class CotacaoDao implements Dao<Cotacao, Long>, Exportable {

    private final EntityManager entityManager;

    public CotacaoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Cotacao cotacao) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(cotacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cotacao cotacao) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(cotacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Cotacao cotacao) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(cotacao);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Cotacao find(Long id) {
        return entityManager.find(Cotacao.class, id);
    }

    @Override
    public List<Cotacao> list() {
        return entityManager.createQuery("SELECT C FROM Cotacao C").getResultList();
    }

    @Override
    public void exportToCsv(String arquivo) {
        MeuSQLUtils.exportarCsv("SELECT * FROM Cotacao", arquivo);
    }
}
