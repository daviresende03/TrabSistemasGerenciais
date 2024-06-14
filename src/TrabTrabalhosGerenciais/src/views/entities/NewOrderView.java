package views.entities;

import application.viewModels.OrderItemVM;
import application.viewModels.OrderVM;
import application.viewModels.PersonVM;
import application.viewModels.ProductVM;
import controllers.OrderController;
import controllers.PersonController;
import controllers.ProductController;
import domain.model.entities.ResponseService;
import domain.model.enums.ProductTypeEnum;
import domain.model.enums.ResponseTypeEnum;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NewOrderView extends javax.swing.JInternalFrame {

    public NewOrderView() {
        this.productController = new ProductController();
        this.personController = new PersonController();
        this.orderController = new OrderController();
        
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
        jLabelOrderTotal = new javax.swing.JLabel();
        jButtonSaveOrder = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaObservations = new javax.swing.JTextArea();
        jLabelObservations = new javax.swing.JLabel();
        jLabelDiscount = new javax.swing.JLabel();
        jTextFieldDiscount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOrderStatus = new javax.swing.JTextField();
        jTextFieldAmountOrder = new javax.swing.JTextField();
        jButtonSaleProduct = new javax.swing.JButton();
        jLabelQuantity = new javax.swing.JLabel();
        jTextFieldQuantity = new javax.swing.JTextField();
        jButtonRemoveProduct = new javax.swing.JButton();

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

        jLabelNewOrder.setText("NOVO PEDIDO");

        jLabelCustomer.setText("Cliente");

        jLabelStaff.setText("Atendente");

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
        jTableSelectedProductsList.setAutoscrolls(false);
        jTableSelectedProductsList.setCellSelectionEnabled(false);
        jTableSelectedProductsList.setRowSelectionAllowed(true);
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
        jButtonConcludeOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConcludeOrderMouseClicked(evt);
            }
        });

        jLabelOrderTotal.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelOrderTotal.setText("Total do Pedido");

        jButtonSaveOrder.setText("SALVAR");

        jTextAreaObservations.setColumns(20);
        jTextAreaObservations.setRows(5);
        jScrollPane5.setViewportView(jTextAreaObservations);

        jLabelObservations.setText("Observações");

        jLabelDiscount.setText("Desconto");

        jLabel1.setText("Status");

        jTextFieldOrderStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldOrderStatus.setEnabled(false);

        jTextFieldAmountOrder.setEnabled(false);

        jButtonSaleProduct.setText("ADICIONAR AO PEDIDO");
        jButtonSaleProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaleProductMouseClicked(evt);
            }
        });

        jLabelQuantity.setText("Quantidade");

        jButtonRemoveProduct.setText("REMOVER ITEM");
        jButtonRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveProductActionPerformed(evt);
            }
        });

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
                                .addComponent(jButtonSaveOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonConcludeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCustomer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelProductsList)
                                            .addComponent(jLabelNewOrder))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabelQuantity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonSaleProduct)))
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
                                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelDiscount)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldDiscount))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelSelectedProductsList)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelOrderTotal)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldAmountOrder))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jButtonRemoveProduct))))))
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQuantity)
                    .addComponent(jButtonSaleProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemoveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabelObservations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDiscount)
                            .addComponent(jTextFieldDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelOrderTotal)
                            .addComponent(jTextFieldAmountOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConcludeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaleProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaleProductMouseClicked
        int lineSelected = this.jTableProductsList.getSelectedRow();
        if(lineSelected<0){
            JOptionPane.showMessageDialog(null, "Primeiramente é necessário selecionar o registro que deseja vender." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(this.jTextFieldQuantity.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "É necessário informar a quantidade a ser vendida." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        double quantity;
        
        try{
            quantity = Double.parseDouble(this.jTextFieldQuantity.getText());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "É necessário informar uma quantidade válida a ser vendida." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int productId = (int)this.jTableProductsList.getValueAt(lineSelected, 0);
        
        ProductVM product = this.productController.get(productId);
        ResponseService response = this.productController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        this.addProductToSaleTable(product, quantity);
        this.updateTotalOrder(product.salePrice*quantity);
    }//GEN-LAST:event_jButtonSaleProductMouseClicked

    private void updateTotalOrder(double value){
        String prefix = "R$ ";
        
        String amountString = this.jTextFieldAmountOrder.getText().replace(prefix, "");
        Double amount = Double.parseDouble(amountString.isEmpty()?"0":amountString) + value;
        
        String newAmountString = prefix + Double.toString(amount<0 ? 0 : amount);
        this.jTextFieldAmountOrder.setText(newAmountString);
    }
    
    private int getComboBoxSelectedId(JComboBox comboBox){
        try{
            String selectedItem = (String)comboBox.getSelectedItem();
            return Integer.parseInt(selectedItem.split("-")[0]);
        } catch(Exception ex){
            return -1;
        }
    }
    
    private List<OrderItemVM> getOrderItems(){
        int quantityProducts = this.jTableSelectedProductsList.getRowCount();
        if(quantityProducts<=0){
            JOptionPane.showMessageDialog(null, "Nenhum item foi vendido!" , "Atenção", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        List<OrderItemVM> orderItems = new ArrayList<OrderItemVM>();
        
        for(int i=0;i<quantityProducts;i++){
            int productId = (int)this.jTableSelectedProductsList.getValueAt(i, 0);
            double quantity = (double)this.jTableSelectedProductsList.getValueAt(i, 2);
            double salePrice = (double)this.jTableSelectedProductsList.getValueAt(i, 3);
            ProductVM product = this.productController.get(productId);
            
            ResponseService response = this.productController.getResponseService();
            if(response.getType()==ResponseTypeEnum.SUCCESS){
                orderItems.add(new OrderItemVM(product, quantity, salePrice));
            }
        }
        return orderItems;
    }
    
    private PersonVM getPersonComboBoxSelected(JComboBox comboBox, String objectName){
        int personId = getComboBoxSelectedId(comboBox);
        if(personId<=0){
            JOptionPane.showMessageDialog(null, "Não foi possível obter o id do "+objectName+" selecionado." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        PersonVM person = this.personController.get(personId);
        ResponseService response = this.personController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, "Não foi possível obter o "+objectName+" selecionado." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        
        return person;
    }
    
    private void jButtonConcludeOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConcludeOrderMouseClicked
        PersonVM customer = getPersonComboBoxSelected(this.jComboBoxCustomer,"cliente");
        if(customer==null){
            return;
        }
        
        PersonVM staff = getPersonComboBoxSelected(this.jComboBoxStaff,"funcionário");
        if(staff==null){
            return;
        }
        
        List<OrderItemVM> orderItems = getOrderItems();
        if(orderItems==null){
            return;
        }
        
        double discount = Double.parseDouble(this.jTextFieldDiscount.getText().isEmpty() ? "0" : this.jTextFieldDiscount.getText());
        String obs = this.jTextAreaObservations.getText();
        
        OrderVM order = new OrderVM(customer, staff, orderItems, discount, obs);
        
        this.orderController.create(order);
        ResponseService responseService = this.orderController.getResponseService();
        
        if(responseService.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, responseService.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, responseService.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.clearForm();
        }
    }//GEN-LAST:event_jButtonConcludeOrderMouseClicked

    private void jButtonRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveProductActionPerformed
        int lineSelected = this.jTableSelectedProductsList.getSelectedRow();
        if(lineSelected<0){
            JOptionPane.showMessageDialog(null, "Primeiramente é necessário selecionar o registro que deseja remover." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        double quantity  = (double)this.jTableSelectedProductsList.getValueAt(lineSelected, 2);
        double salePrice = (double)this.jTableSelectedProductsList.getValueAt(lineSelected, 3);
        
        this.updateTotalOrder(-(quantity*salePrice));
        
        DefaultTableModel model = (DefaultTableModel)this.jTableSelectedProductsList.getModel();
        model.removeRow(lineSelected);
    }//GEN-LAST:event_jButtonRemoveProductActionPerformed

    private void clearForm(){
        this.loadProductTableByDataBase();
        this.loadCustomerComboBox();
        this.loadStaffComboBox();
        
        ((DefaultTableModel)this.jTableSelectedProductsList.getModel()).setRowCount(0);
        this.jTextAreaObservations.setText("");
        this.jTextFieldDiscount.setText("");
        this.jTextFieldOrderStatus.setText("");
        this.jTextFieldQuantity.setText("1.00");
        this.jTextFieldAmountOrder.setText("R$ 0.00");
        this.jTextFieldOrderStatus.setText("NOVO");
        
        this.jComboBoxCustomer.requestFocus();
    }
    
    private void addProductToSaleTable(ProductVM product, double quantity){
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableSelectedProductsList.getModel();
        
        Object[] row = {product.id, product.name, quantity, product.salePrice};
        tableModel.addRow(row);
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
        
        List<PersonVM> people = this.personController.getAll(true, false, false);
        for(PersonVM person : people){
            this.jComboBoxCustomer.addItem(person.id+"-"+person.name);
        }
        
        if(!people.isEmpty()){
            this.jComboBoxCustomer.setSelectedIndex(0);
        }
    }
    
    private void loadStaffComboBox(){
        this.jComboBoxStaff.removeAllItems();
        
        List<PersonVM> staffs = this.personController.getAll(false, true, false);
        for(PersonVM person : staffs){
            this.jComboBoxStaff.addItem(person.id+"-"+person.name);
        }
        
        if(!staffs.isEmpty()){
            this.jComboBoxStaff.setSelectedIndex(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConcludeOrder;
    private javax.swing.JButton jButtonRemoveProduct;
    private javax.swing.JButton jButtonSaleProduct;
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
    private javax.swing.JLabel jLabelQuantity;
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
    private javax.swing.JTextField jTextFieldAmountOrder;
    private javax.swing.JTextField jTextFieldDiscount;
    private javax.swing.JTextField jTextFieldOrderStatus;
    private javax.swing.JTextField jTextFieldQuantity;
    // End of variables declaration//GEN-END:variables
    private ProductController productController;
    private PersonController personController;
    private OrderController orderController;
}
