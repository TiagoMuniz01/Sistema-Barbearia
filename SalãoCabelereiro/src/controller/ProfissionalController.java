package controller;

import controller.helper.ProfissionalHelper;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Profissional;
import view.cadastro.viewProfissional;

public class ProfissionalController {

    private final viewProfissional view;
    private final ProfissionalHelper helper;

    public ProfissionalController(viewProfissional view) {
        this.view = view;
        this.helper = new ProfissionalHelper(view);
    }

    // Método para listar profissionais na tabela
    public void atualizarTabela() {
        Profissional profissionalModel = new Profissional();
        ArrayList<Profissional> profissionais = profissionalModel.listar(); // Lista os profissionais do banco
        helper.preencherTabela(profissionais); // Exibe os profissionais na tabela
    }

    public void carregarProfissionais() {
        Profissional profissional = new Profissional();
        ArrayList<Profissional> profissionais = profissional.listar(); // Busca do banco
        helper.preencherTabela(profissionais); // Popula a tabela
    }

    public void pesquisarProfissional(String filtro) {
        Profissional profissional = new Profissional();
        ArrayList<Profissional> profissionais = profissional.listar(); // Lista completa
        helper.preencherTabelaComPesquisa(profissionais, filtro); // Filtra e exibe
    }
    
    public void carregarRegistro() {
        helper.preencherCamposComSelecao();
    }

    public void selecionarPrimeiro() {
        if (view.getTabelaProfissionais().getRowCount() > 0) {
            view.getTabelaProfissionais().setRowSelectionInterval(0, 0);
            helper.preencherCamposComSelecao();
        }
    }

    public void selecionarUltimo() {
        int totalLinhas = view.getTabelaProfissionais().getRowCount();
        if (totalLinhas > 0) {
            view.getTabelaProfissionais().setRowSelectionInterval(totalLinhas - 1, totalLinhas - 1);
            helper.preencherCamposComSelecao();
        }
    }

    public void selecionarProximo() {
        int linhaAtual = view.getTabelaProfissionais().getSelectedRow();
        int totalLinhas = view.getTabelaProfissionais().getRowCount();

        if (linhaAtual < totalLinhas - 1) {
            view.getTabelaProfissionais().setRowSelectionInterval(linhaAtual + 1, linhaAtual + 1);
            helper.preencherCamposComSelecao();
        }
    }

    public void selecionarAnterior() {
        int linhaAtual = view.getTabelaProfissionais().getSelectedRow();

        if (linhaAtual > 0) {
            view.getTabelaProfissionais().setRowSelectionInterval(linhaAtual - 1, linhaAtual - 1);
            helper.preencherCamposComSelecao();
        }
    }

    // Método para cadastrar um novo profissional
    public void cadastrarProfissional() {
        try {
            // Obter os dados da view
            Profissional profissional = helper.obterModelo();

            // Inserir no banco de dados
            boolean sucesso = profissional.inserir();

            if (sucesso) {
                JOptionPane.showMessageDialog(view, "Profissional cadastrado com sucesso!");
                atualizarTabela(); // Atualizar a tabela após o cadastro
                helper.limparCampos(); // Limpar os campos de entrada na view
            } else {
                JOptionPane.showMessageDialog(view, "Erro ao cadastrar profissional!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }

    // Método para atualizar um profissional
    public void atualizarProfissional() {
        try {
            // Obter os dados da view
            Profissional profissional = helper.obterModelo();

            // Atualizar no banco de dados
            boolean sucesso = profissional.atualizar();

            if (sucesso) {
                JOptionPane.showMessageDialog(view, "Profissional atualizado com sucesso!");
                atualizarTabela(); // Atualizar a tabela após a atualização
                helper.limparCampos();
            } else {
                JOptionPane.showMessageDialog(view, "Erro ao atualizar profissional!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }

    // Método para deletar um profissional
    public void deletarProfissional() {
        try {
            // Obter o ID do profissional selecionado
            int id = helper.obterIdSelecionado();

            if (id == -1) {
                JOptionPane.showMessageDialog(view, "Selecione um profissional para deletar!");
                return;
            }

            // Confirmar exclusão
            int confirmacao = JOptionPane.showConfirmDialog(view, "Deseja realmente excluir o profissional?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                Profissional profissional = new Profissional();
                boolean sucesso = profissional.excluir(id);

                if (sucesso) {
                    JOptionPane.showMessageDialog(view, "Profissional deletado com sucesso!");
                    atualizarTabela(); // Atualizar a tabela após a exclusão
                } else {
                    JOptionPane.showMessageDialog(view, "Erro ao deletar profissional!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage());
        }
    }
}
