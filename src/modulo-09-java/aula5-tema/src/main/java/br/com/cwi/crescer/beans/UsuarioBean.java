/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.beans;

import br.com.cwi.crescer.daos.AbstractDao;
import br.com.cwi.crescer.entidades.Usuario;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author cfari
 */
@Stateless
public class UsuarioBean extends AbstractDao<Usuario, BigInteger> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Usuario> findAll() {
        return this.getEntityManager().createQuery("SELECT u FROM Usuario u").getResultList();
    }

    public Usuario findUsuarioLogado(String email, String senha) {
        String jpql = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha";
        TypedQuery<Usuario> query = this.getEntityManager().createQuery(jpql, Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        List listaUsuarios = query.getResultList();
        Usuario usuarioEncontrado = null;
        if (!listaUsuarios.isEmpty()) {
            usuarioEncontrado = (Usuario) listaUsuarios.get(0);
        }
        return usuarioEncontrado;
    }
}
