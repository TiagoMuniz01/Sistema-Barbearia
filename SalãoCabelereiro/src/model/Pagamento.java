package model;

import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pagamento {
    private int cod_pagamento;
    private String forma_pagamento;
    private final Conexao conexao;

    // Construtores
    public Pagamento() {
        this.conexao = new Conexao();
    }

    public Pagamento(int cod_pagamento, String forma_pagamento) {
        this.cod_pagamento = cod_pagamento;
        this.forma_pagamento = forma_pagamento;
        this.conexao = new Conexao();
    }

    // Métodos Getters e Setters
    public int getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(int cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    // Método para inserir um pagamento
    public boolean inserir() {
        String sql = "INSERT INTO pagamento (forma_pagamento) VALUES (?)"; // Ajustando para o campo correto

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.forma_pagamento); // Define o valor para a inserção

            int rowsInserted = stmt.executeUpdate(); // Executa a inserção
            return rowsInserted > 0; // Retorna true se alguma linha foi inserida
        } catch (SQLException e) {
            System.out.println("Erro ao inserir pagamento: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }

    // Método para listar todos os pagamentos
    public List<Pagamento> listar() {
        List<Pagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT * FROM pagamento"; // Consulta ajustada com o nome correto da tabela

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return pagamentos; // Retorna lista vazia em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery(); // Executa a consulta

            while (resultSet.next()) {
                // Criação do objeto Pagamento a partir do resultado da consulta
                Pagamento pagamento = new Pagamento();
                pagamento.setCod_pagamento(resultSet.getInt("cod_pagamento"));
                pagamento.setForma_pagamento(resultSet.getString("forma_pagamento"));
                pagamentos.add(pagamento); // Adiciona o pagamento à lista
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }

        return pagamentos; // Retorna a lista de pagamentos
    }

    // Método para atualizar um pagamento
    public boolean atualizar() {
        String sql = "UPDATE pagamento SET forma_pagamento=? WHERE cod_pagamento=?"; // Ajustando a consulta

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.forma_pagamento); // Define o valor para a atualização
            stmt.setInt(2, this.cod_pagamento); // Define o código do pagamento a ser atualizado

            int rowsUpdated = stmt.executeUpdate(); // Executa a atualização
            return rowsUpdated > 0; // Retorna true se alguma linha foi atualizada
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pagamento: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }

    // Método para excluir um pagamento
    public boolean excluir(int cod_pagamento) {
        String sql = "DELETE FROM pagamento WHERE cod_pagamento=?"; // Ajustando a consulta

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, cod_pagamento); // Define o código do pagamento a ser excluído

            int rowsDeleted = stmt.executeUpdate(); // Executa a exclusão
            return rowsDeleted > 0; // Retorna true se alguma linha foi excluída
        } catch (SQLException e) {
            System.out.println("Erro ao excluir pagamento: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }
}

