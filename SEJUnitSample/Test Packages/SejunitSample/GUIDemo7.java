/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sejunitsample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Snila
 */
public class GUIDemo7 extends javax.swing.JFrame {

     private DefaultTableModel tableModel;
    private Object[][] sampleOrderData = {
        {"Laptop", 2, "2023-05-10 14:30:00"},
        {"Mouse", 5, "2023-05-10 14:30:00"},
        {"Keyboard", 3, "2023-05-10 14:30:00"},
        {"Monitor", 1, "2023-05-11 10:15:00"},
        {"Headphones", 4, "2023-05-12 16:45:00"}
    };
    /**
     * Creates new form GUIDemo7
     */
     public GUIDemo7() {
        initComponents();
        setSize(600, 400);
        initializeTable();
        addButtonListeners();
    }

      private void initializeTable() {
        String[] columnNames = {"Products", "Quantity", "Order date & time"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 1) return Integer.class; // Quantity column should be numeric
                return String.class;
            }
        };
        jTable4.setModel(tableModel);
    }

    private void addButtonListeners() {
        btnSearch.addActionListener(e -> {
            String customerName = txtCustomer.getText().trim();
            
            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a customer name");
                return;
            }
            
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Simulate searching for customer orders
            // In a real application, this would query a database
            boolean found = false;
            for (Object[] order : sampleOrderData) {
                // Simple simulation - in reality you'd match with customer ID/name
                if (customerName.equalsIgnoreCase("John Doe") || 
                    customerName.equalsIgnoreCase("Jane Smith")) {
                    tableModel.addRow(order);
                    found = true;
                }
            }
            
            if (!found) {
                JOptionPane.showMessageDialog(this, "No orders found for customer: " + customerName);
            } else {
                JOptionPane.showMessageDialog(this, "Found " + tableModel.getRowCount() + " orders for " + customerName);
            }
        });

        btnDelete.addActionListener(e -> {
            int selectedRow = jTable4.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an order to delete");
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this order?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Order deleted successfully");
            }
        });

        btnPrint.addActionListener(e -> {
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No orders to print");
                return;
            }
            
            // Generate a simple print preview
            StringBuilder printContent = new StringBuilder();
            printContent.append("Order Details Report\n");
            printContent.append("Customer: ").append(txtCustomer.getText()).append("\n");
            printContent.append("Generated on: ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("\n\n");
            
            // Add headers
            printContent.append(String.format("%-20s %-10s %-20s\n", 
                "Product", "Quantity", "Order Date/Time"));
            printContent.append("------------------------------------------------\n");
            
            // Add order details
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                printContent.append(String.format("%-20s %-10s %-20s\n",
                    tableModel.getValueAt(i, 0),
                    tableModel.getValueAt(i, 1),
                    tableModel.getValueAt(i, 2)));
            }
            
            // Show print preview (in a real app, you'd send to printer)
            JTextArea printArea = new JTextArea(printContent.toString());
            JOptionPane.showMessageDialog(this, new JScrollPane(printArea), 
                "Print Preview", JOptionPane.INFORMATION_MESSAGE);
        });
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
        lblCustomer = new javax.swing.JLabel();
        txtCustomer = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Order Details");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 20, 180, 50);

        lblCustomer.setText("Customer");
        getContentPane().add(lblCustomer);
        lblCustomer.setBounds(50, 80, 70, 20);
        getContentPane().add(txtCustomer);
        txtCustomer.setBounds(140, 80, 270, 30);

        btnSearch.setText("Search");
        getContentPane().add(btnSearch);
        btnSearch.setBounds(440, 80, 72, 23);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Products", "Quantity", "Order date & time"
            }
        ));
        jScrollPane1.setViewportView(jTable4);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 140, 460, 150);

        btnDelete.setText("Delete");
        getContentPane().add(btnDelete);
        btnDelete.setBounds(340, 300, 72, 23);

        btnPrint.setText("Print");
        getContentPane().add(btnPrint);
        btnPrint.setBounds(430, 300, 75, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDemo7().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JTextField txtCustomer;
    // End of variables declaration//GEN-END:variables
}
