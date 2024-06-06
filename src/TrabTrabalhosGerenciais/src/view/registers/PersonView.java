package view.registers;

import controller.PersonController;
import controller.viewModels.PersonVM;
import domain.Utils.DateUtil;
import javax.swing.JOptionPane;
import domain.model.entities.ResponseService;
import domain.model.enums.ResponseTypeEnum;

public class PersonView extends javax.swing.JInternalFrame {

    public PersonView() {
        initComponents();
        this.setVisible(true);
        
        this.personController = new PersonController();
        this.clearForm();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelNewUser = new javax.swing.JLabel();
        jLabelPersonalData = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jRadioButtonPJ = new javax.swing.JRadioButton();
        jRadioButtonPF = new javax.swing.JRadioButton();
        jLabelDocument = new javax.swing.JLabel();
        jTextFieldDocument = new javax.swing.JTextField();
        jLabelBirthDate = new javax.swing.JLabel();
        jTextFieldBirthDate = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabelStreet = new javax.swing.JLabel();
        jTextFieldStreet = new javax.swing.JTextField();
        jLabelNumber = new javax.swing.JLabel();
        jTextFieldNumber = new javax.swing.JTextField();
        jLabelNeighborhood = new javax.swing.JLabel();
        jTextFieldNeighborhood = new javax.swing.JTextField();
        jLabelCountry = new javax.swing.JLabel();
        jTextFieldCountry = new javax.swing.JTextField();
        jLabelCity = new javax.swing.JLabel();
        jTextFieldCity = new javax.swing.JTextField();
        jLabelState = new javax.swing.JLabel();
        jTextFieldState = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPostalCode = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelObservations = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObservations = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelFunction = new javax.swing.JLabel();
        jCheckBoxCustomer = new javax.swing.JCheckBox();
        jCheckBoxStaff = new javax.swing.JCheckBox();
        jCheckBoxSupplier = new javax.swing.JCheckBox();
        jButtonDeleteUser = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jButtonSaveForm = new javax.swing.JButton();
        jButtonEditForm = new javax.swing.JButton();
        jButtonClearFields = new javax.swing.JButton();

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
        setTitle("Novo usuário");

        jLabelNewUser.setText("NOVO USUÁRIO");

        jLabelPersonalData.setText("DADOS PESSOAIS");

        jLabelName.setText("Nome");

        jRadioButtonPJ.setText("PJ");

        jRadioButtonPF.setText("PF");

        jLabelDocument.setText("Documento");

        jLabelBirthDate.setText("Data de Nascimento");

        jLabel2.setText("ENDEREÇO");

        jLabelStreet.setText("Logradouro");

        jLabelNumber.setText("Nº");

        jLabelNeighborhood.setText("Bairro");

        jLabelCountry.setText("País");

        jLabelCity.setText("Cidade");

        jLabelState.setText("UF");

        jLabel3.setText("CEP");

        jLabelObservations.setText("OBSERVAÇÕES");

        jTextAreaObservations.setColumns(20);
        jTextAreaObservations.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObservations);

        jLabelFunction.setText("FUNÇÃO");

        jCheckBoxCustomer.setText("Cliente");

        jCheckBoxStaff.setText("Colaborador");

        jCheckBoxSupplier.setText("Fornecedor");

