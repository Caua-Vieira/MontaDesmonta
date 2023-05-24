/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Objetos.Usuario;
import conexão.MySQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author cauas
 */
public class TelaLogin extends javax.swing.JFrame {
    String senha;
    CadastroUsuario CadastroU = new CadastroUsuario();
    MenuInicial inicio = new MenuInicial();
    Usuario usuario = new Usuario();
    MySQL conectar = new MySQL();
    
    //private final LoginController controller;
   
    public TelaLogin() {
        initComponents();
        //controller = new LoginController(this);
    }
    
    
    public void Autenticar(Usuario usuario){
        this.conectar.conectaBanco();
        String p = new String(txtSenha.getPassword());
        
        try{
            this.conectar.executarSQL("select * from Usuario where Usuario = '" + txtUsuario.getText() + "';");
            while(this.conectar.getResultSet().next()){
                senha = (this.conectar.getResultSet().getString(3));
            }
            if (senha.equals(p)){
                JOptionPane.showMessageDialog(null, "Usuario encontrado, bem vindo " + txtUsuario.getText());
                inicio.setVisible(true);
                dispose();
            }
        } catch (Exception e){
            System.out.println("Erro ao tentar encontrar usuario!" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuario");
        }finally{
            this.conectar.fechaBanco();
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnCadastro = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nome do usuário:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(330, 250, 150, 19);

        lblSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(0, 0, 0));
        lblSenha.setText("Senha");
        jPanel1.add(lblSenha);
        lblSenha.setBounds(380, 330, 60, 19);

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtUsuario);
        txtUsuario.setBounds(300, 280, 200, 22);

        txtSenha.setBackground(new java.awt.Color(255, 255, 255));
        txtSenha.setForeground(new java.awt.Color(0, 0, 0));
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(txtSenha);
        txtSenha.setBounds(300, 360, 200, 22);

        btnCadastro.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastro.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(0, 0, 0));
        btnCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/adicionar-usuario (1).png"))); // NOI18N
        btnCadastro.setText("Não tem cadastro? Bora se cadastrar!");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastro);
        btnCadastro.setBounds(240, 470, 330, 40);

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(0, 0, 0));
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/add-friend.png"))); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntrar);
        btnEntrar.setBounds(330, 410, 140, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 793, 578);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        CadastroU.setVisible(true);
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        Autenticar(usuario);
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

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

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(JPasswordField txtSenha) {
        this.txtSenha = txtSenha;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
