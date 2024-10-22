/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

/**
 *
 * @author jocimar
 */
    import javax.swing.JOptionPane;
    import java.sql.*; // Importando classe sql para execução de comandos SQL no ambiente JAVA

public class Conexao {
       
    final private String driver = "com.mysql.jdbc.Driver"; //Definição do driver MySQL para acesso aos dados
    final private String url = "jdbc:mysql://localhost/db_barbearia_barbeleon"; //Acesso ao banco de dados do servidor
    final private String usuario = "root"; // Usuário do MySQL - usbwebserver
    final private String senha = ""; // Senha do MySQL - usbwebserver
    private Connection conexao; // Variável que armazenará a conexão aberta
    public Statement statement; // Variável  para execução dos comandos SQL dentro do ambiente JAVA
    public ResultSet resultset; // Variável que armazenará o resultado da execução de um comando SQL
    
    public boolean conecta() {
        boolean result = true;
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha); //Comando para a conexão
            JOptionPane.showMessageDialog(null, "Conexão estabelecida", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch(ClassNotFoundException Driver){
            JOptionPane.showMessageDialog(null, "Driver não localizado"+Driver,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }catch(SQLException Fonte){
            JOptionPane.showMessageDialog(null, "Fonte de dados não localizada"+Fonte,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        
        return result;
    }
    
    public void desconecta() {
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null, "Conexão com o banco fechada", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException fecha){
            
        }
    }
    
    public void executaSQL(String sql){
        try{
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        }catch (SQLException excecao){
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro: "+excecao,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
