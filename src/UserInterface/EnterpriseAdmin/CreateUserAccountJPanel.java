/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.EnterpriseAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Organization.ClinicOrganization;
import Business.Person.Person;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author darsh
 */
public class CreateUserAccountJPanel extends javax.swing.JPanel {

    private JPanel workContainer;
    private Enterprise enterprise;
    private ManageUserAccountJPanel panel;
    private EcoSystem business;
    /**
     * Creates new form CreateUserAccountJPanel
     */
    public CreateUserAccountJPanel(JPanel workContainer, Enterprise enterprise, ManageUserAccountJPanel panel, EcoSystem business) {
        initComponents();
        this.workContainer = workContainer;
        this.enterprise = enterprise;
        this.business = business;
        populateOrganizationComboBox();
        this.panel = panel;
        lbl7.setVisible(false);
            txt3.setVisible(false);
        if(enterprise instanceof HospitalEnterprise)
        {
            lbl7.setVisible(true);
            txt3.setVisible(true);
        }
    }
    
    private void populateOrganizationComboBox(){
        
        cborg.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            cborg.addItem(organization);
        }
    }
    
    public void populatePersonComboBox(Organization organization){
        cbpname.removeAllItems();
        
        for (Person person : organization.getPersonDirectory().getPeopleList()){
            cbpname.addItem(person);
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
                //not a sys,cdc admin
            //check if it is a manufacture enterprise admin
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
    
    
    
    private void populateRoleComboBox(Organization organization){
        cbrole.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            cbrole.addItem(role);
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

        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        cborg = new javax.swing.JComboBox();
        lbl3 = new javax.swing.JLabel();
        cbpname = new javax.swing.JComboBox();
        lbl4 = new javax.swing.JLabel();
        cbrole = new javax.swing.JComboBox();
        lbl5 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        lbl6 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        lbl7 = new javax.swing.JLabel();
        txt3 = new javax.swing.JTextField();

        lbl1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lbl1.setForeground(new java.awt.Color(0, 0, 102));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("Create User Account");

        lbl2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl2.setText("Organization:");

        cborg.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cborg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cborg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cborgActionPerformed(evt);
            }
        });

        lbl3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 255, 255));
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl3.setText("Person:");

        cbpname.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbpname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 255, 255));
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl4.setText("Role:");

        cbrole.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbrole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl5.setForeground(new java.awt.Color(255, 255, 255));
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl5.setText("Username:");

        txt1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        lbl6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl6.setForeground(new java.awt.Color(255, 255, 255));
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl6.setText("Password:");

        txt2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        btn1.setBackground(new java.awt.Color(0, 0, 102));
        btn1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("Create User Account");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(0, 0, 102));
        btn2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("<");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        lbl7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl7.setForeground(new java.awt.Color(255, 255, 255));
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl7.setText("Satellite Clinic Name:");

        txt3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txt3.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl7)
                            .addComponent(lbl3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbpname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbrole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt1)
                            .addComponent(txt2)
                            .addComponent(cborg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn2)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl2)
                            .addComponent(cborg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl7)
                            .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl6))
                        .addGap(18, 18, 18)
                        .addComponent(btn1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cborgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cborgActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization) cborg.getSelectedItem();
        if (organization != null){
            populatePersonComboBox(organization);
            populateRoleComboBox(organization);
            if(organization instanceof ClinicOrganization)
            {   ClinicOrganization satOrg = (ClinicOrganization)organization;
                txt3.setText(satOrg.getClincName());
            }
            else
            txt3.setText("");
        }

    }//GEN-LAST:event_cborgActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:

        String userName = txt1.getText();
        if(userName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter username");
            return;
        }
        String password = txt2.getText();
        if(password.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter password");
            return;
        }
        Organization organization = (Organization) cborg.getSelectedItem();
        Person person = (Person) cbpname.getSelectedItem();
        Role role = (Role) cbrole.getSelectedItem();

        boolean check = checkIfUserAccountExists(userName);

        if(check == true)
        {
            JOptionPane.showMessageDialog(null, "Username Exists please choose another username");
            return;
        }

        for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList())
        {
            if(ua.getPerson().equals(person))
            {
                JOptionPane.showMessageDialog(null, "Credentials for the person already exists!");
                return;
            }
        }
        organization.getUserAccountDirectory().createUserAccount(userName, password, person, role);

        panel.populateTable();
        JOptionPane.showMessageDialog(null, "User Account Created!");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JComboBox cborg;
    private javax.swing.JComboBox cbpname;
    private javax.swing.JComboBox cbrole;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    // End of variables declaration//GEN-END:variables
}
