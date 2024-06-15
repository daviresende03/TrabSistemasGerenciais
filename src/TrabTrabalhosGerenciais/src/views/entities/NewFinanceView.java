package views.entities;

import application.viewModels.FinanceVM;
import controllers.FinanceController;
import domain.model.entities.ResponseService;
import domain.model.enums.ResponseTypeEnum;
import javax.swing.JOptionPane;

public class NewFinanceView extends javax.swing.JInternalFrame {

    public NewFinanceView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNewFinance = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox<>();
        jTextFieldDescription = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jLabelValue = new javax.swing.JLabel();
        jTextFieldValue = new javax.swing.JTextField();
        jButtonSaveFinance = new javax.swing.JButton();

        jLabelNewFinance.setText("NOVO REGISTRO");

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recebimento", "Pagamento" }));
        jComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição");

        jLabelType.setText("Tipo");

        jLabelValue.setText("Valor");

        jTextFieldValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValueActionPerformed(evt);
            }
        });

        jButtonSaveFinance.setText("SALVAR");
        jButtonSaveFinance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveFinanceMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSaveFinance))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDescription)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabelNewFinance))
                                .addGap(0, 564, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelValue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelNewFinance)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelType)
                    .addComponent(jLabelValue)
                    .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonSaveFinance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValueActionPerformed

    private void jButtonSaveFinanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveFinanceMouseClicked
        FinanceVM financeForm = getFinanceByForm();
        
        if(financeForm.type <= 0 || financeForm.value <= 0 || financeForm.description.isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        this.financeController.create(financeForm);
       
        ResponseService response = this.financeController.getResponseService();

        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, response.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.clearForm();
        }
    }//GEN-LAST:event_jButtonSaveFinanceMouseClicked

    private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTypeActionPerformed

    private FinanceVM getFinanceByForm(){
        FinanceVM financeForm = new FinanceVM();
        
        financeForm.type = this.jComboBoxType.getSelectedIndex();
        financeForm.value = Double.parseDouble(this.jTextFieldValue.getText());
        financeForm.description = this.jTextFieldDescription.getText();
        
        return financeForm;
    }
    
    private void clearForm(){
        this.jComboBoxType.setSelectedIndex(0);
        this.jTextFieldValue.setText("");
        this.jTextFieldDescription.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSaveFinance;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNewFinance;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JLabel jLabelValue;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldValue;
    // End of variables declaration//GEN-END:variables
    private FinanceController financeController;
}