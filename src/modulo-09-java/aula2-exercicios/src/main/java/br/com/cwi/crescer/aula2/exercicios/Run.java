/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.exercicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cassio.machado
 */
public class Run {

    public static void main(String[] args) {
//        final String ddl = "CREATE TABLE CASSIO_OFICIAL ("
//                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
//                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
//                + " PRIMARY KEY (ID_PESSOA) "
//                + ")";
//        try (final Connection connection = ConnectionUtils.getConnection()) {
//            try (final Statement statement = connection.createStatement()) {
//                statement.executeUpdate(ddl);
//            } catch (final SQLException e) {
//                System.err.format("SQLException: %s", e);
//            }
//        } catch (SQLException e) {
//            System.err.format("SQLException: %s", e);
//        }

        final String query = "SELECT * FROM CASSIO_OFICIAL";
        try (final Statement statement = ConnectionUtils.getConnection().createStatement()) {
            try (final ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    long idPessoa = resultSet.getLong("ID_PESSOA");
                    String nomePessoa = resultSet.getString("NM_PESSOA");
                    System.out.format("ID: %s NOME: %s\n", idPessoa, nomePessoa);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

}
