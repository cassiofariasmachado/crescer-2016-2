package br.com.cwi.crescer.utils;

import java.io.Serializable;

/**
 * @author Carlos H. Nonnemacher
 */
public interface UserDetails extends Serializable {

    public static final String USUARIO_AUTENTICADO = "USUARIO_AUTENTICADO";

    public String getEmail();

}
