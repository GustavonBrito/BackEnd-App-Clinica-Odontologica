package com.dh.Checkpoint_I.repository;

import com.dh.Checkpoint_I.model.Consulta;
import com.dh.Checkpoint_I.model.Dentista;
import com.dh.Checkpoint_I.model.Paciente;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao <T>{
//  Métodos que serão utilizados no projeto
    T adicionar(T t) throws SQLException;
    T registrarConsulta(T t, Dentista dentista, Paciente paciente) throws SQLException;
    List<T> buscarTodos() throws SQLException;
    List<T> modificar() throws SQLException;
    Optional<T> buscarPorId(int id) throws SQLException;
    void deletarPorId(int id) throws SQLException;


}
