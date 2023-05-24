/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Objetos.Alocacao;
import conexão.MySQL;
import javax.swing.JOptionPane;

/**
 *
 * @author cauas
 */
public class CadastroAlocacao extends javax.swing.JFrame {
       MySQL conectar = new MySQL();
       Alocacao alocar = new Alocacao();
       /**
     * Creates new form Alocacao
     */
    public CadastroAlocacao() {
        initComponents();
        buscarColaborador();
        buscarEmpresa();
    }
    
        private void buscarColaborador(){
        this.conectar.conectaBanco();
        
        
        try{
            this.conectar.executarSQL(
                    "SELECT nome, tipo_montagem from Colaboradores;"
            );
            while(this.conectar.getResultSet() .next()){ //getresultset ta obtendo o resultado do select e o next é pegando cada linha do select
                cbxServico.addItem(this.conectar.getResultSet().getString(1));
                cbxTipo.addItem(this.conectar.getResultSet().getString(2));

            }
            
        } catch (Exception e) {
            System.out.println("Erro ao preencher combobox colaborador" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao preencher combobox colaborador");
            
        }finally{
            this.conectar.fechaBanco();
        } 
    }
        
  
        private void buscarEmpresa(){
        this.conectar.conectaBanco();
        
        
        try{
            this.conectar.executarSQL(
                    "SELECT nome from Empresas;"
            );
            while(this.conectar.getResultSet() .next()){ //getresultset ta obtendo o resultado do select e o next é pegando cada linha do select
                cbxEmpresa1.addItem(this.conectar.getResultSet().getString(1));
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao preencher combobox empresa" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar empresa");
            
        }finally{
            this.conectar.fechaBanco();
        } 
    }
        
    public void CadastrarAlocacao(Alocacao alocar){
        this.conectar.conectaBanco();
        
        alocar.setEmpresa(cbxEmpresa1.getSelectedItem().toString());
        alocar.setPrestador(cbxServico.getSelectedItem().toString());
        alocar.setHoras(txtHoras.getText());
        alocar.setTipo(cbxTipo.getSelectedItem().toString());
        alocar.setDescricao(txtDesejado.getText());
        
        try{
            this.conectar.insertSQL("INSERT INTO Alocacao ("
                    + "empresa,"
                    + "prestador,"
                    + "horas,"
                    + "tipo,"
                    + "desejo"
                  +") VALUES ("
                    + "'" + alocar.getEmpresa() + "',"
                    + "'" + alocar.getPrestador() + "',"
                    + "'" + alocar.getHoras() + "',"
                    + "'" + alocar.getTipo() + "',"
                    + "'" + alocar.getDescricao() + "'"
                + ");");
        }catch (Exception e){
            System.out.println("Erro ao cadastrar Alocação" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Alocação!");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Alocação cadastrada com sucesso!");
        }      
    }
    
    public void DeletarAlocacao(Alocacao alocar){
        this.conectar.conectaBanco();
        
        try{
            this.conectar.updateSQL("DELETE from Alocacao where empresa = '" + cbxEmpresa1.getSelectedItem() + "';");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao deletar Alocação");
        }finally{
            JOptionPane.showMessageDialog(null, "Alocação deletada com sucesso!");
            this.conectar.fechaBanco();
        }
    }
        
    
    private void BuscarAlocacao(Alocacao alocar){
        this.conectar.conectaBanco();
                
        try{
            this.conectar.executarSQL(
                    "SELECT "
                     + "empresa,"
                     + "prestador,"
                     + "horas,"
                     + "tipo,"
                     + "desejo"
                   + " FROM"
                        + " Alocacao"
                   + " WHERE"
                        + " prestador = '" + cbxServico.getSelectedItem() + "'" + ";"
            );
            while(this.conectar.getResultSet() .next()){ //getresultset ta obtendo o resultado do select e o next é pegando cada linha do select
                alocar.setEmpresa(this.conectar.getResultSet().getString(1));
                alocar.setPrestador(this.conectar.getResultSet().getString(2));
                alocar.setHoras(this.conectar.getResultSet().getString(3));
                alocar.setTipo(this.conectar.getResultSet().getString(4));
                alocar.setDescricao(this.conectar.getResultSet().getString(5));
            }
            if(alocar.getEmpresa() == ""){ 
                JOptionPane.showMessageDialog(null, "Alocação não encontrada!");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao consultar Alocação" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar Alocação");
            
        }finally{
            cbxEmpresa1.setSelectedItem(alocar.getEmpresa());
            cbxServico.setSelectedItem(alocar.getPrestador());
            txtHoras.setText(alocar.getHoras());
            cbxTipo.setSelectedItem(alocar.getTipo());
            txtDesejado.setText(alocar.getDescricao());
            this.conectar.fechaBanco();
        } 
    }
        
    public void AtualizarAlocacao(Alocacao alocar){
        this.conectar.conectaBanco();
        
        try{
            this.conectar.updateSQL("UPDATE Alocacao SET empresa = '" + cbxEmpresa1.getSelectedItem() + "' where prestador = '" + cbxServico.getSelectedItem() + "';");
            this.conectar.updateSQL("UPDATE Alocacao SET horas = '" + txtHoras.getText() + "' where prestador = '" + cbxServico.getSelectedItem() + "';");
            this.conectar.updateSQL("UPDATE Alocacao SET tipo = '" + cbxTipo.getSelectedItem() + "' where prestador = '" + cbxServico.getSelectedItem() + "';");
            this.conectar.updateSQL("UPDATE Alocacao SET desejo = '" + txtDesejado.getText() + "' where prestador = '" + cbxServico.getSelectedItem() + "';");
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Alocação");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Alocação atualizada com sucesso!");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxServico = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbxEmpresa1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesejado = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Alocação");
        setResizable(false);

        jPanel1.setLayout(null);

        cbxServico.setBackground(new java.awt.Color(255, 255, 255));
        cbxServico.setForeground(new java.awt.Color(0, 0, 0));
        cbxServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxServico);
        cbxServico.setBounds(440, 230, 180, 22);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Selecione prestador de serviços");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(440, 210, 240, 19);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Selecione a empresa");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 210, 170, 19);

        cbxEmpresa1.setBackground(new java.awt.Color(255, 255, 255));
        cbxEmpresa1.setForeground(new java.awt.Color(0, 0, 0));
        cbxEmpresa1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxEmpresa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmpresa1ActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEmpresa1);
        cbxEmpresa1.setBounds(50, 230, 180, 22);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Descrição do serviço desejado");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 350, 230, 16);

        txtHoras.setBackground(new java.awt.Color(255, 255, 255));
        txtHoras.setForeground(new java.awt.Color(0, 0, 0));
        txtHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasActionPerformed(evt);
            }
        });
        jPanel1.add(txtHoras);
        txtHoras.setBounds(50, 300, 180, 22);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Quantidade de horas");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 280, 150, 16);

        cbxTipo.setBackground(new java.awt.Color(255, 255, 255));
        cbxTipo.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipo);
        cbxTipo.setBounds(440, 300, 180, 22);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tipo de serviço prestado");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(440, 280, 210, 16);

        txtDesejado.setBackground(new java.awt.Color(255, 255, 255));
        txtDesejado.setColumns(20);
        txtDesejado.setForeground(new java.awt.Color(0, 0, 0));
        txtDesejado.setRows(5);
        jScrollPane1.setViewportView(txtDesejado);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 380, 290, 70);

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
        btnDelete.setBounds(130, 480, 170, 70);

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
        btnAtualizar.setBounds(390, 480, 170, 70);

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
        btnCadastrar.setBounds(130, 580, 170, 70);

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
        btnBuscar.setBounds(390, 580, 170, 70);

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cadastro.png"))); // NOI18N
        jPanel1.add(btnDeletar);
        btnDeletar.setBounds(0, 0, 727, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeletarAlocacao(alocar);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        AtualizarAlocacao(alocar);
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        CadastrarAlocacao(alocar);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        BuscarAlocacao(alocar);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbxEmpresa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmpresa1ActionPerformed
    }//GEN-LAST:event_cbxEmpresa1ActionPerformed

    private void cbxServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxServicoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroAlocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAlocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAlocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAlocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAlocacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel btnDeletar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<String> cbxEmpresa1;
    private javax.swing.JComboBox<String> cbxServico;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDesejado;
    private javax.swing.JTextField txtHoras;
    // End of variables declaration//GEN-END:variables
}
