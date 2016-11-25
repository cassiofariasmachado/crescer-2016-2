/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aula1.tema;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Cássio
 */
public class MeuConsoleUtil {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String lerString(String descricao) {
        System.out.println(descricao);
        return SCANNER.next();
    }

    public static int lerOpcao(List<String> descricoes) {
        descricoes.forEach(descricao -> System.out.println(descricao));
        return SCANNER.nextInt();
    }
}
