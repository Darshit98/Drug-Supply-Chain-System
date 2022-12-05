/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Clinic;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.StateNetwork;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.ClinicOrganization;
import Business.Person.Patient;
import Business.UserAccount.UserAccount;
import Business.Vaccine.AdministeredVaccineDetails;
import Business.Vaccine.VaccineDetails;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author darsh
 */
public class AdministerVaccineToPatientClinicJPanel extends javax.swing.JPanel {

   
    private final JPanel workContainer;

    private final HospitalEnterprise hospital;
    private final UserAccount userAccount;
    private final ClinicOrganization clinicOrg;
    private final EcoSystem business;
    private final Patient patient;
    private final StateNetwork state;
    private int flagg;
    
    public AdministerVaccineToPatientClinicJPanel(JPanel workContainer, HospitalEnterprise hospital, ClinicOrganization clinicOrg, UserAccount userAccount , EcoSystem business, Patient patient, StateNetwork state) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.hospital = hospital;
        this.business = business;
        this.clinicOrg = clinicOrg;
        this.patient = patient;
        this.state = state;
        txtdoc.setText(userAccount.getPerson().getFirstName()+" "+userAccount.getPerson().getLastName());
        txtpname.setText(patient.getFirstName() + " " + patient.getLastName());
        cbvacclcodelist.removeAllItems();
        cbbrandlist.removeAllItems();
        cbnum.removeAllItems();
        
