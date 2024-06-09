package view.entities;

public class ProductUnitView extends javax.swing.JFrame {

    public ProductUnitView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelProductUnitName = new javax.swing.JLabel();
        jTextFieldProductUnitName = new javax.swing.JTextField();
        jLabelProductUnitSymbol = new javax.swing.JLabel();
        jTextFieldProductUnitSymbol = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductUnits = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CÓDIGO DA UNIDADE");

        jLabelProductUnitName.setText("NOME");

        jTextFieldProductUnitName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductUnitNameActionPerformed(evt);
            }
        });

        jLabelProductUnitSymbol.setText("SÍMBOLO");

        jTextFieldProductUnitSymbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductUnitSymbolActionPerformed(evt);
            }
        });

        jTableProductUnits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "SÍMBOLO"
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
        jScrollPane1.setViewportView(jTableProductUnits);
        if (jTableProductUnits.getColumnModel().getColumnCount() > 0) {
            jTableProductUnits.getColumnModel().getColumn(0).setResizable(false);
            jTableProductUnits.getColumnModel().getColumn(1).setResizable(false);
            jTableProductUnits.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableProductUnits.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelProductUnitName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProductUnitName)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelProductUnitSymbol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProductUnitSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProductUnitName)
                    .addComponent(jTextFieldProductUnitName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProductUnitSymbol)
                    .addComponent(jTextFieldProductUnitSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldProductUnitSymbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductUnitSymbolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductUnitSymbolActionPerformed

    private void jTextFieldProductUnitNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductUnitNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductUnitNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelProductUnitName;
    private javax.swing.JLabel jLabelProductUnitSymbol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductUnits;
    private javax.swing.JTextField jTextFieldProductUnitName;
    private javax.swing.JTextField jTextFieldProductUnitSymbol;
    // End of variables declaration//GEN-END:variables
}
