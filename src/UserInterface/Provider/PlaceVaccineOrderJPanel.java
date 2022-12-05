/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Provider;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.StateNetwork;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.HospitalOrganization;
import Business.Organization.ManufactureOrganization;
import Business.Organization.Organization;
import Business.Organization.LHDImmuneOrganization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineDetails;
import Business.WorkQueue.ProviderVaccineOrderWorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author darsh
 */
public class PlaceVaccineOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateVaccineOrderJPanel
     */
    private final JPanel workContainer;

    private final HospitalEnterprise hospital;
    private final UserAccount userAccount;
    private HospitalOrganization hospitalOrg;
    private final EcoSystem business;
    private Order tempOrder;
    private final ArrayList<OrderItem> cartOrder;
    private boolean isCheckout;
    private final StateNetwork state;

    public PlaceVaccineOrderJPanel(JPanel workContainer, HospitalEnterprise hospital,HospitalOrganization hospitalOrg,UserAccount userAccount , EcoSystem business, StateNetwork state) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.hospital = hospital;
        this.business = business;
        this.state = state;
        populateManufacturerComboBox();
        this.isCheckout = false;
        
         cartOrder = new ArrayList<OrderItem>();
         
         if(isCheckout == false){
             tempOrder = new Order();
         }
        
        
        
    }

    private void populateManufacturerComboBox() {
        cbmaulist.removeAllItems();
        for (Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerDirectory()) {
            cbmaulist.addItem(manufacturer);

        }
    }
    
    private void displayManufacturerVaccines(){
        
        int rowCount = tblmanu.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblmanu.getModel();
        
        //delete rows
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        
        //get Manufacturer from combo box
        Manufacturer manufacturer = (Manufacturer)cbmaulist.getSelectedItem();
        if(manufacturer == null){
            return;
        }
        
        //populate the table
        ManufactureOrganization manufacureOrg = null;
        for(Organization org : manufacturer.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof ManufactureOrganization)
        {   manufacureOrg = (ManufactureOrganization)org;
            for(VaccineDetails vaccine : manufacureOrg.getVaccineProductCatalog().getVaccineProductList())
            {Object[] row = new Object[6];
            row[0] = vaccine;
            row[1] = vaccine.getVaccineDefinition().getVaccineName();
            row[2] = vaccine.getVaccineId();
            row[3] = vaccine.getBatchId();
            row[4] = vaccine.getVaccinePrice();
              row[5] = vaccine.getManufactureDate();
            defaulttabelmodel.addRow(row);
            }
        }
        }
        
        
        
        
    }
    
    
    private void searchVaccineProducts(String vaccineCode){
        
        int rowCount = tblmanu.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblmanu.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        //search vaccines from all the manufacturers
        
        for(Manufacturer manufacturer: business.getManufacturerDirectory().getManufacturerDirectory())
        {
             ManufactureOrganization manufacureOrg = null;
        for(Organization org : manufacturer.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof ManufactureOrganization)
        {   manufacureOrg = (ManufactureOrganization)org;
            for(VaccineDetails vaccine : manufacureOrg.getVaccineProductCatalog().getVaccineProductList())
            {
                if(vaccineCode.equalsIgnoreCase(vaccine.getVaccineDefinition().getVaccineCode()))
                {
                Object[] row = new Object[6];
            
                row[0] = vaccine;
                row[1] = vaccine.getVaccineDefinition().getVaccineName();
                row[2] = vaccine.getVaccineId();
                row[3] = vaccine.getBatchId();
                row[4] = vaccine.getVaccinePrice();
                row[5] = vaccine.getManufactureDate();        
                defaulttabelmodel.addRow(row);
                }
            }
        }
            
        }
            
            
        }
        
        
        
    }
    
    
    private void refreshCartTable(){
        
          int rowCount = tblcart.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblcart.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        
        for(OrderItem oi: tempOrder.getItemList())
        {
            Object[] row = new Object[8];
            
                row[0] = oi.getVaccineDetails();
                row[1] = oi;
                row[2] = oi.getVaccineDetails().getVaccineId();
                row[3] = oi.getVaccineDetails().getBatchId();
                row[4] = oi.getVaccineDetails().getVaccinePrice();
                  row[5] = oi.getQuantity();
                row[6] = oi.getVaccineDetails().getManufactureDate();
              row[7] = oi.getVaccineDetails().getVaccinePrice()*oi.getQuantity();
                defaulttabelmodel.addRow(row);
        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbmaulist = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtvacccode = new javax.swing.JTextField();
        btnsrch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmanu = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblcart = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        spcount = new javax.swing.JSpinner();
        btnaddcart = new javax.swing.JButton();
        txtcount = new javax.swing.JTextField();
        btnchange = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnremove = new javax.swing.JButton();
        btncheckout = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtamt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbordertype = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(204, 204, 255));
        setForeground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Vaccine Order");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Manufacturer:");

        cbmaulist.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cbmaulist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbmaulist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmaulistActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Manufacturer Vaccine Catalog:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Vaccine Code:");

        btnsrch.setBackground(new java.awt.Color(0, 0, 102));
        btnsrch.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnsrch.setForeground(new java.awt.Color(255, 255, 255));
        btnsrch.setText("Search");
        btnsrch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsrchActionPerformed(evt);
            }
        });

        tblmanu.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblmanu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Vaccine id", "Lot Number", "Price", "Manufacture date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblmanu);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Cart:");

        tblcart.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblcart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Vaccine id", "Lot Number", "Price", "Quantity", "Manufacture date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblcart);

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Quantity:");

        spcount.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        btnaddcart.setBackground(new java.awt.Color(0, 0, 102));
        btnaddcart.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnaddcart.setForeground(new java.awt.Color(255, 255, 255));
        btnaddcart.setText("Add to Cart");
        btnaddcart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddcartActionPerformed(evt);
            }
        });

        txtcount.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnchange.setBackground(new java.awt.Color(0, 0, 102));
        btnchange.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnchange.setForeground(new java.awt.Color(255, 255, 255));
        btnchange.setText("Modify");
        btnchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Quantity:");

        btnremove.setBackground(new java.awt.Color(0, 0, 102));
        btnremove.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnremove.setForeground(new java.awt.Color(255, 255, 255));
        btnremove.setText("Remove");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });

        btncheckout.setBackground(new java.awt.Color(0, 0, 102));
        btncheckout.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btncheckout.setForeground(new java.awt.Color(255, 255, 255));
        btncheckout.setText("Check Out");
        btncheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncheckoutActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Total Amount of Order:");

        txtamt.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtamt.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("Set Contract: ");

        cbordertype.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cbordertype.setForeground(new java.awt.Color(0, 0, 102));
        cbordertype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AsRequired", "Monthly", "Bi-Monthly" }));
        cbordertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbordertypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbmaulist, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtvacccode, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsrch))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcount, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnchange)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnremove)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbordertype, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(btncheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spcount, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnaddcart, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtamt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbmaulist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnsrch)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtvacccode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spcount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddcart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnchange)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncheckout)
                    .addComponent(btnremove)
                    .addComponent(jLabel10)
                    .addComponent(cbordertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddcartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddcartActionPerformed
        // TODO add your handling code here:
        int quantity = (Integer) spcount.getValue();

        //get the selected item
        int selectRow = tblmanu.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a Vaccine First!");
            return;
        }
        VaccineDetails product = (VaccineDetails) tblmanu.getValueAt(selectRow, 0);
        
        if (quantity <= 0 ) {
            JOptionPane.showMessageDialog(null, "Please enter correct quantity");
            return;
        }
        
        
        boolean flag = true;
        //  ArrayList<OrderItem> orders = customer.getOrder().getOrderItemList();
        ArrayList<OrderItem> orders = tempOrder.getItemList();
        for (OrderItem oi : orders) {
            if (oi.getVaccineDetails().equals(product)) {
                int oldQuantity = oi.getQuantity();
                int newQuantity = oldQuantity + quantity;
                oi.setQuantity(newQuantity);
                flag = false;
            }
        }
       
        if(flag){
        //OrderItem orderItem = customer.getOrder().addOrderItem(product, quantity);
        OrderItem orderItem = tempOrder.addNewOrderItem(quantity, product);
        }
     

        isCheckout = false;
        String msg = Integer.toString(quantity) + " " + product.getVaccineDefinition().getVaccineName() + " has added to cart!";
        JOptionPane.showMessageDialog(null, msg);
       
       displayManufacturerVaccines();
        refreshCartTable();
        calulateTotalAmountOfOrder();

    }//GEN-LAST:event_btnaddcartActionPerformed
    
    private void calulateTotalAmountOfOrder(){
        
        if(tempOrder == null){
            return;
        }
        double totalAmount = 0;
        
        for(OrderItem oi: tempOrder.getItemList())
        {
            totalAmount = totalAmount + oi.getQuantity()*oi.getVaccineDetails().getVaccinePrice();
            
        }
        
        txtamt.setText(String.valueOf(totalAmount));
        
        
    }
    
  
    
    private void btnchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeActionPerformed
        // TODO add your handling code here:
        //
        int selectRow = tblcart.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a vaccine from cart first!");
            return;
        }
        //modify the item Quantity
        OrderItem orderItem = (OrderItem) tblcart.getValueAt(selectRow, 1);
    
        int oldQuantity = orderItem.getQuantity();
        //get new quantity
        int newQuantity = Integer.parseInt(txtcount.getText());
       
        orderItem.setQuantity(newQuantity);
        String msg = "The quantity of " + orderItem.getVaccineDetails().getVaccineDefinition().getVaccineName() + " has changed from " + oldQuantity + " to " + newQuantity;
        JOptionPane.showMessageDialog(null, msg);
        
        //orderItem.getVaccineProduct().setAvailablity(oldAvail + oldQuantity - newQuantity);//update the availability

        //refresh the tables
        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_btnchangeActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        // TODO add your handling code here:
        int selectRow = tblcart.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a vaccine from cart first!");
            return;
        }
        OrderItem oi = (OrderItem) tblcart.getValueAt(selectRow, 1);
     
        
        tempOrder.removeOrderItem(oi);
        

        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_btnremoveActionPerformed

    private void btncheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncheckoutActionPerformed
        // TODO add your handling code here:
        // if(!customer.getOrder().getOrderItemList().isEmpty())
        
