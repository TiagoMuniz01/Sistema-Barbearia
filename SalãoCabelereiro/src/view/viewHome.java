/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Tiago e Diogo
 */
public class viewHome extends javax.swing.JFrame {

    /**
     * Creates new form viewHome
     */
    public viewHome() {
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

        lblfundo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenucadastro = new javax.swing.JMenu();
        jitemprofissional = new javax.swing.JMenuItem();
        jitemcliente = new javax.swing.JMenuItem();
        jitemserviço = new javax.swing.JMenuItem();
        jitemagendamento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(17, 17, 17));
        setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/imagens/fundo.jpg"))); // NOI18N
        getContentPane().add(lblfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 730, 560));

        jmenucadastro.setText("Cadastro");

        jitemprofissional.setText("Profissional");
        jitemprofissional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jitemprofissionalActionPerformed(evt);
            }
        });
        jmenucadastro.add(jitemprofissional);

        jitemcliente.setText("Cliente");
        jitemcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jitemclienteActionPerformed(evt);
            }
        });
        jmenucadastro.add(jitemcliente);

        jitemserviço.setText("Serviço");
        jmenucadastro.add(jitemserviço);

        jitemagendamento.setText("Agendamento");
        jmenucadastro.add(jitemagendamento);

        jMenuBar1.add(jmenucadastro);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jitemprofissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jitemprofissionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jitemprofissionalActionPerformed

    private void jitemclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jitemclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jitemclienteActionPerformed

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
            java.util.logging.Logger.getLogger(viewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jitemagendamento;
    private javax.swing.JMenuItem jitemcliente;
    private javax.swing.JMenuItem jitemprofissional;
    private javax.swing.JMenuItem jitemserviço;
    private javax.swing.JMenu jmenucadastro;
    private javax.swing.JLabel lblfundo;
    // End of variables declaration//GEN-END:variables
}
