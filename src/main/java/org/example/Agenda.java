package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Agenda {

    public void adicionarContato(Contato contato) {
        String sql = "INSERT INTO contatos (nome, telefone, email) VALUES (?, ?, ?)";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getTelefone());
            statement.setString(3, contato.getEmail());

            statement.executeUpdate();

            System.out.println("Contato adicionado com sucesso!");

        } catch (SQLException e) {
            if (e.getMessage().contains("contatos_email_key")) {
                System.out.println("Erro: email já cadastrado.");
            } else if (e.getMessage().contains("contatos_telefone_key")) {
                System.out.println("Erro: telefone já cadastrado.");
            } else {
                System.out.println("Erro ao adicionar contato: " + e.getMessage());
            }
        }
    }

    public void listarContatos() {
        String sql = "SELECT * FROM contatos";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                String email = resultado.getString("email");

                Contato contato = new Contato(nome, telefone, email);
                System.out.println(contato);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar contatos: " + e.getMessage());
        }
    }

    public void buscarContato(String nome) {
        String sql = "SELECT * FROM contatos WHERE LOWER(nome) = LOWER(?)";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, nome);

            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    String nomeEncontrado = resultado.getString("nome");
                    String telefone = resultado.getString("telefone");
                    String email = resultado.getString("email");

                    Contato contato = new Contato(nomeEncontrado, telefone, email);
                    System.out.println(contato);
                } else {
                    System.out.println("Contato não encontrado!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar contato: " + e.getMessage());
        }
    }

    public void atualizarContato(String nome, String novoTelefone, String novoEmail) {
        String sql = "UPDATE contatos SET telefone = ?, email = ? WHERE LOWER(nome) = LOWER(?)";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, novoTelefone);
            statement.setString(2, novoEmail);
            statement.setString(3, nome);

            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Contato atualizado com sucesso!");
            } else {
                System.out.println("Contato não encontrado!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar contato: " + e.getMessage());
        }
    }

    public void removerContato(String nome) {
        String sql = "DELETE FROM contatos WHERE nome = ?";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, nome);

            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Contato removido com sucesso!");
            } else {
                System.out.println("Contato não encontrado!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover contato: " + e.getMessage());
        }
    }
}