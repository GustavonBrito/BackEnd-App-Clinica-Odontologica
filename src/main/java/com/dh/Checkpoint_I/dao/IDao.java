package com.dh.Checkpoint_I.dao;

import java.sql.SQLException;

public interface IDao<T> {
    T adicionar(T t) throws SQLException;
}
