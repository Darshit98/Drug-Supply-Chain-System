/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.CDC;

import Business.EcoSystem;
import Business.NationalEnterprise.CDC;
import Business.NationalEnterprise.Manufacturer;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.CDCOrganization;
import Business.Organization.ManufactureOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineDetails;
import Business.WorkQueue.VaccineOrderWorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author darsh
 */
public class CreateVaccineOrder extends javax.swing.JPanel {
    
    private JPanel workContainer;
    private CDC cdc;
    private UserAccount userAccount;
    private CDCOrganization cdcOrg;
    private EcoSystem business;
    private ArrayList<OrderItem> cartOrder;
    private boolean isCheckout;
    /**
     * Creates new form CreateVaccineOrder
     */
    public CreateVaccineOrder(JPanel workContainer, CDC cdc, EcoSystem business, CDCOrganization cdcOrg, UserAccount userAccount) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.cdc = cdc;
        this.business = business;
        populateManufacturerComboBox();
        this.isCheckout = false;
         cartOrder = new ArrayList<OrderItem>();
    
    }

    private void populateManufacturerComboBox() {
        combo1.removeAllItems();
        for (Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerDirectory()) {
            combo1.addItem(manufacturer);

        }
    }
    
    private void displayManufacturerVaccines(){
        
        int rowCount = tblmanuf.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblmanuf.getModel();

        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }

        Manufacturer manufacturer = (Manufacturer)combo1.getSelectedItem();
        if(manufacturer == null){
            return;
        }

        ManufactureOrganization manufacureOrg = null;
        for(Organization org : manufacturer.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof ManufactureOrganization)
        {   manufacureOrg = (ManufactureOrganization)org;
            for(VaccineDetails vaccine : manufacureOrg.getVaccineProductCatalog().getVaccineProductList())
            {Object[] row = new Object[6];
            row[0] = vaccine;
            row[1] = vaccine.getVaccineDefinition().getVaccineName();
            row[2] = vaccine.getManufacturerName();
            row[3] = vaccine.getVaccinePrice();
            row[4] = vaccine.getAvailablity();
            row[5] = vaccine.getManufactureDate();
            defaulttabelmodel.addRow(row);
            }
        }
        }
  
    }
    
    
    private void searchVaccineProducts(String vaccineCode){
        
        int rowCount = tblmanuf.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblmanuf.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        
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
            row[2] = vaccine.getManufacturerName();      
            row[3] = vaccine.getVaccinePrice();
            row[4] = vaccine.getAvailablity();
            row[5] = vaccine.getManufactureDate();
            defaulttabelmodel.addRow(row);
                }
            }
        }
            
        }
            
            
        }
   
    }
    
    
    private void refreshCartTable(){
        
          int rowCount = tbcart.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tbcart.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        
        for(OrderItem oi: cartOrder )
        {
            Object[] row = new Object[7];
            
                row[0] = oi.getVaccineDetails();
                row[1] = oi;
                row[2] = oi.getVaccineDetails().getManufacturerName();            
                row[3] = oi.getVaccineDetails().getVaccinePrice();
                row[4] = oi.getQuantity();
                row[5] = oi.getVaccineDetails().getManufactureDate();
                row[6] = oi.getVaccineDetails().getVaccinePrice()*oi.getQuantity();
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

        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox();
        lbl3 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        btn1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmanuf = new javax.swing.JTable();
        Separator1 = new javax.swing.JSeparator();
        lbl6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbcart = new javax.swing.JTable();
        lbl7 = new javax.swing.JLabel();
        addcount = new javax.swing.JSpinner();
        btn2 = new javax.swing.JButton();
        txt2 = new javax.swing.JTextField();
        btn3 = new javax.swing.JButton();
        lbl8 = new javax.swing.JLabel();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        lbl9 = new javax.swing.JLabel();
        txt3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        lbl1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lbl1.setForeground(new java.awt.Color(0, 0, 102));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("Create Vaccine Order");

        lbl2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(0, 51, 102));
        lbl2.setText("Manufacturer:");

        combo1.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        combo1.setForeground(new java.awt.Color(0, 51, 102));
        combo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        lbl3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(0, 51, 102));
        lbl3.setText("Manufacturer Vaccine Catalog:");

        lbl5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl5.setForeground(new java.awt.Color(0, 51, 102));
        lbl5.setText("Vaccine Code:");

        btn1.setBackground(new java.awt.Color(0, 0, 102));
        btn1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("Search");
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        tblmanuf.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tblmanuf.setForeground(new java.awt.Color(0, 51, 102));
        tblmanuf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Brand", "Price", "Availability", "Manufacture date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblmanuf);

        lbl6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl6.setForeground(new java.awt.Color(0, 51, 102));
        lbl6.setText("Cart:");

        tbcart.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tbcart.setForeground(new java.awt.Color(0, 51, 102));
        tbcart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Brand", "Price", "Quantity", "Manufacture date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbcart);

        lbl7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl7.setForeground(new java.awt.Color(0, 0, 102));
        lbl7.setText("Quantity:");

        addcount.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        btn2.setBackground(new java.awt.Color(0, 0, 102));
        btn2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("Add to Cart");
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(0, 0, 102));
        btn3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("Update");
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        lbl8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl8.setForeground(new java.awt.Color(0, 51, 102));
        lbl8.setText("Quantity:");

        btn4.setBackground(new java.awt.Color(0, 0, 102));
        btn4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("Cancel Order");
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(0, 0, 102));
        btn5.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("Remove");
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(0, 0, 102));
        btn6.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("Check Out");
        btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        lbl9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl9.setForeground(new java.awt.Color(0, 51, 102));
        lbl9.setText("Total Amount:");

        txt3.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Separator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbl6)
                        .addGap(32, 32, 32)
                        .addComponent(lbl8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl9)
                        .addGap(18, 18, 18)
                        .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(256, 256, 256))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addcount, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(lbl5)
                        .addGap(18, 18, 18)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbl3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(lbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl5)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn1)
                        .addComponent(lbl2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl7)
                    .addComponent(addcount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl6)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn3)
                        .addComponent(lbl8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn6)
                    .addComponent(btn5)
                    .addComponent(btn4))
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        // TODO add your handling code here:
        displayManufacturerVaccines();
    }//GEN-LAST:event_combo1ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:

        String vaccineCode = txt1.getText();
        searchVaccineProducts(vaccineCode);

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        int quantity = (Integer) addcount.getValue();

        int selectRow = tblmanuf.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Kindly first select a vaccine!");
            return;
        }
        VaccineDetails product = (VaccineDetails) tblmanuf.getValueAt(selectRow, 0);

        if (quantity <= 0 || quantity > product.getAvailablity()) {
            JOptionPane.showMessageDialog(null, "Incorect Quantity, Please enter it again !");
            return;
        }
 
        boolean flag = true;
       
        ArrayList<OrderItem> orders = cartOrder;
        for (OrderItem oi : orders) {
            if (oi.getVaccineDetails().equals(product)) {
                int oldQuantity = oi.getQuantity();
                int newQuantity = oldQuantity + quantity;
                oi.setQuantity(newQuantity);
                flag = false;
            }
        }
           
        
        if(flag==true)
        {OrderItem orderItem = new OrderItem();
        orderItem.setVaccineDetails(product);
        orderItem.setQuantity(quantity);
        cartOrder.add(orderItem);
        
        }
   
        String msg = Integer.toString(quantity) + " " + product.getVaccineDefinition().getVaccineName() + " has added to cart!";
        JOptionPane.showMessageDialog(null, msg);
        
        product.setAvailablity(product.getAvailablity()-quantity);
        
       displayManufacturerVaccines();
        refreshCartTable();
        calulateTotalAmountOfOrder();
    }//GEN-LAST:event_btn2ActionPerformed

    private void calulateTotalAmountOfOrder(){
        
        if(cartOrder == null){
            return;
        }
        double totalAmount = 0;
        
        for(OrderItem oi: cartOrder)
        {
            totalAmount = totalAmount + oi.getQuantity()*oi.getVaccineDetails().getVaccinePrice();
            
        }
        
        txt3.setText(String.valueOf(totalAmount));
      
    }
    
    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        //
        int selectRow = tbcart.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Kindly first select a vaccine from the cart !");
            return;
        }
      
        OrderItem orderItem = (OrderItem) tbcart.getValueAt(selectRow, 1);
        
        int oldQuantity = orderItem.getQuantity();
        int oldAvail = orderItem.getVaccineDetails().getAvailablity();

        int newQuantity = Integer.parseInt(txt2.getText());

        if (newQuantity <= 0 || newQuantity > oldQuantity + oldAvail) {
            JOptionPane.showMessageDialog(null, "Incorect Quantity, Please enter it again");
            return;
        }
        orderItem.setQuantity(newQuantity);
        String msg = "The quantity of " + orderItem.getVaccineDetails().getVaccineDefinition().getVaccineName() + " has changed from " + oldQuantity + " to " + newQuantity;
        JOptionPane.showMessageDialog(null, msg);
        orderItem.getVaccineDetails().setAvailablity(oldAvail + oldQuantity - newQuantity);

        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:

        if (!isCheckout) {

            for (OrderItem oi : cartOrder) {
                VaccineDetails product = oi.getVaccineDetails();
                int oldAvail = product.getAvailablity();
                int orderedQuantity = oi.getQuantity();
                int newAvail = oldAvail + orderedQuantity;
                product.setAvailablity(newAvail);
            }
            

            JOptionPane.showMessageDialog(null, "Order has not been checked out properly hence previous order will be canceled!");

        } else {
            JOptionPane.showMessageDialog(null, "Order has been checked out successfully, Thank you!");
        }
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);

    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        int selectRow = tbcart.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Kindly first select a vaccine from the cart !");
            return;
        }
        OrderItem oi = (OrderItem) tbcart.getValueAt(selectRow, 1);
        int oldQuantity = oi.getVaccineDetails().getAvailablity();
        int orderedQuantity = oi.getQuantity();
        int newQuantity = orderedQuantity + oldQuantity;
        oi.getVaccineDetails().setAvailablity(newQuantity);
        cartOrder.remove(oi);
        
        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
       if (cartOrder != null) 
            {
     
                Order cdcOrder = new Order();
                
                for(OrderItem oi: cartOrder)
                {
                    cdcOrder.getItemList().add(oi);
                }
                
                for(OrderItem oi: cartOrder)
                {
                    String manufacturer = oi.getVaccineDetails().getManufacturerName();
                    for(Manufacturer manuf : business.getManufacturerDirectory().getManufacturerDirectory())
                    {
                        if(manufacturer.equalsIgnoreCase(String.valueOf(manuf)))
                        {   
                          
                                VaccineOrderWorkRequest vaccineWorkRequest = new VaccineOrderWorkRequest();
                                vaccineWorkRequest.setSender(userAccount);
                                vaccineWorkRequest.setStatus("NewOrder");
                                Order order = new Order();
                                order.addNewOrderItem(oi.getQuantity(), oi.getVaccineDetails());
                                vaccineWorkRequest.setVaccineOrder(order);
                               
                            for(Organization org:manuf.getOrganizationDirectory().getOrganizationList() )
                            {
                                if(org instanceof ManufactureOrganization)
                                {
                                    org.getWorkQueue().addWorkRequest(vaccineWorkRequest);
                                }
                            }
                        }
                    }
                }
                
                JOptionPane.showMessageDialog(null, "Your order has been successfuly added!");
                
                CreateVaccineOrder panel = new CreateVaccineOrder(workContainer, cdc, business, cdcOrg,userAccount);
        workContainer.add("CreateVaccineOrderJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
            
        }
        else
        {JOptionPane.showMessageDialog(null, "Cannot Checkout due to error !");
        }
        displayManufacturerVaccines();
        refreshCartTable();
              
    }//GEN-LAST:event_btn6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separator1;
    private javax.swing.JSpinner addcount;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JComboBox combo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JTable tbcart;
    private javax.swing.JTable tblmanuf;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    // End of variables declaration//GEN-END:variables
}
