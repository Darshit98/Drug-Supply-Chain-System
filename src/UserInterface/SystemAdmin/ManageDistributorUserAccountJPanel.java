/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.SystemAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Person.EnterpriseAdminPerson;
import Business.Role.EnterpriseAdminRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author riyavirani
 */
public class ManageDistributorUserAccountJPanel extends javax.swing.JPanel {

    private final JPanel workContainer;
    private final EcoSystem business;
    /**
     * Creates new form ManageDistributorUserAccountJPanel
     */
    public ManageDistributorUserAccountJPanel(JPanel workContainer, EcoSystem business) {
        initComponents();
        this.workContainer = workContainer;
        this.business = business;
        populateTable();
    }
     private void populateTable(){
        int rowCount = tbladmin.getRowCount();
         DefaultTableModel defaulttabelmodel = (DefaultTableModel)tbladmin.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        for(UserAccount ua : business.getDistributor().getUserAccountDirectory().getUserAccountList()){
            
            if(ua.getRole() instanceof EnterpriseAdminRole){
                Object[] row = new Object[3];
                row[0]=ua;
                row[1]=ua.getPassword();
                row[2]=String.valueOf(ua.getPerson().getFirstName()+ " "+ ua.getPerson().getLastName());
            
            defaulttabelmodel.addRow(row);
            
                
                
                
            }
            
        }
        

    }
     
     
     private boolean checkIfUserAccountExists(String username){
        
        boolean flag= false;
        
        flag = business.getUserAccountDirectory().checkIfUserAccountExists(username );
        
        if (flag == false) {
         

            flag = business.getCdc().getUserAccountDirectory().checkIfUserAccountExists(username);
            if(flag == false)
            { for(Organization org: business.getCdc().getOrganizationDirectory().getOrganizationList())
            {
                flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == true)
                break;
            }
            
            }
            
        }
        if (flag == false) {
         
            for(Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerDirectory())
            { 
                flag = manufacturer.getUserAccountDirectory().checkIfUserAccountExists(username);
                
                if(flag == false)
                {
                    for(Organization org: manufacturer.getOrganizationDirectory().getOrganizationList())
                {
                    flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                    if(flag == true)
                        break;
                }
                }
                if(flag == true)
                { 
                    break;
                }
            }
            
                
            
        }if (flag == false) {
         

            flag = business.getDistributor().getUserAccountDirectory().checkIfUserAccountExists(username);
            if(flag == false)
            { for(Organization org: business.getDistributor().getOrganizationDirectory().getOrganizationList())
            { flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == true)
                {
                    
                    break;
                }
            }
            }
            

        }if (flag == false) {
            
            for (StateNetwork state : business.getStateList()) {
                if(flag == false)
                { flag = state.getLocalHealthDepartment().getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == false)
                {for(Organization org: state.getLocalHealthDepartment().getOrganizationDirectory().getOrganizationList())
                {flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                    if(flag == true)
                    {   
                        break;
                    }
                }
                }
                
                if (flag == false) {
                     

                    for (CityNetwork city : state.getCityList()) {
                        for (Enterprise hospital : city.getEnterpriseDirectory().getEnterpriseDirectory()) {
                            flag = hospital.getUserAccountDirectory().checkIfUserAccountExists(username);
                            if (flag == false) {
                                for (Organization o : hospital.getOrganizationDirectory().getOrganizationList()) {
                                    flag = o.getUserAccountDirectory().checkIfUserAccountExists(username);

                                    if (flag == true) {
                                        
                                        break;

                                    }
                                }
                            }
                            else
                            {   
                            
                                break;
                            }
                           
                    if(flag == true)
                    {
                        break;
                    }
                            

                        }
                        if(flag == true)
                {
                    break;
                }
                    }

                } 
                else {
                    
                    break;
                }

            }
        }
        }
    
        
        return flag;
        
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
        jLabel6 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnback = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        btncreate = new javax.swing.JButton();
        txtpass = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbladmin = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtlname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Distributor Admin");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Last Name:");

        txtfname.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("First Name:");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        btnback.setBackground(new java.awt.Color(0, 0, 102));
        btnback.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setText("<");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnremove.setBackground(new java.awt.Color(0, 0, 102));
        btnremove.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnremove.setForeground(new java.awt.Color(255, 255, 255));
        btnremove.setText("Remove Admin");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });

        btncreate.setBackground(new java.awt.Color(0, 0, 102));
        btncreate.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btncreate.setForeground(new java.awt.Color(255, 255, 255));
        btncreate.setText("Create Admin");
        btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateActionPerformed(evt);
            }
        });

        txtpass.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        tbladmin.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tbladmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Person"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbladmin.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbladmin);

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Password:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("List of Admins:");

        txtuname.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("UserName:");

        txtlname.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfname))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpass)
                                    .addComponent(txtuname)))
                            .addComponent(btncreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnremove))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnback)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnremove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btncreate)
                        .addContainerGap())
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        // TODO add your handling code here:
        int row = tbladmin.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select an Admin from table");
            return;
        }

        UserAccount ua = (UserAccount)tbladmin.getValueAt(row, 0);
        business.getDistributor().getUserAccountDirectory().removeUserAccount(ua);
        populateTable();
    }//GEN-LAST:event_btnremoveActionPerformed

    private void btncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateActionPerformed
        // TODO add your handling code here:

        String firstName = txtfname.getText();
        if(firstName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter First Name!");
            return;
        }
        String lastName = txtlname.getText();
        if(lastName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter last Name!");
            return;
        }
        String username = txtuname.getText();
        if(username.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter Username!");
            return;
        }
        String password = txtpass.getText();
        if(password.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter Password!");
            return;
        }

        boolean check = checkIfUserAccountExists(username);

        if(check == true)
        {
            JOptionPane.showMessageDialog(null, "Username exists, please choose a different username!");
            return;
        }

        EnterpriseAdminPerson admin = (EnterpriseAdminPerson) business.getDistributor().getPersonDirectory().createPerson(firstName, lastName, Role.RoleType.EnterpriseAdmin);

        business.getDistributor().getUserAccountDirectory().createUserAccount(username, password, admin, new EnterpriseAdminRole());

        populateTable();
    }//GEN-LAST:event_btncreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btncreate;
    private javax.swing.JButton btnremove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbladmin;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
