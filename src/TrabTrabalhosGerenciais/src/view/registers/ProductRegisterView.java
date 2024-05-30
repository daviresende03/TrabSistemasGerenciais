package view.registers;

import controller.ProductController;
import controller.viewModels.ProductVM;
import javax.swing.JOptionPane;
import model.entities.ResponseService;
import model.enums.ResponseTypeEnum;

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
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jLabelNewClient.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelNewClient.setText("Novo Produto");

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNewClient)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabelNewClient)
                .addGap(64, 64, 64)
                .addComponent(jButton1)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        /*ResponseService response = controller.create(p);
        
        if(response.getType() == ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, response.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelNewClient;
    // End of variables declaration//GEN-END:variables
    private final ProductController controller;
}
