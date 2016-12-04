/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cfari
 */
@FacesConverter("dateConverter")
public class DataConverter implements Converter {

    private static final SimpleDateFormat FORMATO_DATA_ENTRADA = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat FORMATO_DATA_SAIDA = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return value != null ? FORMATO_DATA_ENTRADA.parse(value) : null;
        } catch (ParseException ex) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return FORMATO_DATA_SAIDA.format((Date) value);
    }
}