        jButtonDeleteUser.setText("EXCLUIR");

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Tipo", "Cliente", "Fornecedor", "Colaborador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setResizable(false);
            usersTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            usersTable.getColumnModel().getColumn(1).setResizable(false);
            usersTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            usersTable.getColumnModel().getColumn(2).setResizable(false);
            usersTable.getColumnModel().getColumn(2).setPreferredWidth(10);
            usersTable.getColumnModel().getColumn(3).setResizable(false);
            usersTable.getColumnModel().getColumn(3).setPreferredWidth(10);
            usersTable.getColumnModel().getColumn(4).setResizable(false);
            usersTable.getColumnModel().getColumn(4).setPreferredWidth(10);
            usersTable.getColumnModel().getColumn(5).setResizable(false);
            usersTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        jButtonSaveForm.setText("SALVAR");
        jButtonSaveForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveFormMouseClicked(evt);
            }
        });

        jButtonEditForm.setText("EDITAR");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSaveForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEditForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDeleteUser))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelStreet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldStreet)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelDocument)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDocument)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelBirthDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBirthDate))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonPF)
                        .addGap(10, 10, 10)
                        .addComponent(jRadioButtonPJ))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabelPersonalData))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelObservations, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFunction)
                                .addGap(25, 25, 25)
                                .addComponent(jCheckBoxCustomer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxStaff)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxSupplier))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNewUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClearFields))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCity)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelState)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldState, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNeighborhood)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNeighborhood)
                                .addGap(26, 26, 26)
                                .addComponent(jLabelCountry)
                                .addGap(5, 5, 5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTextFieldCountry)))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClearFields)
                    .addComponent(jLabelNewUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPersonalData)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonPJ)
                    .addComponent(jRadioButtonPF))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocument)
                    .addComponent(jTextFieldDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBirthDate)
                    .addComponent(jTextFieldBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStreet)
                    .addComponent(jTextFieldStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumber)
                    .addComponent(jTextFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNeighborhood)
                    .addComponent(jTextFieldNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCountry)
                    .addComponent(jTextFieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCity)
                    .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelState)
                    .addComponent(jTextFieldState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelObservations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFunction)
                    .addComponent(jCheckBoxCustomer)
                    .addComponent(jCheckBoxStaff)
                    .addComponent(jCheckBoxSupplier))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeleteUser)
                    .addComponent(jButtonSaveForm)
                    .addComponent(jButtonEditForm))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveFormMouseClicked
        PersonVM personForm = getPersonByForm();
        this.personController.create(personForm);
        
        ResponseService response = this.personController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, response.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.clearForm();
        }
    }//GEN-LAST:event_jButtonSaveFormMouseClicked

    private void jButtonClearFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearFieldsMouseClicked
        this.clearForm();
    }//GEN-LAST:event_jButtonClearFieldsMouseClicked

    private void clearForm(){
        this.jTextFieldName.setText("");
        this.jTextFieldDocument.setText("");
        this.jTextFieldBirthDate.setText("");
        this.jTextFieldStreet.setText("");
        this.jTextFieldNumber.setText("");
        this.jTextFieldNeighborhood.setText("");
        this.jTextFieldCity.setText("");
        this.jTextFieldState.setText("");
        this.jTextFieldCountry.setText("");
        this.jTextFieldPostalCode.setText("");
        this.jTextAreaObservations.setText("");
        
        this.jRadioButtonPF.setSelected(true);
        this.jRadioButtonPJ.setSelected(false);
        
        this.jCheckBoxCustomer.setSelected(false);
        this.jCheckBoxStaff.setSelected(false);
        this.jCheckBoxSupplier.setSelected(false);
        
        this.jTextFieldName.requestFocusInWindow();
    }
    
    private PersonVM getPersonByForm(){
        PersonVM personForm = new PersonVM();
        
        personForm.name = this.jTextFieldName.getText();
        personForm.document = this.jTextFieldDocument.getText();
        personForm.birthDate = DateUtil.dateToString(this.jTextFieldBirthDate.getText());
        personForm.street = this.jTextFieldStreet.getText();
        personForm.number = this.jTextFieldNumber.getText();
        personForm.neighborhood = this.jTextFieldNeighborhood.getText();
        personForm.city = this.jTextFieldCity.getText();
        personForm.state = this.jTextFieldState.getText();
        personForm.country = this.jTextFieldCountry.getText();
        personForm.postalCode = this.jTextFieldPostalCode.getText();
        personForm.observation = this.jTextAreaObservations.getText();
        
        personForm.type = this.jRadioButtonPF.isSelected() ? 1 : 2;
        
        personForm.customer = this.jCheckBoxCustomer.isSelected();
        personForm.staff = this.jCheckBoxStaff.isSelected();
        personForm.supplier = this.jCheckBoxSupplier.isSelected();
                
        return personForm;
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClearFields;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonEditForm;
    private javax.swing.JButton jButtonSaveForm;
    private javax.swing.JCheckBox jCheckBoxCustomer;
    private javax.swing.JCheckBox jCheckBoxStaff;
    private javax.swing.JCheckBox jCheckBoxSupplier;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBirthDate;
    private javax.swing.JLabel jLabelCity;
    private javax.swing.JLabel jLabelCountry;
    private javax.swing.JLabel jLabelDocument;
    private javax.swing.JLabel jLabelFunction;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNeighborhood;
    private javax.swing.JLabel jLabelNewUser;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelObservations;
    private javax.swing.JLabel jLabelPersonalData;
    private javax.swing.JLabel jLabelState;
    private javax.swing.JLabel jLabelStreet;
    private javax.swing.JRadioButton jRadioButtonPF;
    private javax.swing.JRadioButton jRadioButtonPJ;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaObservations;
    private javax.swing.JTextField jTextFieldBirthDate;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldCountry;
    private javax.swing.JTextField jTextFieldDocument;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNeighborhood;
    private javax.swing.JTextField jTextFieldNumber;
    private javax.swing.JTextField jTextFieldPostalCode;
    private javax.swing.JTextField jTextFieldState;
    private javax.swing.JTextField jTextFieldStreet;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
    private PersonController personController;
}
