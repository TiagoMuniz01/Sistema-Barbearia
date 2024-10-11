/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tiago e Diogo
 */
public class Profissional {
    private int cod_profissional;
    private String nome_profissional;
    private String cpf_profissional;
    private String rg_profissional;
    private String telefone_profissional;
    private String email_profissional;
    private String desc_profissional;

    public Profissional(int cod_profissional, String nome_profissional, String cpf_profissional, String rg_profissional, String telefone_profissional, String email_profissional, String desc_profissional) {
        this.cod_profissional = cod_profissional;
        this.nome_profissional = nome_profissional;
        this.cpf_profissional = cpf_profissional;
        this.rg_profissional = rg_profissional;
        this.telefone_profissional = telefone_profissional;
        this.email_profissional = email_profissional;
        this.desc_profissional = desc_profissional;
    }

    public int getCod_profissional() {
        return cod_profissional;
    }

    public void setCod_profissional(int cod_profissional) {
        this.cod_profissional = cod_profissional;
    }

    public String getNome_profissional() {
        return nome_profissional;
    }

    public void setNome_profissional(String nome_profissional) {
        this.nome_profissional = nome_profissional;
    }

    public String getCpf_profissional() {
        return cpf_profissional;
    }

    public void setCpf_profissional(String cpf_profissional) {
        this.cpf_profissional = cpf_profissional;
    }

    public String getRg_profissional() {
        return rg_profissional;
    }

    public void setRg_profissional(String rg_profissional) {
        this.rg_profissional = rg_profissional;
    }

    public String getTelefone_profissional() {
        return telefone_profissional;
    }

    public void setTelefone_profissional(String telefone_profissional) {
        this.telefone_profissional = telefone_profissional;
    }

    public String getEmail_profissional() {
        return email_profissional;
    }

    public void setEmail_profissional(String email_profissional) {
        this.email_profissional = email_profissional;
    }

    public String getDesc_profissional() {
        return desc_profissional;
    }

    public void setDesc_profissional(String desc_profissional) {
        this.desc_profissional = desc_profissional;
    }
    
    
}
