package model;

import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Profissional extends Pessoa {
    // Atributos
    private String desc_profissional;
    private String telefone_profissional;
    private String rg_profissional;
    private final Conexao conexao;

    // Construtores
    public Profissional() {
        // Construtor vazio para permitir a criação de objetos sem inicialização imediata
        this.conexao = new Conexao();
    }

    public Profissional(int cod_profissional, String nome_profissional, String cpf_profissional, String email_profissional, String telefone_profissional, String desc_profissional, String rg_profissional) {
        super(cod_profissional, nome_profissional, cpf_profissional, email_profissional, telefone_profissional);
        this.desc_profissional = desc_profissional;
        this.telefone_profissional = telefone_profissional;
        this.rg_profissional = rg_profissional;
        this.conexao = new Conexao();
    }

    // Métodos Getters e Setters
    public String getDesc_profissional() {
        return desc_profissional;
    }

    public void setDesc_profissional(String desc_profissional) {
        this.desc_profissional = desc_profissional;
    }

    public String getTelefone_profissional() {
        return telefone_profissional;
    }

    public void setTelefone_profissional(String telefone_profissional) {
        this.telefone_profissional = telefone_profissional;
    }

    public String getRg_profissional() {
        return rg_profissional;
    }

    public void setRg_profissional(String rg_profissional) {
        this.rg_profissional = rg_profissional;
    }

    // Método para inserir um profissional
    public boolean inserir() {
        String sql = "INSERT INTO tb_profissional (nome_profissional, cpf_profissional, email_profissional, telefone_profissional, desc_profissional, rg_profissional) VALUES (?, ?, ?, ?, ?, ?)";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            // Define os valores para a inserção
            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getCpf());
            stmt.setString(3, this.getEmail());
            stmt.setString(4, this.telefone_profissional);
            stmt.setString(5, this.desc_profissional);
            stmt.setString(6, this.rg_profissional);

            int rowsInserted = stmt.executeUpdate(); // Executa a inserção
            return rowsInserted > 0; // Retorna true se alguma linha foi inserida
        } catch (SQLException e) {
            System.out.println("Erro ao inserir profissional: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }

    // Método para listar todos os profissionais
    public List<Profissional> listar() {
        List<Profissional> profissionais = new ArrayList<>();
        String sql = "SELECT * FROM tb_profissional"; // Consulta ajustada com o nome correto da tabela

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return profissionais; // Retorna lista vazia em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery(); // Executa a consulta

            while (resultSet.next()) {
                // Criação do objeto Profissional a partir do resultado da consulta
                Profissional profissional = new Profissional();
                profissional.setCod(resultSet.getInt("cod_profissional"));
                profissional.setNome(resultSet.getString("nome_profissional"));
                profissional.setCpf(resultSet.getString("cpf_profissional"));
                profissional.setEmail(resultSet.getString("email_profissional"));
                profissional.setTelefone_profissional(resultSet.getString("telefone_profissional"));
                profissional.setDesc_profissional(resultSet.getString("desc_profissional"));
                profissional.setRg_profissional(resultSet.getString("rg_profissional"));
                profissionais.add(profissional); // Adiciona o profissional à lista
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar profissionais: " + e.getMessage());
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }

        return profissionais; // Retorna a lista de profissionais
    }

    // Método para atualizar um profissional
    public boolean atualizar() {
        String sql = "UPDATE tb_profissional SET nome_profissional=?, cpf_profissional=?, email_profissional=?, telefone_profissional=?, desc_profissional=?, rg_profissional=? WHERE cod_profissional=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            // Define os valores para a atualização
            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getCpf());
            stmt.setString(3, this.getEmail());
            stmt.setString(4, this.telefone_profissional);
            stmt.setString(5, this.desc_profissional);
            stmt.setString(6, this.rg_profissional);
            stmt.setInt(7, this.getCod()); // Código do profissional para localização

            int rowsUpdated = stmt.executeUpdate(); // Executa a atualização
            return rowsUpdated > 0; // Retorna true se alguma linha foi atualizada
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar profissional: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }

    // Método para excluir um profissional
    public boolean excluir(int cod_profissional) {
        String sql = "DELETE FROM tb_profissional WHERE cod_profissional=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, cod_profissional); // Define o ID do profissional a ser excluído
            int rowsDeleted = stmt.executeUpdate(); // Executa a exclusão
            return rowsDeleted > 0; // Retorna true se alguma linha foi excluída
        } catch (SQLException e) {
            System.out.println("Erro ao excluir profissional: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }
    
    // Método para buscar um profissional pelo email
    public Profissional buscarPorEmail(String email) {
        String sql = "SELECT * FROM tb_profissional WHERE email_profissional = ?";

        if (!conexao.conecta()) {
            System.out.println("Erro de conexão com o banco de dados");
            return null;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Cria um objeto Profissional com os dados obtidos
                Profissional profissional = new Profissional();
                profissional.setCod(rs.getInt("cod_profissional"));
                profissional.setNome(rs.getString("nome_profissional"));
                profissional.setCpf(rs.getString("cpf_profissional"));
                profissional.setEmail(rs.getString("email_profissional"));
                profissional.setTelefone_profissional(rs.getString("telefone_profissional"));
                profissional.setDesc_profissional(rs.getString("desc_profissional"));
                profissional.setRg_profissional(rs.getString("rg_profissional"));
                return profissional;  // Retorna o objeto Profissional
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar profissional: " + e.getMessage());
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }

        return null; // Retorna null se o profissional não for encontrado
    }
    
    public void carregar() {
        String sql = "SELECT * FROM tb_cliente WHERE cod_cliente = ?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, this.getCod()); // Usa o código do profissional para buscar
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                this.setNome(resultSet.getString("nome_profissional"));
                this.setCpf(resultSet.getString("cpf_profissional"));
                this.setEmail(resultSet.getString("email_profissional"));
                this.setDesc_profissional(resultSet.getString("desc_profissional"));
                this.setRg_profissional(resultSet.getString("telefone_profissional"));
                this.setRg_profissional(resultSet.getString("rg_profissional"));
            } else {
                System.out.println("Cliente não encontrado no banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao carregar cliente: " + e.getMessage());
        } finally {
            conexao.desconecta();
        }
    }
}
