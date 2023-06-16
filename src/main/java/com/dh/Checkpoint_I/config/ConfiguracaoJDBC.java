//package com.dh.Checkpoint_I.config;
//
//import org.springframework.context.annotation.Configuration;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//@Configuration
//public class ConfiguracaoJDBC {
//
//    private final String jdbcDrive;
//    private final String dbUrl;
//    private final String nomeUsuario;
//    private final String senha;
//
//    public ConfiguracaoJDBC() {
//        this.jdbcDrive = "org.h2.Driver";
////        this.jdbcDrive = "com.mysql.cj.jdbc.Driver";
//        this.dbUrl="jdbc:h2:~/clinicas1;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'queries.sql'";
////        this.dbUrl = "jdbc:mysql://localhost:3306/clinicas;INIT=RUNSCRIPT FROM 'queries.sql'";
//        this.nomeUsuario = "root";
//        this.senha = "root";
//    }
//
//    public Connection conectarComBancoDeDados() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//}
