/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cfari
 */
public class MeuSQLUtils {

    public static void executarArquivoSql(String arquivo) {
        try {
            if (!MeuFileUtils.ehArquivoSql(arquivo)) {
                throw new ArquivoInvalidoException("Arquivo não é SQL.");
            }
            List<String> arquivoSql = MeuReaderUtils.lerArquivo(arquivo);
            StringBuilder comandos = new StringBuilder();
            arquivoSql.forEach((comando) -> {
                comandos.append(comando);
            });
            List<String> listaComandos = Arrays.asList(comandos.toString().split(";"));
            listaComandos.forEach(comando -> executarComandoSql(comando));
        } catch (ArquivoInvalidoException e) {
            System.err.format("Erro: %s", e.getMessage());
        }
    }

    private static void executarComandoSql(String sql) {
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static List<List<String>> executarQuery(String query) {
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query);) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            List<List<String>> tabela = new ArrayList<>();
            int numeroColunas = metaData.getColumnCount();

            List<String> nomeColunas = new ArrayList<>();
            for (int i = 1; i <= numeroColunas; i++) {
                nomeColunas.add(metaData.getColumnLabel(i));
            }
            tabela.add(nomeColunas);

            while (resultSet.next()) {
                List<String> linha = new ArrayList<>();
                for (int i = 1; i <= numeroColunas; i++) {
                    linha.add(resultSet.getString(i));
                }
                tabela.add(linha);
            }

            return tabela;
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return null;
    }

    public static void exibirQuery(String query) {
        List<List<String>> tabela = executarQuery(query);
        tabela.stream().map((linha) -> {
            StringBuilder linhaFormatada = new StringBuilder();
            linha.forEach((coluna) -> {
                linhaFormatada.append(coluna).append("\t");
            });
            return linhaFormatada;
        }).forEachOrdered((linhaConcatenada) -> {
            System.out.println(linhaConcatenada.toString());
        });
    }

    public static void exportarCsv(String query, String arquivo) {
        List<List<String>> tabela = executarQuery(query);
        List<String> conteudo = new ArrayList<>();
        tabela.stream().map((linha) -> {
            return String.join(",", linha);
        }).forEachOrdered((linhaCsv) -> {
            conteudo.add(linhaCsv);
        });
        MeuWriterUtils.escreverArquivo(arquivo, conteudo);
    }

    public static void importarCsv(String tabela, String arquivo) {
        List<String> arquivoCsv = MeuReaderUtils.lerArquivo(arquivo);
        int quantidadeColunas = arquivoCsv.get(0).split(",").length;

        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(tabela).append("(").append(arquivoCsv.get(0)).append(") VALUES(?");
        for (int i = 1; i < quantidadeColunas; i++) {
            sql.append(",?");
        }
        sql.append(")");

        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preStatement = connection.prepareStatement(sql.toString());) {
            for (int i = 1; i < arquivoCsv.size(); i++) {
                String[] colunas = arquivoCsv.get(i).split(",");
                for (int j = 1; j <= colunas.length; j++) {
                    preStatement.setObject(j, colunas[j - 1]);
                }
                preStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
