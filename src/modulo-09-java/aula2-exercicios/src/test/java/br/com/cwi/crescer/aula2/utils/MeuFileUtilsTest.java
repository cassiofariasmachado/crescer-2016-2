/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cfari
 */
public class MeuFileUtilsTest {
    
    @Test
    public void ehArquivoDeveRetornarTrueParaArquivoPontoTxt() {
        Assert.assertTrue(MeuFileUtils.ehArquivo("arquivo.txt"));
    }
    
    @Test
    public void ehArquivoDeveRetornarFalseParaArquivoSemPonto() {
        Assert.assertFalse(MeuFileUtils.ehArquivo("arquivo"));
    }
    
    @Test
    public void ehArquivoTxtDeveRetornarTrueParaArquivoPontoTxt() {
        Assert.assertTrue(MeuFileUtils.ehArquivoTxt("arquivo.txt"));
    }
    
    @Test
    public void ehArquivoTxtDeveRetornarFalseParaArquivoSemPonto() {
        Assert.assertFalse(MeuFileUtils.ehArquivoTxt("arquivo"));
    }
    
    @Test
    public void ehArquivoTxtDeveRetornarFalseParaArquivoPontoDat() {
        Assert.assertFalse(MeuFileUtils.ehArquivoTxt("arquivo.dat"));
    }
    
}
