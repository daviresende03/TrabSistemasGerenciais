package views.entities;

import application.viewModels.PersonVM;
import application.viewModels.ProductVM;
import controllers.PersonController;
import controllers.ProductController;
import domain.model.enums.ProductTypeEnum;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class NewOrderView extends javax.swing.JInternalFrame {

    public NewOrderView() {
        this.productController = new ProductController();
        this.personController = new PersonController();
        
        initComponents();
        this.setVisible(true);
        this.clearForm();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelNewOrder = new javax.swing.JLabel();
        jLabelCustomer = new javax.swing.JLabel();
        jComboBoxCustomer = new javax.swing.JComboBox<>();
        jLabelStaff = new javax.swing.JLabel();
        jComboBoxStaff = new javax.swing.JComboBox<>();
        jLabelProductsList = new javax.swing.JLabel();
        jLabelSelectedProductsList = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductsList = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableSelectedProductsList = new javax.swing.JTable();
        jButtonConcludeOrder = new javax.swing.JButton();
        jButtonDeleteOrder = new javax.swing.JButton();
        jButtonEditOrder = new javax.swing.JButton();
        jLabelOrderTotal = new javax.swing.JLabel();
        jButtonSaveOrder = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaObservations = new javax.swing.JTextArea();
        jLabelObservations = new javax.swing.JLabel();
        jLabelDiscount = new javax.swing.JLabel();
        jTextFieldDiscount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOrderStatus = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
        jScrollPane3.setViewportView(jTable1);

        setClosable(true);
        setTitle("Novo pedido");

        jLabelNewOrder.setText("NOVO PEDIDO");

        jLabelCustomer.setText("Cliente");

        jLabelStaff.setText("Atendente");

        jComboBoxStaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jComboBoxStaff.setToolTipText("");

        jLabelProductsList.setText("Produtos");

        jLabelSelectedProductsList.setText("Produtos selecionados");

        jTableProductsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço", "Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
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
        jTableProductsList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableProductsList);
        jTableProductsList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableProductsList.getColumnModel().getColumnCount() > 0) {
            jTableProductsList.getColumnModel().getColumn(0).setResizable(false);
            jTableProductsList.getColumnModel().getColumn(1).setResizable(false);
            jTableProductsList.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTableProductsList.getColumnModel().getColumn(2).setResizable(false);
            jTableProductsList.getColumnModel().getColumn(3).setResizable(false);
        }

        jTableSelectedProductsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
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
        jTableSelectedProductsList.setColumnSelectionAllowed(true);
        jTableSelectedProductsList.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableSelectedProductsList);
        jTableSelectedProductsList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableSelectedProductsList.getColumnModel().getColumnCount() > 0) {
            jTableSelectedProductsList.getColumnModel().getColumn(0).setResizable(false);
            jTableSelectedProductsList.getColumnModel().getColumn(1).setResizable(false);
            jTableSelectedProductsList.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTableSelectedProductsList.getColumnModel().getColumn(2).setResizable(false);
            jTableSelectedProductsList.getColumnModel().getColumn(3).setResizable(false);
        }

        jButtonConcludeOrder.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonConcludeOrder.setText("FECHAR PEDIDO");
        jButtonConcludeOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConcludeOrder.setMaximumSize(new java.awt.Dimension(128, 30));
        jButtonConcludeOrder.setMinimumSize(new java.awt.Dimension(128, 30));

        jButtonDeleteOrder.setText("EXCLUIR");
        jButtonDeleteOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDeleteOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteOrderMouseClicked(evt);
            }
        });

        jButtonEditOrder.setText("EDITAR");
        jButtonEditOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelOrderTotal.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelOrderTotal.setText("Total do Pedido");

        jButtonSaveOrder.setText("SALVAR");

        jTextAreaObservations.setColumns(20);
        jTextAreaObservations.setRows(5);
        jScrollPane5.setViewportView(jTextAreaObservations);

        jLabelObservations.setText("Observações");

        jLabelDiscount.setText("Desconto");

        jLabel1.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelObservations)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonDeleteOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEditOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSaveOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonConcludeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelProductsList)
                                    .addComponent(jLabelNewOrder)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCustomer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabelStaff)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxStaff, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelSelectedProductsList)
                                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                                                    .addComponent(jLabelOrderTotal)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelDiscount)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldDiscount))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNewOrder)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCustomer)
                    .addComponent(jComboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStaff)
                    .addComponent(jComboBoxStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProductsList)
                    .addComponent(jLabelSelectedProductsList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jLabelObservations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDiscount)
                            .addComponent(jTextFieldDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelOrderTotal))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConcludeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteOrderMouseClicked

    }//GEN-LAST:event_jButtonDeleteOrderMouseClicked

    private void clearForm(){
        this.loadProductTableByDataBase();
        this.loadCustomerComboBox();
        
        ((DefaultTableModel)this.jTableSelectedProductsList.getModel()).setRowCount(0);
        this.jComboBoxStaff.setSelectedIndex(0);
        this.jTextAreaObservations.setText("");
        this.jTextFieldDiscount.setText("");
        this.jTextFieldOrderStatus.setText("");
        
        this.jComboBoxCustomer.requestFocus();
    }
    
    private void loadProductTableByDataBase(){
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableProductsList.getModel();
        tableModel.setRowCount(0);
        
        List<ProductVM> products = this.productController.getAll();
        for (ProductVM product : products){
            String typeDescription = product.type == ProductTypeEnum.PRODUCT_SALE.getValue() ? "Produto" : "Prato Feito";
            
            Object[] row = {product.id, product.name, product.salePrice, product.stock};
            tableModel.addRow(row);
        }
    }
    
    private void loadCustomerComboBox(){
        this.jComboBoxCustomer.removeAllItems();
        
        List<PersonVM> people = this.personController.getAll();
        for(PersonVM person : people){
            this.jComboBoxCustomer.addItem(person.name);
        }
        
        if(!people.isEmpty()){
            this.jComboBoxCustomer.setSelectedIndex(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConcludeOrder;
    private javax.swing.JButton jButtonDeleteOrder;
    private javax.swing.JButton jButtonEditOrder;
    private javax.swing.JButton jButtonSaveOrder;
    private javax.swing.JComboBox<String> jComboBoxCustomer;
    private javax.swing.JComboBox<String> jComboBoxStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCustomer;
    private javax.swing.JLabel jLabelDiscount;
    private javax.swing.JLabel jLabelNewOrder;
    private javax.swing.JLabel jLabelObservations;
    private javax.swing.JLabel jLabelOrderTotal;
    private javax.swing.JLabel jLabelProductsList;
    private javax.swing.JLabel jLabelSelectedProductsList;
    private javax.swing.JLabel jLabelStaff;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableProductsList;
    private javax.swing.JTable jTableSelectedProductsList;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaObservations;
    private javax.swing.JTextField jTextFieldDiscount;
    private javax.swing.JTextField jTextFieldOrderStatus;
    // End of variables declaration//GEN-END:variables
    private ProductController productController;
    private PersonController personController;

}
