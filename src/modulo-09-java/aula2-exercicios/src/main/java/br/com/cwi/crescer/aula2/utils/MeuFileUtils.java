/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.utils;

import br.com.cwi.crescer.aula1.utils.MeuConsoleUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

/**
 *
 * @author Cássio
 */
public class MeuFileUtils {

    public static void main(String[] args) {

        String comando;
        String[] comandos;

        do {
            comando = MeuConsoleUtil.lerComando();
            comandos = comando.split(" ");

            if (comandos.length < 2) {
                System.out.println("Erro: comando inválido.");
                continue;
            }

            switch (comandos[0]) {
                case "mk":
                    criarArquivoOuDiretorio(comandos[1]);
                    break;
                case "rm":
                    removerArquivo(comandos[1]);
                    break;
                case "ls":
                    listar(comandos[1]);
                    break;
                case "mv":
                    moverArquivo(comandos[1], comandos[2]);
                    break;
                default:
                    System.out.println("Erro: comando inválido!");
                    break;
            }

        } while (!comandos[0].equals("exit"));
    }

    public static void criarArquivoOuDiretorio(String arquivoOuDiretorio) {
        try {
            File file = new File(arquivoOuDiretorio);

            if (ehArquivo(arquivoOuDiretorio)) {
                file.createNewFile();
            } else {
                file.mkdirs();
            }

        } catch (IOException e) {
            System.err.format("Erro: %s", e.getMessage());
        }
    }

    public static void removerArquivo(String arquivo) {
        try {
            File file = new File(arquivo);

            if (file.isFile() && file.exists()) {
                file.delete();
            } else {
                System.out.println("Erro: arquivo inválido.");
            }

        } catch (Exception e) {
            System.err.format("Erro: %s", e.getMessage());
        }
    }

    public static void listar(String arquivoOuDiretorio) {

        File file = new File(arquivoOuDiretorio);

        if (!file.exists()) {
            System.out.println("Erro: arquivo ou pasta não existe.");
            return;
        }

        if (file.isFile()) {
            System.out.println(file.getAbsolutePath());
        } else {
            Arrays.asList(file.list()).forEach(arquivoOuPasta -> System.out.println(arquivoOuPasta));
        }
    }

    private static void moverArquivo(String arquivo, String destino) {
        Path pathArquivo = Paths.get(arquivo);
        Path pathDestino = Paths.get(destino);

        try {
            if (ehArquivo(arquivo)) {
                Files.move(pathArquivo, pathDestino.resolve(pathArquivo.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            } else {
                System.out.println("Erro: arquivo inválido.");
            }
        } catch (IOException e) {
            System.err.format("Erro: %s", e.getMessage());
        }

    }

    public static boolean ehArquivo(String arquivo) {
        String[] caminho = arquivo.split(File.pathSeparator);
        return caminho[caminho.length - 1].contains(".");
    }

}
