/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aula1.tema;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Cássio
 */
public class MeuCalendarioUtilTest {

    @Test
    public void retornarDiaDaSemanaDeveRetornarSextaFeira() {
        Date data = MeuCalendarioUtil.converterData("25/11/2016");
        Assert.assertEquals("Sexta-feira", MeuCalendarioUtil.retornarDiaDaSemana(data));
    }

    @Test
    public void retornarDiaDaSemanaDeveRetornarQuintaFeira() {
        Date data = MeuCalendarioUtil.converterData("24/11/2016");
        Assert.assertEquals("Quinta-feira", MeuCalendarioUtil.retornarDiaDaSemana(data));
    }
}
