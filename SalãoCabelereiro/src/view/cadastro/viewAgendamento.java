/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.cadastro;

import controller.AgendamentoController;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import model.Cliente;
import model.Pagamento;
import model.Profissional;
import model.Servico;

/**
 *
 * @author Tiago e Diogo
 */
public class viewAgendamento extends javax.swing.JFrame {

    private final AgendamentoController controller;
    MaskFormatter mfData;
    MaskFormatter mfHora;

    public viewAgendamento() {

        //Tratamento de erro para erro na criação da Mascará
        try {
            mfData = new MaskFormatter("##/##/####");

        } catch (ParseException ex) {
            Logger.getLogger(viewAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Tratamento de erro para erro na criação da Mascará
        try {
            mfHora = new MaskFormatter("##:##");

        } catch (ParseException ex) {
            Logger.getLogger(viewAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        this.setLocationRelativeTo(null);
        controller = new AgendamentoController(this);
        inciar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextValor = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        lblnome = new javax.swing.JLabel();
        lblcpf = new javax.swing.JLabel();
        lbltelefone = new javax.swing.JLabel();
        lblProfissional = new javax.swing.JLabel();
        lblclientes = new javax.swing.JLabel();
        lblemail1 = new javax.swing.JLabel();
        lbltelefone2 = new javax.swing.JLabel();
        lbltelefone3 = new javax.swing.JLabel();
        TextPesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAgendamento = new javax.swing.JTable();
        CBCliente = new javax.swing.JComboBox<>();
        CBServico = new javax.swing.JComboBox<>();
        CBProfissional = new javax.swing.JComboBox<>();
        CBPagamento = new javax.swing.JComboBox<>();
        lbltelefone1 = new javax.swing.JLabel();
        BtnUltimo = new javax.swing.JButton();
        BtnAnterior = new javax.swing.JButton();
        BtnProximo = new javax.swing.JButton();
        BtnPrimeiro = new javax.swing.JButton();
        BtnDeletar = new javax.swing.JButton();
        BtnAlterar = new javax.swing.JButton();
        BtnCadastrar = new javax.swing.JButton();
        TexCod = new javax.swing.JTextField();
        TextHora = new javax.swing.JFormattedTextField(mfHora);
        TextData = new javax.swing.JFormattedTextField(mfData);
        lblpainel = new javax.swing.JLabel();
        lblfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextValor.setEditable(false);
        TextValor.setEnabled(false);
        TextValor.setFocusable(false);
        getContentPane().add(TextValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 130, 30));

        lblid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(204, 204, 204));
        lblid.setText("Cod");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 30, 20));

        lblnome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblnome.setForeground(new java.awt.Color(204, 204, 204));
        lblnome.setText("Cliente");
        getContentPane().add(lblnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 50, 30));

        lblcpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcpf.setForeground(new java.awt.Color(204, 204, 204));
        lblcpf.setText("Serviço");
        getContentPane().add(lblcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 60, 30));

        lbltelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltelefone.setForeground(new java.awt.Color(204, 204, 204));
        lbltelefone.setText("Valor");
        getContentPane().add(lbltelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 10));

        lblProfissional.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProfissional.setForeground(new java.awt.Color(204, 204, 204));
        lblProfissional.setText("Profissional");
        getContentPane().add(lblProfissional, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 30));

        lblclientes.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lblclientes.setForeground(new java.awt.Color(204, 204, 204));
        lblclientes.setText("Agendamento");
        getContentPane().add(lblclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        lblemail1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblemail1.setForeground(new java.awt.Color(204, 204, 204));
        lblemail1.setText("Pagamento");
        getContentPane().add(lblemail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 80, 30));

        lbltelefone2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltelefone2.setForeground(new java.awt.Color(204, 204, 204));
        lbltelefone2.setText("Pesquisar Agendamento:");
        getContentPane().add(lbltelefone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 30));

        lbltelefone3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltelefone3.setForeground(new java.awt.Color(204, 204, 204));
        lbltelefone3.setText("Hora");
        getContentPane().add(lbltelefone3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, 10));

        TextPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextPesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(TextPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 300, 30));

        tabelaAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Serviço", "Valor", "Profissional", "Data", "Hora", "Pagamento"
            }
        ));
        tabelaAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAgendamentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaAgendamento);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 700, 120));

        getContentPane().add(CBCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 190, 30));

        CBServico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBServicoItemStateChanged(evt);
            }
        });
        getContentPane().add(CBServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 190, 30));

        getContentPane().add(CBProfissional, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 190, 30));

        getContentPane().add(CBPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 190, 30));

        lbltelefone1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltelefone1.setForeground(new java.awt.Color(204, 204, 204));
        lbltelefone1.setText("Data");
        getContentPane().add(lbltelefone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, 10));

        BtnUltimo.setBackground(new java.awt.Color(44, 148, 82));
        BtnUltimo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnUltimo.setForeground(new java.awt.Color(255, 255, 255));
        BtnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/icons/final.png"))); // NOI18N
        BtnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUltimoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 30, 30));

        BtnAnterior.setBackground(new java.awt.Color(44, 148, 82));
        BtnAnterior.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        BtnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/icons/anterior.png"))); // NOI18N
        BtnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 30, 30));

        BtnProximo.setBackground(new java.awt.Color(44, 148, 82));
        BtnProximo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnProximo.setForeground(new java.awt.Color(255, 255, 255));
        BtnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/icons/proximo.png"))); // NOI18N
        BtnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProximoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnProximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 30, 30));

        BtnPrimeiro.setBackground(new java.awt.Color(44, 148, 82));
        BtnPrimeiro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnPrimeiro.setForeground(new java.awt.Color(255, 255, 255));
        BtnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/icons/inicio.png"))); // NOI18N
        BtnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrimeiroActionPerformed(evt);
            }
        });
        getContentPane().add(BtnPrimeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 30, 30));

        BtnDeletar.setBackground(new java.awt.Color(44, 148, 82));
        BtnDeletar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnDeletar.setForeground(new java.awt.Color(255, 255, 255));
        BtnDeletar.setText("Deletar");
        BtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 90, 30));

        BtnAlterar.setBackground(new java.awt.Color(44, 148, 82));
        BtnAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAlterar.setText("Alterar");
        BtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 90, 30));

        BtnCadastrar.setBackground(new java.awt.Color(44, 148, 82));
        BtnCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BtnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        BtnCadastrar.setText("Agendar");
        BtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastrar(evt);
            }
        });
        getContentPane().add(BtnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 190, 40));

        TexCod.setEditable(false);
        TexCod.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TexCod.setEnabled(false);
        TexCod.setFocusable(false);
        getContentPane().add(TexCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 40, 22));
        getContentPane().add(TextHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 130, 30));
        getContentPane().add(TextData, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 130, 30));

        lblpainel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/imagens/Painel.png"))); // NOI18N
        getContentPane().add(lblpainel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 740, 410));

        lblfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/imagens/fundo.jpg"))); // NOI18N
        getContentPane().add(lblfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 790, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUltimoActionPerformed
        int lastRow = tabelaAgendamento.getRowCount() - 1;
        if (lastRow >= 0) {
            tabelaAgendamento.setRowSelectionInterval(lastRow, lastRow);
            carregarRegistro(); // Reutiliza o método para carregar os dados
        }
    }//GEN-LAST:event_BtnUltimoActionPerformed

    private void BtnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrimeiroActionPerformed
        tabelaAgendamento.setRowSelectionInterval(0, 0);
        carregarRegistro(); // Reutiliza o método para carregar os dados
    }//GEN-LAST:event_BtnPrimeiroActionPerformed

    private void BtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletarActionPerformed
        this.controller.excluir();  // Chama o método de exclusão do controller
    }//GEN-LAST:event_BtnDeletarActionPerformed

    private void BtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente atualizar o registro?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Obtém o código do agendamento
                int id = Integer.parseInt(TexCod.getText());

                // Obtém o cliente selecionado e seu código
                Cliente cliente = (Cliente) CBCliente.getSelectedItem();
                int codCliente = cliente.getCod(); // Método para obter o código do cliente

                // Obtém o serviço selecionado e seu código
                Servico servico = (Servico) CBServico.getSelectedItem();
                int codServico = servico.getCod_servico(); // Método para obter o código do serviço

                // Obtém o profissional selecionado e seu código
                Profissional profissional = (Profissional) CBProfissional.getSelectedItem();
                int codProfissional = profissional.getCod(); // Método para obter o código do profissional

                // Obtém o pagamento selecionado e seu código
                Pagamento pagamento = (Pagamento) CBPagamento.getSelectedItem();
                int codPagamento = pagamento.getCod_pagamento(); // Método para obter o código do pagamento

                // Obtém a data e a hora
                String data = TextData.getText();
                String hora = TextHora.getText();

                // Chama o método do controller para atualizar o agendamento
                controller.atualizarAgendamento(id, codCliente, codServico, codProfissional, codPagamento, data, hora);

                // Atualiza a tabela e exibe mensagem de sucesso
                controller.atualizarTabela();
                JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso!");

            } catch (Exception e) {
                // Trata exceções e exibe mensagem de erro
                JOptionPane.showMessageDialog(this, "Erro ao atualizar o registro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_BtnAlterarActionPerformed

    private void BtnCadastrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrar
        this.controller.agendar();
    }//GEN-LAST:event_BtnCadastrar

    private void CBServicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBServicoItemStateChanged

        this.controller.atualizarValor();

    }//GEN-LAST:event_CBServicoItemStateChanged

    private void TextPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextPesquisarKeyReleased
        // Captura o texto digitado pelo usuário
        String nomeCliente = TextPesquisar.getText().trim();

        // Atualiza a tabela na view chamando o método do controller
        if (!nomeCliente.isEmpty()) {
            controller.buscarAgendamentosPorNome(nomeCliente); // Busca os registros correspondentes
        } else {
            controller.atualizarTabela(); // Se o campo estiver vazio, carrega todos os registros
        }
    }//GEN-LAST:event_TextPesquisarKeyReleased

    private void tabelaAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAgendamentoMouseClicked
        carregarRegistro();
    }//GEN-LAST:event_tabelaAgendamentoMouseClicked

    private void BtnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProximoActionPerformed
        int selectedRow = tabelaAgendamento.getSelectedRow(); // Obtém a linha selecionada atualmente
        int totalRows = tabelaAgendamento.getRowCount(); // Número total de linhas na tabela

        if (selectedRow < totalRows - 1) { // Verifica se há uma próxima linha
            tabelaAgendamento.setRowSelectionInterval(selectedRow + 1, selectedRow + 1); // Move a seleção para a próxima linha
            carregarRegistro(); // Reutiliza o método para carregar os dados nos campos
        }
    }//GEN-LAST:event_BtnProximoActionPerformed

    private void BtnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnteriorActionPerformed
        int selectedRow = tabelaAgendamento.getSelectedRow(); // Obtém a linha selecionada atualmente

        if (selectedRow > 0) { // Verifica se há uma linha anterior
            tabelaAgendamento.setRowSelectionInterval(selectedRow - 1, selectedRow - 1); // Move a seleção para a linha anterior
            carregarRegistro(); // Reutiliza o método para carregar os dados nos campos
        }
    }//GEN-LAST:event_BtnAnteriorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlterar;
    private javax.swing.JButton BtnAnterior;
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.JButton BtnDeletar;
    private javax.swing.JButton BtnPrimeiro;
    private javax.swing.JButton BtnProximo;
    private javax.swing.JButton BtnUltimo;
    private javax.swing.JComboBox<Cliente> CBCliente;
    private javax.swing.JComboBox<Pagamento> CBPagamento;
    private javax.swing.JComboBox<Profissional> CBProfissional;
    private javax.swing.JComboBox<Servico> CBServico;
    private javax.swing.JTextField TexCod;
    private javax.swing.JFormattedTextField TextData;
    private javax.swing.JFormattedTextField TextHora;
    private javax.swing.JTextField TextPesquisar;
    private javax.swing.JTextField TextValor;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblProfissional;
    private javax.swing.JLabel lblclientes;
    private javax.swing.JLabel lblcpf;
    private javax.swing.JLabel lblemail1;
    private javax.swing.JLabel lblfundo;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblnome;
    private javax.swing.JLabel lblpainel;
    private javax.swing.JLabel lbltelefone;
    private javax.swing.JLabel lbltelefone1;
    private javax.swing.JLabel lbltelefone2;
    private javax.swing.JLabel lbltelefone3;
    private javax.swing.JTable tabelaAgendamento;
    // End of variables declaration//GEN-END:variables

    private void inciar() {
        this.controller.atualizarTabela();
        this.controller.atualizarCliente();
        this.controller.atualizarServico();
        this.controller.atualizarPagamento();
        this.controller.atualizarProfissional();
        this.controller.atualizarValor();
        this.controller.atualizarNovoCodigo();
    }

    private void carregarRegistro() {
        int selectedRow = tabelaAgendamento.getSelectedRow();
        if (selectedRow >= 0) {
            // Preenche os campos de texto diretamente
            TexCod.setText(tabelaAgendamento.getValueAt(selectedRow, 0).toString());
            TextValor.setText(tabelaAgendamento.getValueAt(selectedRow, 3).toString());
            TextData.setText(tabelaAgendamento.getValueAt(selectedRow, 5).toString());
            TextHora.setText(tabelaAgendamento.getValueAt(selectedRow, 6).toString());

            // Obter os valores das colunas da tabela
            String clienteNome = tabelaAgendamento.getValueAt(selectedRow, 1).toString();
            String servicoNome = tabelaAgendamento.getValueAt(selectedRow, 2).toString();
            String profissionalNome = tabelaAgendamento.getValueAt(selectedRow, 4).toString();
            String pagamentoTipo = tabelaAgendamento.getValueAt(selectedRow, 7).toString();

            // Definir os valores nos ComboBoxes
            setComboBoxSelection(CBCliente, clienteNome);
            setComboBoxSelection(CBServico, servicoNome);
            setComboBoxSelection(CBProfissional, profissionalNome);
            setComboBoxSelection(CBPagamento, pagamentoTipo);
        }
    }

