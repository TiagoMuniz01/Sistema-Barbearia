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

    public String getHorarioFormatado_agendamento() {
        return horario_agendamento.format(TIME_FORMATTER_EXIBICAO);
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

    public String getDataFormatada_agendamento() {
        return data_agendamento.format(DATE_FORMATTER_EXIBICAO);
    }

    public void setData_agendamento(String data_agendamento) {
        try {
            this.data_agendamento = LocalDate.parse(data_agendamento, DATE_FORMATTER_BANCO);
        } catch (Exception ex) {
            System.out.println("Erro ao converter data: " + ex.getMessage());
        }
    }

    // Método para inserir um agendamento
    public boolean inserir(Agendamento agendamento) {
        String sql = "INSERT INTO tb_agendamento (horario_agendamento, data_agendamento, cod_cliente, cod_profissional, cod_servico, cod_pagamento) VALUES (?, ?, ?, ?, ?, ?)";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            // Define os parâmetros com base no objeto Agendamento recebido
            stmt.setString(1, agendamento.getHorario_agendamento().format(TIME_FORMATTER_BANCO));
            stmt.setString(2, agendamento.getData_agendamento().format(DATE_FORMATTER_BANCO));
            stmt.setInt(3, agendamento.getCliente().getCod());
            stmt.setInt(4, agendamento.getProfissional().getCod());
            stmt.setInt(5, agendamento.getServico().getCod_servico());
            stmt.setInt(6, agendamento.getPagamento().getCod_pagamento());

            // Executa a inserção e verifica se teve sucesso
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
                int codCliente = rs.getInt("cod_cliente");
                if (!rs.wasNull() && codCliente > 0) {
                    Cliente cliente = new Cliente();
                    cliente.setCod(codCliente);
                    cliente.carregar(); // Método carregar preenche os dados do cliente

                    // Fromata a data de nasc para exibição
                    cliente.setData_nasc(cliente.getData_nascFormatada()); // Formata para exibição

                    agendamento.setCliente(cliente);
                }

                // Popula o serviço associado ao agendamento
                int codServico = rs.getInt("cod_servico");
                if (!rs.wasNull() && codServico > 0) {
                    Servico servico = new Servico();
                    servico.setCod_servico(codServico);
                    servico.carregar(); // Método carregar preenche os dados do serviço

                    // Certifica-se de que os dados do tempo de serviço sejam válidos
                    if (servico.getTempo_servico() == null) {
                        servico.setTempo_servico(LocalTime.MIDNIGHT); // Define como meia-noite (00:00:00) se nulo
                    }

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

    /*// Método para excluir um agendamento
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
    }*/

    // Método no AgendamentoModel para excluir um agendamento do banco de dados
    public boolean excluir(int codAgendamento) {
        String sql = "DELETE FROM tb_agendamento WHERE cod_agendamento = ?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, codAgendamento);  // Define o código do agendamento para exclusão

            // Executa a exclusão no banco
            int rowsDeleted = stmt.executeUpdate();

            return rowsDeleted > 0;  // Retorna 'true' se um registro foi excluído
        } catch (SQLException e) {
            System.out.println("Erro ao excluir agendamento: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();  // Garante que a conexão seja fechada
        }
    }

    public static ArrayList<Agendamento> buscarPorNomeCliente(String nomeCliente) {
        String sql = "SELECT a.* "
                + "FROM tb_agendamento a "
                + "INNER JOIN tb_cliente c ON a.cod_cliente = c.cod_cliente "
                + "WHERE c.nome_cliente LIKE ?"; // Consulta com filtro pelo nome do cliente
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
            stmt.setString(1, "%" + nomeCliente + "%"); // Define o parâmetro para a busca
            rs = stmt.executeQuery(); // Executa a consulta

            // Itera sobre os resultados retornados pelo banco de dados
            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setCod_agendamento(rs.getInt("cod_agendamento"));
                agendamento.setHorario_agendamento(rs.getString("horario_agendamento"));
                agendamento.setData_agendamento(rs.getString("data_agendamento"));

                // Popula o cliente associado ao agendamento
                int codCliente = rs.getInt("cod_cliente");
                if (!rs.wasNull() && codCliente > 0) {
                    Cliente cliente = new Cliente();
                    cliente.setCod(codCliente);
                    cliente.carregar(); // Método carregar preenche os dados do cliente

                    // Formata a data de nascimento para exibição
                    cliente.setData_nasc(cliente.getData_nascFormatada());
                    agendamento.setCliente(cliente);
                }

                // Popula o serviço associado ao agendamento
                int codServico = rs.getInt("cod_servico");
                if (!rs.wasNull() && codServico > 0) {
                    Servico servico = new Servico();
                    servico.setCod_servico(codServico);
                    servico.carregar(); // Método carregar preenche os dados do serviço

                    // Certifica-se de que os dados do tempo de serviço sejam válidos
                    if (servico.getTempo_servico() == null) {
                        servico.setTempo_servico(LocalTime.MIDNIGHT); // Define como meia-noite (00:00:00) se nulo
                    }
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

                // Popula o pagamento associado ao agendamento, se aplicável
                int codPagamento = rs.getInt("cod_pagamento");
                if (!rs.wasNull() && codPagamento > 0) {
                    Pagamento pagamento = new Pagamento();
                    pagamento.setCod_pagamento(codPagamento);
                    pagamento.carregar(); // Método carregar preenche os dados do pagamento
                    agendamento.setPagamento(pagamento);
                }

                // Adiciona o agendamento à lista
                agendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar agendamentos por nome do cliente: " + e.getMessage());
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

        return agendamentos; // Retorna a lista de agendamentos encontrados
    }

    public int getProximoCodigo() {
        String sql = "SELECT MAX(cod_agendamento) AS max_codigo FROM tb_agendamento";
        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return -1;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("max_codigo") + 1; // Incrementa o maior código encontrado
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o próximo código: " + e.getMessage());
        } finally {
            conexao.desconecta();
        }
        return 1; // Retorna 1 se a tabela estiver vazia
    }
}
