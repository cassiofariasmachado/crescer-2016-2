/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.exercicios;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author cassio.machado
 */
public class PessoaFactory {

    public static void main(String[] args) {

    }

    public void insert(Pessoa pessoa) {
        final String insert = "INSERT INTO CASSIO_OFICIAL(ID_PESSOA, NM_PESSOA ) "
                + "VALUES (?, ?)";

        try (final PreparedStatement preparedStatement = ConnectionUtils.getConnection().prepareStatement(insert)) {
            preparedStatement.setLong(1, pessoa.getId());
            preparedStatement.setString(2, pessoa.getNome());
            preparedStatement.executeUpdate();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    
}
