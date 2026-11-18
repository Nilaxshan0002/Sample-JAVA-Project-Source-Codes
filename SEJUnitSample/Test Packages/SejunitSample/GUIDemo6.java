/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sejunitsample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Snila
 */
public class GUIDemo6 extends javax.swing.JFrame {

    private DefaultTableModel orderTableModel;
    private Object[][] sampleProducts = {
        {"Laptop", 1200.00},
        {"Mouse", 25.50},
        {"Keyboard", 45.00},
        {"Monitor", 350.00},
        {"Headphones", 80.00}
    };
    
    private String[] customers = {
        "John Doe", 
        "Jane Smith", 
        "Michael Fernando", 
        "Susan Perera", 
        "David Silva"
    };
    
    /**
     * Creates new form GUIDemo6
     */
    public GUIDemo6() {
        initComponents();
        setSize(650, 500);
        setTitle("Order Creation Page");
        initializeOrderTable();
        initializeComponents();
        addButtonListeners();
    }
    
      private void initializeOrderTable() {
        String[] columnNames = {"Product", "Quantity", "Price"};
        orderTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1; // Only quantity column is editable
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 1) return Integer.class;
                if (columnIndex == 2) return Double.class;
                return String.class;
            }
        };
        orderTable.setModel(orderTableModel);
    }

    private void initializeComponents() {
        // Set current date
        txtOrderDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        txtOrderDate.setEditable(false);
        
        // Initialize customer combo box
        cboCustomer.removeAllItems();
        for (String customer : customers) {
            cboCustomer.addItem(customer);
        }
        
        // Initialize product combo box
        cboProduct.removeAllItems();
        for (Object[] product : sampleProducts) {
            cboProduct.addItem(product[0].toString());
        }
        
        // Set default quantity
        txtQuantity.setText("1");
    }

    private void addButtonListeners() {
        btnAddProduct.addActionListener(e -> addProductToOrder());
        btnRemoveProduct.addActionListener(e -> removeProductFromOrder());
        btnSubmitOrder.addActionListener(e -> submitOrder());
        btnCancel.addActionListener(e -> cancelOrder());
    }
    
    private void addProductToOrder() {
        String selectedProduct = (String) cboProduct.getSelectedItem();
        if (selectedProduct == null) {
            JOptionPane.showMessageDialog(this, "Please select a product");
            return;
        }

        try {
            int quantity = Integer.parseInt(txtQuantity.getText());
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0");
                return;
            }

            // Find product price
            double price = 0;
            for (Object[] product : sampleProducts) {
                if (product[0].equals(selectedProduct)) {
                    price = (double) product[1];
                    break;
                }
            }

            // Add to order table
            orderTableModel.addRow(new Object[]{
                selectedProduct,
                quantity,
                price
            });

            // Reset product selection and quantity
            cboProduct.setSelectedIndex(0);
            txtQuantity.setText("1");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity");
        }
    }
    
    private void removeProductFromOrder() {
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to remove");
            return;
        }
        orderTableModel.removeRow(selectedRow);
    }
    
    private void submitOrder() {
        if (orderTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please add products to the order");
            return;
        }

        String customer = (String) cboCustomer.getSelectedItem();
        if (customer == null || customer.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a customer");
            return;
        }

        // Calculate total
        double total = 0;
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order Confirmation\n\n");
        orderDetails.append("Customer: ").append(customer).append("\n");
        orderDetails.append("Date: ").append(txtOrderDate.getText()).append("\n\n");
        orderDetails.append("Products:\n");
        
        for (int i = 0; i < orderTableModel.getRowCount(); i++) {
            String product = (String) orderTableModel.getValueAt(i, 0);
            int quantity = (int) orderTableModel.getValueAt(i, 1);
            double price = (double) orderTableModel.getValueAt(i, 2);
            total += quantity * price;
            
            orderDetails.append(String.format("- %s x%d @ $%.2f\n", product, quantity, price));
        }
        
        orderDetails.append(String.format("\nTotal: $%.2f", total));

        int confirm = JOptionPane.showConfirmDialog(this, 
            orderDetails.toString(), 
            "Confirm Order", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Order submitted successfully!");
            resetOrderForm();
        }
    }
    
    private void cancelOrder() {
        if (orderTableModel.getRowCount() > 0) {
            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to cancel this order?",
                "Confirm Cancel",
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                resetOrderForm();
            }
        } else {
            resetOrderForm();
        }
    }

    private void resetOrderForm() {
        orderTableModel.setRowCount(0);
        cboCustomer.setSelectedIndex(0);
        cboProduct.setSelectedIndex(0);
        txtQuantity.setText("1");
        txtOrderDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
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
        lblOrderDate = new javax.swing.JLabel();
        lblProduct = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        cboSearchCustomer = new javax.swing.JComboBox<>();
        cboProduct = new javax.swing.JComboBox<>();
        lblQuantity1 = new javax.swing.JTextField();
        lblOrderDate1 = new javax.swing.JTextField();
        lblAddProducttoOrder = new javax.swing.JTextField();
        lblRemoveProduct = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Order Creation Page");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 10, 240, 50);

        lblCustomer.setText("Customer:");
        getContentPane().add(lblCustomer);
        lblCustomer.setBounds(50, 80, 53, 16);

        lblOrderDate.setText("Order Date:");
        getContentPane().add(lblOrderDate);
        lblOrderDate.setBounds(340, 80, 80, 16);

        lblProduct.setText("Product:");
        getContentPane().add(lblProduct);
        lblProduct.setBounds(50, 130, 45, 16);

        lblQuantity.setText("Quantity:");
        getContentPane().add(lblQuantity);
        lblQuantity.setBounds(50, 170, 60, 16);

        cboSearchCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "John Doe", "Jane Smith", "Michael Fernando", "Susan Perera", "David Silva" }));
        cboSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSearchCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(cboSearchCustomer);
        cboSearchCustomer.setBounds(150, 70, 140, 30);

        cboProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Mouse", "Keyboard", "Monitor", "Headphones" }));
        getContentPane().add(cboProduct);
        cboProduct.setBounds(150, 120, 140, 30);
        getContentPane().add(lblQuantity1);
        lblQuantity1.setBounds(150, 170, 140, 30);
        getContentPane().add(lblOrderDate1);
        lblOrderDate1.setBounds(430, 70, 140, 30);

        lblAddProducttoOrder.setText("Add Product to Order");
        getContentPane().add(lblAddProducttoOrder);
        lblAddProducttoOrder.setBounds(420, 120, 150, 30);

        lblRemoveProduct.setText("Remove Product");
        getContentPane().add(lblRemoveProduct);
        lblRemoveProduct.setBounds(420, 170, 150, 30);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable8);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 220, 530, 90);

        btnSubmit.setText("Submit Order");
        getContentPane().add(btnSubmit);
        btnSubmit.setBounds(370, 330, 101, 23);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(500, 330, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cboSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSearchCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSearchCustomerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GUIDemo6().setVisible(true);
        });
    }
        /* Set the Nimbus look and feel */      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDemo6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cboProduct;
    private javax.swing.JComboBox<String> cboSearchCustomer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextField lblAddProducttoOrder;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblOrderDate;
    private javax.swing.JTextField lblOrderDate1;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTextField lblQuantity1;
    private javax.swing.JTextField lblRemoveProduct;
    // End of variables declaration//GEN-END:variables
}
