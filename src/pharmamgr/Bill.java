/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmamgr;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static pharmamgr.Inventory.buildTableModel;

/**
 *
 * @author Local User
 */
public class Bill extends javax.swing.JFrame {
    public static final String userInSesh = new Login().userInSesh;
    /**
     * Creates new form Bill
     */
    public Bill() {
        initComponents();
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
          this.setLocationRelativeTo(null);
          uname_label.setText(userInSesh);
          invoice.setEditable(false);

                        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","");            
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from cart");
            JTable table = new JTable(buildTableModel(rs));
            if(cart.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "There are no medicines.");
            }
            cart.setModel(table.getModel());
            System.out.println("Got model");
//            cart.setModel(DbUtils.resultSetToTableModel(rs));
          }
          catch(Exception e){
              System.out.println(e.toString());
          }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        remove_button = new javax.swing.JButton();
        checkout_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        totalamt_textfield = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoice = new javax.swing.JTextArea();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        uname_label = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back.setText("Back to inventory");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Cart and invoice");

        cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cart.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(cart);
        if (cart.getColumnModel().getColumnCount() > 0) {
            cart.getColumnModel().getColumn(0).setResizable(false);
            cart.getColumnModel().getColumn(1).setResizable(false);
            cart.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setText("Cart");

        remove_button.setText("Remove item");
        remove_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_buttonActionPerformed(evt);
            }
        });

        checkout_button.setText("Checkout");
        checkout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkout_buttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jLabel2.setText("Total: ");

        totalamt_textfield.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        totalamt_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalamt_textfieldActionPerformed(evt);
            }
        });

        invoice.setColumns(20);
        invoice.setRows(5);
        jScrollPane2.setViewportView(invoice);

        label1.setFont(new java.awt.Font("Humnst777 Blk BT", 0, 12)); // NOI18N
        label1.setText("Invoice");

        label2.setText("Current user: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalamt_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(uname_label, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(remove_button)
                                        .addGap(18, 18, 18)
                                        .addComponent(checkout_button)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(142, 142, 142))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(remove_button)
                            .addComponent(checkout_button)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalamt_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(back)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uname_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_backActionPerformed

    private void remove_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_buttonActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(null, "The selected stock item will be removed. Do you want to continue?", "Remove medicine", JOptionPane.YES_NO_OPTION);
        if(response == 0)
        {
            DefaultTableModel model = (DefaultTableModel) cart.getModel();
            System.out.println(cart.getSelectedRow());
            String med = (String) model.getValueAt(cart.getSelectedRow(), 0);
            int qty = (int) model.getValueAt(cart.getSelectedRow(), 1);
            try 
            {
//                int qtyInt;
//                qtyInt = Integer.parseInt(qty);
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","");
                PreparedStatement pstmt=con.prepareStatement("delete from cart where medicine=?");
                pstmt.setString(1, med);
                pstmt.executeUpdate();
                PreparedStatement pstmt1=con.prepareStatement("update medicine set quantity=quantity+? where name=?");
                pstmt1.setInt(1, qty);
                pstmt1.setString(2, med);
                pstmt.executeUpdate();
                pstmt1.executeUpdate();
                model.removeRow(cart.getSelectedRow());
                JOptionPane.showMessageDialog(null,"Item removed successfully");
            } 
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(null,ex.toString());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Item not removed.");
        }
    }//GEN-LAST:event_remove_buttonActionPerformed

    private void checkout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkout_buttonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) cart.getModel();
        try 
        {
            totalamt_textfield.setEditable(false);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","");
            PreparedStatement stmt=con.prepareStatement("select * from cart");
            ResultSet rs=stmt.executeQuery();
            rs=stmt.executeQuery();
            int total = 0;
            if(cart.getRowCount() >0)
            {
                for(int i = 0; i < cart.getRowCount(); i++)
                {
                    total = total + (int)model.getValueAt(i, 2);
                }
                
                invoice.append("Medicine\tQuantity\tPrice\n");
                while(rs.next())
                {
                    invoice.append(rs.getString("Medicine") + "\t" + rs.getString("Quantity") +"\t" + rs.getString("Price") + "\n");
                }
                totalamt_textfield.setText(Integer.toString(total));
                
                
                PreparedStatement stmtdel = con.prepareStatement("delete from cart");
                stmtdel.executeUpdate();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
    

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cart is empty. Please buy medicines.");
            }
        } 
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_checkout_buttonActionPerformed

    private void totalamt_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalamt_textfieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_totalamt_textfieldActionPerformed

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
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill().setVisible(true);

                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTable cart;
    private javax.swing.JButton checkout_button;
    private javax.swing.JTextArea invoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JButton remove_button;
    private javax.swing.JTextField totalamt_textfield;
    private java.awt.Label uname_label;
    // End of variables declaration//GEN-END:variables
}
