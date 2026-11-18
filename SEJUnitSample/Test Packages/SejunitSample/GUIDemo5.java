/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sejunitsample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Snila
 */
public class GUIDemo5 extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private List<Product> products = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    
    // Product class to hold data
    class Product {
        int id;
        String name;
        double unitPrice;
        int quantity;
        String category;
        
        public Product(int id, String name, double unitPrice, int quantity, String category) {
            this.id = id;
            this.name = name;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
            this.category = category;
        }
        
        public Object[] toArray() {
            return new Object[]{id, name, unitPrice, quantity, category};
        }
    }
    
    class Category {
        int id;
        String name;
        
        public Category(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }

    public GUIDemo5() {
        initComponents();
        setSize(750, 600);
        initializeTable();
        loadSampleData();
        addButtonListeners();
        setupCategoryComboBox();
    }

    private void setupCategoryComboBox() {
        cboCategory.removeAllItems();
        cboCategory.addItem(new Category(0, "-- Select Category --"));
    }

    private void initializeTable() {
        String[] columnNames = {"Product_ID", "Product_Name", "Unit_Price", "Quantity", "Category"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch(columnIndex) {
                    case 0: return Integer.class;
                    case 2: return Double.class;
                    case 3: return Integer.class;
                    default: return String.class;
                }
            }
        };
        jTable3.setModel(tableModel);
    }
    
    private void loadSampleData() {
        products.clear();
        categories.clear();
        tableModel.setRowCount(0);
        
        // Initialize categories
        categories.add(new Category(1, "Bakery"));
        categories.add(new Category(2, "Beverage"));
        categories.add(new Category(3, "Pharmacy"));
        categories.add(new Category(4, "Meat"));
        categories.add(new Category(5, "Seafood"));
        
        // Populate dropdown
        cboCategory.removeAllItems();
        cboCategory.addItem(new Category(0, "-- Select Category --"));
        categories.forEach(cboCategory::addItem);
        
        // Add sample products
        addProduct(new Product(1, "White Bread", 120.00, 50, "Bakery"));
        addProduct(new Product(2, "Orange Juice", 250.00, 30, "Beverage"));
        addProduct(new Product(3, "Paracetamol", 50.00, 100, "Pharmacy"));
        addProduct(new Product(4, "Chicken Breast", 850.00, 20, "Meat"));
        addProduct(new Product(5, "Salmon Fish", 1500.00, 15, "Seafood"));
    }
    
    private void addProduct(Product product) {
        products.add(product);
        tableModel.addRow(product.toArray());
    }
    
    private void addButtonListeners() {
        btnAdd.addActionListener(e -> addProduct());
        btnUpdate.addActionListener(e -> updateProduct());
        btnDelete.addActionListener(e -> deleteProduct());
        btnSearch.addActionListener(e -> searchProduct());
        btnClear.addActionListener(e -> clearFields());
        
        jTable3.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jTable3.getSelectedRow() != -1) {
                loadProductToFields(jTable3.getSelectedRow());
            }
        });
    }
    
    private void addProduct() {
        try {
            int id = Integer.parseInt(txtMessage1.getText());
            String name = txtMessage2.getText().trim();
            double price = Double.parseDouble(txtMessage3.getText());
            int quantity = Integer.parseInt(txtMessage4.getText());
            Category category = (Category) cboCategory.getSelectedItem();
            
            if (name.isEmpty() || category.id == 0) {
                throw new IllegalArgumentException("Please fill all fields");
            }
            if (price <= 0 || quantity < 0) {
                throw new IllegalArgumentException("Price must be positive and quantity non-negative");
            }
            
            // Check for duplicate ID
            for (Product p : products) {
                if (p.id == id) {
                    throw new IllegalArgumentException("Product ID already exists");
                }
            }
            
            addProduct(new Product(id, name, price, quantity, category.name));
            clearFields();
            JOptionPane.showMessageDialog(this, "Product added successfully");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void updateProduct() {
        int row = jTable3.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product");
            return;
        }
        
        try {
            int id = Integer.parseInt(txtMessage1.getText());
            String name = txtMessage2.getText().trim();
            double price = Double.parseDouble(txtMessage3.getText());
            int quantity = Integer.parseInt(txtMessage4.getText());
            Category category = (Category) cboCategory.getSelectedItem();
            
            if (name.isEmpty() || category.id == 0) {
                throw new IllegalArgumentException("Please fill all fields");
            }
            if (price <= 0 || quantity < 0) {
                throw new IllegalArgumentException("Price must be positive and quantity non-negative");
            }
            
            Product updated = new Product(id, name, price, quantity, category.name);
            products.set(row, updated);
            
            for (int i = 0; i < 5; i++) {
                tableModel.setValueAt(updated.toArray()[i], row, i);
            }
            
            JOptionPane.showMessageDialog(this, "Product updated successfully");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void deleteProduct() {
        int row = jTable3.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Delete this product?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            products.remove(row);
            tableModel.removeRow(row);
            clearFields();
            JOptionPane.showMessageDialog(this, "Product deleted successfully");
        }
    }
    
    private void searchProduct() {
        String term = JOptionPane.showInputDialog(this, "Enter product name or ID:");
        if (term == null || term.trim().isEmpty()) return;
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String id = tableModel.getValueAt(i, 0).toString();
            String name = tableModel.getValueAt(i, 1).toString().toLowerCase();
            
            if (id.equals(term) || name.contains(term.toLowerCase())) {
                jTable3.setRowSelectionInterval(i, i);
                jTable3.scrollRectToVisible(jTable3.getCellRect(i, 0, true));
                loadProductToFields(i);
                return;
            }
        }
        
        JOptionPane.showMessageDialog(this, "Product not found");
    }
    
    private void loadProductToFields(int row) {
        txtMessage1.setText(tableModel.getValueAt(row, 0).toString());
        txtMessage2.setText(tableModel.getValueAt(row, 1).toString());
        txtMessage3.setText(tableModel.getValueAt(row, 2).toString());
        txtMessage4.setText(tableModel.getValueAt(row, 3).toString());
        
        String category = tableModel.getValueAt(row, 4).toString();
        for (int i = 0; i < cboCategory.getItemCount(); i++) {
            if (cboCategory.getItemAt(i).toString().equals(category)) {
                cboCategory.setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void clearFields() {
        txtMessage1.setText("");
        txtMessage2.setText("");
        txtMessage3.setText("");
        txtMessage4.setText("");
        cboCategory.setSelectedIndex(0);
        jTable3.clearSelection();
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
        jLabel2 = new javax.swing.JLabel();
        lblProduct_Name = new javax.swing.JLabel();
        lblUnit_Price = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblProduct_ID = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtMessage2 = new javax.swing.JTextField();
        txtMessage3 = new javax.swing.JTextField();
        txtMessage4 = new javax.swing.JTextField();
        txtMessage1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        cboCategory = new javax.swing.JComboBox<>();

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Product Management Page");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 40, 360, 50);

        lblProduct_Name.setText("Product_Name");
        getContentPane().add(lblProduct_Name);
        lblProduct_Name.setBounds(60, 160, 90, 30);

        lblUnit_Price.setText("Unit_Price");
        getContentPane().add(lblUnit_Price);
        lblUnit_Price.setBounds(60, 210, 90, 30);

        lblQuantity.setText("Quantity");
        getContentPane().add(lblQuantity);
        lblQuantity.setBounds(60, 260, 90, 30);

        lblCategory.setText("Category");
        getContentPane().add(lblCategory);
        lblCategory.setBounds(60, 310, 90, 30);

        lblProduct_ID.setText("Product_ID");
        getContentPane().add(lblProduct_ID);
        lblProduct_ID.setBounds(60, 110, 90, 30);

        btnAdd.setText("Add");
        getContentPane().add(btnAdd);
        btnAdd.setBounds(60, 370, 72, 23);

        btnUpdate.setText("Update");
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(160, 370, 72, 23);

        btnDelete.setText("Delete");
        getContentPane().add(btnDelete);
        btnDelete.setBounds(260, 370, 72, 23);

        btnSearch.setText("Search");
        getContentPane().add(btnSearch);
        btnSearch.setBounds(360, 370, 72, 23);

        btnClear.setText("Clear");
        getContentPane().add(btnClear);
        btnClear.setBounds(460, 370, 72, 23);
        getContentPane().add(txtMessage2);
        txtMessage2.setBounds(190, 160, 330, 30);
        getContentPane().add(txtMessage3);
        txtMessage3.setBounds(190, 210, 330, 30);
        getContentPane().add(txtMessage4);
        txtMessage4.setBounds(190, 260, 330, 30);
        getContentPane().add(txtMessage1);
        txtMessage1.setBounds(190, 110, 330, 30);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product_ID", "Product_Name", "Unit_Price ", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(jTable3);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(60, 410, 470, 160);

        cboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electronics ", "Clothing ", "Groceries  ", "Furniture ", "Books" }));
        cboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(cboCategory);
        cboCategory.setBounds(190, 310, 330, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoryActionPerformed
         // Filter products by category if needed
        if (cboCategory.getSelectedIndex() > 0) {
            // Implement filtering logic if required
        }
       }
    }//GEN-LAST:event_cboCategoryActionPerformed
                       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GUIDemo5().setVisible(true);
        });
    }
              
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDemo5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblProduct_ID;
    private javax.swing.JLabel lblProduct_Name;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblUnit_Price;
    private javax.swing.JTextField txtMessage1;
    private javax.swing.JTextField txtMessage2;
    private javax.swing.JTextField txtMessage3;
    private javax.swing.JTextField txtMessage4;
    // End of variables declaration//GEN-END:variables
}
