package views.entities;

import application.viewModels.UnitVM;
import controllers.UnitController;
import domain.model.entities.ResponseService;
import domain.model.enums.ResponseTypeEnum;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProductUnitView extends javax.swing.JInternalFrame {

    public ProductUnitView() {
        initComponents();
        this.setVisible(true);
        
        this.unitController = new UnitController();
        this.clearForm();
        this.loadUnitTableByDataBase();
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelProductUnit = new javax.swing.JLabel();
        jLabelProductUnitName = new javax.swing.JLabel();
        jTextFieldProductUnitName = new javax.swing.JTextField();
        jLabelProductUnitSymbol = new javax.swing.JLabel();
        jTextFieldProductUnitSymbol = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductUnits = new javax.swing.JTable();
        jButtonDeleteProductUnit = new javax.swing.JButton();
        jButtonEditProductUnit = new javax.swing.JButton();
        jButtonSaveProductUnit = new javax.swing.JButton();
        jLabelProductUnitId = new javax.swing.JLabel();
        jTextFieldProductUnitId = new javax.swing.JTextField();
        jButtonClearFields = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unidade de Produto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ProductUnitIcon.png"))); // NOI18N

        jLabelProductUnit.setText("UNIDADE DE PRODUTO");

        jLabelProductUnitName.setText("Nome");

        jLabelProductUnitSymbol.setText("Símbolo");

        jTableProductUnits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Símbolo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductUnits.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableProductUnits);
        jTableProductUnits.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableProductUnits.getColumnModel().getColumnCount() > 0) {
            jTableProductUnits.getColumnModel().getColumn(0).setResizable(false);
            jTableProductUnits.getColumnModel().getColumn(1).setResizable(false);
            jTableProductUnits.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableProductUnits.getColumnModel().getColumn(2).setResizable(false);
        }

        jButtonDeleteProductUnit.setText("EXCLUIR");
        jButtonDeleteProductUnit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteProductUnitMouseClicked(evt);
            }
        });

        jButtonEditProductUnit.setText("EDITAR");
        jButtonEditProductUnit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditProductUnitMouseClicked(evt);
            }
        });

        jButtonSaveProductUnit.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonSaveProductUnit.setText("SALVAR");
        jButtonSaveProductUnit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveProductUnitMouseClicked(evt);
            }
        });

        jLabelProductUnitId.setText("Código");

        jTextFieldProductUnitId.setEnabled(false);

        jButtonClearFields.setText("LIMPAR CAMPOS");
        jButtonClearFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClearFieldsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonDeleteProductUnit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEditProductUnit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSaveProductUnit))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelProductUnit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonClearFields))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelProductUnitId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProductUnitId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProductUnitName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProductUnitName)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelProductUnitSymbol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProductUnitSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProductUnit)
                    .addComponent(jButtonClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldProductUnitId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelProductUnitId))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelProductUnitName)
                        .addComponent(jTextFieldProductUnitName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelProductUnitSymbol)
                        .addComponent(jTextFieldProductUnitSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonEditProductUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteProductUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveProductUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveProductUnitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveProductUnitMouseClicked
        UnitVM unitForm = getProductUnitByForm();
        
        if(unitForm.name.isBlank() || unitForm.symbol.isBlank()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        unitForm.id = Integer.parseInt(this.jTextFieldProductUnitId.getText().isEmpty() ? "0" : this.jTextFieldProductUnitId.getText());
        
            if(unitForm.id == 0){
                this.unitController.create(unitForm);
            } else {
                this.unitController.update(unitForm);
            }

            ResponseService response = this.unitController.getResponseService();

            if(response.getType() != ResponseTypeEnum.SUCCESS){
                JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, response.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.clearForm();
                this.loadUnitTableByDataBase();
            }
    }//GEN-LAST:event_jButtonSaveProductUnitMouseClicked

    private void jButtonEditProductUnitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditProductUnitMouseClicked
        int lineSelected = this.jTableProductUnits.getSelectedRow();
        
        if(lineSelected<0){
            JOptionPane.showMessageDialog(null, "Primeiramente é necessário selecionar o registro que deseja alterar." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        this.clearForm();
        
        int id = (int)this.jTableProductUnits.getValueAt(lineSelected, 0);
        
        UnitVM unit = this.unitController.get(id);
        ResponseService response = this.unitController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        completeForm(unit);
        this.jLabelProductUnit.setText("Edição de Unidade de Produto");
        this.jButtonEditProductUnit.setEnabled(false);
    }//GEN-LAST:event_jButtonEditProductUnitMouseClicked

    private void jButtonClearFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearFieldsMouseClicked
        this.clearForm();
    }//GEN-LAST:event_jButtonClearFieldsMouseClicked

    private void jButtonDeleteProductUnitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteProductUnitMouseClicked
        int lineSelected = this.jTableProductUnits.getSelectedRow();
        
        if(lineSelected<0){
            JOptionPane.showMessageDialog(null, "Primeiramente é necessário selecionar o registro que deseja deletar." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int id = (int)this.jTableProductUnits.getValueAt(lineSelected, 0);
        this.unitController.delete(id);
        
        ResponseService response = this.unitController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, response.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.loadUnitTableByDataBase();
        }
    }//GEN-LAST:event_jButtonDeleteProductUnitMouseClicked

    private UnitVM getProductUnitByForm(){
        UnitVM unitForm = new UnitVM();
        
        unitForm.name = this.jTextFieldProductUnitName.getText();
        unitForm.symbol = this.jTextFieldProductUnitSymbol.getText();
        
        return unitForm;
    }
    
    private void completeForm(UnitVM unit){
        this.jTextFieldProductUnitId.setText(Integer.toString(unit.id));
        this.jTextFieldProductUnitName.setText(unit.name);
        this.jTextFieldProductUnitSymbol.setText(unit.symbol);
    }
    
    private void clearForm(){
        this.jTextFieldProductUnitId.setText("");
        this.jTextFieldProductUnitName.setText("");
        this.jTextFieldProductUnitSymbol.setText("");
        this.jTextFieldProductUnitName.requestFocusInWindow();
        this.jLabelProductUnit.setText("NOVA UNIDADE DE PRODUTO");
        this.jButtonEditProductUnit.setEnabled(true);
    }
    
    private void loadUnitTableByDataBase(){
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableProductUnits.getModel();
        tableModel.setRowCount(0);
        
        List<UnitVM> units = this.unitController.getAll();
        
        for (UnitVM unit : units) {            
            Object[] row = {unit.id, unit.name, unit.symbol};
            
            tableModel.addRow(row);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClearFields;
    private javax.swing.JButton jButtonDeleteProductUnit;
    private javax.swing.JButton jButtonEditProductUnit;
    private javax.swing.JButton jButtonSaveProductUnit;
    private javax.swing.JLabel jLabelProductUnit;
    private javax.swing.JLabel jLabelProductUnitId;
    private javax.swing.JLabel jLabelProductUnitName;
    private javax.swing.JLabel jLabelProductUnitSymbol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductUnits;
    private javax.swing.JTextField jTextFieldProductUnitId;
    private javax.swing.JTextField jTextFieldProductUnitName;
    private javax.swing.JTextField jTextFieldProductUnitSymbol;
    // End of variables declaration//GEN-END:variables
    private UnitController unitController;
}
