package com.dh.Checkpoint_I.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao <T>{
    //Retorno nomeMetodo(Parametros);
    T adicionar(T t) throws SQLException;

    List<T> buscarTodos() throws SQLException;

    List<T> modificar() throws SQLException;

    Optional<T> buscarPorId(int id) throws SQLException;

    void deletarPorId(int id) throws SQLException;
}
