/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.LoginDao;
import model.Login;

/**
 *
 * @author Luciana_2
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public TelaLogin() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldSenha = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabelInvalido = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setForeground(new java.awt.Color(255, 204, 255));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Seja Bem - Vindo!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 20, 156, 22);

        jLabelUsuario.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        jLabelUsuario.setText("Usuário:");
        jPanel1.add(jLabelUsuario);
        jLabelUsuario.setBounds(19, 114, 49, 17);
        jPanel1.add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(78, 110, 131, 26);
        jPanel1.add(jTextFieldSenha);
        jTextFieldSenha.setBounds(78, 156, 133, 28);

        jLabelSenha.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        jLabelSenha.setText("Senha:");
        jPanel1.add(jLabelSenha);
        jLabelSenha.setBounds(19, 161, 39, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Indentifique-se por favor para entrar no sistema.");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(67, 55, 305, 17);

        jButtonEntrar.setBackground(new java.awt.Color(255, 0, 255));
        jButtonEntrar.setFont(new java.awt.Font("Imprint MT Shadow", 0, 18)); // NOI18N
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEntrar);
        jButtonEntrar.setBounds(332, 195, 104, 39);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(310, 140, 0, 0);

        jLabelInvalido.setFont(new java.awt.Font("Arial", 3, 10)); // NOI18N
        jLabelInvalido.setText("*Usuário ou senha inválido");
        jPanel1.add(jLabelInvalido);
        jLabelInvalido.setBounds(20, 210, 150, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Tela de Login do Sistema");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
         String usuario = jTextFieldUsuario.getText();
         String senha = jTextFieldSenha.getText();
        //instanciando um usuário com os dados digitados
        Login login = new Login(usuario, senha);
        //chamando o método efetuar login
        Boolean logou = LoginDao.fazerLogin(login);
        //verificando se logou
        if(logou){
            new Principal().setVisible(true);
            this.dispose();
        }else
        {
            jLabelInvalido.setVisible(true);
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLabelInvalido.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelInvalido;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
