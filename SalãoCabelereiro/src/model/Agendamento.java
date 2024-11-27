package model;

import conexao.Conexao;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Agendamento {

    private int cod_agendamento;
    private Cliente cliente; // FK
    private Profissional profissional; // FK
    private Pagamento pagamento; // FK
    private Servico servico; // FK
    private LocalTime horario_agendamento;
    private LocalDate data_agendamento;
    private final Conexao conexao;

    // Formatadores para data e hora (conversão do banco e exibição)
    private static final DateTimeFormatter TIME_FORMATTER_BANCO = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER_BANCO = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER_EXIBICAO = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER_EXIBICAO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Construtor vazio
    public Agendamento() {
        this.conexao = new Conexao();
    }

    // Construtor completo
    public Agendamento(int cod_agendamento, Cliente cliente, Profissional profissional, Pagamento pagamento, Servico servico, String horario_agendamento, String data_agendamento) {
        this.cod_agendamento = cod_agendamento;
        this.cliente = cliente;
        this.profissional = profissional;
        this.pagamento = pagamento;
        this.servico = servico;

        try {
            this.horario_agendamento = LocalTime.parse(horario_agendamento, TIME_FORMATTER_BANCO);
        } catch (Exception ex) {
            System.out.println("Erro ao converter horário: " + ex.getMessage());
        }

        try {
            this.data_agendamento = LocalDate.parse(data_agendamento, DATE_FORMATTER_BANCO);
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

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalTime getHorario_agendamento() {
        return horario_agendamento;
    }

    public void setHorario_agendamento(String horario_agendamento) {
        try {
            this.horario_agendamento = LocalTime.parse(horario_agendamento, TIME_FORMATTER_BANCO);
        } catch (Exception ex) {
            System.out.println("Erro ao converter horário: " + ex.getMessage());
        }
    }

    public LocalDate getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(String data_agendamento) {
        try {
            this.data_agendamento = LocalDate.parse(data_agendamento, DATE_FORMATTER_BANCO);
        } catch (Exception ex) {
            System.out.println("Erro ao converter data: " + ex.getMessage());
        }
    }

    // Método para inserir um agendamento
    public boolean inserir() {
        String sql = "INSERT INTO tb_agendamento (horario_agendamento, data_agendamento, cod_cliente, cod_profissional, cod_servico, cod_pagamento) VALUES (?, ?, ?, ?, ?, ?)";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.horario_agendamento.format(TIME_FORMATTER_BANCO));
            stmt.setString(2, this.data_agendamento.format(DATE_FORMATTER_BANCO));
            stmt.setInt(3, this.cliente.getCod());
            stmt.setInt(4, this.profissional.getCod());
            stmt.setInt(5, this.servico.getCod_servico());
            stmt.setInt(6, this.pagamento.getCod_pagamento());

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
    public static ArrayList<Agendamento> listar() {
        String sql = "SELECT * FROM tb_agendamento";
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        Conexao conexaoLocal = new Conexao();

        if (!conexaoLocal.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return agendamentos;
        }

        try (PreparedStatement stmt = conexaoLocal.getConexao().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setCod_agendamento(rs.getInt("cod_agendamento"));
                agendamento.setHorario_agendamento(rs.getString("horario_agendamento"));
                agendamento.setData_agendamento(rs.getString("data_agendamento"));

                // Popule objetos associados, se necessário
                // Exemplo:
                // Cliente cliente = new Cliente();
                // cliente.setCod(rs.getInt("cod_cliente"));
                // agendamento.setCliente(cliente);

                agendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar agendamentos: " + e.getMessage());
        } finally {
            conexaoLocal.desconecta();
        }

        return agendamentos;
    }

    // Método para atualizar um agendamento
    public boolean atualizar() {
        String sql = "UPDATE tb_agendamento SET horario_agendamento=?, data_agendamento=?, cod_cliente=?, cod_profissional=?, cod_servico=?, cod_pagamento=? WHERE cod_agendamento=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.horario_agendamento.format(TIME_FORMATTER_BANCO));
            stmt.setString(2, this.data_agendamento.format(DATE_FORMATTER_BANCO));
            stmt.setInt(3, this.cliente.getCod());
            stmt.setInt(4, this.profissional.getCod());
            stmt.setInt(5, this.servico.getCod_servico());
            stmt.setInt(6, this.pagamento.getCod_pagamento());
            stmt.setInt(7, this.cod_agendamento);

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
        String sql = "DELETE FROM tb_agendamento WHERE cod_agendamento=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, this.cod_agendamento);

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

