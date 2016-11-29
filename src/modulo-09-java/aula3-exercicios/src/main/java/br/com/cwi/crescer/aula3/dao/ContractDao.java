/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula2.utils.MeuSQLUtils;
import br.com.cwi.crescer.aula3.entities.Contract;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cfari
 */
public class ContractDao implements Dao<Contract, Long>, Exportable {

    private final EntityManager entityManager;

    public ContractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Contract contract) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(contract);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Contract contract) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(contract);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Contract contract) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(contract);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Contract find(Long id) {
        return entityManager.find(Contract.class, id);
    }

    @Override
    public List<Contract> list() {
        return entityManager.createQuery("SELECT C FROM Contract C").getResultList();
    }

    @Override
    public void exportToCsv(String arquivo) {
        MeuSQLUtils.exportarCsv("SELECT * FROM Contract", arquivo);
    }
}
