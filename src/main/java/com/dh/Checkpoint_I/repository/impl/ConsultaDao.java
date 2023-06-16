//package com.dh.Checkpoint_I.repository.impl;
//
//import com.dh.Checkpoint_I.config.ConfiguracaoJDBC;
//import com.dh.Checkpoint_I.model.Consulta;
//import com.dh.Checkpoint_I.model.Dentista;
//import com.dh.Checkpoint_I.model.Paciente;
//import com.dh.Checkpoint_I.repository.IDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//
//import org.apache.log4j.Logger;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ConsultaDao implements IDao<Consulta> {
//    private final static Logger log = Logger.getLogger(ConsultaDao.class);
//
//    private ConfiguracaoJDBC configuracaoJDBC;
//
//    @Autowired
//    public ConsultaDao(ConfiguracaoJDBC configuracaoJDBC){
//        this.configuracaoJDBC = configuracaoJDBC;
//    }
//
//    @Override
//    public Consulta adicionar(Consulta consulta) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Consulta registrarConsulta(Consulta consulta) throws SQLException {
//        log.info("Registrando horario da consulta: " + consulta.getDataHoraConsulta());
//
//        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
//        Statement statement = null;
//
//        String query = String.format("INSERT INTO consultas (dataHoraPaciente,dataHoraDentista,dataHoraConsulta,dentista,paciente) " +
//        "VALUES ('%s','%s','%s','%s','%s')", consulta.getDataHoraPaciente(),consulta.getDataHoraDentista(),
//                consulta.getDataHoraConsulta() ,consulta.getNomeDentista(), consulta.getNomePaciente());
//        try {
//          statement = connection.createStatement();
//          statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
//            ResultSet generatedKeys = statement.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                consulta.setId(generatedKeys.getInt(1));
//               log.info("Recuperando id da consulta: " + consulta.toString());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//       } finally {
//          statement.close();
//          connection.close();
//       }
//       return consulta;
//    }
//
//    @Override
//    public List<Consulta> buscarTodos() throws SQLException {
//        return null;
//    }
//
//    @Override
//    public List<Consulta> modificar() throws SQLException {
//        return null;
//    }
//
//    @Override
//    public Optional<Consulta> buscarPorId(int id) throws SQLException {
//        return Optional.empty();
//    }
//
//    @Override
//    public void deletarPorId(int id) throws SQLException {
//
//    }
//}
//
////package com.dh.hotelv2.dao.impl;
////
////        import com.dh.hotelv2.config.ConfiguracaoJDBC;
////        import com.dh.hotelv2.dao.IDao;
////        import com.dh.hotelv2.model.Filial;
////        import org.apache.log4j.Logger;
////        import org.apache.tomcat.util.http.fileupload.FileUpload;
////        import org.springframework.beans.factory.annotation.Autowired;
////        import org.springframework.stereotype.Repository;
////
////        import java.sql.Connection;
////        import java.sql.ResultSet;
////        import java.sql.SQLException;
////        import java.sql.Statement;
////        import java.util.ArrayList;
////        import java.util.List;
////        import java.util.Optional;
////
////@Repository
////public class FilialDao implements IDao<Filial> {
////
////    private final static Logger log = Logger.getLogger(FilialDao.class);
////
////    private ConfiguracaoJDBC configuracaoJDBC;
////
////    @Autowired
////    public FilialDao(ConfiguracaoJDBC configuracaoJDBC) {
////        this.configuracaoJDBC = configuracaoJDBC;
////    }
////
////    @Override
////    public Filial salvar(Filial filial) throws SQLException {
////        log.info("Salvando nova filial: " + filial.toString());
////
////        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
////        Statement statement = null;
////
////        String query = String.format("INSERT INTO filiais (nome, rua, numero, cidade, estado, cincoestrelas) " +
////                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", filial.getNome(), filial.getRua(), filial.getNumero(),
////                filial.getCidade(), filial.getEstado(), filial.getCincoEstrelas());
////
////        try {
////            statement = connection.createStatement();
////            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
////            ResultSet generatedKeys = statement.getGeneratedKeys();
////            if (generatedKeys.next()) {
////                filial.setId(generatedKeys.getInt(1));
////                log.info("Recuperando id da filial: " + filial.toString());
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } finally {
////            statement.close();
////            connection.close();
////        }
////        return filial;
////    }
////
////    @Override
////    public List<Filial> buscarTodos() throws SQLException {
////        log.info("Buscando todas as filiais salvas...");
////
////        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
////        Statement statement = null;
////
////        String query = "SELECT * FROM filiais";
////
////        List<Filial> filialList = new ArrayList<>();
////
////        try {
////            statement = connection.createStatement();
////            ResultSet resultSet = statement.executeQuery(query);
////            while (resultSet.next()) {
////                int id = resultSet.getInt("id");
////                String nome = resultSet.getString("nome");
////                String rua = resultSet.getString("rua");
////                String numero = resultSet.getString("numero");
////                String cidade = resultSet.getString("cidade");
////                String estado = resultSet.getString("estado");
////                String cincoEstrelas = resultSet.getString("cincoEstrelas");
////
////                Filial filial = new Filial(id, nome, rua, numero, cidade, estado, cincoEstrelas);
////
////                filialList.add(filial);
////            }
////
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } finally {
////            statement.close();
////            connection.close();
////        }
////        return filialList;
////    }
////
////    @Override
////    public Optional<Filial> buscarPorId(int id) throws SQLException {
////        log.info("Buscando a filial de id: " + id);
////
////        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
////        Statement statement = null;
////
////        String query = String.format("SELECT * FROM filiais WHERE ID='%s'", id);
////
////        Filial filial = null;
////
////        try {
////            statement = connection.createStatement();
////            ResultSet resultSet = statement.executeQuery(query);
////            while (resultSet.next()) {
////                int idFilial = resultSet.getInt("id");
////                String nome = resultSet.getString("nome");
////                String rua = resultSet.getString("rua");
////                String numero = resultSet.getString("numero");
////                String cidade = resultSet.getString("cidade");
////                String estado = resultSet.getString("estado");
////                String cincoEstrelas = resultSet.getString("cincoEstrelas");
////
////                filial = new Filial(idFilial, nome, rua, numero, cidade, estado, cincoEstrelas);
////            }
////
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } finally {
////            statement.close();
////            connection.close();
////        }
////        return filial != null ? Optional.of(filial) : Optional.empty();
////    }
////
////    @Override
////    public void deletarPorId(int id) throws SQLException {
////        log.info("Deletando filial de id: " + id);
////
////        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
////        Statement statement = null;
////
////        String query = String.format("DELETE FROM filiais WHERE ID = %s", id);
////
////        try {
////            statement = connection.createStatement();
////            statement.executeUpdate(query);
////
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } finally {
////            statement.close();
////            connection.close();
////        }
////    }
////}