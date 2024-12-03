package controller.helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Profissional;
import view.cadastro.viewProfissional;

public class ProfissionalHelper {

    private final viewProfissional view;

    public ProfissionalHelper(viewProfissional view) {
        this.view = view;
    }

    // Obter os dados do modelo a partir dos campos da view
    public Profissional obterModelo() {
        int id = view.getTxtId().getText().isEmpty() ? 0 : Integer.parseInt(view.getTxtId().getText());
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCpf().getText();
        String rg = view.getTxtRg().getText();
        String telefone = view.getTxtTelefone().getText();
        String email = view.getTxtEmail().getText();

        return new Profissional(id, nome, cpf, email, telefone, null, rg);
    }

    // Preencher a tabela com a lista de profissionais
    public void preencherTabela(ArrayList<Profissional> profissionais) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaProfissionais().getModel();
        tableModel.setRowCount(0); // Limpar tabela

        // Adiciona os profissionais na tabela
        for (Profissional profissional : profissionais) {
            tableModel.addRow(new Object[]{
                profissional.getCod(),
                profissional.getNome(),
                profissional.getCpf(),
                profissional.getRg_profissional(),
                profissional.getTelefone_profissional(),
                profissional.getEmail()
            });
        }
    }

    public void preencherTabelaComPesquisa(ArrayList<Profissional> profissionais, String filtro) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaProfissionais().getModel();
        tableModel.setRowCount(0); // Limpa a tabela

        for (Profissional profissional : profissionais) {
            if (profissional.getNome().toLowerCase().contains(filtro.toLowerCase())
                    || profissional.getCpf().contains(filtro)) {
                tableModel.addRow(new Object[]{
                    profissional.getCod(),
                    profissional.getNome(),
                    profissional.getCpf(),
                    profissional.getRg_profissional(),
                    profissional.getTelefone_profissional(),
                    profissional.getEmail()
                });
            }
        }
    }

    // Limpar os campos da interface
    public void limparCampos() {
        view.getTxtId().setText("");
        view.getTxtNome().setText("");
        view.getTxtCpf().setText("");
        view.getTxtRg().setText("");
        view.getTxtTelefone().setText("");
        view.getTxtEmail().setText("");
    }

    // Obter o ID do profissional selecionado na tabela
    public int obterIdSelecionado() {
        int linhaSelecionada = view.getTabelaProfissionais().getSelectedRow();

        if (linhaSelecionada == -1) {
            return -1; // Nenhuma linha selecionada
        }

        return (int) view.getTabelaProfissionais().getValueAt(linhaSelecionada, 0); // Coluna 0 = ID
    }

    // Preencher os campos com os dados do profissional selecionado
    public void preencherCamposComSelecao() {
        int linhaSelecionada = view.getTabelaProfissionais().getSelectedRow();

        if (linhaSelecionada != -1) {
            // Obter dados da linha selecionada
            view.getTxtId().setText(view.getTabelaProfissionais().getValueAt(linhaSelecionada, 0).toString());
            view.getTxtNome().setText(view.getTabelaProfissionais().getValueAt(linhaSelecionada, 1).toString());
            view.getTxtCpf().setText(view.getTabelaProfissionais().getValueAt(linhaSelecionada, 2).toString());
            view.getTxtRg().setText(view.getTabelaProfissionais().getValueAt(linhaSelecionada, 3).toString());
            view.getTxtTelefone().setText(view.getTabelaProfissionais().getValueAt(linhaSelecionada, 4).toString());
            view.getTxtEmail().setText(view.getTabelaProfissionais().getValueAt(linhaSelecionada, 5).toString());
        }
    }
}
