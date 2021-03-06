/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.User;
import service.UserService;

/**
 *
 * @author Toàn
 */
public class ListUser extends javax.swing.JFrame {
    UserService userService;
    DefaultTableModel defaultTableModel;
    /**
     * Creates new form ListUer
     */
    public ListUser() throws SQLException {
        initComponents();
        userService = new UserService();
        defaultTableModel= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            } 
        };
        
        
        userTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("name");
        defaultTableModel.addColumn("phone");
        defaultTableModel.addColumn("user");
        defaultTableModel.addColumn("pass");
        defaultTableModel.addColumn("role");
        defaultTableModel.addColumn("favorite");
        defaultTableModel.addColumn("about");
        

        
        setTableData(userService.getAllUser());
        
    }
    private void setTableData( List<User> users){
        for(User user: users){
            
            defaultTableModel.addRow(new Object[]{user.getId(),user.getName(),user.getPhone(),user.getUsername(),user.getPass()
            ,user.getRole(),user.getFavorite(),user.getAbout()});
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

        addUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        f5 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        editUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addUser.setText("Add");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        userTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(userTable);

        f5.setText("F5");
        f5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f5ActionPerformed(evt);
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        editUser.setText("Edit User");
        editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(editUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editUser, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(f5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void f5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f5ActionPerformed
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0); 
        try {
            setTableData(userService.getAllUser());
        } catch (SQLException ex) {
            Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_f5ActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        // TODO add your handling code here:
        

        new AddUser().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addUserActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int row =userTable.getSelectedRow();
        if( row == -1 ){
            
            JOptionPane.showMessageDialog(ListUser.this,"You did not select anything to delete","Error",JOptionPane.ERROR_MESSAGE);
       
        } else {
            int confirm = JOptionPane.showConfirmDialog(ListUser.this," are you sure you want to delete");
            if (confirm==JOptionPane.YES_OPTION){
                int userId= Integer.valueOf(String.valueOf(userTable.getValueAt(row, 0)));
                try {
                    userService.deleteUser(userId);
                } catch (SQLException ex) {
                    Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                defaultTableModel.setRowCount(0); 
                try {
                    setTableData(userService.getAllUser());
                } catch (SQLException ex) {
                    Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_deleteActionPerformed

    private void editUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserActionPerformed
        // TODO add your handling code here:
        int row =userTable.getSelectedRow();
        if( row == -1 ){
            
            JOptionPane.showMessageDialog(ListUser.this,"You did not select anything to Edit","Error",JOptionPane.ERROR_MESSAGE);
       
        } else{
             int userId= Integer.valueOf(String.valueOf(userTable.getValueAt(row, 0)));
            try {
                new EditUser(userId).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
            }
             this.dispose();
           
        }
    }//GEN-LAST:event_editUserActionPerformed

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
            java.util.logging.Logger.getLogger(ListUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListUser().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUser;
    private javax.swing.JButton delete;
    private javax.swing.JButton editUser;
    private javax.swing.JButton f5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
