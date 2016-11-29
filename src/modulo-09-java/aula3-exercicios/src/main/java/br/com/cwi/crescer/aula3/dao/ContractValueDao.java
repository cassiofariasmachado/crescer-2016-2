/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula2.utils.MeuSQLUtils;
import br.com.cwi.crescer.aula3.entities.ContractValue;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cfari
 */
public class ContractValueDao implements Dao<ContractValue, Long>, Exportable {

    private final EntityManager entityManager;

    public ContractValueDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(ContractValue contractValue) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(contractValue);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(ContractValue contractValue) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(contractValue);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(ContractValue contractValue) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(contractValue);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public ContractValue find(Long id) {
        return entityManager.find(ContractValue.class, id);
    }

    @Override
    public List<ContractValue> list() {
        return entityManager.createQuery("SELECT C FROM ContractValue C").getResultList();
    }

    @Override
    public void exportToCsv(String arquivo) {
        MeuSQLUtils.exportarCsv("SELECT * FROM ContractValue", arquivo);
    }
}
