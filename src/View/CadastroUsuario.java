/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Objetos.Usuario;
import conexão.MySQL;
import javax.swing.JOptionPane;

/**
 *
 * @author cauas
 */
public class CadastroUsuario extends javax.swing.JFrame {
    MySQL conectar = new MySQL();
    Usuario NovoUsuario = new Usuario();
    
    public CadastroUsuario() {
        initComponents();
    }

    public void cadastraUsuario(Usuario NovoUsuario){
        this.conectar.conectaBanco();
        
        NovoUsuario.setNome(txtNome.getText());
        NovoUsuario.setSenha(txtSenha.getText());
        NovoUsuario.setCidade(txtCidade.getText());
        NovoUsuario.setEstado((String) txtEstado.getSelectedItem());
        NovoUsuario.setEndereco(txtEndereco.getText());
        
        try{
            this.conectar.insertSQL("INSERT INTO Usuario ("
                    + "usuario,"
                    + "senha,"
                    + "endereco,"
                    + "cidade,"
                    + "estado"
                  +") VALUES ("
                    + "'" + NovoUsuario.getNome() + "',"
                    + "'" + NovoUsuario.getSenha() + "',"
                    + "'" + NovoUsuario.getEndereco() + "',"
                    + "'" + NovoUsuario.getCidade() + "',"
                    + "'" + NovoUsuario.getEstado() + "'"
                + ");");
        }catch (Exception e){
            System.out.println("Erro ao cadastrar usuario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario!");
        } finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado com sucesso!");
        }
    }
    
    public void AtualizarUsuario(Usuario NovoUsuario){
        this.conectar.conectaBanco();
        
        try{
            this.conectar.updateSQL("UPDATE Usuario SET usuario = '" + txtNome.getText() + "' where senha = '" + txtSenha.getText() + "';");
            this.conectar.updateSQL("UPDATE Usuario SET endereco = '" + txtEndereco.getText() + "' where senha = '" + txtSenha.getText() + "';");
            this.conectar.updateSQL("UPDATE Usuario SET cidade = '" + txtCidade.getText() + "' where senha = '" + txtSenha.getText() + "';");
            this.conectar.updateSQL("UPDATE Usuario SET estado = '" + txtEstado.getSelectedItem()+ "' where senha = '" + txtSenha.getText() + "';");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuario");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
        }
    }
    
    public void DeletarUsuario(Usuario NovoUsuario){
        this.conectar.conectaBanco();
        
        try{
            this.conectar.updateSQL("DELETE from Usuario where usuario = '" + txtNome.getText() + "';");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao deletar colaborador");
        }finally{
            JOptionPane.showMessageDialog(null, "Colaborador deletado com sucesso!");
            this.conectar.fechaBanco();
        }
    }
    
        private void BuscarUsuario(Usuario NovoUsuario){
        this.conectar.conectaBanco();
                
        try{
            this.conectar.executarSQL(
                    "SELECT "
                     + "usuario,"
                     + "senha,"
                     + "endereco,"
                     + "cidade,"
                     + "estado"
                   + " FROM"
                        + " Usuario"
                   + " WHERE"
                        + " senha = '" + txtSenha.getText() + "'" + ";"
            );
            while(this.conectar.getResultSet() .next()){ //getresultset ta obtendo o resultado do select e o next é pegando cada linha do select
                NovoUsuario.setNome(this.conectar.getResultSet().getString(1));
                NovoUsuario.setSenha(this.conectar.getResultSet().getString(2));
                NovoUsuario.setEndereco(this.conectar.getResultSet().getString(3));
                NovoUsuario.setCidade(this.conectar.getResultSet().getString(4));
                NovoUsuario.setEstado(this.conectar.getResultSet().getString(5));
            }
            if(NovoUsuario.getNome() == ""){ 
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar usuário" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuário");
            
        }finally{
            txtNome.setText(NovoUsuario.getNome());
            txtSenha.setText(NovoUsuario.getSenha());
            txtEndereco.setText(NovoUsuario.getEndereco());
            txtCidade.setText(NovoUsuario.getCidade());
            txtEstado.setSelectedItem(NovoUsuario.getEstado());
            this.conectar.fechaBanco();
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEndereco = new javax.swing.JTextArea();
        btnCadastrar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        btnAtualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuários");
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 170, 90, 20);

        txtNome.setBackground(new java.awt.Color(255, 255, 255));
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome);
        txtNome.setBounds(50, 190, 180, 22);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Senha");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 250, 60, 19);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cidade");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(400, 170, 70, 19);

        txtCidade.setBackground(new java.awt.Color(255, 255, 255));
        txtCidade.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtCidade);
        txtCidade.setBounds(400, 190, 200, 22);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estado");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(400, 250, 70, 19);

        txtEstado.setBackground(new java.awt.Color(255, 255, 255));
        txtEstado.setForeground(new java.awt.Color(0, 0, 0));
        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF" }));
        jPanel1.add(txtEstado);
        txtEstado.setBounds(400, 270, 200, 22);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Endereço");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 320, 90, 19);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        txtEndereco.setBackground(new java.awt.Color(255, 255, 255));
        txtEndereco.setColumns(20);
        txtEndereco.setForeground(new java.awt.Color(0, 0, 0));
        txtEndereco.setRows(5);
        jScrollPane1.setViewportView(txtEndereco);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 340, 330, 86);

        btnCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mole.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrar);
        btnCadastrar.setBounds(350, 490, 120, 60);

        txtSenha.setBackground(new java.awt.Color(255, 255, 255));
        txtSenha.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtSenha);
        txtSenha.setBounds(50, 270, 180, 22);

        btnAtualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/updated.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar);
        btnAtualizar.setBounds(30, 490, 120, 60);

        btnDeletar.setBackground(new java.awt.Color(255, 255, 255));
        btnDeletar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnDeletar.setForeground(new java.awt.Color(0, 0, 0));
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeletar);
        btnDeletar.setBounds(190, 490, 120, 60);

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/binoculars.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(510, 490, 120, 60);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cadastro.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 668, 660);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastraUsuario(NovoUsuario);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        AtualizarUsuario(NovoUsuario);
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        DeletarUsuario(NovoUsuario);
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
            BuscarUsuario(NovoUsuario);
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextArea txtEndereco;
    private javax.swing.JComboBox<String> txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
