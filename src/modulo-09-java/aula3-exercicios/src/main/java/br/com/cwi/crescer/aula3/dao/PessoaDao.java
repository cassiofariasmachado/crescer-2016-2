/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula3.entities.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import static org.hibernate.criterion.MatchMode.ANYWHERE;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author cassio.machado
 */
public class PessoaDao implements Dao<Pessoa, Long> {

    private final EntityManager entityManager;

    public PessoaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Pessoa find(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> list() {
        return entityManager.createQuery("SELECT P FROM Pessoa P").getResultList();
    }

    public List<Pessoa> findByName(String nmPessoa) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Restrictions.like("nmPessoa", nmPessoa, ANYWHERE));
        return criteria.list();
    }

    public List<Pessoa> findByEntity(Pessoa pessoa) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Example.create(pessoa));
        return criteria.list();
    }
}
