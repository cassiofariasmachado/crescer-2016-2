/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cfari
 */
public class MeuReaderUtils {

    public static void main(String[] args) {
        exibirConteudo("arquivo.txt");
    }

    public static List<String> lerArquivo(String arquivo) {
        List<String> listaConteudoArquivo = new ArrayList<>();
        try {

            if (!MeuFileUtils.ehArquivoTxt(arquivo)) {
                throw new ArquivoInvalidoException();
            }

            File file = new File(arquivo);

            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String linha = buffer.readLine();

            while (linha != null) {
                listaConteudoArquivo.add(linha);
                linha = buffer.readLine();
            }

        } catch (FileNotFoundException e) {
            System.err.format("Erro: %s", e.getMessage());
        } catch (IOException e) {
            System.err.format("Erro: %s", e.getMessage());
        } catch (ArquivoInvalidoException e) {
            System.err.format("Erro: %s", e.getMessage());
        }

        return listaConteudoArquivo;
    }

    public static void exibirConteudo(String arquivo) {
        List<String> conteudoArquivo = lerArquivo(arquivo);

        if (conteudoArquivo != null) {
            conteudoArquivo.forEach(p -> System.out.println(p));
        }
    }

}
