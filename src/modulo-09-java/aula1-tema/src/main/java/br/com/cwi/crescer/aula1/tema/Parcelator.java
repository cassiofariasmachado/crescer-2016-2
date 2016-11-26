/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1.tema;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Cássio
 */
public class Parcelator {
    
    private static final SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd/MM/yyyy");

    public Map<String, String> calcularParcelas(BigDecimal valor, double taxaDeJuros, int numeroParcelas, Date dataVencimento) {
        Map<String, String> parcelas = new LinkedHashMap<>();
        
        // valorTotal = valor + taxaDeJuros / 100 * valor;
        BigDecimal valorTotal = valor.multiply(BigDecimal.valueOf(taxaDeJuros).divide(BigDecimal.valueOf(100))).add(valor);
        BigDecimal valorParcela = valorTotal.divide(BigDecimal.valueOf(numeroParcelas), 2, RoundingMode.CEILING);
        
        Calendar datasVencimento = Calendar.getInstance();
        datasVencimento.setTime(dataVencimento);

        for (int i = 0; i < numeroParcelas; i++) {
            parcelas.put(FORMATO_DATA.format(datasVencimento.getTime()), valorParcela.toString());
            datasVencimento.add(Calendar.MONTH, 1);
        }

        return parcelas;
    }
}
