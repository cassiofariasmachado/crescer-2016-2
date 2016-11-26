/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.utils;

import br.com.cwi.crescer.aula1.utils.MeuConsoleUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Cássio
 */
public class MeuFileUtils {

    public static void main(String[] args) {

        String comando;
        String[] comandos;
        MeuFileUtils fileUtils = new MeuFileUtils();

        do {
            comando = MeuConsoleUtil.lerComando();
            comandos = comando.split(" ");

            if (comandos.length < 2) {
                System.out.println("Erro: comando inválido.");
                continue;
            }

            switch (comandos[0]) {
                case "mk":
                    fileUtils.criarArquivoOuDiretorio(comandos[1]);
                    break;
                case "rm":
                    fileUtils.removerArquivo(comandos[1]);
                    break;
                case "ls":
                    fileUtils.listar(comandos[1]);
                    break;
                case "mv":
                    fileUtils.moverArquivo(comandos[1], comandos[2]);
                    break;

                default:
                    System.out.println("Erro: comando inválido!");
                    break;
            }

        } while (!comandos[0].equals("exit"));
    }

    public void criarArquivoOuDiretorio(String arquivoOuDiretorio) {
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

    public void removerArquivo(String arquivo) {
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

    public void listar(String arquivoOuDiretorio) {

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

    private void moverArquivo(String arquivo, String destino) {
        Path pathArquivo = FileSystems.getDefault().getPath(arquivo);
        Path pathDestino = FileSystems.getDefault().getPath(destino);
        File fileDestino = new File(destino);
        try {
            if (ehArquivo(arquivo) && fileDestino.isDirectory()) {
                Files.move(pathArquivo, pathDestino, REPLACE_EXISTING);
            }
        } catch (IOException e) {
            System.err.format("Erro: %s", e.getMessage());
        }

    }

    public boolean ehArquivo(String arquivo) {
        String[] caminho = arquivo.split(File.pathSeparator);
        return caminho[caminho.length - 1].contains(".");
    }

}
