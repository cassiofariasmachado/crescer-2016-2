/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula2.utils.MeuSQLUtils;
import br.com.cwi.crescer.aula3.entities.Client;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cfari
 */
public class ClientDao implements Dao<Client, Long>, Exportable {

    private final EntityManager entityManager;

    public ClientDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Client client) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Client client) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Client client) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Client find(Long id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public List<Client> list() {
        return entityManager.createQuery("SELECT C FROM Client C").getResultList();
    }

    @Override
    public void exportToCsv(String arquivo) {
        MeuSQLUtils.exportarCsv("SELECT * FROM Client", arquivo);
    }
}
