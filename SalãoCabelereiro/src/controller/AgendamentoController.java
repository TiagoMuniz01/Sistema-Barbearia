package controller;

import controller.helper.AgendamentoHelper;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Agendamento;
import model.Cliente;
import model.Pagamento;
import model.Profissional;
import model.Servico;
import view.cadastro.viewAgendamento;

public class AgendamentoController {

    private final viewAgendamento view;
    private final AgendamentoHelper helper;

    public AgendamentoController(viewAgendamento view) {
        this.view = view;
        this.helper = new AgendamentoHelper(view);
    }

    public void atualizarTabela() {

        //Buscar lista com agendaemntos no banco de dados
        Agendamento agendamento = new Agendamento();
        ArrayList<Agendamento> agendamentos = agendamento.listar();

        //Exibir esta lista na view
        helper.prencerTabela(agendamentos);

    }

    public void atualizarCliente() {

        //Buscar Clientes do banco de dados
        Cliente cliente = new Cliente();
        ArrayList<Cliente> clientes = cliente.listar();

        //Exibir clientes no Combobox Cliente
        helper.preencherClientes(clientes);
    }

    public void atualizarServico() {

        Servico servico = new Servico();
        ArrayList<Servico> servicos = servico.listar();

        helper.preencherServico(servicos);
    }

    public void atualizarPagamento() {

        Pagamento pagamento = new Pagamento();
        ArrayList<Pagamento> pagamentos = pagamento.listar();

        helper.preencherPagamento(pagamentos);
    }

    public void atualizarProfissional() {
        Profissional profissional = new Profissional();
        ArrayList<Profissional> profissionais = profissional.listar();

        helper.preencherProfissional(profissionais);

    }

    public void atualizarValor() {
        Servico servico = helper.obterServico();
        helper.setValor(servico.getPreco_servico());
    }

    public void atualizarNovoCodigo() {
        Agendamento agendamento = new Agendamento();
        int novoCodigo = agendamento.getProximoCodigo();
        helper.setCodigo(novoCodigo); // Atualiza o campo na tela
    }

    public void agendar() {
        try {
            Agendamento agendamento = helper.obterModelo();
            if (new Agendamento().inserir(agendamento)) {
                JOptionPane.showMessageDialog(view, "Agendamento salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(view, "Erro ao salvar agendamento!");
            }
            atualizarTabela();
            helper.limparTela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro: " + ex.getMessage());
        }
    }

    public void buscarAgendamentosPorNome(String nomeCliente) {
        // Busca agendamentos pelo nome do cliente no banco de dados
        Agendamento agendamento = new Agendamento();
        ArrayList<Agendamento> agendamentos = agendamento.buscarPorNomeCliente(nomeCliente);

        // Atualiza a tabela com os resultados encontrados
        helper.prencerTabela(agendamentos);
    }

    public void excluir() {

        Agendamento agendamento = new Agendamento();
        // Recupera o código do agendamento a partir do campo de texto 'TexCod'
        String codAgendamentoStr = view.getTexCod().getText().trim();

        if (codAgendamentoStr.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Selecione um agendamento para excluir.");
            return;
        }

        int codAgendamento = Integer.parseInt(codAgendamentoStr);  // Converte para inteiro

        // Confirmação da exclusão
        int confirmacao = JOptionPane.showConfirmDialog(view,
                "Você tem certeza que deseja excluir este agendamento?",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Chama o método de exclusão no model (no banco de dados)
            boolean sucesso = agendamento.excluir(codAgendamento);  // Método de exclusão no Model

            if (sucesso) {
                JOptionPane.showMessageDialog(view, "Agendamento excluído com sucesso!");
                atualizarTabela();  // Atualiza a tabela após a exclusão
            } else {
                JOptionPane.showMessageDialog(view, "Erro ao excluir agendamento. Operação de exclusão cancelada !");
            }
        }
    }

    public void atualizarAgendamento(int id, int codCliente, int codServico, int codProfissional, int codPagamento, String data, String hora) {
        // Criar objetos das FKs
        Cliente cliente = new Cliente();
        cliente.setCod(codCliente);
        cliente.carregar(); // Método no Cliente para buscar os dados no banco

        Servico servico = new Servico();
        servico.setCod_servico(codServico);
        servico.carregar(); // Método no Servico para buscar os dados no banco

        Profissional profissional = new Profissional();
        profissional.setCod(codProfissional);
        profissional.carregar(); // Método no Profissional para buscar os dados no banco

        Pagamento pagamento = new Pagamento();
        pagamento.setCod_pagamento(codPagamento);
        pagamento.carregar(); // Método no Pagamento para buscar os dados no banco

        // Ajustar os formatos de data e hora
        String dataFormatada;
        String horaFormatada;

        try {
            dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception ex) {
            System.out.println("Erro ao formatar a data: " + ex.getMessage());
            dataFormatada = data; // Valor padrão caso ocorra erro
        }

        try {
            horaFormatada = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"))
                    .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        } catch (Exception ex) {
            System.out.println("Erro ao formatar o horário: " + ex.getMessage());
            horaFormatada = hora; // Valor padrão caso ocorra erro
        }

        // Exibir os valores após a formatação para verificar
        System.out.println("Hora formatada: " + horaFormatada);
        System.out.println("Data formatada: " + dataFormatada);

        // Criar objeto Agendamento
        Agendamento agendamento = new Agendamento(
                id,
                cliente,
                profissional,
                pagamento,
                servico,
                horaFormatada,
                dataFormatada
        );

        // Atualizar o agendamento no banco
        if (agendamento.atualizar()) {
            System.out.println("Agendamento atualizado com sucesso.");
        } else {
            System.out.println("Erro ao atualizar o agendamento.");
        }
    }

}
