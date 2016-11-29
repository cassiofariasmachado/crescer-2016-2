/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cfari
 */
public class MeuWriterUtils {

    public static void main(String[] args) {
        List<String> conteudo = new ArrayList<>();
        conteudo.add("Seis");
        conteudo.add("Sete");
        conteudo.add("Oito");
        conteudo.add("Nove");
        conteudo.add("Dez");
        escreverArquivo("arquivo.txt", conteudo);
    }

    public static void escreverArquivo(String arquivo, List<String> conteudo) {
        try {
            File file = new File(arquivo);
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file, true));

            if (conteudo != null) {
                for (String linha : conteudo) {
                    buffer.append(linha);
                    buffer.newLine();
                }
            }
            buffer.flush();
        } catch (FileNotFoundException e) {
            System.err.format("Erro: %s", e.getMessage());
        } catch (IOException e) {
            System.err.format("Erro: %s", e.getMessage());
        }
    }

    public static void escreverArquivoTxt(String arquivo, List<String> conteudo) {
        try {
            if (!MeuFileUtils.ehArquivoTxt(arquivo)) {
                throw new ArquivoInvalidoException();
            }
            escreverArquivo(arquivo, conteudo);
        } catch (ArquivoInvalidoException e) {
            System.err.format("Erro: %s", e.getMessage());
        }
    }
}
