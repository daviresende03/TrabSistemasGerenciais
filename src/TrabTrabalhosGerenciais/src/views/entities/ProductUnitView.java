package views.entities;

public class ProductUnitView extends javax.swing.JInternalFrame {

    public ProductUnitView() {
        initComponents();
        this.setVisible(true);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelProductUnit.setText("UNIDADE DE PRODUTO");

        jLabelProductUnitName.setText("Nome");

        jTextFieldProductUnitName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductUnitNameActionPerformed(evt);
            }
        });

        jLabelProductUnitSymbol.setText("Símbolo");

        jTextFieldProductUnitSymbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductUnitSymbolActionPerformed(evt);
            }
        });

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
        jTableProductUnits.setColumnSelectionAllowed(true);
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

        jButtonEditProductUnit.setText("EDITAR");

        jButtonSaveProductUnit.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonSaveProductUnit.setText("SALVAR");

        jLabelProductUnitId.setText("Código");

        jTextFieldProductUnitId.setEnabled(false);

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
                                .addGap(0, 0, Short.MAX_VALUE))))
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
                .addGap(20, 20, 20)
                .addComponent(jLabelProductUnit)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonEditProductUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteProductUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveProductUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
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
}
