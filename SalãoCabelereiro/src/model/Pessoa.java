/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tiago e Diogo
 */

// O tipo de classe abstract serve para ela não conseguir ser instanciada, ela só serve para criar as classe filhas Profissional e Cliente, sendo uma boa prática bloquear sua instânciação porque não vai ser necessário nesse sistema. (O que não é necessário não deve existir)
abstract public class Pessoa { //Classe pai para as classes filho profissional e cliente
    protected int cod;  //Atributo protected serve para poder acessar os atributos na propria classe e nas classes filha
    protected String nome;
    protected String cpf;
    protected String email;
    protected String telefone;

    public Pessoa(int cod, String nome, String cpf, String email, String telefone) {
        this.cod = cod;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
    
    public Pessoa() {
    
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
