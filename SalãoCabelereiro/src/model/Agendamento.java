package model;

import conexao.Conexao;
import java.sql.*;
import java.time.Duration;
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
        String sql = "SELECT * FROM tb_agendamento"; // Consulta para listar todos os agendamentos
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        Conexao conexaoLocal = new Conexao();

        if (!conexaoLocal.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return agendamentos; // Retorna uma lista vazia em caso de erro
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexaoLocal.getConexao().prepareStatement(sql); // Prepara a consulta
            rs = stmt.executeQuery(); // Executa a consulta e obtém os resultados

            // Itera sobre os resultados retornados pelo banco de dados
            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setCod_agendamento(rs.getInt("cod_agendamento"));
                agendamento.setHorario_agendamento(rs.getString("horario_agendamento"));
                agendamento.setData_agendamento(rs.getString("data_agendamento"));

                // Popula o cliente associado ao agendamento
                // Popula o cliente associado ao agendamento
                int codCliente = rs.getInt("cod_cliente");
                if (!rs.wasNull() && codCliente > 0) {
                    Cliente cliente = new Cliente();
                    cliente.setCod(codCliente);
                    cliente.carregar(); // Método carregar preenche os dados do cliente

                    // Verifica se a data de nascimento do cliente é válida
                    LocalDate dataNascimento = cliente.getData_nasc();  // Aqui já é um LocalDate

                    if (dataNascimento != null) {
                        // Caso queira exibir a data no formato desejado
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        cliente.setData_nasc(dataNascimento.format(formatter)); // Formata para exibição
                    } else {
                        cliente.setData_nasc(""); // Define como vazio se a data for nula
                    }

                    agendamento.setCliente(cliente);
                }

                // Popula o serviço associado ao agendamento
                int codServico = rs.getInt("cod_servico");
                if (!rs.wasNull() && codServico > 0) {
                    Servico servico = new Servico();
                    servico.setCod_servico(codServico);

                    // Valida e converte o tempo_servico
                    try {
                        String tempo = rs.getString("tempo_servico");
                        if (tempo != null && !tempo.isEmpty()) {
                            servico.setTempo_servico(Duration.parse(tempo)); // Converte a string para Duration
                        } else {
                            servico.setTempo_servico(Duration.ZERO); // Define como 0 se nulo ou vazio
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao processar tempo_servico: " + e.getMessage());
                        servico.setTempo_servico(Duration.ZERO); // Define um valor padrão em caso de erro
                    }

                    servico.carregar(); // Método carregar preenche os dados do serviço
                    agendamento.setServico(servico);
                }

                // Popula o profissional associado ao agendamento, se aplicável
                int codProfissional = rs.getInt("cod_profissional");
                if (!rs.wasNull() && codProfissional > 0) {
                    Profissional profissional = new Profissional();
                    profissional.setCod(codProfissional);
                    profissional.carregar(); // Método carregar preenche os dados do profissional
                    agendamento.setProfissional(profissional);
                }
                
                int codPagamento = rs.getInt("cod_pagamento");
                if (!rs.wasNull() && codPagamento > 0) {
                    Pagamento pagamento = new Pagamento();
                    pagamento.setCod_pagamento(codPagamento);
                    pagamento.carregar(); // Método carregar preenche os dados do profissional
                    agendamento.setPagamento(pagamento);
                }

                // Adiciona o agendamento à lista
                agendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar agendamentos: " + e.getMessage());
        } finally {
            // Fecha o ResultSet e PreparedStatement, além da conexão
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
            conexaoLocal.desconecta(); // Fecha a conexão
        }

        return agendamentos; // Retorna a lista de agendamentos
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
