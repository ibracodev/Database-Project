/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcgui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ibrahim
 */
public class AddMatches extends javax.swing.JFrame {

    /**
     * Creates new form AddMatches
     */
    
    myDBCon dbCon;
    ResultSet rs;
    
    public AddMatches() {
        initComponents();
        this.setLocationRelativeTo(null);
        
         lblErrorMatchNo.setVisible(false);
        lblErrorHome.setVisible(false);
        lblErrorVisitor.setVisible(false);
        try {
          
            dbCon = new myDBCon();
          
            rs = dbCon.executeStatement("SELECT team_id from teams ORDER BY team_id ASC");
             
            cmbHome.removeAllItems();          
            while (rs.next()) {
                cmbHome.addItem(rs.getString("team_id"));
            }
            
            rs = dbCon.executeStatement("SELECT team_id from teams ORDER BY team_id ASC");
             
            cmbVisitor.removeAllItems();          
            while (rs.next()) {
                cmbVisitor.addItem(rs.getString("team_id"));
            }
            
            rs = dbCon.executeStatement("SELECT DISTINCT result from Match ORDER BY result ASC");
             
            cmbResult.removeAllItems();          
            while (rs.next()) {
                cmbResult.addItem(rs.getString("result"));
            } 
                   
            
            rs = dbCon.executeStatement("SELECT match_number home, visitor, result from Match ORDER BY Match_Number ASC");
            
                rs.beforeFirst();
                rs.first();
                populateFields();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

     private void populateFields() {
        try {
            cmbHome.setSelectedItem(rs.getString("home"));
            cmbVisitor.setSelectedItem(rs.getString("visitor")); 
            cmbResult.setSelectedItem(rs.getString("result"));
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeletePlayer.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbHome = new javax.swing.JComboBox<>();
        txtMatchNo = new javax.swing.JTextField();
        cmbVisitor = new javax.swing.JComboBox<>();
        cmbResult = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        lblErrorMatchNo = new javax.swing.JLabel();
        txtHomeGoals = new javax.swing.JTextField();
        txtVisitGoals = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblErrorHome = new javax.swing.JLabel();
        lblErrorVisitor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Match");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Home:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Away:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Result:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Match Number:");

        cmbHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        cmbVisitor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblErrorMatchNo.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorMatchNo.setText("Error");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Home Goals:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Visitor Goals:");

        lblErrorHome.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorHome.setText("Error");

        lblErrorVisitor.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorVisitor.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMatchNo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(69, 69, 69)
                                .addComponent(cmbHome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbVisitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHomeGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtVisitGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrorMatchNo)
                            .addComponent(lblErrorHome)
                            .addComponent(lblErrorVisitor))))
                .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(btnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbVisitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtHomeGoals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblErrorHome)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVisitGoals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lblErrorVisitor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMatchNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorMatchNo))
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
          try {
            if (isValidData()) {
                String prepSQL = "INSERT INTO match (home, home_goals, visitor, visitor_goals, result, match_number) VALUES ("
                + cmbHome.getSelectedItem() + ","
                + txtHomeGoals.getText().trim() + ", "       
                + cmbVisitor.getSelectedItem()+ ", "
                + txtVisitGoals.getText().trim() + ", "        
                + cmbResult.getSelectedItem()+ ", "
                + txtMatchNo.getText().trim()+ ")";
                
                int result = dbCon.executePrepared(prepSQL);
                if (result > 0) {

                    javax.swing.JLabel label = new javax.swing.JLabel("New match added successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                    clearInputBoxes();
                } else {
                    // check validation errors 
                }

                rs.close();
            } else {

                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding new match." + e.getMessage());
        }
    }//GEN-LAST:event_btnAddActionPerformed

     void clearInputBoxes() {
        txtMatchNo.setText("");
        cmbHome.setSelectedIndex(0);
        cmbResult.setSelectedIndex(0);
        cmbVisitor.setSelectedIndex(0);
        txtHomeGoals.setText("");
        txtVisitGoals.setText("");
    }

    
    /**
     * @param args the command line arguments
     */
     public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
     
     void clearErrorLabels() {
        lblErrorMatchNo.setText("");
        lblErrorMatchNo.setVisible(false);
        lblErrorHome.setText("");
        lblErrorHome.setVisible(false);
        lblErrorVisitor.setText("");
        lblErrorVisitor.setVisible(false);
     }
    
     boolean isValidData() {
         
         clearErrorLabels();
         boolean result = true;
        if (txtMatchNo.getText().trim().isEmpty() || !isInteger(txtMatchNo.getText().trim())) {
            if (txtMatchNo.getText().trim().isEmpty()) {
                lblErrorMatchNo.setText("Invalid. Cannot be empty.");
            } else if (!isInteger(txtMatchNo.getText().trim())) {
                lblErrorMatchNo.setText("Invalid. Must be integer.");
            }

            lblErrorMatchNo.setVisible(true);
            result = false;
        }
        
        if (txtHomeGoals.getText().trim().isEmpty() || !isInteger(txtHomeGoals.getText().trim())) {
            if (txtHomeGoals.getText().trim().isEmpty()) {
                lblErrorHome.setText("Invalid. Cannot be empty.");
            } else if (!isInteger(txtHomeGoals.getText().trim())) {
                lblErrorHome.setText("Invalid. Must be integer.");
            }

            lblErrorHome.setVisible(true);
            result = false;
        }
        
        if (txtVisitGoals.getText().trim().isEmpty() || !isInteger(txtVisitGoals.getText().trim())) {
            if (txtVisitGoals.getText().trim().isEmpty()) {
                lblErrorVisitor.setText("Invalid. Cannot be empty.");
            } else if (!isInteger(txtVisitGoals.getText().trim())) {
                lblErrorVisitor.setText("Invalid. Must be integer.");
            }

            lblErrorVisitor.setVisible(true);
            result = false;
        }
        
        int home = Integer.parseInt(txtHomeGoals.getText().trim());
        int visitor = Integer.parseInt(txtVisitGoals.getText().trim());
        int res = Integer.parseInt(cmbResult.getSelectedItem().toString());
        
        if (res == 1){
            if (home <= visitor){
                lblErrorHome.setText("Invalid. Cannot be smaller or equal.");
                lblErrorVisitor.setText("Invalid. Cannot be larger.");
                
                lblErrorHome.setVisible(true);
                lblErrorVisitor.setVisible(true);
                result = false;
            }
        }
        else if (res == 2){
            if (home >= visitor){
                lblErrorHome.setText("Invalid. Cannot be larger.");
                lblErrorVisitor.setText("Invalid. Cannot be smaller or equal.");
                
                lblErrorHome.setVisible(true);
                lblErrorVisitor.setVisible(true);
                result = false;
            }
        }
        
        else if (res ==3){
            if (home != visitor){
                lblErrorHome.setText("Invalid. Must be equal.");
                lblErrorVisitor.setText("Invalid. Must be equal.");
                
                lblErrorHome.setVisible(true);
                lblErrorVisitor.setVisible(true);
                result = false;
            }
                
        } 
        
        
        
        return result;
             
       }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> cmbHome;
    private javax.swing.JComboBox<String> cmbResult;
    private javax.swing.JComboBox<String> cmbVisitor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblErrorHome;
    private javax.swing.JLabel lblErrorMatchNo;
    private javax.swing.JLabel lblErrorVisitor;
    private javax.swing.JTextField txtHomeGoals;
    private javax.swing.JTextField txtMatchNo;
    private javax.swing.JTextField txtVisitGoals;
    // End of variables declaration//GEN-END:variables
}
