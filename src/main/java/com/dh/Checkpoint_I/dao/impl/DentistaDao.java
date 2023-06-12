package com.dh.Checkpoint_I.dao.impl;

import com.dh.Checkpoint_I.config.ConfiguracaoJDBC;
import com.dh.Checkpoint_I.dao.IDao;
import com.dh.Checkpoint_I.model.Dentista;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DentistaDao implements IDao<Dentista> {

    private final static Logger log = Logger.getLogger(DentistaDao.class);

    private ConfiguracaoJDBC configuracaoJDBC;

    public DentistaDao(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    public Dentista adicionar(Dentista dentista) throws SQLException {
        log.info("Salvando..." + dentista.toString());

        try (Connection connection = configuracaoJDBC.conectarComBancoDeDados();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO dentista (MATRICULACADASTRO, NOME, SOBRENOME) VALUES (?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, dentista.getMatriculaCadastro());
            statement.setString(2, dentista.getNome());
            statement.setString(3, dentista.getSobrenome());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        dentista.setMatriculaCadastro(String.valueOf(generatedKeys.getInt(1)));
                        log.info("Recuperando..." + dentista.toString());
                    }
                }
            }
        } catch (SQLException e) {
            log.error("Erro ao adicionar dentista: " + e.getMessage());
            throw e;
        }

        return dentista;
    }

    public List<Dentista> listarTodos() throws SQLException {
        List<Dentista> dentistas = new ArrayList<>();

        try (Connection connection = configuracaoJDBC.conectarComBancoDeDados();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM dentista");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Dentista dentista = new Dentista();
                dentista.setMatriculaCadastro(resultSet.getString("MATRICULACADASTRO"));
                dentista.setNome(resultSet.getString("NOME"));
                dentista.setSobrenome(resultSet.getString("SOBRENOME"));

                dentistas.add(dentista);
            }
        } catch (SQLException e) {
            log.error("Erro ao listar dentistas: " + e.getMessage());
            throw e;
        }

        return dentistas;
    }

    public void remover(Dentista dentista) throws SQLException {
        log.info("Removendo..." + dentista.toString());

        try (Connection connection = configuracaoJDBC.conectarComBancoDeDados();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM dentista WHERE MATRICULACADASTRO = ?")) {

            statement.setString(1, dentista.getMatriculaCadastro());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                log.info("Dentista removido com sucesso");
            } else {
                log.info("Nenhum dentista foi removido");
            }
        } catch (SQLException e) {
            log.error("Erro ao remover dentista: " + e.getMessage());
            throw e;
        }
    }

    public void editar(Dentista dentista) throws SQLException {
        log.info("Editando..." + dentista.toString());

        try (Connection connection = configuracaoJDBC.conectarComBancoDeDados();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE dentista SET NOME = ?, SOBRENOME = ? WHERE MATRICULACADASTRO = ?")) {

            statement.setString(1, dentista.getNome());
            statement.setString(2, dentista.getSobrenome());
            statement.setString(3, dentista.getMatriculaCadastro());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                log.info("Dentista editado com sucesso");
            } else {
                log.info("Nenhum dentista foi editado");
            }
        } catch (SQLException e) {
            log.error("Erro ao editar dentista: " + e.getMessage());
            throw e;
        }
    }
}
