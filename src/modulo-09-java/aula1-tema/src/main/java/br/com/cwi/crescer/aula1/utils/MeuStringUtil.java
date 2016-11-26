/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cássio
 */
public class MeuStringUtil {

    public static void main(String[] args) {
        int opcao;
        List<String> listaDeOpcoes = new ArrayList();
        listaDeOpcoes.add("-------------------------------------------------------");
        listaDeOpcoes.add("1 - ehVazia() - verifica se String é vazia");
        listaDeOpcoes.add("2 - contarVogais() - canta vogais");
        listaDeOpcoes.add("3 - inverterPalavra() - inverte String");
        listaDeOpcoes.add("4 - ehPalindromo() - verifica se String é palindromo");
        listaDeOpcoes.add("5 - sair");

        do {
            opcao = MeuConsoleUtil.lerOpcao(listaDeOpcoes);
            String retorno = "";
            String palavra = MeuConsoleUtil.lerString("Digite a palavra: ");

            switch (opcao) {
                case 1:
                    retorno = Boolean.toString(ehVazia(palavra));
                    break;
                case 2:
                    retorno = Integer.toString(contarVogais(palavra));
                    break;
                case 3:
                    retorno = inverterPalavra(palavra);
                    break;
                case 4:
                    retorno = Boolean.toString(ehPalindromo(palavra));
                    break;
            }

            System.out.println(retorno);
        } while (opcao != 5);
    }

    public static boolean ehVazia(String palavra) {
        return palavra.length() == 0;
    }

    public static int contarVogais(String palavra) {
        String palavraMinuscula = palavra;
        return palavraMinuscula.length() - palavraMinuscula.replaceAll("[aeiou]", "").length();
    }

    public static String inverterPalavra(String palavra) {
        return new StringBuilder(palavra).reverse().toString();
    }

    public static boolean ehPalindromo(String palavra) {
        String palavraInvertida = inverterPalavra(palavra);
        return palavraInvertida.equalsIgnoreCase(palavra);
    }
}
