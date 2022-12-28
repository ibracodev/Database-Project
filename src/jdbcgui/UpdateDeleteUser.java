/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usama
 */
public class UpdateDeleteUser extends javax.swing.JFrame {

    /**
     * Creates new form UpdateDeleteUser
     */
     myDBCon dbCon;
     ResultSet rs;
    
     public String encrypt (String password){
          char[] pass = password.toCharArray();
          password ="";
          for (char c : pass ){
              c += 5;
              password+=c;
          }
         
          return password;
       }
     
     public String decrypt (String password){
          char[] pass = password.toCharArray();
          password ="";
          for (char c : pass ){
              c -= 5;
              password+=c;
          }
         
          return password;
       }


    
    public UpdateDeleteUser() {
        initComponents();
        
        this.setLocationRelativeTo(null);

        lblUserError.setVisible(false);
        lblNameErrror.setVisible(false);
        lblConfrimPassError.setVisible(false);
        lblNewPassError.setVisible(false);
        ;

        //populate mgr and deptno combo boxes 
         dbCon = new myDBCon();
         getNewData();
    }
     private void getNewData() {

        try {
            String str;
            
            rs = dbCon.executeStatement("SELECT DISTINCT type FROM loginusers ORDER BY type ASC ");
            cmbType.removeAllItems();
            while (rs.next()) {
                cmbType.addItem(rs.getString("type"));
            }

           
            rs= dbCon.executeStatement("Select DISTINCT  username,password,name,type from loginusers");
            rs.beforeFirst();
            rs.first();
            populateFields();
        } catch (SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Display selected username.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
     
      private void populateFields() {
        try {
            txtUser.setText(rs.getString("username"));
            txtName.setText(rs.getString("name"));
            txtNewPass.setText(decrypt(rs.getString("password")));
            cmbType.setSelectedItem(rs.getString("type"));
            txtConfirmPass.setText("");
    

            EnableDisableButtons();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeletePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      private void MoveNext() {
        try {
            // TODO add your handling code here:

            if (!rs.isLast()) {

                rs.next();
                populateFields();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeletePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        private void MovePrevious() {
        try {
            // TODO add your handling code here:

            if (!rs.isFirst()) {
                rs.previous();
                populateFields();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeletePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void EnableDisableButtons() {
        try {
            if (rs.isFirst()) {
                prevButton.setEnabled(false);
            } else {
                prevButton.setEnabled(true);
            }
            if (rs.isLast()) {
                nextButton.setEnabled(false);
            } else {
                nextButton.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeletePlayer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
          void clearErrorLabels() {
        lblUserError.setText("");
        lblUserError.setVisible(false);
        lblNameErrror.setText("");
        lblNameErrror.setVisible(false);
        lblNewPassError.setText("");
        lblNewPassError.setVisible(false);
        lblConfrimPassError.setText("");
        lblConfrimPassError.setVisible(false);
       

    }

           public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
     boolean isValidData() {

               clearErrorLabels();
        boolean result = true;
        if (txtUser.getText().trim().isEmpty() || (txtUser.getText().trim()).length() > 25) {
            if (txtUser.getText().trim().isEmpty()) {
                lblUserError.setText("Invalid. Cannot be empty.");
            } else if ((txtUser.getText().trim().length() > 25)) {
                lblUserError.setText("Invalid. Must be < 25 chars.");
            }

            lblUserError.setVisible(true);
            result = false;
        }

        if (txtNewPass.getText().trim().isEmpty() || (txtNewPass.getText().trim().length() > 25)) {
            if (txtNewPass.getText().trim().isEmpty()) {
                lblNewPassError.setText("Invalid. Cannot be empty.");
            } else if ((txtNewPass.getText().trim().length() > 10)) {
                lblNewPassError.setText("Invalid. Must be < 25 chars.");
            }

            lblNewPassError.setVisible(true);
            result = false;
        }

        if (txtConfirmPass.getText().trim().isEmpty() || (txtConfirmPass.getText().trim().length() > 25) || (!txtConfirmPass.getText().equals(txtNewPass.getText()))) {
            if (txtConfirmPass.getText().trim().isEmpty()) {
                lblConfrimPassError.setText("Invalid. Cannot be empty.");
            } else if (txtConfirmPass.getText().trim().length() > 25) {  ///dddddddddddddddddddddddddddddddddddddddddddddd
                lblConfrimPassError.setText("Invalid. Must be < 25 chars.");
            }
            else if (!txtConfirmPass.getText().equals(txtNewPass.getText())) {
                lblConfrimPassError.setText("Invalid. Does not match the password typed.");
            }
            lblConfrimPassError.setVisible(true);
            result = false;
        }
        if (txtName.getText().trim().isEmpty()|| (txtName.getText().trim().length() > 25)) {
            if (txtName.getText().trim().isEmpty()) {
            lblNameErrror.setText("Invalid. Cannot be empty.");
            }else if (txtName.getText().trim().length() > 25) {
                lblNameErrror.setText("Invalid. Must be < 25 chars.");
            }
            lblNameErrror.setVisible(true);
            result = false;
        }

        return result;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        cmbType = new javax.swing.JComboBox<>();
        txtNewPass = new javax.swing.JPasswordField();
        txtConfirmPass = new javax.swing.JPasswordField();
        showConfirmPass = new javax.swing.JCheckBox();
        showNewPass = new javax.swing.JCheckBox();
        lblNameErrror = new javax.swing.JLabel();
        lblUserError = new javax.swing.JLabel();
        lblNewPassError = new javax.swing.JLabel();
        lblConfrimPassError = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Update/Delete User");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Type");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Confirm Password");

        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });

        txtNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewPassActionPerformed(evt);
            }
        });

        showConfirmPass.setText("Show Password");
        showConfirmPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showConfirmPassActionPerformed(evt);
            }
        });

        showNewPass.setText("Show Password");
        showNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showNewPassActionPerformed(evt);
            }
        });

        lblNameErrror.setForeground(new java.awt.Color(255, 51, 51));
        lblNameErrror.setText("Error");

        lblUserError.setForeground(new java.awt.Color(255, 51, 51));
        lblUserError.setText("Error");

        lblNewPassError.setForeground(new java.awt.Color(255, 51, 51));
        lblNewPassError.setText("Error");

        lblConfrimPassError.setForeground(new java.awt.Color(255, 51, 51));
        lblConfrimPassError.setText("Error");

        updateButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prevButton.setText("Prev");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(prevButton)
                                .addGap(33, 33, 33)
                                .addComponent(updateButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtUser)
                                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(showNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(showConfirmPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblNameErrror)
                                                .addComponent(lblUserError))
                                            .addComponent(lblNewPassError)
                                            .addComponent(lblConfrimPassError)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameErrror))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showConfirmPass)
                            .addComponent(lblConfrimPassError)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(showNewPass)
                        .addComponent(lblNewPassError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prevButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showNewPassActionPerformed
        // TODO add your handling code here:
         if(showNewPass.isSelected()){
            txtNewPass.setEchoChar((char)0);
        }
        else {
            txtNewPass.setEchoChar('*');
        }
    }//GEN-LAST:event_showNewPassActionPerformed

    private void showConfirmPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showConfirmPassActionPerformed
        // TODO add your handling code here:
         if(showConfirmPass.isSelected()){
            txtConfirmPass.setEchoChar((char)0);
        }
        else {
            txtConfirmPass.setEchoChar('*');
        }
    }//GEN-LAST:event_showConfirmPassActionPerformed

    private void txtNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewPassActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
         try {
            // make the result set scrolable forward/backward updatable
//            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (isValidData()) {
                int result = JOptionPane.showConfirmDialog(this," Do you want to continue action?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION){
                     String strSQL =   "UPDATE loginusers SET  username = '"+txtUser.getText()+"' ,"+
                                    " password = '"+ encrypt(txtNewPass.getText())+ "' , "+
                                    " name = '" + txtName.getText()+ "' ," + 
                                    " type = "+ cmbType.getSelectedItem().toString()+" where username = '"+ txtUser.getText()+"'";
                                    
                     result = dbCon.executePrepared(strSQL);
                         if (result > 0){
                            javax.swing.JLabel label = new javax.swing.JLabel("Username " + txtUser.getText() + " updated successfully.");
                            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                            JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                            getNewData(); }
                         else {        
                         }
                }
               

              
                        
            } else {
                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error updating User." + e.getMessage());
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
         try {
            // make the result set scrolable forward/backward updatable
           
            String strSQL = "DELETE FROM loginusers WHERE username = '" + txtUser.getText().trim()+ "' " ;
            int result = JOptionPane.showConfirmDialog(this," Do you want to continue action?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION){
                
                result = dbCon.executePrepared(strSQL);
                 if(result > 0){
                javax.swing.JLabel label = new javax.swing.JLabel("Username " + txtUser.getText().trim() + " deleted successfully.");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                getNewData();
                }
                  else{
                    
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting user."+ e.getMessage());

        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        MoveNext();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
        MovePrevious();
    }//GEN-LAST:event_prevButtonActionPerformed

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTypeActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateDeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDeleteUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblConfrimPassError;
    private javax.swing.JLabel lblNameErrror;
    private javax.swing.JLabel lblNewPassError;
    private javax.swing.JLabel lblUserError;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton prevButton;
    private javax.swing.JCheckBox showConfirmPass;
    private javax.swing.JCheckBox showNewPass;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
