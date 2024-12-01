package model;

import conexao.Conexao;
import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Servico {

    private int cod_servico;
    private String nome_servico;
    private String descricao_servico;
    private float preco_servico;
    private LocalTime tempo_servico;
    private final Conexao conexao;

    private static final DateTimeFormatter TIME_FORMATTER_BANCO = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter TIME_FORMATTER_EXIBICAO = DateTimeFormatter.ofPattern("HH:mm");

    // Construtores
    public Servico() {
        this.conexao = new Conexao();
    }

    public Servico(int cod_servico, String nome_servico, String descricao_servico, float preco_servico, String tempo_servico) {
        this.cod_servico = cod_servico;
        this.nome_servico = nome_servico;
        this.descricao_servico = descricao_servico;
        this.preco_servico = preco_servico;

        try {
            this.tempo_servico = LocalTime.parse(tempo_servico, TIME_FORMATTER_BANCO);
        } catch (Exception ex) {
            System.out.println("Erro ao converter horário: " + ex.getMessage());
        }

        this.conexao = new Conexao();

    }

    // Métodos Getters e Setters
    public int getCod_servico() {
        return cod_servico;
    }

    public void setCod_servico(int cod_servico) {
        this.cod_servico = cod_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public String getDescricao_servico() {
        return descricao_servico;
    }

    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }

    public float getPreco_servico() {
        return preco_servico;
    }

    public void setPreco_servico(float preco_servico) {
        this.preco_servico = preco_servico;
    }

    public String getHorarioFormatado_agendamento() {
        return tempo_servico.format(TIME_FORMATTER_EXIBICAO);
    }

    public void setHorario_agendamento(String horario_agendamento) {
        try {
            this.tempo_servico = LocalTime.parse(horario_agendamento, TIME_FORMATTER_BANCO);
        } catch (Exception ex) {
            System.out.println("Erro ao converter horário: " + ex.getMessage());
        }
    }

    public LocalTime getTempo_servico() {
        return tempo_servico;
    }

    public void setTempo_servico(LocalTime tempo_servico) {
        this.tempo_servico = tempo_servico;
    }

    // Método para inserir um serviço
    public boolean inserir() {
        String sql = "INSERT INTO tb_servico (nome_servico, preco_servico, tempo_servico, desc_servico) VALUES (?, ?, ?, ?)";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.nome_servico);
            stmt.setFloat(2, this.preco_servico);
            stmt.setString(3, this.tempo_servico.format(TIME_FORMATTER_BANCO));
            stmt.setString(4, this.descricao_servico);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir serviço: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();
        }
    }

// Método para listar todos os serviços
    public static ArrayList<Servico> listar() {
        ArrayList<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM tb_servico";

        Conexao conexaoLocal = new Conexao();

        if (!conexaoLocal.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return servicos;
        }

        try (PreparedStatement stmt = conexaoLocal.getConexao().prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Servico servico = new Servico();
                servico.setCod_servico(resultSet.getInt("cod_servico"));
                servico.setNome_servico(resultSet.getString("nome_servico"));
                servico.setPreco_servico(resultSet.getFloat("preco_servico"));
                servico.setDescricao_servico(resultSet.getString("desc_servico"));

                String tempoServicoStr = resultSet.getString("tempo_servico");
                if (tempoServicoStr != null && !tempoServicoStr.isEmpty()) {
                    servico.setTempo_servico(LocalTime.parse(tempoServicoStr, TIME_FORMATTER_BANCO));
                }

                servicos.add(servico);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar serviços: " + e.getMessage());
        } finally {
            conexaoLocal.desconecta();
        }

        return servicos;
    }

// Método para atualizar um serviço
    public boolean atualizar() {
        String sql = "UPDATE tb_servico SET nome_servico=?, preco_servico=?, tempo_servico=?, desc_servico=? WHERE cod_servico=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.nome_servico);
            stmt.setFloat(2, this.preco_servico);
            stmt.setString(3, this.tempo_servico.format(TIME_FORMATTER_BANCO));
            stmt.setString(4, this.descricao_servico);
            stmt.setInt(5, this.cod_servico);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar serviço: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();
        }
    }

// Método para excluir um serviço
    public boolean excluir(int cod_servico) {
        String sql = "DELETE FROM tb_servico WHERE cod_servico=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, cod_servico);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir serviço: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();
        }
    }

// Método para carregar os dados de um serviço com base no cod_servico
    public void carregar() {
        String sql = "SELECT * FROM tb_servico WHERE cod_servico = ?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, this.cod_servico);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                this.nome_servico = resultSet.getString("nome_servico");
                this.descricao_servico = resultSet.getString("desc_servico");
                this.preco_servico = resultSet.getFloat("preco_servico");

                String tempoBanco = resultSet.getString("tempo_servico");
                if (tempoBanco != null && !tempoBanco.isEmpty()) {
                    this.tempo_servico = LocalTime.parse(tempoBanco, TIME_FORMATTER_BANCO);
                }
            } else {
                System.out.println("Serviço não encontrado no banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao carregar serviço: " + e.getMessage());
        } finally {
            conexao.desconecta();
        }
    }
    
    @Override
    public String toString(){
        return getNome_servico();
    }
}