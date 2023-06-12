package com.dh.Checkpoint_I.controller;

import com.dh.Checkpoint_I.config.ConfiguracaoJDBC;
import com.dh.Checkpoint_I.dao.impl.DentistaDao;
import com.dh.Checkpoint_I.model.Dentista;
import com.dh.Checkpoint_I.service.DentistaService;

import java.sql.SQLException;
import java.util.List;
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
            System.out.println("2. Listar Dentistas");
            System.out.println("3. Remover Dentista");
            System.out.println("4. Editar Dentista");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarDentista();
                    break;
                case 2:
                    listarDentistas();
                    break;
                case 3:
                    removerDentista();
                    break;
                case 4:
                    editarDentista();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        } while (opcao != 5);
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

    private static void listarDentistas() {
        System.out.println("=== Listar Dentistas ===");

        try {
            List<Dentista> dentistas = dentistaService.listarTodos();
            if (dentistas.isEmpty()) {
                System.out.println("Nenhum dentista cadastrado.");
            } else {
                System.out.println("Dentistas cadastrados:");
                for (Dentista dentista : dentistas) {
                    System.out.println(dentista);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao listar os dentistas: " + e.getMessage());
        }
    }

    private static void removerDentista() {
        System.out.println("=== Remover Dentista ===");

        System.out.print("Matrícula de Cadastro do dentista a ser removido: ");
        String matriculaCadastro = scanner.next();

        Dentista dentista = new Dentista();
        dentista.setMatriculaCadastro(matriculaCadastro);

        try {
            dentistaService.remover(dentista);
            System.out.println("Dentista removido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao remover o dentista: " + e.getMessage());
        }

    }

    private static void editarDentista() {
        System.out.println("=== Editar Dentista ===");

        System.out.print("Matrícula de Cadastro do dentista a ser editado: ");
        String matriculaCadastro = scanner.next();

        System.out.print("Novo Nome: ");
        String novoNome = scanner.next();

        System.out.print("Novo Sobrenome: ");
        String novoSobrenome = scanner.next();

        Dentista dentista = new Dentista();
        dentista.setMatriculaCadastro(matriculaCadastro);
        dentista.setNome(novoNome);
        dentista.setSobrenome(novoSobrenome);

        try {
            dentistaService.editar(dentista);
            System.out.println("Dentista editado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao editar o dentista: " + e.getMessage());
        }
    }
}
