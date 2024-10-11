/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Tiago e Diogo
 */
// Modelagem de dados do cliente
public class Cliente {
    private int cod_cliente;
    private String nome_cliente;
    private String cpf_cliente;
    private String email_cliente;
    private Date data_nasc;
    private String senha_cliente;
    private String telefone_cliente;

    public Cliente(int cod_cliente, String nome_cliente, String cpf_cliente, String email_cliente, Date data_nasc, String senha_cliente, String telefone_cliente) {
        this.cod_cliente = cod_cliente;
        this.nome_cliente = nome_cliente;
        this.cpf_cliente = cpf_cliente;
        this.email_cliente = email_cliente;
        this.data_nasc = data_nasc;
        this.senha_cliente = senha_cliente;
        this.telefone_cliente = telefone_cliente;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
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
    
}
