package view.entities;

import controller.ProductController;
import controller.viewModels.ProductVM;
import domain.model.enums.ProductTypeEnum;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProductView extends javax.swing.JInternalFrame {

    public ProductView() {
        this.productController = new ProductController();
        
        initComponents();
        this.setVisible(true);
        this.clearForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelNewProduct = new javax.swing.JLabel();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        jLabelNewProduct.setText("NOVO PRODUTO");

        jButtonClearFields.setText("LIMPAR CAMPOS");
        jButtonClearFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClearFieldsMouseClicked(evt);
            }
        });

        jLabel1.setText("Nome");

        jComboBoxUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelCostPrice.setText("Preço de Custo");

        jLabelSalePrice.setText("Preço de Venda");

        jLabelStock.setText("Estoque");

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
        jScrollPane2.setViewportView(jProductTable);
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

        jButton1.setText("SALVAR");

        jButton2.setText("EDITAR");

        jButton3.setText("EXCLUIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
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
                                .addComponent(jLabelNewProduct)
                                .addGap(174, 174, 174))
                            .addGroup(layout.createSequentialGroup()
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClearFields)
                    .addComponent(jLabelNewProduct))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCostPrice)
                    .addComponent(jTextFieldCostPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSalePrice)
                    .addComponent(jTextFieldSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStock)
                    .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearFieldsMouseClicked
        this.clearForm();
    }//GEN-LAST:event_jButtonClearFieldsMouseClicked

    
    private void clearForm(){
        this.jTextFieldProductName.setText("");
        this.jTextFieldSalePrice.setText("");
        this.jTextFieldCostPrice.setText("");
        this.jTextFieldStock.setText("");
        this.jComboBoxType.setSelectedIndex(0);
        this.jComboBoxUnit.setSelectedIndex(0);
        this.jTextFieldProductName.requestFocusInWindow();
        
        this.loadProductTableByDataBase();
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonClearFields;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JComboBox<String> jComboBoxUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCostPrice;
    private javax.swing.JLabel jLabelNewProduct;
    private javax.swing.JLabel jLabelSalePrice;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JTable jProductTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCostPrice;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldSalePrice;
    private javax.swing.JTextField jTextFieldStock;
    // End of variables declaration//GEN-END:variables
    private final ProductController productController;
}
