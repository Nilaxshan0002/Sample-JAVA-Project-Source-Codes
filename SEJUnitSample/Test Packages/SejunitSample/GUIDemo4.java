/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sejunitsample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Snila
 */
public class GUIDemo4 extends javax.swing.JFrame {
// Table model for displaying category data
    private DefaultTableModel tableModel;
    private List<Category> categories = new ArrayList<>();
    
    
    // Category class to hold data
    class Category {
        int id;
        String name;
        String description;
        
        public Category(int id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
        
        public Object[] toArray() {
            return new Object[]{id, name, description};
        }
    }

    /**
     * Creates new form GUIDemo4
     */
    public GUIDemo4() {
        initComponents();
        setSize(650, 550);
        initializeTable();
        loadSampleData();
        addButtonListeners();
    }

    private void initializeTable() {
        String[] columnNames = {"Category_ID", "Category_Name", "Description"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable2.setModel(tableModel);
    }
    
    private void loadSampleData() {
        categories.clear();
        tableModel.setRowCount(0);
        
        // Add sample categories
        categories.add(new Category(1, "Electronics", "Electronic devices and accessories"));
        categories.add(new Category(2, "Clothing", "Men's and women's clothing"));
        categories.add(new Category(3, "Groceries", "Food and household items"));
        categories.add(new Category(4, "Furniture", "Home and office furniture"));
        categories.add(new Category(5, "Books", "Educational and recreational books"));
        
        for (Category category : categories) {
            tableModel.addRow(category.toArray());
        }
    }
    
    private void addButtonListeners() {
        btnAdd.addActionListener(e -> addCategory());
        btnUpdate.addActionListener(e -> updateCategory());
        btnDelete.addActionListener(e -> deleteCategory());
        btnSearch.addActionListener(e -> searchCategory());
        btnClear.addActionListener(e -> clearFields());
        
        jTable2.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jTable2.getSelectedRow() != -1) {
                loadCategoryToFields(jTable2.getSelectedRow());
            }
        });
    }
    
    private void addCategory() {
        try {
            int id = Integer.parseInt(txtMessage1.getText());
            String name = txtMessage2.getText().trim();
            String description = txtMessage3.getText().trim();
            
            if (name.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
                return;
            }
            
            // Check if ID already exists
            for (Category cat : categories) {
                if (cat.id == id) {
                    JOptionPane.showMessageDialog(this, "Category ID already exists");
                    return;
                }
            }
            
            Category newCategory = new Category(id, name, description);
            categories.add(newCategory);
            tableModel.addRow(newCategory.toArray());
            
            clearFields();
            JOptionPane.showMessageDialog(this, "Category added successfully");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID");
        }
    }
    
    private void updateCategory() {
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a category to update");
            return;
        }
        
        try {
            int id = Integer.parseInt(txtMessage1.getText());
            String name = txtMessage2.getText().trim();
            String description = txtMessage3.getText().trim();
            
            if (name.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
                return;
            }
            
            Category updatedCategory = new Category(id, name, description);
            categories.set(selectedRow, updatedCategory);
            
            // Update table
            tableModel.setValueAt(id, selectedRow, 0);
            tableModel.setValueAt(name, selectedRow, 1);
            tableModel.setValueAt(description, selectedRow, 2);
            
            JOptionPane.showMessageDialog(this, "Category updated successfully");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID");
        }
    }
    
    private void deleteCategory() {
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a category to delete");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this category?",
            "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            categories.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            clearFields();
            JOptionPane.showMessageDialog(this, "Category deleted successfully");
        }
    }
    
    private void searchCategory() {
        String searchTerm = txtMessage2.getText().trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term");
            return;
        }
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String name = tableModel.getValueAt(i, 1).toString().toLowerCase();
            String id = tableModel.getValueAt(i, 0).toString();
            
            if (name.contains(searchTerm) || id.equals(searchTerm)) {
                jTable2.setRowSelectionInterval(i, i);
                jTable2.scrollRectToVisible(jTable2.getCellRect(i, 0, true));
                loadCategoryToFields(i);
                return;
            }
        }
        
        JOptionPane.showMessageDialog(this, "No matching category found");
    }
    
    private void loadCategoryToFields(int rowIndex) {
        txtMessage1.setText(tableModel.getValueAt(rowIndex, 0).toString());
        txtMessage2.setText(tableModel.getValueAt(rowIndex, 1).toString());
        txtMessage3.setText(tableModel.getValueAt(rowIndex, 2).toString());
    }
    
    private void clearFields() {
        txtMessage1.setText("");
        txtMessage2.setText("");
        txtMessage3.setText("");
        jTable2.clearSelection();
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
        lblCategory_Name = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblCategory_ID = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtMessage3 = new javax.swing.JTextField();
        txtMessage2 = new javax.swing.JTextField();
        txtMessage1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Category Management Page");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 30, 360, 50);

        lblCategory_Name.setText("Category_Name");
        getContentPane().add(lblCategory_Name);
        lblCategory_Name.setBounds(70, 170, 90, 30);

        lblDescription.setText("Description");
        getContentPane().add(lblDescription);
        lblDescription.setBounds(70, 230, 90, 30);

        lblCategory_ID.setText("Category_ID");
        getContentPane().add(lblCategory_ID);
        lblCategory_ID.setBounds(70, 110, 90, 30);

        btnAdd.setText("Add");
        getContentPane().add(btnAdd);
        btnAdd.setBounds(70, 310, 72, 23);

        btnUpdate.setText("Update");
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(180, 310, 72, 23);

        btnDelete.setText("Delete");
        getContentPane().add(btnDelete);
        btnDelete.setBounds(280, 310, 72, 23);

        btnSearch.setText("Search");
        getContentPane().add(btnSearch);
        btnSearch.setBounds(370, 310, 72, 23);

        btnClear.setText("Clear");
        getContentPane().add(btnClear);
        btnClear.setBounds(460, 310, 72, 23);
        getContentPane().add(txtMessage3);
        txtMessage3.setBounds(230, 230, 300, 30);
        getContentPane().add(txtMessage2);
        txtMessage2.setBounds(230, 170, 300, 30);
        getContentPane().add(txtMessage1);
        txtMessage1.setBounds(230, 110, 300, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Category_ID", "Category_Name"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 360, 460, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDemo4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblCategory_ID;
    private javax.swing.JLabel lblCategory_Name;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JTextField txtMessage1;
    private javax.swing.JTextField txtMessage2;
    private javax.swing.JTextField txtMessage3;
    // End of variables declaration//GEN-END:variables
}
