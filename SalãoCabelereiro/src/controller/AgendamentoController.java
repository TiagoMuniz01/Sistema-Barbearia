package controller;

import controller.helper.AgendamentoHelper;
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

    public void atualizarCodigo() {
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

}
