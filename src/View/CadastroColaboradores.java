/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Objetos.Colaboradores;
import conexão.MySQL;
import javax.swing.JOptionPane;

/**
 *
 * @author cauas
 */
public class CadastroColaboradores extends javax.swing.JFrame {
    Colaboradores Ncolaborador = new Colaboradores();
    MySQL conectar = new MySQL();
    public CadastroColaboradores() {
        initComponents();
    }
    
    public void CadastrarColaborador(Colaboradores Ncolaborador){
        this.conectar.conectaBanco();
        
        Ncolaborador.setNome(txtNome.getText());
        Ncolaborador.setIdade(txtIdade.getText());
        Ncolaborador.setEndereco(txtEndereco.getText());
        Ncolaborador.setCidade(txtCidade.getText());
        Ncolaborador.setEstado((String) txtEstado.getSelectedItem());
        Ncolaborador.setTipo(txtTipo.getText());
        
        try{
            this.conectar.insertSQL("INSERT INTO Colaboradores ("
                    + "nome,"
                    + "idade,"
                    + "endereco,"
                    + "cidade,"
                    + "estado,"
                    + "tipo_montagem"
                  +") VALUES ("
                    + "'" + Ncolaborador.getNome() + "',"
                    + "'" + Ncolaborador.getIdade() + "',"
                    + "'" + Ncolaborador.getEndereco() + "',"
                    + "'" + Ncolaborador.getCidade() + "',"
                    + "'" + Ncolaborador.getEstado() + "',"
                    + "'" + Ncolaborador.getTipo() + "'"
                + ");");
        }catch (Exception e){
            System.out.println("Erro ao cadastrar colaborador" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar colaborador!");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Colaborador Cadastrado com sucesso!");
        }
            
    }
    
    public void AtualizarColaborador(Colaboradores Ncolaborador){
        this.conectar.conectaBanco();
        
        try{
            this.conectar.updateSQL("UPDATE Colaboradores SET idade = '" + txtIdade.getText() + "' where nome = '" + txtNome.getText() + "';");
            this.conectar.updateSQL("UPDATE Colaboradores SET endereco = '" + txtEndereco.getText() + "' where nome = '" + txtNome.getText() + "';");
            this.conectar.updateSQL("UPDATE Colaboradores SET cidade = '" + txtCidade.getText() + "' where nome = '" + txtNome.getText() + "';");
            this.conectar.updateSQL("UPDATE Colaboradores SET estado = '" + txtEstado.getSelectedItem()+ "' where nome = '" + txtNome.getText() + "';");
            this.conectar.updateSQL("UPDATE Colaboradores SET tipo_montagem = '" + txtTipo.getText() + "' where nome = '" + txtNome.getText() + "';");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar colaborador");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Colaborador atualizado com sucesso!");
        }
    }
    
        private void BuscarColaborador(Colaboradores Ncolaborador){
        this.conectar.conectaBanco();
                
        try{
            this.conectar.executarSQL(
                    "SELECT "
                     + "nome,"
                     + "idade,"
                     + "endereco,"
                     + "cidade,"
                     + "estado,"
                     + "tipo_montagem"
                   + " FROM"
                        + " Colaboradores"
                   + " WHERE"
                        + " nome = '" + txtNome.getText() + "'" + ";"
            );
            while(this.conectar.getResultSet() .next()){ //getresultset ta obtendo o resultado do select e o next é pegando cada linha do select
                Ncolaborador.setNome(this.conectar.getResultSet().getString(1));
                Ncolaborador.setIdade(this.conectar.getResultSet().getString(2));
                Ncolaborador.setEndereco(this.conectar.getResultSet().getString(3));
                Ncolaborador.setCidade(this.conectar.getResultSet().getString(4));
                Ncolaborador.setEstado(this.conectar.getResultSet().getString(5));
                Ncolaborador.setTipo(this.conectar.getResultSet().getString(6));
            }
            if(Ncolaborador.getNome() == ""){ 
                JOptionPane.showMessageDialog(null, "Colaborador não encontrado!");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar colaborador" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar colaborador");
            
        }finally{
            txtNome.setText(Ncolaborador.getNome());
            txtIdade.setText(Ncolaborador.getIdade());
            txtEndereco.setText(Ncolaborador.getEndereco());
            txtCidade.setText(Ncolaborador.getCidade());
            txtEstado.setSelectedItem(Ncolaborador.getEstado());
            txtTipo.setText(Ncolaborador.getTipo());
            this.conectar.fechaBanco();
        } 
    }
    
    public void DeletarColaborador(Colaboradores Ncolaborador){
        this.conectar.conectaBanco();
        
        try{
            this.conectar.updateSQL("DELETE from Colaboradores where nome = '" + txtNome.getText() + "';");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao deletar colaborador");
        }finally{
            JOptionPane.showMessageDialog(null, "Colaborador deletado com sucesso!");
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
        txtTipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEndereco = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        btnCadastrar1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de colaboradores");
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Especialidade de montagem");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(410, 370, 210, 20);

        txtNome.setBackground(new java.awt.Color(255, 255, 255));
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtNome);
        txtNome.setBounds(30, 220, 190, 22);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nome");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 190, 60, 19);

        txtTipo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipo.setForeground(new java.awt.Color(0, 0, 0));
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipo);
        txtTipo.setBounds(410, 400, 220, 22);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Idade");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 280, 60, 19);

        txtCidade.setBackground(new java.awt.Color(255, 255, 255));
        txtCidade.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtCidade);
        txtCidade.setBounds(410, 220, 220, 22);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cidade");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(410, 190, 60, 20);

        txtEstado.setBackground(new java.awt.Color(255, 255, 255));
        txtEstado.setForeground(new java.awt.Color(0, 0, 0));
        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF" }));
        jPanel1.add(txtEstado);
        txtEstado.setBounds(410, 310, 220, 22);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Endereço");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 370, 90, 19);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        txtEndereco.setBackground(new java.awt.Color(255, 255, 255));
        txtEndereco.setColumns(20);
        txtEndereco.setForeground(new java.awt.Color(0, 0, 0));
        txtEndereco.setRows(5);
        jScrollPane1.setViewportView(txtEndereco);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 400, 300, 86);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Estado");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(410, 280, 60, 20);

        txtIdade.setBackground(new java.awt.Color(255, 255, 255));
        txtIdade.setForeground(new java.awt.Color(0, 0, 0));
        txtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdade);
        txtIdade.setBounds(30, 310, 190, 22);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ex: móveis empresariais, industriais, etc...");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(410, 430, 230, 20);

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
        btnAtualizar.setBounds(180, 520, 130, 70);

        btnCadastrar1.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrar1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnCadastrar1.setForeground(new java.awt.Color(0, 0, 0));
        btnCadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mole.png"))); // NOI18N
        btnCadastrar1.setText("Cadastrar");
        btnCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrar1);
        btnCadastrar1.setBounds(510, 520, 130, 70);

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
        btnDelete.setBounds(20, 520, 130, 70);

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
        btnBuscar.setBounds(340, 520, 130, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cadastro.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 670, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        AtualizarColaborador(Ncolaborador);
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrar1ActionPerformed
        CadastrarColaborador(Ncolaborador);
    }//GEN-LAST:event_btnCadastrar1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeletarColaborador(Ncolaborador);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        BuscarColaborador(Ncolaborador);
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
            java.util.logging.Logger.getLogger(CadastroColaboradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroColaboradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroColaboradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroColaboradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroColaboradores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextArea txtEndereco;
    private javax.swing.JComboBox<String> txtEstado;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
