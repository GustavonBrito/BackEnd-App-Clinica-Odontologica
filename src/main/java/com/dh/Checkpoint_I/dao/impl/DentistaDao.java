package com.dh.Checkpoint_I.dao.impl;

import com.dh.Checkpoint_I.config.ConfiguracaoJDBC;
import com.dh.Checkpoint_I.dao.IDao;
import com.dh.Checkpoint_I.model.Dentista;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
