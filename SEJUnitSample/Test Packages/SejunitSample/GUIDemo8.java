/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sejunitsample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Snila
 */
public class GUIDemo8 extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private Object[][] sampleSalesData = {
        {"2023-01-01", 1250.50},
        {"2023-01-02", 1840.75},
        {"2023-01-03", 2100.00},
        {"2023-01-04", 1560.25},
        {"2023-01-05", 1980.60}
    };
    /**
     * Creates new form GUIDemo8
     */
    public GUIDemo8() {
        initComponents();
        setSize(600, 400);
        initializeTable();
        initializeReportTypes();
        addButtonListeners();
    }

     private void initializeTable() {
        String[] columnNames = {"Date", "Sales"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 1) return Double.class; // Sales column should be numeric
                return String.class;
            }
        };
        jTable5.setModel(tableModel);
    }

    private void initializeReportTypes() {
        cboReport.removeAllItems();
        cboReport.addItem("Select Report");
        cboReport.addItem("Daily Sales Report");
        cboReport.addItem("Weekly Sales Report");
        cboReport.addItem("Monthly Sales Report");
        cboReport.addItem("Yearly Sales Report");
    }

    private void addButtonListeners() {
        btnGenerate.addActionListener(e -> {
            String selectedReport = cboReport.getSelectedItem().toString();
            
            if (selectedReport.equals("Select Report")) {
                JOptionPane.showMessageDialog(this, "Please select a report type");
                return;
            }
            
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Generate sample data based on report type
            switch (selectedReport) {
                case "Daily Sales Report":
                    for (Object[] row : sampleSalesData) {
                        tableModel.addRow(row);
                    }
                    break;
                case "Weekly Sales Report":
                    tableModel.addRow(new Object[]{"Week 1, Jan 2023", 8750.00});
                    tableModel.addRow(new Object[]{"Week 2, Jan 2023", 10250.50});
                    break;
                case "Monthly Sales Report":
                    tableModel.addRow(new Object[]{"January 2023", 48730.25});
                    tableModel.addRow(new Object[]{"February 2023", 52340.75});
                    break;
                case "Yearly Sales Report":
                    tableModel.addRow(new Object[]{"2022", 458920.50});
                    tableModel.addRow(new Object[]{"2023", 512340.25});
                    break;
            }
            
            JOptionPane.showMessageDialog(this, selectedReport + " generated successfully");
        });

        btnExport.addActionListener(e -> {
            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No data to export. Please generate a report first.");
                return;
            }
            
            try {
                // Create a timestamp for the filename
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String timestamp = dateFormat.format(new Date());
                String fileName = "SalesReport_" + timestamp + ".csv";
                
                // Write data to CSV file
                FileWriter csvWriter = new FileWriter(fileName);
                
                // Write headers
                for (int i = 0; i < tableModel.getColumnCount(); i++) {
                    csvWriter.append(tableModel.getColumnName(i));
                    if (i < tableModel.getColumnCount() - 1) {
                        csvWriter.append(",");
                    }
                }
                csvWriter.append("\n");
                
                // Write data
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        csvWriter.append(tableModel.getValueAt(i, j).toString());
                        if (j < tableModel.getColumnCount() - 1) {
                            csvWriter.append(",");
                        }
                    }
                    csvWriter.append("\n");
                }
                
                csvWriter.flush();
                csvWriter.close();
                
                JOptionPane.showMessageDialog(this, "Report exported successfully as: " + fileName);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error exporting report: " + ex.getMessage());
            }
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
        cboReport = new javax.swing.JComboBox<>();
        btnGenerate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        btnExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Report Page");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 30, 150, 50);

        cboReport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Report" }));
        getContentPane().add(cboReport);
        cboReport.setBounds(40, 90, 320, 30);

        btnGenerate.setText("Generate");
        getContentPane().add(btnGenerate);
        btnGenerate.setBounds(370, 90, 80, 20);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date", "Sales"
            }
        ));
        jScrollPane1.setViewportView(jTable5);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 140, 410, 80);

        btnExport.setText("Export");
        getContentPane().add(btnExport);
        btnExport.setBounds(380, 240, 72, 23);

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
            java.util.logging.Logger.getLogger(GUIDemo8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDemo8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDemo8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDemo8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDemo8().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JComboBox<String> cboReport;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable5;
    // End of variables declaration//GEN-END:variables
}
