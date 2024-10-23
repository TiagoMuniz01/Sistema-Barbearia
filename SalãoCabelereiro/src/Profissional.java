import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Profissional {
    // Atributos
    private int id; // Supondo que ID é um campo gerado pelo banco de dados
    private String nome;
    private String especialidade;
    private String telefone;
    private String celular;
    private String endereco;
    private final Conexao conexao;

    // Construtor
    public Profissional() {
        this.conexao = new Conexao(); // Instancia a classe de conexão
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Método para inserir um profissional
    public boolean inserir() {
        String sql = "INSERT INTO profissional (nome, especialidade, telefone, celular, endereco) VALUES (?, ?, ?, ?, ?)";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            // Define os valores para a inserção
            stmt.setString(1, this.nome);
            stmt.setString(2, this.especialidade);
            stmt.setString(3, this.telefone);
            stmt.setString(4, this.celular);
            stmt.setString(5, this.endereco);

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
        String sql = "SELECT * FROM profissional"; 

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return profissionais; // Retorna lista vazia em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery(); // Executa a consulta

            while (resultSet.next()) {
                // Criação do objeto Profissional a partir do resultado da consulta
                Profissional profissional = new Profissional();
                profissional.setId(resultSet.getInt("id"));
                profissional.setNome(resultSet.getString("nome"));
                profissional.setEspecialidade(resultSet.getString("especialidade"));
                profissional.setTelefone(resultSet.getString("telefone"));
                profissional.setCelular(resultSet.getString("celular"));
                profissional.setEndereco(resultSet.getString("endereco"));
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
        String sql = "UPDATE profissional SET nome=?, especialidade=?, telefone=?, celular=?, endereco=? WHERE id=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            // Define os valores para a atualização
            stmt.setString(1, this.nome);
            stmt.setString(2, this.especialidade);
            stmt.setString(3, this.telefone);
            stmt.setString(4, this.celular);
            stmt.setString(5, this.endereco);
            stmt.setInt(6, this.id); // ID do profissional para localização

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
    public boolean excluir(int id) {
        String sql = "DELETE FROM profissional WHERE id=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false; // Retorna false em caso de erro
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, id); // Define o ID do profissional a ser excluído
            int rowsDeleted = stmt.executeUpdate(); // Executa a exclusão
            return rowsDeleted > 0; // Retorna true se alguma linha foi excluída
        } catch (SQLException e) {
            System.out.println("Erro ao excluir profissional: " + e.getMessage());
            return false; // Retorna false em caso de erro
        } finally {
            conexao.desconecta(); // Fecha a conexão
        }
    }
}
