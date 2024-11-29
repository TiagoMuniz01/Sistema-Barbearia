package model;

import conexao.Conexao;
import java.sql.*;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Servico {

    private int cod_servico;
    private String nome_servico;
    private String descricao_servico;
    private float preco_servico;
    private Duration tempo_servico;
    private final Conexao conexao;

    // Construtores
    public Servico() {
        this.conexao = new Conexao();
    }

    public Servico(int cod_servico, String nome_servico, String descricao_servico, float preco_servico, Duration tempo_servico) {
        this.cod_servico = cod_servico;
        this.nome_servico = nome_servico;
        this.descricao_servico = descricao_servico;
        this.preco_servico = preco_servico;
        this.tempo_servico = tempo_servico;
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

    public Duration getTempo_servico() {
        return tempo_servico;
    }

    public void setTempo_servico(Duration tempo_servico) {
        this.tempo_servico = tempo_servico;
    }

    // Método para inserir um serviço
    public boolean inserir() {
        String sql = "INSERT INTO tb_servico (nome_servico, preco_servico, tempo_servico, desc_servico) VALUES (?, ?, ?, ?)";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.nome_servico); // Define o nome do serviço
            stmt.setFloat(2, this.preco_servico); // Define o preço do serviço
            stmt.setString(3, this.tempo_servico.toString()); // Converte o tempo para string
            stmt.setString(4, this.descricao_servico); // Define a descrição do serviço

            int rowsInserted = stmt.executeUpdate(); // Executa a inserção
            return rowsInserted > 0; // Retorna true se alguma linha foi inserida
        } catch (SQLException e) {
            System.out.println("Erro ao inserir serviço: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }

    // Método para listar todos os serviços
    public static ArrayList<Servico> listar() {
        ArrayList<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM tb_servico"; // Consulta ajustada com o nome correto da tabela

        Conexao conexaoLocal = new Conexao();

        if (!conexaoLocal.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return servicos; // Retorna lista vazia em caso de erro
        }

        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            stmt = conexaoLocal.getConexao().prepareStatement(sql);
            resultSet = stmt.executeQuery(); // Executa a consulta

            while (resultSet.next()) {
                // Criação do objeto Servico a partir do resultado da consulta
                Servico servico = new Servico();
                servico.setCod_servico(resultSet.getInt("cod_servico"));
                servico.setNome_servico(resultSet.getString("nome_servico"));
                servico.setPreco_servico(resultSet.getFloat("preco_servico"));

                /*/ Trata o tempo do serviço como Duration, verificando se o valor não é nulo
                String tempoServicoStr = resultSet.getString("tempo_servico");
                if (tempoServicoStr != null && !tempoServicoStr.isEmpty()) {
                    servico.setTempo_servico(Duration.parse(tempoServicoStr));
                } else {
                    servico.setTempo_servico(Duration.ZERO); // Define como zero se não houver valor
                }*/

                servico.setDescricao_servico(resultSet.getString("desc_servico"));
                servicos.add(servico); // Adiciona o serviço à lista
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar serviços: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
            conexaoLocal.desconecta(); // Fecha a conexão
        }

        return servicos; // Retorna a lista de serviços
    }

    // Método para atualizar um serviço
    public boolean atualizar() {
        String sql = "UPDATE tb_servico SET nome_servico=?, preco_servico=?, tempo_servico=?, desc_servico=? WHERE cod_servico=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.nome_servico); // Define o nome do serviço
            stmt.setFloat(2, this.preco_servico); // Define o preço do serviço
            stmt.setString(3, this.tempo_servico.toString()); // Converte o tempo para string
            stmt.setString(4, this.descricao_servico); // Define a descrição do serviço
            stmt.setInt(5, this.cod_servico); // Define o código do serviço a ser atualizado

            int rowsUpdated = stmt.executeUpdate(); // Executa a atualização
            return rowsUpdated > 0; // Retorna true se alguma linha foi atualizada
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar serviço: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }

    // Método para excluir um serviço
    public boolean excluir(int cod_servico) {
        String sql = "DELETE FROM tb_servico WHERE cod_servico=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, cod_servico); // Define o código do serviço a ser excluído

            int rowsDeleted = stmt.executeUpdate(); // Executa a exclusão
            return rowsDeleted > 0; // Retorna true se alguma linha foi excluída
        } catch (SQLException e) {
            System.out.println("Erro ao excluir serviço: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
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
            stmt.setInt(1, this.cod_servico); // Define o código do serviço a ser carregado
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // Preenche os atributos do serviço a partir do resultado da consulta
                this.nome_servico = resultSet.getString("nome_servico");
                this.descricao_servico = resultSet.getString("desc_servico");
                this.preco_servico = resultSet.getFloat("preco_servico");

               /* // Tenta pegar o tempo_servico
                String tempoBanco = resultSet.getString("tempo_servico");

                if (tempoBanco != null && !tempoBanco.isEmpty()) {
                    try {
                        this.tempo_servico = Duration.parse(tempoBanco); // Converte se estiver no formato correto
                    } catch (DateTimeParseException e) {
                        System.out.println("Erro ao parsear tempo_servico (formato inválido): " + e.getMessage());
                        this.tempo_servico = Duration.ZERO; // Define um valor padrão em caso de erro de formato
                    }
                } else {
                    this.tempo_servico = Duration.ZERO; // Define como 0 se for nulo ou vazio
                }*/
            } else {
                System.out.println("Serviço não encontrado no banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao carregar serviço: " + e.getMessage());
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }

    @Override
    public String toString(){
        return getNome_servico();
    }
}
