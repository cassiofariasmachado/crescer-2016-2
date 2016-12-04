/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.web;

import br.com.cwi.crescer.utils.FacesUtils;
import br.com.cwi.crescer.utils.UserDetails;
import static br.com.cwi.crescer.utils.UserDetails.USUARIO_AUTENTICADO;
import br.com.cwi.crescer.beans.UsuarioBean;
import br.com.cwi.crescer.entidades.Usuario;
import br.com.cwi.crescer.filters.User;
import br.com.cwi.crescer.utils.CriptografiaUtils;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author cfari
 */
@ManagedBean
@ViewScoped
public class LoginManagedBean {

    @EJB
    private UsuarioBean usuarioBean;

    private User user;

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public String getUsuarioAutenticado() {
        final UserDetails userDetails;
        userDetails = (UserDetails) FacesUtils.getSession().getAttribute(USUARIO_AUTENTICADO);
        return userDetails == null ? null : userDetails.getEmail();
    }

    public String login() {
        user.setSenha(CriptografiaUtils.criptografar(user.getSenha()));
        Usuario usuario = usuarioBean.findUsuarioLogado(user.getEmail(), user.getSenha());
        if (usuario != null) {
            FacesUtils.getSession().setAttribute(USUARIO_AUTENTICADO, this.user);
            return "index";
        }
        FacesUtils.addErrorMessage("Email ou senha inválidos!");
        return null;
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "logout";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
