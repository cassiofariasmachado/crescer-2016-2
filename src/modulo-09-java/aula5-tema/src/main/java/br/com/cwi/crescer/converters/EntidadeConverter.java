/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.converters;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import br.com.cwi.crescer.entidades.IEntidade;

/**
 *
 * @author cfari
 */
public class EntidadeConverter<T extends IEntidade> implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent uIComponent, String value) {
        if (value != null) {
            return this.getInComponent(uIComponent, value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        final T entidade = (T) value;
        if (entidade != null) {
            this.setInComponent(component, entidade);
            return entidade.getId().toString();
        }
        return null;
    }

    private void setInComponent(final UIComponent uIComponent, final T entidade) {
        Map<BigInteger, T> entidades;
        entidades = (Map<BigInteger, T>) uIComponent.getAttributes().get("entidades");
        if (entidades == null) {
            entidades = new HashMap<>();
        }
        entidades.put(entidade.getId(), entidade);
        uIComponent.getAttributes().put("entidades", entidades);
    }

    private Object getInComponent(UIComponent uIComponent, String value) throws NumberFormatException {
        Map<BigInteger, T> entidades;
        entidades = (Map<BigInteger, T>) uIComponent.getAttributes().get("entidades");
        if (entidades != null) {
            return entidades.get(new BigInteger(value));
        }
        return null;
    }

}
