/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

/**
 *
 * @author Tiago e Diogo
 */
public class Profissional extends Pessoa{
  
    private String rg_profissional;
    private String desc_profissional;
    private 

    public Profissional(String rg_profissional, String desc_profissional, int cod, String nome, String cpf, String email, String telefone) {
        super(cod, nome, cpf, email, telefone);
        this.rg_profissional = rg_profissional;
        this.desc_profissional = desc_profissional;
    }

    public String getRg_profissional() {
        return rg_profissional;
    }

    public void setRg_profissional(String rg_profissional) {
        this.rg_profissional = rg_profissional;
    }

    public String getDesc_profissional() {
        return desc_profissional;
    }

    public void setDesc_profissional(String desc_profissional) {
        this.desc_profissional = desc_profissional;
    }
    
    public String inserir(){
        return s;
    } 
}
