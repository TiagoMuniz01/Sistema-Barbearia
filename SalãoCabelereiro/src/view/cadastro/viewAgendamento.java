/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.cadastro;

/**
 *
 * @author Tiago e Diogo
 */
public class viewAgendamento extends javax.swing.JFrame {

    /**
     * Creates new form viewAgendamento
     */
    public viewAgendamento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtextid = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        jtextnome = new javax.swing.JTextField();
        lblnome = new javax.swing.JLabel();
        jtextcpf = new javax.swing.JTextField();
        lblcpf = new javax.swing.JLabel();
        jtexttelefone = new javax.swing.JTextField();
        lbltelefone = new javax.swing.JLabel();
        jtextemail = new javax.swing.JTextField();
        lblemail = new javax.swing.JLabel();
        lblclientes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablecliente = new javax.swing.JTable();
        lbltelefone1 = new javax.swing.JLabel();
        jtexttelefone1 = new javax.swing.JTextField();
        btnnext = new javax.swing.JButton();
        tras = new javax.swing.JButton();
        frente = new javax.swing.JButton();
        btnreturn = new javax.swing.JButton();
        btndeletar = new javax.swing.JButton();
        btnalterar = new javax.swing.JButton();
        btnagendar = new javax.swing.JButton();
        lblpainel = new javax.swing.JLabel();
        lblfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtextid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextidActionPerformed(evt);
            }
        });
        getContentPane().add(jtextid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 40, 22));

        lblid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(204, 204, 204));
        lblid.setText("Id");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        jtextnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextnomeActionPerformed(evt);
            }
        });
        getContentPane().add(jtextnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 175, 192, 22));

        lblnome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblnome.setForeground(new java.awt.Color(204, 204, 204));
        lblnome.setText("Nome");
        getContentPane().add(lblnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 175, -1, -1));

        jtextcpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextcpfActionPerformed(evt);
            }
        });
        getContentPane().add(jtextcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 192, 22));

        lblcpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblcpf.setForeground(new java.awt.Color(204, 204, 204));
        lblcpf.setText("Serviço");
        getContentPane().add(lblcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 210, -1, -1));

        jtexttelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtexttelefoneActionPerformed(evt);
            }
        });
        getContentPane().add(jtexttelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 315, 192, 22));

        lbltelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltelefone.setForeground(new java.awt.Color(204, 204, 204));
        lbltelefone.setText("Hora");
        getContentPane().add(lbltelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 315, -1, -1));

        jtextemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextemailActionPerformed(evt);
            }
        });
        getContentPane().add(jtextemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 245, 192, 22));

        lblemail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblemail.setForeground(new java.awt.Color(204, 204, 204));
        lblemail.setText("Valor");
        getContentPane().add(lblemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 245, -1, -1));

        lblclientes.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lblclientes.setForeground(new java.awt.Color(204, 204, 204));
        lblclientes.setText("Agendamento");
        getContentPane().add(lblclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        tablecliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Valor", "Duração", "Descrição"
            }
        ));
        jScrollPane2.setViewportView(tablecliente);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 670, 120));

        lbltelefone1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltelefone1.setForeground(new java.awt.Color(204, 204, 204));
        lbltelefone1.setText("Data");
        getContentPane().add(lbltelefone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 280, -1, -1));

        jtexttelefone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtexttelefone1ActionPerformed(evt);
            }
        });
        getContentPane().add(jtexttelefone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 192, 22));

        btnnext.setBackground(new java.awt.Color(44, 148, 82));
        btnnext.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnnext.setForeground(new java.awt.Color(255, 255, 255));
        btnnext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/icons/final.png"))); // NOI18N
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });
        getContentPane().add(btnnext, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 30, 30));

        tras.setBackground(new java.awt.Color(44, 148, 82));
        tras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tras.setForeground(new java.awt.Color(255, 255, 255));
        tras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/icons/anterior.png"))); // NOI18N
        tras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trasActionPerformed(evt);
            }
        });
        getContentPane().add(tras, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 30, 30));

        frente.setBackground(new java.awt.Color(44, 148, 82));
        frente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        frente.setForeground(new java.awt.Color(255, 255, 255));
        frente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/icons/proximo.png"))); // NOI18N
        frente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frenteActionPerformed(evt);
            }
        });
        getContentPane().add(frente, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 30, 30));

        btnreturn.setBackground(new java.awt.Color(44, 148, 82));
        btnreturn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnreturn.setForeground(new java.awt.Color(255, 255, 255));
        btnreturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/icons/inicio.png"))); // NOI18N
        btnreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnreturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 30, 30));

        btndeletar.setBackground(new java.awt.Color(44, 148, 82));
        btndeletar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btndeletar.setForeground(new java.awt.Color(255, 255, 255));
        btndeletar.setText("Deletar");
        btndeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btndeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 230, 30));

        btnalterar.setBackground(new java.awt.Color(44, 148, 82));
        btnalterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnalterar.setForeground(new java.awt.Color(255, 255, 255));
        btnalterar.setText("Alterar");
        btnalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnalterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 230, 30));

        btnagendar.setBackground(new java.awt.Color(44, 148, 82));
        btnagendar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnagendar.setForeground(new java.awt.Color(255, 255, 255));
        btnagendar.setText("Cadastrar");
        btnagendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagendarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 230, 30));

        lblpainel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/imagens/Painel.png"))); // NOI18N
        getContentPane().add(lblpainel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 710, 390));

        lblfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/imagens/fundo.jpg"))); // NOI18N
        getContentPane().add(lblfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 790, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtextidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextidActionPerformed

    private void jtextnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextnomeActionPerformed

    private void jtextcpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextcpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextcpfActionPerformed

    private void jtexttelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtexttelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtexttelefoneActionPerformed

    private void jtextemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextemailActionPerformed

    private void jtexttelefone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtexttelefone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtexttelefone1ActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnnextActionPerformed

    private void trasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trasActionPerformed

    private void frenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_frenteActionPerformed

    private void btnreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnreturnActionPerformed

    private void btndeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndeletarActionPerformed

    private void btnalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnalterarActionPerformed

    private void btnagendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagendarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagendarActionPerformed

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
    private javax.swing.JButton btnagendar;
    private javax.swing.JButton btnalterar;
    private javax.swing.JButton btndeletar;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnreturn;
    private javax.swing.JButton frente;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtextcpf;
    private javax.swing.JTextField jtextemail;
    private javax.swing.JTextField jtextid;
    private javax.swing.JTextField jtextnome;
    private javax.swing.JTextField jtexttelefone;
    private javax.swing.JTextField jtexttelefone1;
    private javax.swing.JLabel lblclientes;
    private javax.swing.JLabel lblcpf;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfundo;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblnome;
    private javax.swing.JLabel lblpainel;
    private javax.swing.JLabel lbltelefone;
    private javax.swing.JLabel lbltelefone1;
    private javax.swing.JTable tablecliente;
    private javax.swing.JButton tras;
    // End of variables declaration//GEN-END:variables
}
