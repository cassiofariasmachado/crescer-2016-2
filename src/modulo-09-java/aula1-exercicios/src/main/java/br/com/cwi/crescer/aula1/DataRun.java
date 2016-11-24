/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author cassio.machado
 */
public class DataRun {

    public static void main(String args[]) {
        retornarDiaDaSemanaDoAniversario();
    }

    public static Date retornarDataAtual() {
        return new Date();
    }

    public static void retornarDiaDaSemanaDoAniversario() {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite sua data de nascimento: ");
            String dataNascimentoLida = scanner.nextLine();

            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            Date dataAniversario = formatoData.parse(dataNascimentoLida);

            System.out.println(new SimpleDateFormat("EEEE").format(dataAniversario));

        } catch (Exception e) {
            System.err.print(e.getMessage());
            System.out.print("Erro ao converter a data informada!!!");
        }
    }
}
