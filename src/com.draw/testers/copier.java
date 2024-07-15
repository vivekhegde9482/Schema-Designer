package com.draw.testers;

import javax.swing.*;
import java.awt.*;

public class copier {


    private void in(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(
                new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel a = new JPanel();
        a.setAlignmentX(Component.CENTER_ALIGNMENT);
        a.setPreferredSize(new Dimension(100, 100));
        a.setMaximumSize(new Dimension(100, 100)); // set max = pref
        a.setBorder(BorderFactory.createTitledBorder("aa"));
        JPanel b = new JPanel();
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setPreferredSize(new Dimension(50, 50));
        b.setMaximumSize(new Dimension(50, 50)); // set max = pref
        b.setBorder(BorderFactory.createTitledBorder("bb"));

        frame.getContentPane().add(a);
        frame.getContentPane().add(b);
        frame.pack();
        frame.setVisible(true);
    }
//
//    private void initComponents() {
//
//        jDialog1 = new javax.swing.JDialog();
//        jLabel1 = new javax.swing.JLabel();
//        jButton1 = new javax.swing.JButton();
//        jPanel1 = new javax.swing.JPanel();
//
//        jLabel1.setText("jLabel1");
//
//        jButton1.setText("jButton1");
//
//        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
//        jDialog1.getContentPane().setLayout(jDialog1Layout);
//        jDialog1Layout.setHorizontalGroup(
//                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jDialog1Layout.createSequentialGroup()
//                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(jDialog1Layout.createSequentialGroup()
//                                                .addGap(175, 175, 175)
//                                                .addComponent(jLabel1))
//                                        .addGroup(jDialog1Layout.createSequentialGroup()
//                                                .addGap(157, 157, 157)
//                                                .addComponent(jButton1)))
//                                .addContainerGap(165, Short.MAX_VALUE))
//        );
//        jDialog1Layout.setVerticalGroup(
//                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jDialog1Layout.createSequentialGroup()
//                                .addGap(25, 25, 25)
//                                .addComponent(jLabel1)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
//                                .addComponent(jButton1)
//                                .addGap(23, 23, 23))
//        );
//
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel1Layout.setVerticalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 400, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 300, Short.MAX_VALUE)
//        );
//
//        pack();
//    }// </editor-fold>

}
