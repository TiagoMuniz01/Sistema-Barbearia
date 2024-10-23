/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.Duration;
import model.Servico;
import model.Cliente;
import model.Profissional;
import model.Pagamento;
import model.Agendamento;

/**
 *
 * @author Tiago e Diogooioioi
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
        Cliente cliente = new Cliente("16/02/2008", "123", 0, "Tiago", "439.830.508.40", "tiagopimentel.tp@gmail.com", "11 98064-1561");

        // Exibindo valores genéricos do construtor
        System.out.println("Valores do cliente criados com o construtor:");
        System.out.println("Código do Cliente: " + cliente.getCod());
        System.out.println("Nome do Cliente: " + cliente.getNome());
        System.out.println("CPF do Cliente: " + cliente.getCpf());
        System.out.println("Email do Cliente: " + cliente.getEmail());
        System.out.println("Data de Nascimento do Cliente: " + cliente.getData_nasc());
        System.out.println("Senha do Cliente: " + cliente.getSenha_cliente());
        System.out.println("Telefone do Cliente: " + cliente.getTelefone());

        // Exibindo os valores personalizados
        System.out.println("\nValores personalizados do cliente:");
        System.out.println("Código do Cliente: " + cliente.getCod());
        System.out.println("Nome do Cliente: " + cliente.getNome());
        System.out.println("CPF do Cliente: " + cliente.getCpf());
        System.out.println("Email do Cliente: " + cliente.getEmail());
        System.out.println("Data de Nascimento do Cliente: " + cliente.getData_nasc());
        System.out.println("Senha do Cliente: " + cliente.getSenha_cliente());
        System.out.println("Telefone do Cliente: " + cliente.getTelefone());
        
        
        Profissional profissional = new Profissional("123456789", "Descrição", 0, "Ericson", "1234567891011", "dahfhasdkhfksdhf@gmail.com", "11 96545-9862");
        
        // Exibindo os valores personalizados
        System.out.println("\nValores personalizados do profissional:");
        System.out.println("Código do Profissional: " + profissional.getCod());
        System.out.println("Nome do Profissional: " + profissional.getNome());
        System.out.println("CPF do Profissional: " + profissional.getCpf());
        System.out.println("RG do Profissional: " + profissional.getRg_profissional());
        System.out.println("Telefone do Profissional: " + profissional.getTelefone());
        System.out.println("Email do Profissional: " + profissional.getEmail());
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
        
        Agendamento teste_agendamento = new Agendamento(0, cliente, profissional, pagamento, 0, "12:30", "15/10/2024");
        
        // Imprimindo os valores do agendamento diretamente
        System.out.println("Código do Agendamento: " + teste_agendamento.getCod_agendamento());
        System.out.println("Cliente: " + teste_agendamento.getCliente().getNome()); // Exibindo o nome do cliente
        System.out.println("Profissional: " + teste_agendamento.getProfissional().getNome()); // Exibindo o nome do profissional
        System.out.println("Código do Serviço: " + teste_agendamento.getCod_servico());
        System.out.println("Horário do Agendamento: " + teste_agendamento.getHorario_agendamento());
        System.out.println("Data do Agendamento: " + teste_agendamento.getData_agendamento());
        System.out.println("Tipo de pagamento: " + teste_agendamento.getPagamento().getTipo_pagamento());
    }
}
