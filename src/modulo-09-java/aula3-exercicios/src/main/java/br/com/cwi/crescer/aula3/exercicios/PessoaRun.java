/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.exercicios;

import br.com.cwi.crescer.aula3.dao.PessoaDao;
import br.com.cwi.crescer.aula3.entities.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cassio.machado
 */
public class PessoaRun {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        PessoaDao dao = new PessoaDao(em);

        Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa("Pessoa");
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNmPessoa("Pessoa");

        dao.insert(pessoa);
        dao.insert(pessoa2);

        dao.list().forEach(p -> System.out.println(p.getIdPessoa() + " - " + p.getNmPessoa()));

        em.close();
        emf.close();
    }
}
