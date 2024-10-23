/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexao {

    final private String driver = "com.mysql.cj.jdbc.Driver"; // Atualizado para o driver mais recente do MySQL
    final private String url = "jdbc:mysql://localhost/db_barbearia_barbeleon"; // URL de conexão com o banco de dados
    final private String usuario = "root"; // Usuário do MySQL
    final private String senha = ""; // Senha do MySQL
    public Connection conexao; // Variável que armazenará a conexão aberta
    public Statement statement; // Variável para execução dos comandos SQL no ambiente JAVA
    public ResultSet resultset; // Variável que armazenará o resultado da execução de um comando SQL
    
    public Connection getConexao() {
        return this.conexao;
    }

    // Método para estabelecer a conexão com o banco de dados
    public boolean conecta() {
        boolean result = true;
        try {
            Class.forName(driver); // Carrega o driver JDBC
            conexao = DriverManager.getConnection(url, usuario, senha); // Estabelece a conexão
            System.out.println("Conexão estabelecida com sucesso.");
        } catch (ClassNotFoundException Driver) {
            System.out.println("Driver não localizado: " + Driver.getMessage());
            result = false;
        } catch (SQLException Fonte) {
            System.out.println("Erro na fonte de dados: " + Fonte.getMessage());
            result = false;
        }
        return result;
    }

    // Método para fechar a conexão com o banco de dados
    public void desconecta() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão com o banco fechada.");
            }
        } catch (SQLException fecha) {
            System.out.println("Erro ao fechar a conexão: " + fecha.getMessage());
        }
    }

    // Método para executar comandos SQL
    public void executaSQL(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
            System.out.println("Comando SQL executado com sucesso.");
        } catch (SQLException excecao) {
            System.out.println("Erro no comando SQL: " + excecao.getMessage());
        }
    }
}

