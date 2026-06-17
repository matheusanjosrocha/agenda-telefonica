package org.example;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

            int opcao = 0;

            while (opcao != 6) {
                System.out.println("---Agenda Telefônica---");
                System.out.println("1. Adicionar Contato");
                System.out.println("2. Remover Contato");
                System.out.println("3. Buscar Contato");
                System.out.println("4. Listar Contato");
                System.out.println("5. Atualizar Contato");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Digite o email: ");
                        String email = scanner.nextLine();
                        Contato contato = new Contato(nome, telefone, email);
                        agenda.adicionarContato(contato);
                        break;
                    case 2:
                        System.out.print("Digite o nome do contato a ser removido: ");
                        String nomeRemover = scanner.nextLine();
                        agenda.removerContato(nomeRemover);
                        break;
                    case 3:
                        System.out.print("Digite o nome do contato a ser buscado: ");
                        String nomeBuscar = scanner.nextLine();
                        agenda.buscarContato(nomeBuscar);
                        break;
                    case 4:
                        agenda.listarContatos();
                        break;
                    case 5:
                        System.out.print("Digite o nome do contato a ser atualizado: ");
                        String nomeAtualizar = scanner.nextLine();
                        System.out.print("Digite o novo telefone: ");
                        String novoTelefone = scanner.nextLine();
                        System.out.print("Digite o novo email: ");
                        String novoEmail = scanner.nextLine();
                        agenda.atualizarContato(nomeAtualizar, novoTelefone, novoEmail);
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }
        scanner.close();
    }
}