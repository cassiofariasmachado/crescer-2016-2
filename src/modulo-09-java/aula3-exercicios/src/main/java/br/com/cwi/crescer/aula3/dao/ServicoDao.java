/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula2.utils.MeuSQLUtils;
import br.com.cwi.crescer.aula3.entities.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cfari
 */
public class ServicoDao implements Dao<Servico, Long>, Exportable {

    private final EntityManager entityManager;

    public ServicoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Servico servico) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(servico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Servico servico) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(servico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Servico servico) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(servico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Servico find(Long id) {
        return entityManager.find(Servico.class, id);
    }

    @Override
    public List<Servico> list() {
        return entityManager.createQuery("SELECT C FROM Servico C").getResultList();
    }

    @Override
    public void exportToCsv(String arquivo) {
        MeuSQLUtils.exportarCsv("SELECT * FROM Servico", arquivo);
    }
}
