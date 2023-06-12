package com.dh.Checkpoint_I.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    T adicionar(T t) throws SQLException;
    List<T> listarTodos() throws SQLException;
    void remover(T t) throws SQLException;
    void editar(T t) throws SQLException;
}
