package br.com.cwi.crescer.beans;

import br.com.cwi.crescer.daos.AbstractDao;
import br.com.cwi.crescer.entidades.Pessoa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class PessoaBean extends AbstractDao<Pessoa, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public PessoaBean() {
        super(Pessoa.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Pessoa> findAll() {
        return this.getEntityManager().createQuery("select p from Pessoa p").getResultList();
    }
}
