/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.draw.testers;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author vivekhegde
 */
public class test extends JFrame {

    /**
     * Creates new form test
     */
    public test() {
        initComponents();
    }

    JButton jDailogBotton;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jDialog1 = new JDialog();
        jLabel1 = new JLabel();
        jDailogBotton = new JButton();
        jLabel1.setText(" ok");


        jDailogBotton.setText("OK");

        jDialog1.getContentPane().setLayout(
                new BoxLayout(jDialog1.getContentPane(), BoxLayout.Y_AXIS));

        JPanel labelPanel = new JPanel();
        labelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPanel.setPreferredSize(new Dimension(jLabel1.getText().length()*8, 100));
        labelPanel.add(jLabel1);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setPreferredSize(new Dimension(50, 50));
        buttonPanel.setMaximumSize(new Dimension(50, 50)); // set max = pref
        buttonPanel.add(jDailogBotton);

        jDialog1.getContentPane().add(labelPanel);
        jDialog1.getContentPane().add(buttonPanel);
        jDialog1.setMinimumSize(new Dimension(jLabel1.getText().length()*8,90));

        pack();
        jDialog1.setVisible(true);
    }// </editor-fold>

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("hegde");
                //frame.setContentPane(new newForm());
            }
        });
    }

    // Variables declaration - do not modify
    private JDialog jDialog1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    // End of variables declaration
}
