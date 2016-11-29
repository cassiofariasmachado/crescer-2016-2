/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula2.utils.MeuSQLUtils;
import br.com.cwi.crescer.aula3.entities.Servico;
import br.com.cwi.crescer.aula3.entities.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cfari
 */
public class UsuarioDao implements Dao<Usuario, Long>, Exportable {

    private final EntityManager entityManager;

    public UsuarioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Usuario usuario) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Usuario usuario) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Usuario usuario) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Usuario find(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> list() {
        return entityManager.createQuery("SELECT U FROM Usuario U").getResultList();
    }

    @Override
    public void exportToCsv(String arquivo) {
        MeuSQLUtils.exportarCsv("SELECT * FROM Usuario", arquivo);
    }
}
