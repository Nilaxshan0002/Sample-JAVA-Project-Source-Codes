/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sejunitsample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
/**
 *
 * @author Snila
 */
public class GUIDemo3 extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private Object[][] sampleCustomers = {
        {1, "John Doe", "Colombo, Sri Lanka", "1990-05-15", "Male", "johndoe@example.com", "0771234567"},
        {2, "Jane Smith", "Galle, Sri Lanka", "1985-10-22", "Female", "janesmith@example.com", "0777654321"},
        {3, "Michael Fernando", "Kandy, Sri Lanka", "1995-07-30", "Male", "michaelf@example.com", "0711122334"},
        {4, "Susan Perera", "Negombo, Sri Lanka", "1992-11-12", "Female", "susanp@example.com", "0754455667"},
        {5, "David Silva", "Matara, Sri Lanka", "1988-03-08", "Male", "davids@example.com", "0789988776"}
    };
    
    /**
     * Creates new form GUIDemo3
     */
     public GUIDemo3() {
        initComponents();
        setSize(750, 650);
        initializeTable();
        loadSampleData();
        addButtonListeners();
        addFieldListeners();  // Add this to initialize extra listeners
        // Set default gender selection
        cboGender.setSelectedIndex(0);
    }

    private void initializeTable() {
    String[] columnNames = {"Customer_ID", "Name", "Address", "DOB", "Gender", "Email", "Contact_No"};
    tableModel = new DefaultTableModel(columnNames, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Make all cells non-editable
        }
        
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            // Optional: Add type safety for columns
            switch(columnIndex) {
                case 0: return Integer.class; // Customer_ID
                default: return String.class; // All other columns
            }
        }
    };
    jTable.setModel(tableModel);
}

    private void loadSampleData() {
        tableModel.setRowCount(0);
        for (Object[] customer : sampleCustomers) {
            tableModel.addRow(customer);
        }
    }

    private void addButtonListeners() {
        btnAdd.addActionListener(e -> addCustomer());
        btnUpdate.addActionListener(e -> updateCustomer());
        btnDelete.addActionListener(e -> deleteCustomer());
        btnSearch.addActionListener(e -> searchCustomer());
        btnClear.addActionListener(e -> clearFields());

        jTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jTable.getSelectedRow() != -1) {
                loadCustomerToFields(jTable.getSelectedRow());
            }
        });
    }

    private void addCustomer() {
        try {
            int id = Integer.parseInt(txtMessage1.getText());
            String name = txtMessage2.getText().trim();
            String address = txtMessage3.getText().trim();
            String dob = txtMessage4.getText().trim();
            String gender = cboGender.getSelectedItem().toString();
            String email = txtMessage6.getText().trim();
            String contactNo = txtMessage7.getText().trim();

            // Validate required fields
            if (name.isEmpty() || address.isEmpty() || dob.isEmpty() || email.isEmpty() || contactNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields");
                return;
            }

            // Validate email format
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address");
                return;
            }

            // Validate contact number
            if (!contactNo.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Contact number must be 10 digits");
                return;
            }

            // Check if ID already exists
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if ((int) tableModel.getValueAt(i, 0) == id) {
                    JOptionPane.showMessageDialog(this, "Customer ID already exists");
                    return;
                }
            }

            // Add new customer
            tableModel.addRow(new Object[]{id, name, address, dob, gender, email, contactNo});
            clearFields();
            JOptionPane.showMessageDialog(this, "Customer added successfully");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric Customer ID");
        }
    }

    private void updateCustomer() {
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer to update");
            return;
        }

        try {
            int id = Integer.parseInt(txtMessage1.getText());
            String name = txtMessage2.getText().trim();
            String address = txtMessage3.getText().trim();
            String dob = txtMessage4.getText().trim();
            String gender = cboGender.getSelectedItem().toString();
            String email = txtMessage6.getText().trim();
            String contactNo = txtMessage7.getText().trim();

            // Validate required fields
            if (name.isEmpty() || address.isEmpty() || dob.isEmpty() || email.isEmpty() || contactNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields");
                return;
            }

            // Validate email format
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address");
                return;
            }

            // Validate contact number
            if (!contactNo.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Contact number must be 10 digits");
                return;
            }

            // Update customer
            tableModel.setValueAt(id, selectedRow, 0);
            tableModel.setValueAt(name, selectedRow, 1);
            tableModel.setValueAt(address, selectedRow, 2);
            tableModel.setValueAt(dob, selectedRow, 3);
            tableModel.setValueAt(gender, selectedRow, 4);
            tableModel.setValueAt(email, selectedRow, 5);
            tableModel.setValueAt(contactNo, selectedRow, 6);

            JOptionPane.showMessageDialog(this, "Customer updated successfully");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric Customer ID");
        }
    }

    private void deleteCustomer() {
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer to delete");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this customer?",
            "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.removeRow(selectedRow);
            clearFields();
            JOptionPane.showMessageDialog(this, "Customer deleted successfully");
        }
    }

    private void searchCustomer() {
        String searchTerm = JOptionPane.showInputDialog(this, "Enter customer ID or name to search:");
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return;
        }

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String id = tableModel.getValueAt(i, 0).toString();
            String name = tableModel.getValueAt(i, 1).toString().toLowerCase();

            if (id.equals(searchTerm) || name.contains(searchTerm.toLowerCase())) {
                jTable.setRowSelectionInterval(i, i);
                jTable.scrollRectToVisible(jTable.getCellRect(i, 0, true));
                loadCustomerToFields(i);
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Customer not found");
    }

    private void loadCustomerToFields(int rowIndex) {
        txtMessage1.setText(tableModel.getValueAt(rowIndex, 0).toString());
        txtMessage2.setText(tableModel.getValueAt(rowIndex, 1).toString());
        txtMessage3.setText(tableModel.getValueAt(rowIndex, 2).toString());
        txtMessage4.setText(tableModel.getValueAt(rowIndex, 3).toString());
        cboGender.setSelectedItem(tableModel.getValueAt(rowIndex, 4).toString());
        txtMessage6.setText(tableModel.getValueAt(rowIndex, 5).toString());
        txtMessage7.setText(tableModel.getValueAt(rowIndex, 6).toString());
    }

    private void clearFields() {
        txtMessage1.setText("");
        txtMessage2.setText("");
        txtMessage3.setText("");
        txtMessage4.setText("");
        cboGender.setSelectedIndex(0);
        txtMessage6.setText("");
        txtMessage7.setText("");
        jTable.clearSelection();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblAddress = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCustomer_ID = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblContact_No = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtMessage4 = new javax.swing.JTextField();
        txtMessage3 = new javax.swing.JTextField();
        txtMessage2 = new javax.swing.JTextField();
        txtMessage6 = new javax.swing.JTextField();
        txtMessage1 = new javax.swing.JTextField();
        txtMessage7 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        cboGender = new javax.swing.JComboBox<>();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblAddress.setText("Address");
        getContentPane().add(lblAddress);
        lblAddress.setBounds(60, 170, 80, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Customer Management Page");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 10, 360, 50);

        lblCustomer_ID.setText("Customer_ID");
        getContentPane().add(lblCustomer_ID);
        lblCustomer_ID.setBounds(60, 70, 90, 30);

        lblDOB.setText("DOB");
        getContentPane().add(lblDOB);
        lblDOB.setBounds(60, 220, 37, 16);

        lblGender.setText("Gender");
        getContentPane().add(lblGender);
        lblGender.setBounds(60, 260, 70, 40);

        lblEmail.setText("Email");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(60, 320, 37, 16);

        lblContact_No.setText("Contact_No");
        getContentPane().add(lblContact_No);
        lblContact_No.setBounds(60, 360, 80, 30);

        lblName.setText("Name");
        getContentPane().add(lblName);
        lblName.setBounds(60, 120, 80, 30);

        btnUpdate.setText("Update");
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(180, 420, 72, 23);

        btnDelete.setText("Delete");
        getContentPane().add(btnDelete);
        btnDelete.setBounds(310, 420, 72, 23);

        btnSearch.setText("Search");
        getContentPane().add(btnSearch);
        btnSearch.setBounds(450, 420, 72, 23);

        btnClear.setText("Clear");
        getContentPane().add(btnClear);
        btnClear.setBounds(580, 420, 72, 23);

        btnAdd.setText("Add");
        getContentPane().add(btnAdd);
        btnAdd.setBounds(60, 420, 72, 23);
        getContentPane().add(txtMessage4);
        txtMessage4.setBounds(210, 220, 440, 30);
        getContentPane().add(txtMessage3);
        txtMessage3.setBounds(210, 170, 440, 30);
        getContentPane().add(txtMessage2);
        txtMessage2.setBounds(210, 120, 440, 30);
        getContentPane().add(txtMessage6);
        txtMessage6.setBounds(210, 320, 440, 30);

        txtMessage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessage1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtMessage1);
        txtMessage1.setBounds(210, 70, 440, 30);
        getContentPane().add(txtMessage7);
        txtMessage7.setBounds(210, 370, 440, 30);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer_ID ", "Name", "Address", "DOB", "Gender", "Email", "Contact_No"
            }
        ));
        jScrollPane2.setViewportView(jTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(60, 460, 590, 110);

        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        cboGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGenderActionPerformed(evt);
            }
        });
        getContentPane().add(cboGender);
        cboGender.setBounds(210, 270, 440, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    private void txtMessage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessage1ActionPerformed
        // TODO add your handling code here:
         try {
            Integer.parseInt(txtMessage1.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Customer ID must be a number");
            txtMessage1.requestFocus();
       }
    }//GEN-LAST:event_txtMessage1ActionPerformed

    private void cboGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGenderActionPerformed
        // Example: You could add gender-specific logic here if needed
        String selectedGender = cboGender.getSelectedItem().toString();
    // Any gender-specific handling would go here
    }//GEN-LAST:event_cboGenderActionPerformed

    // Add key listeners for better UX (optional)
private void addFieldListeners() {
    txtMessage1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (!Character.isDigit(evt.getKeyChar())) {
                evt.consume();
            }
        }
    });
    
    txtMessage7.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (!Character.isDigit(evt.getKeyChar()) || txtMessage7.getText().length() >= 10) {
                evt.consume();
            }
        }
    });
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDemo3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContact_No;
    private javax.swing.JLabel lblCustomer_ID;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtMessage1;
    private javax.swing.JTextField txtMessage2;
    private javax.swing.JTextField txtMessage3;
    private javax.swing.JTextField txtMessage4;
    private javax.swing.JTextField txtMessage6;
    private javax.swing.JTextField txtMessage7;
    // End of variables declaration//GEN-END:variables
}
