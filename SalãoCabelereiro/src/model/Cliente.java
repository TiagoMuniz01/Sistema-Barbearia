/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.time.LocalDate;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Cliente extends Pessoa {
    private LocalDate data_nasc;
    private String senha_cliente; 

    // Construtor com tratamento de exceção para a data
    public Cliente(String data_nasc, String senha_cliente, int cod, String nome, String cpf, String email, String telefone) {
        super(cod, nome, cpf, email, telefone); // Chamando o construtor da classe Pessoa

        try {
            // Definindo o formato esperado da data (dd/MM/yyyy)
            DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Convertendo a string data_nasc para LocalDate
            this.data_nasc = LocalDate.parse(data_nasc, formatado);

            System.out.println("Data convertida com sucesso: " + this.data_nasc);
        } catch (DateTimeParseException ex) {
            // Caso a data esteja no formato errado, captura a exceção e exibe uma mensagem de erro
            System.out.println("Erro: Data no formato inválido. Use o formato dd/MM/yyyy.");
        }

        // Atribuindo o valor à variável senha_cliente
        this.senha_cliente = senha_cliente;
    }

    // Getters e Setters

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        try {
            // Definindo o formato esperado da data (dd/MM/yyyy)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Convertendo a string para LocalDate
            this.data_nasc = LocalDate.parse(data_nasc, formatter);

            System.out.println("Data convertida com sucesso: " + this.data_nasc);
        } catch (DateTimeParseException ex) {
            // Caso a data esteja no formato errado, captura a exceção e exibe uma mensagem de erro
            System.out.println("Erro: Data no formato inválido. Use o formato dd/MM/yyyy.");
        }
    }

    public String getSenha_cliente() {
        return senha_cliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senha_cliente = senha_cliente;
    }
    
}
