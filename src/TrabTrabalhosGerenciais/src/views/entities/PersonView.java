package views.entities;

import controllers.PersonController;
import application.viewModels.PersonVM;
import domain.utils.DateUtil;
import javax.swing.JOptionPane;
import domain.model.entities.ResponseService;
import domain.model.enums.ResponseTypeEnum;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PersonView extends javax.swing.JInternalFrame {

    public PersonView() {
        initComponents();
        this.setVisible(true);
        
        this.personController = new PersonController();
        this.clearForm();
        this.loadPersonTableByDataBase();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
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
        jButtonSaveUser = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableUsers = new javax.swing.JTable();
        jButtonDeleteUser = new javax.swing.JButton();
        jButtonEditForm = new javax.swing.JButton();
        jButtonClearFields = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jLabelId = new javax.swing.JLabel();

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

        jLabelTitle.setText("NOVO USUÁRIO");

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

        jLabelObservations.setText("Observações");

        jTextAreaObservations.setColumns(20);
        jTextAreaObservations.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObservations);

        jLabelFunction.setText("FUNÇÃO");

        jCheckBoxCustomer.setText("Cliente");

        jCheckBoxStaff.setText("Colaborador");

        jCheckBoxSupplier.setText("Fornecedor");

        jButtonSaveUser.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonSaveUser.setText("SALVAR");
        jButtonSaveUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSaveUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveUserMouseClicked(evt);
            }
        });

        jTableUsers.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableUsers.setCellSelectionEnabled(false);
        jTableUsers.setRowSelectionAllowed(true);
        jTableUsers.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableUsers);
        jTableUsers.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableUsers.getColumnModel().getColumnCount() > 0) {
            jTableUsers.getColumnModel().getColumn(0).setResizable(false);
            jTableUsers.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTableUsers.getColumnModel().getColumn(1).setResizable(false);
            jTableUsers.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTableUsers.getColumnModel().getColumn(2).setResizable(false);
            jTableUsers.getColumnModel().getColumn(2).setPreferredWidth(10);
            jTableUsers.getColumnModel().getColumn(3).setResizable(false);
            jTableUsers.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTableUsers.getColumnModel().getColumn(4).setResizable(false);
            jTableUsers.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTableUsers.getColumnModel().getColumn(5).setResizable(false);
            jTableUsers.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        jButtonDeleteUser.setText("EXCLUIR");
        jButtonDeleteUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteUserMouseClicked(evt);
            }
        });

        jButtonEditForm.setText("EDITAR");
        jButtonEditForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditFormMouseClicked(evt);
            }
        });

        jButtonClearFields.setText("LIMPAR CAMPOS");
        jButtonClearFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonClearFieldsMouseClicked(evt);
            }
        });

        jTextFieldId.setEnabled(false);

        jLabelId.setText("Código");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDeleteUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEditForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSaveUser))
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
                        .addComponent(jLabelId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFunction)
                                .addGap(25, 25, 25)
                                .addComponent(jCheckBoxCustomer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxStaff))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelObservations)
                                .addGap(28, 28, 28)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxSupplier))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
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
                    .addComponent(jButtonClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPersonalData)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonPJ)
                    .addComponent(jRadioButtonPF)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelId))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocument)
                    .addComponent(jTextFieldDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBirthDate)
                    .addComponent(jTextFieldBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
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
                .addGap(20, 20, 20)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelObservations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFunction)
                    .addComponent(jCheckBoxCustomer)
                    .addComponent(jCheckBoxStaff)
                    .addComponent(jCheckBoxSupplier))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButtonEditForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSaveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearFieldsMouseClicked
        this.clearForm();
    }//GEN-LAST:event_jButtonClearFieldsMouseClicked

    private void jButtonEditFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditFormMouseClicked
        int lineSelected = this.jTableUsers.getSelectedRow();
        if(lineSelected<0){
            JOptionPane.showMessageDialog(null, "Primeiramente é necessário selecionar o registro que deseja alterar." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        this.clearForm();
        
        int id = (int)this.jTableUsers.getValueAt(lineSelected, 0);
        
        PersonVM person = this.personController.get(id);
        ResponseService response = this.personController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        completeForm(person);
        this.jLabelTitle.setText("Edição de Usuário");
        this.jButtonEditForm.setEnabled(false);
        
    }//GEN-LAST:event_jButtonEditFormMouseClicked

    private void jButtonDeleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteUserMouseClicked
        int lineSelected = this.jTableUsers.getSelectedRow();
        if(lineSelected<0){
            JOptionPane.showMessageDialog(null, "Primeiramente é necessário selecionar o registro que deseja deletar." , "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int id = (int)this.jTableUsers.getValueAt(lineSelected, 0);
        this.personController.delete(id);
        
        ResponseService response = this.personController.getResponseService();
        
        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, response.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.loadPersonTableByDataBase();
        }
    }//GEN-LAST:event_jButtonDeleteUserMouseClicked

    private void jButtonSaveUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveUserMouseClicked
        PersonVM personForm = getPersonByForm();
        int personId = Integer.parseInt(this.jTextFieldId.getText().isEmpty() ? "0" : this.jTextFieldId.getText());
        
        if(personId == 0){
            this.personController.create(personForm);
        }else{
            personForm.id = personId;
            this.personController.update(personForm);
        }
        
        ResponseService response = this.personController.getResponseService();

        if(response.getType() != ResponseTypeEnum.SUCCESS){
            JOptionPane.showMessageDialog(null, response.getMessage() , "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, response.getMessage() , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.clearForm();
            this.loadPersonTableByDataBase();
            this.jButtonEditForm.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonSaveUserMouseClicked

    private void completeForm(PersonVM person){
        this.jTextFieldId.setText(Integer.toString(person.id));        
        this.jTextFieldName.setText(person.name);
        this.jTextFieldDocument.setText(person.document);
        this.jTextFieldBirthDate.setText(DateUtil.dateToString(person.birthDate));
        this.jTextFieldStreet.setText(person.street);
        this.jTextFieldNumber.setText(person.number);
        this.jTextFieldNeighborhood.setText(person.neighborhood);
        this.jTextFieldCity.setText(person.city);
        this.jTextFieldState.setText(person.state);
        this.jTextFieldCountry.setText(person.country);
        this.jTextFieldPostalCode.setText(person.postalCode);
        this.jTextAreaObservations.setText(person.observation);
        
        this.jRadioButtonPF.setSelected(person.type == 1);
        this.jRadioButtonPJ.setSelected(!this.jRadioButtonPF.isSelected());
        
        this.jCheckBoxCustomer.setSelected(person.customer);
        this.jCheckBoxStaff.setSelected(person.staff);
        this.jCheckBoxSupplier.setSelected(person.supplier);
    }
    
    private void clearForm(){
        this.jTextFieldId.setText("");
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
        
        this.jLabelTitle.setText("Novo Usuário");
        this.jButtonEditForm.setEnabled(true);
    }
    
    private PersonVM getPersonByForm(){
        PersonVM personForm = new PersonVM();
        
        personForm.name = this.jTextFieldName.getText();
        personForm.document = this.jTextFieldDocument.getText();
        personForm.birthDate = DateUtil.stringToDate(this.jTextFieldBirthDate.getText());
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
    
    private void loadPersonTableByDataBase(){
        DefaultTableModel tableModel = (DefaultTableModel) this.jTableUsers.getModel();
        tableModel.setRowCount(0);
        
        List<PersonVM> people = this.personController.getAll();
        for (PersonVM person : people) {
            String personType = person.type == 1 ? "PF" : "PJ";
            String isCustomer = person.customer ? "SIM" : "NÃO";
            String isStaff = person.staff ? "SIM" : "NÃO";
            String isSupplier = person.supplier ? "SIM" : "NÃO";
            
            Object[] row = {person.id, person.name, personType, isCustomer, isSupplier, isStaff};

            tableModel.addRow(row);
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClearFields;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonEditForm;
    private javax.swing.JButton jButtonSaveUser;
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
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNeighborhood;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelObservations;
    private javax.swing.JLabel jLabelPersonalData;
    private javax.swing.JLabel jLabelState;
    private javax.swing.JLabel jLabelStreet;
    private javax.swing.JLabel jLabelTitle;
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
    private javax.swing.JTable jTableUsers;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaObservations;
    private javax.swing.JTextField jTextFieldBirthDate;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldCountry;
    private javax.swing.JTextField jTextFieldDocument;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNeighborhood;
    private javax.swing.JTextField jTextFieldNumber;
    private javax.swing.JTextField jTextFieldPostalCode;
    private javax.swing.JTextField jTextFieldState;
    private javax.swing.JTextField jTextFieldStreet;
    // End of variables declaration//GEN-END:variables
    private PersonController personController;
}
