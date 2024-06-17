package views.entities;

import controllers.ProductController;
import application.viewModels.ProductVM;
import application.viewModels.UnitVM;
import controllers.UnitController;
import domain.model.entities.ResponseService;
import domain.model.enums.ProductTypeEnum;
import domain.model.enums.ResponseTypeEnum;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductView extends javax.swing.JInternalFrame {

    public ProductView() {
        this.productController = new ProductController();
        this.unitController = new UnitController();
        
        initComponents();
        this.setVisible(true);
        this.clearForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jButtonClearFields = new javax.swing.JButton();
        jTextFieldProductName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxUnit = new javax.swing.JComboBox<>();
        jLabelCostPrice = new javax.swing.JLabel();
        jTextFieldCostPrice = new javax.swing.JTextField();
        jLabelSalePrice = new javax.swing.JLabel();
        jTextFieldSalePrice = new javax.swing.JTextField();
        jLabelStock = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
        jComboBoxType = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jProductTable = new javax.swing.JTable();
        jButtonDeleteProduct = new javax.swing.JButton();
        jButtonEditProduct = new javax.swing.JButton();
        jButtonSaveProduct = new javax.swing.JButton();
        jTextFieldProductId = new javax.swing.JTextField();
        jLabelProductId = new javax.swing.JLabel();

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
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ProductViewIcon.png"))); // NOI18N

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTitle.setText("NOVO PRODUTO");

        jButtonClearFields.setText("LIMPAR CAMPOS");
        jButtonClearFields.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonClearFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClearFieldsMouseClicked(evt);
            }
        });

        jLabel1.setText("Nome");

        jComboBoxUnit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelCostPrice.setText("Preço de Custo");

        jLabelSalePrice.setText("Preço de Venda");

        jLabelStock.setText("Estoque");

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Produto Final", "Prato Feito" }));
        jComboBoxType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Unidade", "Tipo", "Estoque", "Preço de Custo", "Preço de Venda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jProductTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jProductTable);
        jProductTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jProductTable.getColumnModel().getColumnCount() > 0) {
            jProductTable.getColumnModel().getColumn(0).setResizable(false);
            jProductTable.getColumnModel().getColumn(1).setResizable(false);
            jProductTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            jProductTable.getColumnModel().getColumn(2).setResizable(false);
            jProductTable.getColumnModel().getColumn(3).setResizable(false);
            jProductTable.getColumnModel().getColumn(4).setResizable(false);
            jProductTable.getColumnModel().getColumn(5).setResizable(false);
            jProductTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jButtonDeleteProduct.setText("EXCLUIR");
        jButtonDeleteProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDeleteProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteProductMouseClicked(evt);
            }
        });

        jButtonEditProduct.setText("EDITAR");
        jButtonEditProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditProductMouseClicked(evt);
            }
        });

        jButtonSaveProduct.setText("SALVAR");
        jButtonSaveProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSaveProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveProductMouseClicked(evt);
            }
        });

        jTextFieldProductId.setEnabled(false);

        jLabelProductId.setText("Código");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDeleteProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEditProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSaveProduct))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelCostPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCostPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelSalePrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSalePrice, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldStock, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTitle)
                                .addGap(174, 174, 174))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelProductId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldProductName)
                                .addGap(25, 25, 25)
                                .addComponent(jComboBoxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonClearFields)
                            .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jButtonClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProductId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCostPrice)
                    .addComponent(jTextFieldCostPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSalePrice)
                    .addComponent(jTextFieldSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStock)
                    .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonDeleteProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButtonEditProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSaveProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearFieldsMouseClicked
        this.clearForm();
    }//GEN-LAST:event_jButtonClearFieldsMouseClicked

    private void jButtonSaveProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveProductMouseClicked
        ProductVM productVM;
        try{
             productVM = getProductByForm();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Informe valores válidos" , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int productId = Integer.parseInt(this.jTextFieldProductId.getText().isEmpty() ? "0" : this.jTextFieldProductId.getText());
        
        if(productVM.name.isBlank() || productVM.costPrice  == 0 || productVM.salePrice == 0 || productVM.stock == 0 || productVM.type < 0 || productVM.unitName.equals("0")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(productId == 0){
            this.productController.create(productVM);
        }else{
            productVM.id = productId;
            this.productController.update(productVM);
        }
        
        ResponseService response = this.productController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, response.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.clearForm();
            this.jButtonEditProduct.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonSaveProductMouseClicked

    private void jButtonEditProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditProductMouseClicked
        int lineSelected = this.jProductTable.getSelectedRow();
        if(lineSelected<0){
            JOptionPane.showMessageDialog(null, "Primeiramente é necessário selecionar o registro que deseja alterar." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        this.clearForm();
        
        int id = (int)this.jProductTable.getValueAt(lineSelected, 0);
        
        ProductVM product = this.productController.get(id);
        ResponseService response = this.productController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        completeForm(product);
        this.jLabelTitle.setText("EDIÇÃO DE USUÁRIO");
        this.jButtonEditProduct.setEnabled(false); 
    }//GEN-LAST:event_jButtonEditProductMouseClicked

    private void completeForm(ProductVM product){
        this.jTextFieldProductId.setText(Integer.toString(product.id));
        this.jTextFieldProductName.setText(product.name);
        this.jTextFieldCostPrice.setText(Double.toString(product.costPrice));
        this.jTextFieldSalePrice.setText(Double.toString(product.salePrice));
        this.jTextFieldStock.setText(Double.toString(product.stock));
        
        this.jComboBoxType.setSelectedIndex(product.type-1);
        this.jComboBoxUnit.setSelectedItem(product.unitName);
    }
    
    
    private void jButtonDeleteProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteProductMouseClicked
        int lineSelected = this.jProductTable.getSelectedRow();
        if(lineSelected<0){
            JOptionPane.showMessageDialog(null, "Primeiramente é necessário selecionar o registro que deseja deletar." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int id = (int)this.jProductTable.getValueAt(lineSelected, 0);
        this.productController.delete(id);
        
        ResponseService response = this.productController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, response.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.loadProductTableByDataBase();
        }
    }//GEN-LAST:event_jButtonDeleteProductMouseClicked

    private ProductVM getProductByForm(){
        ProductVM productForm = new ProductVM();
        
        productForm.name = this.jTextFieldProductName.getText();
        productForm.type = this.jComboBoxType.getSelectedIndex()+1;
        productForm.unitName = (String)this.jComboBoxUnit.getSelectedItem();
        productForm.costPrice = Double.parseDouble(this.jTextFieldCostPrice.getText().isBlank() ? "0" : this.jTextFieldCostPrice.getText());
        productForm.salePrice = Double.parseDouble(this.jTextFieldSalePrice.getText().isBlank() ? "0" : this.jTextFieldSalePrice.getText());
        productForm.stock = Double.parseDouble(this.jTextFieldStock.getText().isBlank() ? "0" : this.jTextFieldStock.getText());

        return productForm;
    }
    
    private void clearForm(){
        this.loadUnitComboBox();

        this.jTextFieldProductName.setText("");
        this.jTextFieldSalePrice.setText("");
        this.jTextFieldCostPrice.setText("");
        this.jTextFieldStock.setText("");
        this.jComboBoxType.setSelectedIndex(0);
        this.jTextFieldProductName.requestFocusInWindow();

        this.loadProductTableByDataBase();
    }

    private void loadUnitComboBox(){ 
        this.jComboBoxUnit.removeAllItems();

        List<UnitVM> unitsVM = this.unitController.getAll();
        for(UnitVM unit : unitsVM){
            this.jComboBoxUnit.addItem(unit.name);
        }

        if(!unitsVM.isEmpty()){
            this.jComboBoxUnit.setSelectedIndex(0);
        }
    }
    
    private void loadProductTableByDataBase(){
        DefaultTableModel tableModel = (DefaultTableModel) this.jProductTable.getModel();
        tableModel.setRowCount(0);
        
        List<ProductVM> products = this.productController.getAll();
        for (ProductVM product : products){
            String typeDescription = product.type == ProductTypeEnum.PRODUCT_SALE.getValue() ? "Produto" : "Prato Feito";
            
            Object[] row = {product.id, product.name, product.unitName, typeDescription, product.stock, product.costPrice, product.salePrice};
            tableModel.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClearFields;
    private javax.swing.JButton jButtonDeleteProduct;
    private javax.swing.JButton jButtonEditProduct;
    private javax.swing.JButton jButtonSaveProduct;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JComboBox<String> jComboBoxUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCostPrice;
    private javax.swing.JLabel jLabelProductId;
    private javax.swing.JLabel jLabelSalePrice;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTable jProductTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCostPrice;
    private javax.swing.JTextField jTextFieldProductId;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldSalePrice;
    private javax.swing.JTextField jTextFieldStock;
    // End of variables declaration//GEN-END:variables
    private final ProductController productController;
    private final UnitController unitController;
}