        populateVaccineCodeComboBox();
        
    }
    
    private void populateVaccineCodeComboBox()
    {
       cbvacclcodelist.removeAllItems();
       
       ArrayList<String> vprodList = new ArrayList<String>();
       
       
       for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(vprodList.contains(product.getVaccineDefinition().getVaccineCode())== false)
                   {
                       cbvacclcodelist.addItem(product);
                       vprodList.add(product.getVaccineDefinition().getVaccineCode());
                   }
                   
               }
           }
       }
        
    }
    
    private void populateBrandComboBox(VaccineDetails vaccine)
    {
        cbbrandlist.removeAllItems();
         String vaccineCode = vaccine.getVaccineDefinition().getVaccineCode();
            ArrayList<String> brandList = new ArrayList<String>();
         for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && brandList.contains(product.getManufacturerName())==false )
                   {
                       cbbrandlist.addItem(product.getManufacturerName());
                       brandList.add(product.getManufacturerName());
                   }
               }
           }
       }
        
    }
    
    
    private void populateBatchComboBox(String brandName){
        
        cbnum.removeAllItems();
        VaccineDetails vp = (VaccineDetails)cbvacclcodelist.getSelectedItem();
        String vaccineCode = vp.getVaccineDefinition().getVaccineCode();
        
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getManufacturerName().equalsIgnoreCase(brandName) && product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode))
                   {
                       cbnum.addItem(product.getBatchId());
                   }
               }
           }
       }
        
        
    }
    
    private void populateTextFields()
    {
        VaccineDetails prod = (VaccineDetails)cbvacclcodelist.getSelectedItem();
        if(prod == null)
        {
            return;
        }
        String vaccineCode = prod.getVaccineDefinition().getVaccineCode();
        
        
        String brand = (String)cbbrandlist.getSelectedItem();
        
        String batchID = (String)cbnum.getSelectedItem();
        
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getManufacturerName().equalsIgnoreCase(brand) && product.getBatchId().equalsIgnoreCase(batchID) && product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode))
                   {
                       txtmanudate.setText(String.valueOf(product.getManufactureDate()));
                       return;
                   }
               }
           }
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
        txtpname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbvacclcodelist = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtdosenum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtmanudate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbnum = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtdoc = new javax.swing.JTextField();
        btnadmin = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbbrandlist = new javax.swing.JComboBox();
        btnback = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        cbArm = new javax.swing.JComboBox();
        cbstatus = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administer Vaccine");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Patient: ");

        txtpname.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtpname.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Vaccine Details:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Vaccine Code:");

        cbvacclcodelist.setBackground(new java.awt.Color(0, 0, 102));
        cbvacclcodelist.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cbvacclcodelist.setForeground(new java.awt.Color(255, 255, 255));
        cbvacclcodelist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbvacclcodelist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbvacclcodelistActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Dose Number:");

        txtdosenum.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Manufacture Date:");

        txtmanudate.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtmanudate.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Batch Number :");

        cbnum.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cbnum.setForeground(new java.awt.Color(0, 0, 102));
        cbnum.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnumActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Arm");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Injection Status:");

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Given By:");

        txtdoc.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtdoc.setEnabled(false);

        btnadmin.setBackground(new java.awt.Color(0, 0, 102));
        btnadmin.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnadmin.setForeground(new java.awt.Color(255, 255, 255));
        btnadmin.setText("Administer Vaccine");
        btnadmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadminActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Brand:");

        cbbrandlist.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cbbrandlist.setForeground(new java.awt.Color(0, 0, 102));
        cbbrandlist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbrandlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbrandlistActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(0, 0, 102));
        btnback.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setText("<");
        btnback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 51, 102));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 102));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ICONS/11122021icons/keepitup_70x70.png"))); // NOI18N

        cbArm.setBackground(new java.awt.Color(0, 0, 102));
        cbArm.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cbArm.setForeground(new java.awt.Color(255, 255, 255));
        cbArm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Right", "Left" }));
        cbArm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbArmActionPerformed(evt);
            }
        });

        cbstatus.setBackground(new java.awt.Color(0, 0, 102));
        cbstatus.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cbstatus.setForeground(new java.awt.Color(255, 255, 255));
        cbstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Success", "Fail" }));
        cbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstatusActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ICONS/11122021icons/vaccine.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbvacclcodelist, 0, 173, Short.MAX_VALUE)
                                            .addComponent(cbbrandlist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(185, 185, 185)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(349, 349, 349)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbnum, 0, 120, Short.MAX_VALUE)
                                                .addComponent(txtdosenum)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel12))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cbArm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtmanudate)
                                                .addComponent(txtdoc)
                                                .addComponent(cbstatus, 0, 175, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 65, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel13, jLabel14, jLabel5, jLabel7});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbvacclcodelist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cbnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbrandlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel6)
                            .addComponent(txtdosenum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7))
                    .addComponent(txtmanudate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbArm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtdoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnadmin))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbvacclcodelistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbvacclcodelistActionPerformed
        // TODO add your handling code here:
        cbbrandlist.removeAllItems();
        VaccineDetails prod = (VaccineDetails)cbvacclcodelist.getSelectedItem();
        if(prod == null)
        {
            return;
        }
        populateBrandComboBox(prod);
 
    }//GEN-LAST:event_cbvacclcodelistActionPerformed

    private void btnadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadminActionPerformed
        // TODO add your handling code here:
      
        try
        {
          
             VaccineDetails vp = (VaccineDetails)cbvacclcodelist.getSelectedItem();
            String vaccineCode = vp.getVaccineDefinition().getVaccineCode();
        
        String brand = (String)cbbrandlist.getSelectedItem();
        
        String batchID = (String)cbnum.getSelectedItem();
        VaccineDetails prod = null;
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization && prod== null)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getManufacturerName().equalsIgnoreCase(brand) && product.getBatchId().equalsIgnoreCase(batchID) && product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode))
                   {
                      prod=product;
                      break;
                   }
               }
           }
       }
   
        Date administeredDate = new Date();   

        String siteRoute = null;
        String status = null;
        siteRoute = (String)cbArm.getSelectedItem();
        status = (String)cbstatus.getSelectedItem();
        
        
        AdministeredVaccineDetails administeredVaccine = null;
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                administeredVaccine = hospOrg.getClinic().addNewAdministeredVaccine();
            }
        }
        
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                for(VaccineDetails product : hospOrg.getClinic().getVaccineInventoryClinic())
                {
                    if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && product.getBatchId().equalsIgnoreCase(batchID))
                    {administeredVaccine.setVaccineProduct(product);
                    break;
                    }
                        
                }
            }
        }
     
       for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                for(VaccineDetails p: hospOrg.getClinic().getVaccineInventoryClinic())
                {
                    
                    
                    if(p.equals(administeredVaccine.getVaccineProduct()))
                    {   
                        if(p.getAvailablity()<0)
                        {
                            JOptionPane.showMessageDialog(null, "Vaccine Out of Stock!");
                             flagg=1;
                        }
                        else
                        {p.setAvailablity(p.getAvailablity()-1);
                             flagg=2;
                        }
                    }
                }
                        
                }
            }
        
        
        if (flagg==2){
        int dose = Integer.parseInt(txtdosenum.getText());
        administeredVaccine.setDoseNumber(dose);
        administeredVaccine.setshotstatus(status);
        administeredVaccine.setProvider(userAccount);
        administeredVaccine.setSiteRoute(siteRoute);
        administeredVaccine.setDate(administeredDate);
        administeredVaccine.setPatient(patient);
        if(status.equalsIgnoreCase("Fail"))
        {
            administeredVaccine.setfailedReason("Failed");
        }
        
       
       
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                AdministeredVaccineDetails v = hospOrg.getClinic().addNewAdministeredVaccine();
                v = administeredVaccine;
            }
        }
       
        AdministeredVaccineDetails av = patient.addNewAdministeredVaccine();
        av=administeredVaccine;
       
       
        JOptionPane.showMessageDialog(null, "Vaccination Done!");
     
        }}
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter numeric data in dose field");
            //return;
        }
  
    }//GEN-LAST:event_btnadminActionPerformed

    private void cbbrandlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbrandlistActionPerformed
        // TODO add your handling code here:
        cbnum.removeAllItems();
        String brand = (String)cbbrandlist.getSelectedItem();
        if(brand == null)
        {
            return;
        }
        
        populateBatchComboBox(brand);
        
        
    }//GEN-LAST:event_cbbrandlistActionPerformed

    private void cbnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnumActionPerformed
        // TODO add your handling code here:
        populateTextFields();
    }//GEN-LAST:event_cbnumActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btnbackActionPerformed

    private void cbArmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbArmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbArmActionPerformed

    private void cbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbstatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadmin;
    private javax.swing.JButton btnback;
    private javax.swing.JComboBox cbArm;
    private javax.swing.JComboBox cbbrandlist;
    private javax.swing.JComboBox cbnum;
    private javax.swing.JComboBox cbstatus;
    private javax.swing.JComboBox cbvacclcodelist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtdoc;
    private javax.swing.JTextField txtdosenum;
    private javax.swing.JTextField txtmanudate;
    private javax.swing.JTextField txtpname;
    // End of variables declaration//GEN-END:variables
}
