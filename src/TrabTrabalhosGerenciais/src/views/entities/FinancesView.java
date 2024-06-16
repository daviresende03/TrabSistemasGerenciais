package views.entities;

import application.viewModels.CashRegisterVM;
import application.viewModels.FinanceVM;
import controllers.CashRegisterController;
import controllers.FinanceController;
import domain.model.entities.ResponseService;
import domain.model.enums.ResponseTypeEnum;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FinancesView extends javax.swing.JInternalFrame {

    public FinancesView() {        
        this.financeController = new FinanceController();
        this.cashRegisterController = new CashRegisterController();
        
        initComponents();
        this.setVisible(true);     
        this.resetScreen(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableRegisters = new javax.swing.JTable();
        jTextFieldValue = new javax.swing.JTextField();
        jButtonOpenAndClose = new javax.swing.JButton();
        jButtonNewRegister = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setFrameIcon(null);

        jLabelTitle.setText("CONTROLE DE CAIXA");

        jLabelStatus.setText("STATUS");

        jTextFieldStatus.setEditable(false);
        jTextFieldStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldStatus.setEnabled(false);

        jTableRegisters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Tipo ", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(jTableRegisters);

        jTextFieldValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldValue.setEnabled(false);

        jButtonOpenAndClose.setText("ABRIR CAIXA");
        jButtonOpenAndClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOpenAndCloseMouseClicked(evt);
            }
        });

        jButtonNewRegister.setText("NOVO REGISTRO");
        jButtonNewRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNewRegisterMouseClicked(evt);
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
                        .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonOpenAndClose))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOpenAndClose)
                    .addComponent(jButtonNewRegister))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpenAndCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOpenAndCloseMouseClicked
        boolean cashIsOpen = isOpenByTextField();
        if(!cashIsOpen){
            this.openCashRegister();
        }else{
            this.closeCashRegister();
        }
    }//GEN-LAST:event_jButtonOpenAndCloseMouseClicked

    private void jButtonNewRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNewRegisterMouseClicked
        int cashRegisterOpenId = this.cashRegisterController.getIdCashIsOpen();
        if(cashRegisterOpenId<=0){
            JOptionPane.showMessageDialog(null, "É necessário primeiramente abrir o caixa." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        NewFinanceView newFinanceView = new NewFinanceView(parentFrame, cashRegisterOpenId);
        newFinanceView.setVisible(true);
        
        this.resetScreen(cashRegisterOpenId);
    }//GEN-LAST:event_jButtonNewRegisterMouseClicked

    private void resetScreen(int cashRegisterId){
        int cashRegisterOpenId = cashRegisterId<=0 ? this.cashRegisterController.getIdCashIsOpen() : cashRegisterId;  
        this.updateCashRegisterStatus(cashRegisterOpenId>0);
        this.updateFinanceTable(cashRegisterOpenId);        
    }
    
    private void updateFinanceTable(int cashRegisterOpenId){
        if(cashRegisterOpenId<=0){
            loadFinanceTableByDataBase(new ArrayList<FinanceVM>());
            return;
        }
        
        List<FinanceVM> finances = this.financeController.getAllByCashRegisterId(cashRegisterOpenId);
        ResponseService response = this.financeController.getResponseService();
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        loadFinanceTableByDataBase(finances);
    }
    
    private void loadFinanceTableByDataBase(List<FinanceVM> finances){
        double amount = 0;
        DefaultTableModel model = (DefaultTableModel)this.jTableRegisters.getModel();
        model.setRowCount(0);
        
        for(FinanceVM finance : finances){            
            amount+= (finance.type == 1 ? finance.value : (-finance.value));
            
            String type = finance.type == 1 ? "Recebimento" : "Pagamento";
            String valueString = String.format("R$ %.2f", finance.value);
            Object[] row = {finance.id, finance.description, type, valueString};
            model.addRow(row);
        }
        
        String amountString = String.format("R$ %.2f", amount);
        this.jTextFieldValue.setText(amountString);
    }
    
    private void openCashRegister(){
        CashRegisterVM cashRegister = this.cashRegisterController.open();
        
        ResponseService responseService = this.cashRegisterController.getResponseService();
        if(responseService.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, responseService.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, responseService.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            updateCashRegisterStatus(true);
        }
    }
    
    private void closeCashRegister(){
        int cashRegisterOpenId = this.cashRegisterController.getIdCashIsOpen();        
        ResponseService responseService = this.cashRegisterController.getResponseService();
        if(responseService.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, responseService.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        this.cashRegisterController.close(cashRegisterOpenId);        
        responseService = this.cashRegisterController.getResponseService();
        if(responseService.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, responseService.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, responseService.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            updateCashRegisterStatus(false);
            updateFinanceTable(0);
        }
    }
    
    private void updateCashRegisterStatus(boolean isOpen){
        String statusLabel = isOpen ? "ABERTO" : "FECHADO";
        this.jTextFieldStatus.setText(statusLabel);
        String buttonLabel = (isOpen ? "FECHAR" : "ABRIR")+" CAIXA";
        this.jButtonOpenAndClose.setText(buttonLabel);
    }
    
    private boolean isOpenByTextField(){
        return this.jTextFieldStatus.getText().equals("ABERTO");
    }
    
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
    private javax.swing.JButton jButtonNewRegister;
    private javax.swing.JButton jButtonOpenAndClose;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableRegisters;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldValue;
    // End of variables declaration//GEN-END:variables
    private FinanceController financeController;
    private CashRegisterController cashRegisterController;
}