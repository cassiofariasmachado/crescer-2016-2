package br.com.cwi.crescer.filters;

import br.com.cwi.crescer.utils.UserDetails;

/**
 * @author Carlos H. Nonnemacher
 */
public class User implements UserDetails {

    private String email;
    private String senha;

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
