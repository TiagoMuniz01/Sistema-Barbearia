package model;

import conexao.Conexao;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private LocalDate data_nasc;
    private String senha_cliente;
    private String telefone_cliente; // Variável mantida conforme seu nome anterior
    private final Conexao conexao; // Objeto para manipulação da conexão com o banco de dados

    // Construtor vazio
    public Cliente() {
        this.conexao = new Conexao();
    }

    // Construtor parametrizado
    public Cliente(int cod_cliente, String nome_cliente, String cpf_cliente, String email_cliente, String telefone_cliente, String data_nasc, String senha_cliente) {
        super(cod_cliente, nome_cliente, cpf_cliente, email_cliente, telefone_cliente); // Chama o construtor da classe Pessoa
        this.conexao = new Conexao();

        try {
            // Definindo o formato esperado da data (dd/MM/yyyy)
            DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Convertendo a string data_nasc para LocalDate
            this.data_nasc = LocalDate.parse(data_nasc, formatado);
        } catch (DateTimeParseException ex) {
            System.out.println("Erro: Data no formato inválido. Use o formato dd/MM/yyyy.");
        }

        this.senha_cliente = senha_cliente;
    }

    // Getters e Setters
    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.data_nasc = LocalDate.parse(data_nasc, formatter);
        } catch (DateTimeParseException ex) {
            System.out.println("Erro: Data no formato inválido. Use o formato dd/MM/yyyy.");
        }
    }

    public String getSenha_cliente() {
        return senha_cliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senha_cliente = senha_cliente;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    // Método para inserir um cliente no banco de dados
    public boolean inserir() {
        String sql = "INSERT INTO tb_cliente (nome_cliente, cpf_cliente, email_cliente, telefone_cliente, data_nasc, senha_cliente) VALUES (?, ?, ?, ?, ?, ?)";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getCpf());
            stmt.setString(3, this.getEmail());
            stmt.setString(4, this.telefone_cliente);
            stmt.setString(5, this.data_nasc.toString()); // Convertendo LocalDate para String
            stmt.setString(6, this.senha_cliente);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();
        }
    }

    // Método para listar todos os clientes
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM tb_cliente";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return clientes;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setCod(resultSet.getInt("cod_cliente")); // Ajustado para o campo correto
                cliente.setNome(resultSet.getString("nome_cliente"));
                cliente.setCpf(resultSet.getString("cpf_cliente"));
                cliente.setEmail(resultSet.getString("email_cliente"));
                cliente.setTelefone_cliente(resultSet.getString("telefone_cliente"));
                cliente.setData_nasc(resultSet.getString("data_nasc"));
                cliente.setSenha_cliente(resultSet.getString("senha_cliente"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        } finally {
            conexao.desconecta();
        }

        return clientes;
    }

    // Método para atualizar um cliente no banco de dados
    public boolean atualizar() {
        String sql = "UPDATE tb_cliente SET nome_cliente=?, cpf_cliente=?, email_cliente=?, telefone_cliente=?, data_nasc=?, senha_cliente=? WHERE cod_cliente=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getCpf());
            stmt.setString(3, this.getEmail());
            stmt.setString(4, this.telefone_cliente);
            stmt.setString(5, this.data_nasc.toString()); // Convertendo LocalDate para String
            stmt.setString(6, this.senha_cliente);
            stmt.setInt(7, this.getCod()); // Ajuste para o campo `cod_cliente`

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();
        }
    }

    // Método para excluir um cliente do banco de dados
    public boolean excluir(int cod_cliente) {
        String sql = "DELETE FROM tb_cliente WHERE cod_cliente=?";

        if (!conexao.conecta()) {
            System.out.println("Não foi possível conectar ao banco de dados");
            return false;
        }

        try (PreparedStatement stmt = conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, cod_cliente);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
            return false;
        } finally {
            conexao.desconecta();
        }
    }
}
