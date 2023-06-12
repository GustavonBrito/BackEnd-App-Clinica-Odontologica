package com.dh.Checkpoint_I.service;

import com.dh.Checkpoint_I.dao.IDao;
import com.dh.Checkpoint_I.model.Dentista;

import java.sql.SQLException;
import java.util.List;

public class DentistaService {

    private final IDao<Dentista> dentistaDao;

    public DentistaService(IDao<Dentista> dentistaDao) {
        this.dentistaDao = dentistaDao;
    }

    public Dentista adicionar(Dentista dentista) throws SQLException {
        return dentistaDao.adicionar(dentista);
    }

    public List<Dentista> listarTodos() throws SQLException {
        return dentistaDao.listarTodos();
    }

    public void remover(Dentista dentista) throws SQLException {
        dentistaDao.remover(dentista);
    }

    public void editar(Dentista dentista) throws SQLException {
        dentistaDao.editar(dentista);
    }
}
