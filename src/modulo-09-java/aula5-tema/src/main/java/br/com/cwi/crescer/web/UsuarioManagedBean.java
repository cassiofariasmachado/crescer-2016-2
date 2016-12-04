/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.web;

import br.com.cwi.crescer.beans.UsuarioBean;
import br.com.cwi.crescer.entidades.Usuario;
import br.com.cwi.crescer.utils.CriptografiaUtils;
import br.com.cwi.crescer.utils.FacesUtils;
import java.util.List;
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
public class UsuarioManagedBean {

    @EJB
    private UsuarioBean usuarioBean;

    private Usuario usuario;
    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.usuarios = usuarioBean.findAll();
        this.usuarios.sort((a, b) -> a.getId().compareTo(b.getId()));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void adicionar() {
        if (!FacesUtils.getContext().isValidationFailed()) {
            criptografarSenhaDoUsuario();
            usuarioBean.insert(usuario);
            this.init();
            FacesUtils.addSuccessMessage("Usuário cadastrado com sucesso!");
        }
    }

    private void criptografarSenhaDoUsuario() {
        String senha = usuario.getSenha();
        String senhaCriptografada = CriptografiaUtils.criptografar(senha);
        usuario.setSenha(senhaCriptografada);
    }
}
