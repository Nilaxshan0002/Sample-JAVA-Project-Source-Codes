/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sejunitsample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Snila
 */
public class GUIDemo9 extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private Object[][] sampleUsers = {
        {1, "admin", "Admin"},
        {2, "manager1", "Manager"},
        {3, "cashier1", "Cashier"},
        {4, "stock1", "Stock Manager"},
        {5, "account1", "Accountant"}
    };
    /**
     * Creates new form GUIDemo9
     */
   public GUIDemo9() {
        initComponents();
        setSize(600, 450);
        initializeTable();
        loadSampleData();
        addButtonListeners();
    }

    private void initializeTable() {
        String[] columnNames = {"User_ID", "Username", "Role"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        jTable6.setModel(tableModel);
    }

    private void loadSampleData() {
        tableModel.setRowCount(0);
        for (Object[] user : sampleUsers) {
            tableModel.addRow(user);
        }
    }

    private void addButtonListeners() {
        btnAdd.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtUser_ID.getText());
                String username = txtUsername.getText();
                String password = new String(txtPassword.getText()); // In real app, you'd hash this
                String role = cboRole.getSelectedItem().toString();

                // Validate required fields
                if (username.isEmpty() || password.isEmpty() || role.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all fields");
                    return;
                }

                // Add new user to the table
                tableModel.addRow(new Object[]{id, username, role});
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid User ID (number)");
            }
        });

        btnUpdate.addActionListener(e -> {
            int selectedRow = jTable6.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to update");
                return;
            }

            try {
                int id = Integer.parseInt(txtUser_ID.getText());
                String username = txtUsername.getText();
                String password = new String(txtPassword.getText()); // In real app, you'd hash this
                String role = cboRole.getSelectedItem().toString();

                // Update the selected row
                tableModel.setValueAt(id, selectedRow, 0);
                tableModel.setValueAt(username, selectedRow, 1);
                tableModel.setValueAt(role, selectedRow, 2);

                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid User ID (number)");
            }
        });

        btnDelete.addActionListener(e -> {
            int selectedRow = jTable6.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to delete");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this user?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
                clearFields();
            }
        });

        btnSearch.addActionListener(e -> {
            String searchTerm = JOptionPane.showInputDialog(this, "Enter user ID or username to search:");
            if (searchTerm == null || searchTerm.trim().isEmpty()) return;

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String id = tableModel.getValueAt(i, 0).toString();
                String username = tableModel.getValueAt(i, 1).toString().toLowerCase();

                if (id.equals(searchTerm) || username.contains(searchTerm.toLowerCase())) {
                    jTable6.setRowSelectionInterval(i, i);
                    jTable6.scrollRectToVisible(jTable6.getCellRect(i, 0, true));

                    // Populate fields with selected user data
                    txtUser_ID.setText(id);
                    txtUsername.setText(tableModel.getValueAt(i, 1).toString());
                    cboRole.setSelectedItem(tableModel.getValueAt(i, 2).toString());
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "User not found");
        });

        btnClear.addActionListener(e -> {
            clearFields();
        });

        // Add table selection listener to populate fields when a row is selected
        jTable6.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = jTable6.getSelectedRow();
                if (selectedRow != -1) {
                    txtUser_ID.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    txtUsername.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    cboRole.setSelectedItem(tableModel.getValueAt(selectedRow, 2).toString());
                }
            }
        });
    }

    private void clearFields() {
        txtUser_ID.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        cboRole.setSelectedIndex(0);
        jTable6.clearSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblUser_ID = new javax.swing.JLabel();
        lblIsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUser_ID = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        lblRole = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Optional Page");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 30, 180, 50);

        lblUser_ID.setText("User_ID");
        getContentPane().add(lblUser_ID);
        lblUser_ID.setBounds(90, 90, 70, 20);

        lblIsername.setText("Username");
        getContentPane().add(lblIsername);
        lblIsername.setBounds(90, 130, 53, 16);

        lblPassword.setText("Password");
        getContentPane().add(lblPassword);
        lblPassword.setBounds(90, 180, 50, 16);
        getContentPane().add(txtUser_ID);
        txtUser_ID.setBounds(190, 90, 350, 30);
        getContentPane().add(txtUsername);
        txtUsername.setBounds(190, 130, 350, 30);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(190, 180, 350, 30);

        lblRole.setText("Role");
        getContentPane().add(lblRole);
        lblRole.setBounds(90, 220, 40, 20);

        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Manager", "Cashier", "Stock Manager", "Accountant", "Viewer", " " }));
        getContentPane().add(cboRole);
        cboRole.setBounds(190, 220, 350, 30);

        btnAdd.setText("Add");
        getContentPane().add(btnAdd);
        btnAdd.setBounds(90, 260, 72, 23);

        btnUpdate.setText("Update");
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(190, 260, 72, 23);

        btnDelete.setText("Delete");
        getContentPane().add(btnDelete);
        btnDelete.setBounds(290, 260, 72, 23);

        btnSearch.setText("Search");
        getContentPane().add(btnSearch);
        btnSearch.setBounds(380, 260, 72, 23);

        btnClear.setText("Clear");
        getContentPane().add(btnClear);
        btnClear.setBounds(470, 260, 72, 23);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "User_ID", "Username", "Role"
            }
        ));
        jScrollPane1.setViewportView(jTable6);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 300, 460, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIDemo9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDemo9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDemo9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDemo9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDemo9().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable6;
    private javax.swing.JLabel lblIsername;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUser_ID;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUser_ID;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
