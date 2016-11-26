/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1.utils;

import br.com.cwi.crescer.aula1.utils.MeuStringUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Cássio
 */
public class MeuStringUtilTest {
    
   @Test
   public void ehVaziaDeveRetornarTrueParaStringVazia(){
       Assert.assertTrue(MeuStringUtil.ehVazia(""));
   }
   
   @Test
   public void ehVaziaDeveRetornarFalseParaStringNaoVazia(){
       Assert.assertFalse(MeuStringUtil.ehVazia("stringNaoVazia"));
   }
   
   @Test 
   public void contarVogaisDeveRetornarZeroParaPalavraSemVogais() {
       Assert.assertEquals(0, MeuStringUtil.contarVogais("bcdfghjklmnpqrstvxyz"));
   }
   
   @Test 
   public void contarVogaisDeveRetornarDoisParaPalavraComDuasVogais() {
       Assert.assertEquals(2,MeuStringUtil.contarVogais("crescer"));
   }
   
   @Test 
   public void inverterPalavraDeveRetornarPalavraInvertida() {
       Assert.assertEquals("recserc", MeuStringUtil.inverterPalavra("crescer"));
   }

   public void ehPalindromoDeveRetornarTrueParaPalindromoOvo() {
       Assert.assertTrue(MeuStringUtil.ehPalindromo("ovo"));
   }
   
   @Test 
   public void ehPalindromoDeveRetornarTrueParaPalindromoAmeAEma() {
       Assert.assertTrue(MeuStringUtil.ehPalindromo("Ame a ema"));
   }
   
   @Test 
   public void ehPalindromoDeveRetornarFalseParaNaoPalindromoCrescer() {
       Assert.assertFalse(MeuStringUtil.ehPalindromo("Crescer"));
   }
}
