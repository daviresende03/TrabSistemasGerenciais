package views.entities;

import application.viewModels.FinanceVM;
import controllers.FinanceController;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FinancesView extends javax.swing.JInternalFrame {

    public FinancesView() {
        this.financeController = new FinanceController();
        
        initComponents();
        this.getRegisters();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegisters = new javax.swing.JTable();
        jTextFieldValue = new javax.swing.JTextField();
        jButtonValue = new javax.swing.JButton();
        jButtonNewRegister = new javax.swing.JButton();
        jButtonDeleteRegister = new javax.swing.JButton();

        jLabelTitle.setText("CONTROLE DE CAIXA");

        jLabelStatus.setText("STATUS");

        jTextFieldStatus.setEditable(false);

        jTableRegisters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Tipo ", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRegisters.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTableRegisters);
        jTableRegisters.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableRegisters.getColumnModel().getColumnCount() > 0) {
            jTableRegisters.getColumnModel().getColumn(0).setResizable(false);
            jTableRegisters.getColumnModel().getColumn(1).setResizable(false);
            jTableRegisters.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableRegisters.getColumnModel().getColumn(2).setResizable(false);
            jTableRegisters.getColumnModel().getColumn(3).setResizable(false);
        }

        jButtonValue.setText("ABRIR CAIXA");

        jButtonNewRegister.setText("NOVO REGISTRO");

        jButtonDeleteRegister.setText("APAGAR REGISTRO");
        jButtonDeleteRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNewRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDeleteRegister)
                        .addGap(67, 67, 67)
                        .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonValue))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jLabelStatus)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonValue)
                    .addComponent(jButtonNewRegister)
                    .addComponent(jButtonDeleteRegister))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteRegisterMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteRegisterMouseClicked

    private void getRegisters(){
        this.loadRegisterTableByDataBase();
    }
    
    private void loadRegisterTableByDataBase(){
        List<FinanceVM> registers = this.financeController.getAll();
        
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableRegisters.getModel();
        tableModel.setRowCount(0);
        
        for(FinanceVM register : registers){
            String type = register.type == 1 ? "RECEBIMENTO" : "PAGAMENTO";
            String value = String.format("R$ %.2f", register.value);
            Object[] row = { register.id, register.description, type, value };
            tableModel.addRow(row);
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteRegister;
    private javax.swing.JButton jButtonNewRegister;
    private javax.swing.JButton jButtonValue;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRegisters;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldValue;
    // End of variables declaration//GEN-END:variables
    private FinanceController financeController;
}
