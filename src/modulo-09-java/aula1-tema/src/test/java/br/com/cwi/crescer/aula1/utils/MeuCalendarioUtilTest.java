/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1.utils;

import br.com.cwi.crescer.aula1.utils.MeuCalendarioUtil;
import java.util.Calendar;
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
    
    @Test
    public void retornarTempoDecorridoAteHojeDeveRetornarZeroParaDiaMesEAno() {
        Date data = new Date();
        Assert.assertEquals("0 ano(s), 0 mes(es) e 0 dia(s)", MeuCalendarioUtil.retornarTempoDecorridoAteHoje(data));
    }
    
    @Test
    public void retornarTempoDecorridoAteHojeDeveRetornarUmDia() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Assert.assertEquals("0 ano(s), 0 mes(es) e 1 dia(s)", MeuCalendarioUtil.retornarTempoDecorridoAteHoje(calendar.getTime()));
    }
    
    @Test
    public void retornarTempoDecorridoAteHojeDeveRetornarUmAno() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        Assert.assertEquals("1 ano(s), 0 mes(es) e 0 dia(s)", MeuCalendarioUtil.retornarTempoDecorridoAteHoje(calendar.getTime()));
    }
}
