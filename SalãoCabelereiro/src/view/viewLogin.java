/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


/**
 *
 * @author Tiago e Diogo
 */
public class viewLogin extends javax.swing.JFrame {

    /**
     * Creates new form viewLogin
     */
    public viewLogin() {
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

        lbllogin = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();
        jtextusuario = new javax.swing.JTextField();
        lblusuario = new javax.swing.JLabel();
        lblbarbeleon = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();
        btentrar = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        lblfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbllogin.setBackground(new java.awt.Color(255, 255, 255));
        lbllogin.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lbllogin.setForeground(new java.awt.Color(204, 204, 204));
        lbllogin.setText("Login");
        getContentPane().add(lbllogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        lbllogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\jocimar\\Downloads\\LOGO SVG BARBELEON.png")); // NOI18N
        getContentPane().add(lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 310, 280));

        jtextusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextusuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jtextusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 210, 20));

        lblusuario.setBackground(new java.awt.Color(153, 153, 153));
        lblusuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(204, 204, 204));
        lblusuario.setText("Usuario");
        getContentPane().add(lblusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        lblbarbeleon.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        lblbarbeleon.setForeground(new java.awt.Color(44, 148, 82));
        lblbarbeleon.setText("BARBELEON");
        getContentPane().add(lblbarbeleon, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        lblsenha.setBackground(new java.awt.Color(187, 187, 187));
        lblsenha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblsenha.setForeground(new java.awt.Color(204, 204, 204));
        lblsenha.setText("Senha");
        getContentPane().add(lblsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        btentrar.setBackground(new java.awt.Color(44, 148, 82));
        btentrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btentrar.setForeground(new java.awt.Color(204, 204, 204));
        btentrar.setText("Entrar");
        btentrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btentrarActionPerformed(evt);
            }
        });
        getContentPane().add(btentrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 90, 30));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 210, -1));

        lblfundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imgBarb/imagens/fundo.jpg"))); // NOI18N
        getContentPane().add(lblfundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 788, 553));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtextusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextusuarioActionPerformed

    private void btentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btentrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btentrarActionPerformed

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
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btentrar;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jtextusuario;
    private javax.swing.JLabel lblbarbeleon;
    private javax.swing.JLabel lblfundo;
    private javax.swing.JLabel lbllogin;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JLabel lblusuario;
    // End of variables declaration//GEN-END:variables
}
