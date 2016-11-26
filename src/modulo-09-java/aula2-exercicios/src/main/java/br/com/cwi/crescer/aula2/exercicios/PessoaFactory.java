/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2.exercicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cassio.machado
 */
public class PessoaFactory {

    public static void main(String[] args) {
        
    }

    public void inserir(Pessoa pessoa) {
        final String insert = "INSERT INTO Pessoa(Id, Nome ) "
                + "VALUES (SEQ_Pessoa.NEXTVAL, ?)";

        try (final PreparedStatement preparedStatement = ConnectionUtils.getConnection().prepareStatement(insert)) {
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.executeUpdate();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    
    public void remover(Pessoa p) {
        final String insert = "DELETE Pessoa WHERE Id = ?";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

            preparedStatement.setLong(1, p.getId());
            preparedStatement.executeUpdate();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public List<Pessoa> listar() {
        final String query = "SELECT * FROM Pessoa";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query);) {

            List<Pessoa> pessoas = new ArrayList<>();

            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa(resultSet.getLong("Id"), resultSet.getString("Nome"));
                pessoas.add(pessoa);
            }

            return pessoas;

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return null;

    }
}
