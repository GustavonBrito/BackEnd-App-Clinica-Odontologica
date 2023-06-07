package com.dh.Checkpoint_I.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao {
    //Retorno nomeMetodo(Parametros);
    T salvar(T t) throws SQLException;

    List<T> buscarTodos() throws SQLException;

    Optional<T> buscarPorId(int id) throws SQLException;

    void deletarPorId(int id) throws SQLException;
}
