package com.dh.Checkpoint_I.controller;

import com.dh.Checkpoint_I.config.ConfiguracaoJDBC;
import com.dh.Checkpoint_I.dao.impl.DentistaDao;
import com.dh.Checkpoint_I.model.Dentista;
import com.dh.Checkpoint_I.service.DentistaService;

import java.sql.SQLException;
import java.util.Scanner;

public class DentistaController {

    private static DentistaService dentistaService;
    private static Scanner scanner;

    public static void main(String[] args) {
        configurarDependencias();
        exibirMenu();
    }

    private static void configurarDependencias() {
        // Configurar as dependências, como a instância do DentistaService
        dentistaService = new DentistaService(new DentistaDao(new ConfiguracaoJDBC()));
        scanner = new Scanner(System.in);
    }

    private static void exibirMenu() {
        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Dentista");
            System.out.println("2. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarDentista();
                    break;
                case 2:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        } while (opcao != 2);
    }

    private static void adicionarDentista() {
        System.out.println("=== Adicionar Dentista ===");

        System.out.print("Matrícula de Cadastro: ");
        String matriculaCadastro = scanner.next();

        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("Sobrenome: ");
        String sobrenome = scanner.next();

        Dentista dentista = new Dentista(matriculaCadastro, nome, sobrenome);

        try {
            Dentista dentistaAdicionado = dentistaService.adicionar(dentista);
            System.out.println("Dentista adicionado com sucesso:");
            System.out.println(dentistaAdicionado);
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao adicionar o dentista: " + e.getMessage());
        }
    }
}