//        if((rbbimon.isSelected() || rbmon.isSelected() || rbnormal.isSelected()))
//        {
            
        
        if (!tempOrder.getItemList().isEmpty()) 
            {   
                boolean adhoc = false;
                boolean bimonth = false;
                boolean monthly = false;
                String s = (String) cbordertype.getSelectedItem();
            
            if(s.equals("AsRequired"))
            {
                adhoc = true;
                bimonth = false;
                monthly = false;
            }
            if(s.equals("Monthly"))
            {
                adhoc = false;
                bimonth = false;
                monthly = true;
            }
            if(s.equals("Bi-Monthly"))
            {
                adhoc = false;
                bimonth = true;
                monthly = false;
            }
                //get the contract details
//                boolean adhoc = rbnormal.isSelected();
//                boolean bimonth = rbbimon.isSelected();
//                boolean monthly = rbmon.isSelected();
//                
                Order o = hospital.getOrderCatalog().addNewOrder();
                o=tempOrder;
               
                ProviderVaccineOrderWorkRequest workRequest = new ProviderVaccineOrderWorkRequest();
                workRequest.setasReq(adhoc);
                workRequest.setHalfmonthContract(bimonth);
                workRequest.setfullMonthContract(monthly);
                workRequest.setVaccineOrder(tempOrder);
                workRequest.setSender(userAccount);
                workRequest.setStatus("New Order");
                workRequest.calculateDeliveryDate(workRequest);
                workRequest.setEnterprise(hospital);
             
                for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
                {
                    if(org instanceof HospitalOrganization)
                    {
                        HospitalOrganization hosOrg = (HospitalOrganization)org;
                        hosOrg.getWorkQueue().addWorkRequest(workRequest);
                    }
                }
                
                for(Organization org: state.getLocalHealthDepartment().getOrganizationDirectory().getOrganizationList())
                {
                    if(org instanceof LHDImmuneOrganization)
                    {
                        org.getWorkQueue().addWorkRequest(workRequest);
                    }
                }
                
                
                JOptionPane.showMessageDialog(null, "Your order has been successfuly added!");
            
        }
        else
        {JOptionPane.showMessageDialog(null, "Error occured when trying to check out!");
        }
        
        isCheckout = true;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to Place another order?", "Warning", dialogButton);


        if (dialogResult == JOptionPane.YES_OPTION) {
            tempOrder = new Order();

        }

        displayManufacturerVaccines();
        refreshCartTable();

          PlaceVaccineOrderJPanel panel = new PlaceVaccineOrderJPanel(workContainer, hospital, hospitalOrg, userAccount, business, state);
        workContainer.add("PlaceVaccineOrderJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
  
        
//        else
//        {
//            JOptionPane.showMessageDialog(null, "Please Select a type of order");
//            return;
//        }
        
    }//GEN-LAST:event_btncheckoutActionPerformed

    private void cbmaulistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmaulistActionPerformed
        // TODO add your handling code here:

        displayManufacturerVaccines();
    }//GEN-LAST:event_cbmaulistActionPerformed

    private void btnsrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsrchActionPerformed
        // TODO add your handling code here:
        
        String vaccineCode = txtvacccode.getText();
        searchVaccineProducts(vaccineCode);
        
        
    }//GEN-LAST:event_btnsrchActionPerformed

    private void cbordertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbordertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbordertypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddcart;
    private javax.swing.JButton btnchange;
    private javax.swing.JButton btncheckout;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnsrch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbmaulist;
    private javax.swing.JComboBox cbordertype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spcount;
    private javax.swing.JTable tblcart;
    private javax.swing.JTable tblmanu;
    private javax.swing.JTextField txtamt;
    private javax.swing.JTextField txtcount;
    private javax.swing.JTextField txtvacccode;
    // End of variables declaration//GEN-END:variables
}
