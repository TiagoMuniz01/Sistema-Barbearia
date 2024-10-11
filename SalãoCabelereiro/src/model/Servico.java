/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.time.Duration;

//Essa classe vai servir para modelar o objeto serviço
public class Servico { 
    //Propriedades da entidade serviço, vindos do banco de dados
    private int cod_servico;
    private String nome_servico;
    private String descricao_servico;
    private float preco_servico;
    private Duration tempo_servico;

    public Servico(int cod_servico, String nome_servico, String descricao_servico, float preco_servico, Duration tempo_servico) {
        this.cod_servico = cod_servico;
        this.nome_servico = nome_servico;
        this.descricao_servico = descricao_servico;
        this.preco_servico = preco_servico;
        this.tempo_servico = tempo_servico;
    }

    public int getCod_servico() {
        return cod_servico;
    }

    public void setCod_servico(int cod_servico) {
        this.cod_servico = cod_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public String getDescricao_servico() {
        return descricao_servico;
    }

    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }

    public float getPreco_servico() {
        return preco_servico;
    }

    public void setPreco_servico(float preco_servico) {
        this.preco_servico = preco_servico;
    }

    public Duration getTempo_servico() {
        return tempo_servico;
    }

    public void setTempo_servico(Duration tempo_servico) {
        this.tempo_servico = tempo_servico;
    }
    
    
    
}
