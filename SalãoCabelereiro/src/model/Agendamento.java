package model;

import conexao.Conexao;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {

    private int cod_agendamento;
    private Cliente cliente; // FK
    private Profissional profissional; // FK
    private Pagamento pagamento; // FK
    private int cod_servico;
    private LocalTime horario_agendamento;
    private LocalDate data_agendamento;
    private final Conexao conexao;

    // Construtor com tratamento para a data e horário de agendamento
    public Agendamento() {
        this.conexao = new Conexao();
    }

    public Agendamento(int cod_agendamento, Cliente cliente, Profissional profissional, Pagamento pagamento, int cod_servico, String horario_agendamento, String data_agendamento) {
        this.cod_agendamento = cod_agendamento;
        this.cliente = cliente;
        this.profissional = profissional;
        this.pagamento = pagamento;
        this.cod_servico = cod_servico;

        // Tenta converter a string horario_agendamento para LocalTime
        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            this.horario_agendamento = LocalTime.parse(horario_agendamento, timeFormatter);
        } catch (Exception ex) {
            System.out.println("Erro ao converter horário: " + ex.getMessage());
        }

        // Tenta converter a string data_agendamento para LocalDate
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.data_agendamento = LocalDate.parse(data_agendamento, dateFormatter);
        } catch (Exception ex) {
            System.out.println("Erro ao converter data: " + ex.getMessage());
        }

        this.conexao = new Conexao();
    }

    // Getters e Setters
    public int getCod_agendamento() {
        return cod_agendamento;
    }

    public void setCod_agendamento(int cod_agendamento) {
        this.cod_agendamento = cod_agendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public int getCod_servico() {
        return cod_servico;
    }

    public void setCod_servico(int cod_servico) {
        this.cod_servico = cod_servico;
    }

    public LocalTime getHorario_agendamento() {
        return horario_agendamento;
    }

    public void setHorario_agendamento(String horario_agendamento) {
        try {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            this.horario_agendamento = LocalTime.parse(horario_agendamento, timeFormatter);
        } catch (Exception ex) {
            System.out.println("Erro ao converter horário: " + ex.getMessage());
        }
    }

    public LocalDate getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(String data_agendamento) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.data_agendamento = LocalDate.parse(data_agendamento, dateFormatter);
        } catch (Exception ex) {
            System.out.println("Erro ao converter data: " + ex.getMessage());
        }
    }

    // Método para inserir um agendamento
    public boolean inserir() {
        String sql = "INSERT INTO agendamento (horario_agendamento, data_agendamento, cod_cliente, cod_profissional, cod_servico, cod_pagamento) VALUES (?, ?, ?, ?, ?, ?)";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.horario_agendamento.toString()); // Formato HH:mm
            stmt.setString(2, this.data_agendamento.toString()); // Formato yyyy-MM-dd
            stmt.setInt(3, this.cliente.getCod()); // Chave estrangeira para Cliente
            stmt.setInt(4, this.profissional.getCod()); // Chave estrangeira para Profissional
            stmt.setInt(5, this.cod_servico); // Chave estrangeira para Serviço
            stmt.setInt(6, this.pagamento.getCod_pagamento()); // Chave estrangeira para Pagamento

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir agendamento: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();
        }
    }

    // Método para listar todos os agendamentos
    public void listar() {
        String sql = "SELECT * FROM agendamento";
        
        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Agendamento: " + rs.getInt("cod_agendamento") + " - " +
                                   rs.getString("horario_agendamento") + " - " +
                                   rs.getString("data_agendamento"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar agendamentos: " + e.getMessage());
        } finally {
            conexao.desconecta();
        }
    }

    // Método para atualizar um agendamento
    public boolean atualizar() {
        String sql = "UPDATE agendamento SET horario_agendamento=?, data_agendamento=?, cod_cliente=?, cod_profissional=?, cod_servico=?, cod_pagamento=? WHERE cod_agendamento=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.horario_agendamento.toString()); // Formato HH:mm
            stmt.setString(2, this.data_agendamento.toString()); // Formato yyyy-MM-dd
            stmt.setInt(3, this.cliente.getCod()); // Chave estrangeira para Cliente
            stmt.setInt(4, this.profissional.getCod()); // Chave estrangeira para Profissional
            stmt.setInt(5, this.cod_servico); // Chave estrangeira para Serviço
            stmt.setInt(6, this.pagamento.getCod_pagamento()); // Chave estrangeira para Pagamento
            stmt.setInt(7, this.cod_agendamento); // Para identificar o agendamento a ser atualizado

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar agendamento: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();
        }
    }

    // Método para excluir um agendamento
    public boolean excluir() {
        String sql = "DELETE FROM agendamento WHERE cod_agendamento=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, this.cod_agendamento); // Usa o código para excluir o agendamento

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir agendamento: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();
        }
    }
}
