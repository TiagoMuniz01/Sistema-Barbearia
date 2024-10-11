/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Date;
import java.time.Duration;

import model.Servico;
import model.Cliente;
import model.Profissional;
import model.Pagamento;

/**
 *
 * @author Tiago e Diogo
 */
public class Teste {
    
    public static void main(String[] args){
        
       // Criando um objeto Servico com valores genéricos no construtor
        Servico servico = new Servico(0, "Serviço padrão", "Descrição padrão", 0.0f, Duration.ofMinutes(0));

        // Personalizando valores usando setters
        servico.setCod_servico(1);
        servico.setNome_servico("Corte de cabelo");
        servico.setDescricao_servico("Corte de cabelo clássico");
        servico.setPreco_servico(50.0f);
        servico.setTempo_servico(Duration.ofMinutes(30));

        // Exibindo valores personalizados
        System.out.println("\nValores personalizados do serviço:");
        System.out.println("Código do Serviço: " + servico.getCod_servico());
        System.out.println("Nome do Serviço: " + servico.getNome_servico());
        System.out.println("Descrição do Serviço: " + servico.getDescricao_servico());
        System.out.println("Preço do Serviço: R$ " + servico.getPreco_servico());
        System.out.println("Tempo do Serviço: " + servico.getTempo_servico().toMinutes() + " minutos");
        
        
        // Criando um objeto Cliente com valores genéricos no construtor
        Cliente cliente = new Cliente(0, "Cliente Padrão", "000.000.000-00", "email@exemplo.com", new Date(), "senha123", "0000-0000");

        // Exibindo valores genéricos do construtor
        System.out.println("Valores do cliente criados com o construtor:");
        System.out.println("Código do Cliente: " + cliente.getCod_cliente());
        System.out.println("Nome do Cliente: " + cliente.getNome_cliente());
        System.out.println("CPF do Cliente: " + cliente.getCpf_cliente());
        System.out.println("Email do Cliente: " + cliente.getEmail_cliente());
        System.out.println("Data de Nascimento do Cliente: " + cliente.getData_nasc());
        System.out.println("Senha do Cliente: " + cliente.getSenha_cliente());
        System.out.println("Telefone do Cliente: " + cliente.getTelefone_cliente());

        // Personalizando os valores usando os setters
        cliente.setCod_cliente(1);
        cliente.setNome_cliente("Maria Oliveira");
        cliente.setCpf_cliente("123.456.789-00");
        cliente.setEmail_cliente("maria.oliveira@exemplo.com");
        cliente.setData_nasc(new Date(90, 6, 15)); // Exemplo de data de nascimento: 15/07/1990
        cliente.setSenha_cliente("novaSenha456");
        cliente.setTelefone_cliente("(11) 98765-4321");

        // Exibindo os valores personalizados
        System.out.println("\nValores personalizados do cliente:");
        System.out.println("Código do Cliente: " + cliente.getCod_cliente());
        System.out.println("Nome do Cliente: " + cliente.getNome_cliente());
        System.out.println("CPF do Cliente: " + cliente.getCpf_cliente());
        System.out.println("Email do Cliente: " + cliente.getEmail_cliente());
        System.out.println("Data de Nascimento do Cliente: " + cliente.getData_nasc());
        System.out.println("Senha do Cliente: " + cliente.getSenha_cliente());
        System.out.println("Telefone do Cliente: " + cliente.getTelefone_cliente());
        
        
        Profissional profissional = new Profissional(0, "Profissional Padrão", "000.000.000-00", "00.000.000-0", "0000-0000", "email@exemplo.com", "Descrição padrão");

        // Exibindo valores genéricos do construtor
        System.out.println("Valores do profissional criados com o construtor:");
        System.out.println("Código do Profissional: " + profissional.getCod_profissional());
        System.out.println("Nome do Profissional: " + profissional.getNome_profissional());
        System.out.println("CPF do Profissional: " + profissional.getCpf_profissional());
        System.out.println("RG do Profissional: " + profissional.getRg_profissional());
        System.out.println("Telefone do Profissional: " + profissional.getTelefone_profissional());
        System.out.println("Email do Profissional: " + profissional.getEmail_profissional());
        System.out.println("Descrição do Profissional: " + profissional.getDesc_profissional());

        // Personalizando os valores usando os setters
        profissional.setCod_profissional(1);
        profissional.setNome_profissional("João da Silva");
        profissional.setCpf_profissional("123.456.789-00");
        profissional.setRg_profissional("12.345.678-9");
        profissional.setTelefone_profissional("(11) 98765-4321");
        profissional.setEmail_profissional("joao.silva@exemplo.com");
        profissional.setDesc_profissional("Especialista em cortes masculinos");

        // Exibindo os valores personalizados
        System.out.println("\nValores personalizados do profissional:");
        System.out.println("Código do Profissional: " + profissional.getCod_profissional());
        System.out.println("Nome do Profissional: " + profissional.getNome_profissional());
        System.out.println("CPF do Profissional: " + profissional.getCpf_profissional());
        System.out.println("RG do Profissional: " + profissional.getRg_profissional());
        System.out.println("Telefone do Profissional: " + profissional.getTelefone_profissional());
        System.out.println("Email do Profissional: " + profissional.getEmail_profissional());
        System.out.println("Descrição do Profissional: " + profissional.getDesc_profissional());
        
        
        // Criando um objeto Pagamento com valores genéricos no construtor
        Pagamento pagamento = new Pagamento(0, "Pagamento Padrão");

        // Exibindo valores genéricos do construtor
        System.out.println("Valores do pagamento criados com o construtor:");
        System.out.println("Código do Pagamento: " + pagamento.getCod_pagamento());
        System.out.println("Tipo de Pagamento: " + pagamento.getTipo_pagamento());

        // Personalizando os valores usando os setters
        pagamento.setCod_pagamento(1);
        pagamento.setTipo_pagamento("Cartão de Crédito");

        // Exibindo os valores personalizados
        System.out.println("\nValores personalizados do pagamento:");
        System.out.println("Código do Pagamento: " + pagamento.getCod_pagamento());
        System.out.println("Tipo de Pagamento: " + pagamento.getTipo_pagamento());
    }
}