// Método genérico para selecionar um item em um JComboBox baseado no nome/descrição
    private <T> void setComboBoxSelection(javax.swing.JComboBox<T> comboBox, String value) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            T item = comboBox.getItemAt(i);
            // Supondo que o método toString dos objetos retorne a descrição/nome esperados
            if (item != null && item.toString().equals(value)) {
                comboBox.setSelectedItem(item);
                return;
            }
        }
        // Caso não encontre correspondência, nenhuma seleção será feita
        System.out.println("Item não encontrado no ComboBox: " + value);
    }

    public JTable getTabelaAgendamento() {
        return tabelaAgendamento;
    }

    public void setTabelaAgendamento(JTable tabelaAgendamento) {
        this.tabelaAgendamento = tabelaAgendamento;
    }

    // Getter e Setter para CBCliente
    public JComboBox<Cliente> getCBCliente() {
        return CBCliente;
    }

    public void setCBCliente(JComboBox<Cliente> CBCliente) {
        this.CBCliente = CBCliente;
    }

    // Getter e Setter para CBPagamento
    public JComboBox<Pagamento> getCBPagamento() {
        return CBPagamento;
    }

    public void setCBPagamento(JComboBox<Pagamento> CBPagamento) {
        this.CBPagamento = CBPagamento;
    }

