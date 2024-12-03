/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.helper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.Cliente;
import model.Pagamento;
import model.Profissional;
import model.Servico;
import view.cadastro.viewAgendamento;

/**
 *
 * @author Tiago e Diogo
 */
public class AgendamentoHelper implements IHelper {

    private final viewAgendamento view;

    public AgendamentoHelper(viewAgendamento view) {
        this.view = view;
    }

    // Formatadores para data e hora (conversão do banco e exibição)
    private static final DateTimeFormatter TIME_FORMATTER_BANCO = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER_BANCO = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER_EXIBICAO = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER_EXIBICAO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LocalDate parseData(String dataTexto) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dataTexto, formatter);
        } catch (Exception ex) {
            System.out.println("Erro ao converter data: " + ex.getMessage());
            return null;
        }
    }

    public LocalTime parseHora(String horaTexto) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(horaTexto, formatter);
        } catch (Exception ex) {
            System.out.println("Erro ao converter hora: " + ex.getMessage());
            return null;
        }
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
                agendamento.getServico() != null ? agendamento.getServico().getPreco_servico() : "N/A",
                agendamento.getProfissional() != null ? agendamento.getProfissional().getNome() : "N/A",
                agendamento.getData_agendamento() != null ? agendamento.getDataFormatada_agendamento() : "N/A",
                agendamento.getHorario_agendamento() != null ? agendamento.getHorarioFormatado_agendamento() : "N/A",
                agendamento.getPagamento() != null ? agendamento.getPagamento().getForma_pagamento() : "N/A"
            });
        }
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        JComboBox<Cliente> comboBox = view.getCBCliente();
        comboBox.removeAllItems(); // Limpa os itens anteriores

        for (Cliente cliente : clientes) {
            comboBox.addItem(cliente); // Adiciona o objeto Cliente
        }
    }

    public void preencherServico(ArrayList<Servico> servicos) {

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCBServico().getModel();

        for (Servico servico : servicos) { //Acesso a cada um dos objetos cliente dentro da lista clientes

            comboBoxModel.addElement(servico);

        }
    }

    public void preencherPagamento(ArrayList<Pagamento> pagamentos) {

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCBPagamento().getModel();

        for (Pagamento pagamento : pagamentos) { //Acesso a cada um dos objetos cliente dentro da lista clientes

            comboBoxModel.addElement(pagamento);

        }
    }

    public void preencherProfissional(ArrayList<Profissional> profissionais) {

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCBProfissional().getModel();

        for (Profissional profissional : profissionais) { //Acesso a cada um dos objetos cliente dentro da lista clientes

            comboBoxModel.addElement(profissional);

        }
    }

    public Servico obterServico() {

        return (Servico) view.getCBServico().getSelectedItem();

    }

    public Cliente obterCliente() {

        return (Cliente) view.getCBCliente().getSelectedItem();

    }

    public Profissional obterProfissional() {

        return (Profissional) view.getCBProfissional().getSelectedItem();

    }

    public Pagamento obterPagamento() {

        return (Pagamento) view.getCBPagamento().getSelectedItem();

    }

    public void setValor(float preco_servico) {

        view.getTextValor().setText(Float.toString(preco_servico));

    }

    public void setCodigo(int codigo) {
        view.getTexCod().setText(String.valueOf(codigo)); // Atualiza o campo TexCod com o novo código
    }

    @Override
    public Agendamento obterModelo() {
        String buscaTexto = view.getTextPesquisar().getText();
        String dataTexto = view.getTextData().getText();
        String horaTexto = view.getTextHora().getText();

        LocalDate data = parseData(dataTexto);
        LocalTime hora = parseHora(horaTexto);

        if (data == null || hora == null) {
            throw new IllegalArgumentException("Data ou hora inválida!");
        }

        return new Agendamento(0, obterCliente(), obterProfissional(), obterPagamento(), obterServico(),
                hora.format(TIME_FORMATTER_BANCO), data.format(DATE_FORMATTER_BANCO));
    }
    
    

    @Override
    public void limparTela() {
        view.getTexCod().setText("");
        view.getTextData().setText("");
        view.getTextHora().setText("");
    }

}
