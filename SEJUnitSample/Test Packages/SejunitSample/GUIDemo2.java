/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sejunitsample;

import javax.swing.*;
/**
 *
 * @author Snila
 */
public class GUIDemo2 extends javax.swing.JFrame {
    /**
     * Creates new form GUIDemo2
     */
    public GUIDemo2() {
        initComponents();
        setSize(800, 500);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addButtonListeners();
    }

    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPro = new javax.swing.JButton();
        btnCate = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnLog = new javax.swing.JButton();
        btnCus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Home Page");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 20, 150, 60);

        btnPro.setText("Product Management");
        getContentPane().add(btnPro);
        btnPro.setBounds(260, 100, 210, 40);

        btnCate.setText("Category Management");
        getContentPane().add(btnCate);
        btnCate.setBounds(500, 103, 190, 40);

        btnOrder.setText("Order Management");
        getContentPane().add(btnOrder);
        btnOrder.setBounds(170, 160, 190, 40);

        btnReport.setText("Reports");
        getContentPane().add(btnReport);
        btnReport.setBounds(420, 160, 130, 40);

        btnLog.setText("Logout");
        getContentPane().add(btnLog);
        btnLog.setBounds(310, 220, 130, 40);

        btnCus.setText("Customer Management ");
        getContentPane().add(btnCus);
        btnCus.setBounds(40, 100, 200, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addButtonListeners() {
        // Customer Management Button
        btnCus.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Customer Management Page would open here");
        });


        // Product Management Button
        btnPro.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Product Management Page would open here");
        });

        // Category Management Button
        btnCate.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Category Management Page would open here");
        });

        // Order Management Button
        btnOrder.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Order Management Page would open here");
        });

        // Reports Button
        btnReport.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Reports Page would open here");
        });


        // Logout Button
        btnLog.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                this, 
                "Are you sure you want to logout?", 
                "Confirm Logout", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                // For demo, just show a login message
                JOptionPane.showMessageDialog(this, "Logging out...");
                // In a real app, you would open the login window here
                // new GUIDemo1().setVisible(true);
                // this.dispose();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GUIDemo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDemo2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCate;
    private javax.swing.JButton btnCus;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnPro;
    private javax.swing.JButton btnReport;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
