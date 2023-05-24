/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Objetos.Colaboradores;
import Objetos.Empresas;
import conexão.MySQL;
import javax.swing.JOptionPane;

/**
 *
 * @author cauas
 */
public class CadastroEmpresa extends javax.swing.JFrame {
    Empresas Nempresa = new Empresas();
    MySQL conectar = new MySQL();
    
    /**
     * Creates new form CadastroEmpresa
     */
    public CadastroEmpresa() {
        initComponents();
    }
    
    public void CadastrarEmpresa(Empresas Nempresa){
        this.conectar.conectaBanco();
        
        Nempresa.setNome(txtNome.getText());
        Nempresa.setRazao(txtRazao.getText());
        Nempresa.setCidade(txtCidade.getText());
        Nempresa.setCNPJ(txtCNPJ.getText());
        Nempresa.setEndereco(txtEndereco.getText());
        
        try{
            this.conectar.insertSQL("INSERT INTO Empresas ("
                    + "nome,"
                    + "razao,"
                    + "cidade,"
                    + "cnpj,"
                    + "endereco"
                  +") VALUES ("
                    + "'" + Nempresa.getNome() + "',"
                    + "'" + Nempresa.getRazao() + "',"
                    + "'" + Nempresa.getCidade() + "',"
                    + "'" + Nempresa.getCNPJ() + "',"
                    + "'" + Nempresa.getEndereco() + "'"
                + ");");
        }catch (Exception e){
            System.out.println("Erro ao cadastrar empresa" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar empresa!");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso!");
        }
            
    }
  
    public void DeletarEmpresa(Empresas Nempresa){
        this.conectar.conectaBanco();
        
        try{
            this.conectar.updateSQL("DELETE from Empresas where cnpj = '" + txtCNPJ.getText() + "';");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao deletar empresa");
        }finally{
            JOptionPane.showMessageDialog(null, "Empresa deletado com sucesso!");
            this.conectar.fechaBanco();
        }
    }
    
    public void AtualizarEmpresa(Empresas Nempresa){
        this.conectar.conectaBanco();
        
        try{
            this.conectar.updateSQL("UPDATE Empresas SET nome = '" + txtNome.getText() + "' where cnpj = '" + txtCNPJ.getText() + "';");
            this.conectar.updateSQL("UPDATE Empresas SET razao = '" + txtRazao.getText() + "' where cnpj = '" + txtCNPJ.getText() + "';");
            this.conectar.updateSQL("UPDATE Empresas SET cidade = '" + txtCidade.getText() + "' where cnpj = '" + txtCNPJ.getText() + "';");
            this.conectar.updateSQL("UPDATE Empresas SET endereco = '" + txtEndereco.getText() + "' where cnpj = '" + txtCNPJ.getText() + "';");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar empresa");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Empresa atualizada com sucesso!");
        }
    }
    
    private void BuscarEmpresa(Empresas Nempresa){
        this.conectar.conectaBanco();
                
        try{
            this.conectar.executarSQL(
                    "SELECT "
                     + "nome,"
                     + "razao,"
                     + "cidade,"
                     + "endereco"
                   + " FROM"
                        + " Empresas"
                   + " WHERE"
                        + " cnpj = '" + txtCNPJ.getText() + "'" + ";"
            );
            while(this.conectar.getResultSet() .next()){ //getresultset ta obtendo o resultado do select e o next é pegando cada linha do select
                Nempresa.setNome(this.conectar.getResultSet().getString(1));
                Nempresa.setRazao(this.conectar.getResultSet().getString(2));
                Nempresa.setCidade(this.conectar.getResultSet().getString(3));
                Nempresa.setEndereco(this.conectar.getResultSet().getString(4));
            }
            if(Nempresa.getNome() == ""){ 
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar cliente" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente");
            
        }finally{
            txtNome.setText(Nempresa.getNome());
            txtRazao.setText(Nempresa.getRazao());
            txtCidade.setText(Nempresa.getCidade());
            txtEndereco.setText(Nempresa.getEndereco());
            this.conectar.fechaBanco();
        } 
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRazao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEndereco = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de colaboradores");
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CNPJ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(390, 260, 120, 19);

        txtNome.setBackground(new java.awt.Color(255, 255, 255));
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtNome);
        txtNome.setBounds(30, 210, 180, 22);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Endereço");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 330, 120, 19);

        txtCidade.setBackground(new java.awt.Color(255, 255, 255));
        txtCidade.setForeground(new java.awt.Color(0, 0, 0));
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });
        jPanel1.add(txtCidade);
        txtCidade.setBounds(30, 280, 200, 22);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nome fantasia");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 190, 120, 19);

        txtRazao.setBackground(new java.awt.Color(255, 255, 255));
        txtRazao.setForeground(new java.awt.Color(0, 0, 0));
        txtRazao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazaoActionPerformed(evt);
            }
        });
        jPanel1.add(txtRazao);
        txtRazao.setBounds(390, 210, 200, 22);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Razão social");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(390, 190, 120, 19);

        txtCNPJ.setBackground(new java.awt.Color(255, 255, 255));
        txtCNPJ.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCNPJ);
        txtCNPJ.setBounds(390, 280, 200, 22);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cidade");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 260, 120, 19);

        txtEndereco.setBackground(new java.awt.Color(255, 255, 255));
        txtEndereco.setColumns(20);
        txtEndereco.setForeground(new java.awt.Color(0, 0, 0));
        txtEndereco.setRows(5);
        jScrollPane1.setViewportView(txtEndereco);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 350, 290, 80);

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delete.png"))); // NOI18N
        btnDelete.setText("Deletar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(80, 450, 170, 70);

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
        btnAtualizar.setBounds(370, 450, 170, 70);

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
        btnCadastrar.setBounds(80, 550, 170, 70);

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
        btnBuscar.setBounds(370, 550, 170, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cadastro.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 610, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtRazaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazaoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtRazaoActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeletarEmpresa(Nempresa);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        AtualizarEmpresa(Nempresa);
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        CadastrarEmpresa(Nempresa);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        BuscarEmpresa(Nempresa);
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
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEmpresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextArea txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRazao;
    // End of variables declaration//GEN-END:variables
}
