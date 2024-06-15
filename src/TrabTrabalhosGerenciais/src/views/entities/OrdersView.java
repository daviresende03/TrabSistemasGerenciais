package views.entities;

import application.viewModels.OrderVM;
import controllers.OrderController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrdersView extends javax.swing.JInternalFrame {

    public OrdersView() {
        this.orderController = new OrderController();
        
        initComponents();
        this.setVisible(true);
        this.resetScreen();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelNewOrder = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxOrdersFilter = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOrder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonConcludeOrder = new javax.swing.JButton();

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
        setTitle("LISTA DE PEDIDOS");

        jLabelNewOrder.setText("PEDIDOS");

        jLabel2.setText("Filtrar pedidos");

        jComboBoxOrdersFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aberto", "Faturado" }));
        jComboBoxOrdersFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrdersFilterActionPerformed(evt);
            }
        });

        jTableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Atendente", "Status", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableOrder.setShowGrid(false);
        jTableOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableOrder);
        jTableOrder.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableOrder.getColumnModel().getColumnCount() > 0) {
            jTableOrder.getColumnModel().getColumn(0).setResizable(false);
            jTableOrder.getColumnModel().getColumn(1).setResizable(false);
            jTableOrder.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTableOrder.getColumnModel().getColumn(2).setResizable(false);
            jTableOrder.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableOrder.getColumnModel().getColumn(3).setResizable(false);
            jTableOrder.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("TOTAL DE PEDIDOS EM ABERTO");

        jLabel3.setText("TOTAL DE PEDIDOS CONCLUÍDOS");

        jLabel4.setText("TOTAL DE PEDIDOS CANCELADOS");

        jButtonConcludeOrder.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonConcludeOrder.setText("FECHAR PEDIDO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonConcludeOrder))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNewOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxOrdersFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNewOrder)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxOrdersFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonConcludeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxOrdersFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrdersFilterActionPerformed
        this.loadOrderTableByDataBase();
    }//GEN-LAST:event_jComboBoxOrdersFilterActionPerformed

    private void resetScreen(){
        this.jComboBoxOrdersFilter.setSelectedIndex(0);
        this.loadOrderTableByDataBase();
    }
    
    private void loadOrderTableByDataBase(){
        boolean invoiced = this.jComboBoxOrdersFilter.getSelectedIndex()==1;
        List<OrderVM> orders = this.orderController.getAll(invoiced);
        
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableOrder.getModel();
        tableModel.setRowCount(0);
        
        for(OrderVM order : orders){
            String status = order.invoiced ? "FATURADO" : "ABERTO";
            String amount = String.format("R$ %.2f", order.amount);
            Object[] row = { order.id, order.customer.name, order.waiter.name, status, amount };
            tableModel.addRow(row);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConcludeOrder;
    private javax.swing.JComboBox<String> jComboBoxOrdersFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNewOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableOrder;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    private OrderController orderController;

}