// Getter e Setter para CBServico
    public JComboBox<Servico> getCBServico() {
        return CBServico;
    }

    public void setCBServico(JComboBox<Servico> CBServico) {
        this.CBServico = CBServico;
    }

// Getter e Setter para CBProfissional
    public JComboBox<Profissional> getCBProfissional() {
        return CBProfissional;
    }

    public void setCBProfissional(JComboBox<Profissional> CBProfissional) {
        this.CBProfissional = CBProfissional;
    }

    public JTextField getTextValor() {
        return TextValor;
    }

    public void setTextValor(JTextField TextValor) {
        this.TextValor = TextValor;
    }

    public JTextField getTexCod() {
        return TexCod;
    }

    public void setTextCod(int codigo) {
        this.TexCod.setText(String.valueOf(codigo));
    }

    public JFormattedTextField getTextData() {
        return TextData;
    }

    public void setTextData(JFormattedTextField TextData) {
        this.TextData = TextData;
    }

    public JFormattedTextField getTextHora() {
        return TextHora;
    }

    public void setTextHora(JFormattedTextField TextHora) {
        this.TextHora = TextHora;
    }

    public JTextField getTextPesquisar() {
        return TextPesquisar;
    }

    public void setTextPesquisar(JTextField TextPesquisar) {
        this.TextPesquisar = TextPesquisar;
    }
}
