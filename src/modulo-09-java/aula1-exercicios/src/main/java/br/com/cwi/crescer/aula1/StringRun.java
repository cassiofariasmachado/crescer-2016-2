/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cassio.machado
 */
public class StringRun {

    public static void main(String[] args) {
        
    }

    public static int retornarQuantidadeDeVogais(final String palavra) {
        int numeroVogais = 0;
        String vogais = "abcde";
        String palavraLowerCase = palavra.toLowerCase();
        for (int i = 0; i + 1 < palavra.length(); i++) {
            if (vogais.contains(palavraLowerCase.substring(i, i + 1))) {
                numeroVogais++;
            }
        }
        return numeroVogais;
    }

    public static String inverterString(final String palavra) {
        return new StringBuilder(palavra).reverse().toString();
    }

    public static String retornarEstados() {
        StringBuilder estadosConcatenados = new StringBuilder();
        List<Estados> estados = Arrays.asList(Estados.values());

        estados.forEach((Estados e) -> {
            estadosConcatenados.append(e.getNome());
            estadosConcatenados.append(",");
        });

        estadosConcatenados.deleteCharAt(estadosConcatenados.length() - 1);
        
        return estadosConcatenados.toString();
    }
}
