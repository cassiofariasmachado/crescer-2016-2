/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1.tema;

import java.math.BigDecimal;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Cássio
 */
public class ParcelatorTest {
    
    @Test
    public void calcularParcelasDeveCalcularParcelasDe110() {
        Parcelator parcelador = new Parcelator();
        Map<String, String> parcelas = parcelador.calcularParcelas(new BigDecimal(1000), 10, 10, MeuCalendarioUtil.converterData("30/11/2016"));
        Assert.assertEquals("30/11/2016", parcelas.keySet().toArray()[0]);
        Assert.assertEquals("30/12/2016", parcelas.keySet().toArray()[1]);
        Assert.assertEquals("30/01/2017", parcelas.keySet().toArray()[2]);
        Assert.assertEquals("110.00", parcelas.values().toArray()[0]);
        Assert.assertEquals("110.00", parcelas.values().toArray()[1]);
        Assert.assertEquals("110.00", parcelas.values().toArray()[2]);
    }
    
    @Test
    public void calcularParcelasDeveCalcularParcelasDe336() {
        Parcelator parcelador = new Parcelator();
        Map<String, String> parcelas = parcelador.calcularParcelas(new BigDecimal(1000), 10, 3, MeuCalendarioUtil.converterData("30/11/2016"));
        Assert.assertEquals("30/11/2016", parcelas.keySet().toArray()[0]);
        Assert.assertEquals("30/12/2016", parcelas.keySet().toArray()[1]);
        Assert.assertEquals("30/01/2017", parcelas.keySet().toArray()[2]);
        Assert.assertEquals("366.67", parcelas.values().toArray()[0]);
        Assert.assertEquals("366.67", parcelas.values().toArray()[1]);
        Assert.assertEquals("366.67", parcelas.values().toArray()[2]);
    }
    
}
