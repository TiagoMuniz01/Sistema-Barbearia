/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.helper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import view.cadastro.viewAgendamento;

/**
 *
 * @author Tiago e Diogo
 */
public class AgendamentoHelper {
    
    private final viewAgendamento view;

    public AgendamentoHelper(viewAgendamento view) {
        this.view = view;
    }

    public void prencerTabela(ArrayList<Agendamento> agendamentos) {
    
        DefaultTableModel tabelaModelo = (DefaultTableModel) view.getTabelaAgendamento().getModel();
        tabelaModelo.setNumRows(0);

        // Percorrer a lista preenchendo a tabela model
        for (Agendamento agendamento : agendamentos) {

            tabelaModelo.addRow(new Object[]{
                agendamento.getCod_agendamento(),
                agendamento.getCliente() != null ? agendamento.getCliente().getNome() : "N/A",
                agendamento.getServico() != null ? agendamento.getServico().getNome_servico() : "N/A",
                agendamento.getPagamento() != null ? agendamento.getPagamento().getForma_pagamento() : "N/A",
                agendamento.getData_agendamento() != null ? agendamento.getDataFormatada_agendamento(): "N/A",
                agendamento.getHorario_agendamento() != null ? agendamento.getHorarioFormatado_agendamento(): "N/A"
            });
        }   
    }
  
}
