package view.registers;

import controller.ProductController;

public class ProductRegisterView extends javax.swing.JInternalFrame {

    public ProductRegisterView() {
        this.controller = new ProductController();
        
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNewClient = new javax.swing.JLabel();

        setClosable(true);

        jLabelNewClient.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelNewClient.setText("Novo Produto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNewClient)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabelNewClient)
                .addContainerGap(555, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelNewClient;
    // End of variables declaration//GEN-END:variables
    private final ProductController controller;
}
