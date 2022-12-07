/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.SystemAdmin;

import Business.EcoSystem;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author riyavirani
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    
      private final JPanel workContainer;
    private final EcoSystem business;
    public ManageUserAccountJPanel(JPanel workContainer, EcoSystem business) {
        initComponents();
        this.workContainer = workContainer;
        this.business = business;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnMangeFDAAdmin = new javax.swing.JButton();
        btnMangeDistributorAdmin = new javax.swing.JButton();
        btnManageProviderAdmin = new javax.swing.JButton();
        btnManageSHAdmin = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        lblTitle.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage User Account");

        btnMangeFDAAdmin.setBackground(new java.awt.Color(0, 0, 102));
        btnMangeFDAAdmin.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnMangeFDAAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnMangeFDAAdmin.setText("Manage FDA Admin");
        btnMangeFDAAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMangeFDAAdminActionPerformed(evt);
            }
        });

        btnMangeDistributorAdmin.setBackground(new java.awt.Color(0, 0, 102));
        btnMangeDistributorAdmin.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnMangeDistributorAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnMangeDistributorAdmin.setText("Manage Distributor Admin");
        btnMangeDistributorAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMangeDistributorAdminActionPerformed(evt);
            }
        });

        btnManageProviderAdmin.setBackground(new java.awt.Color(0, 0, 102));
        btnManageProviderAdmin.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnManageProviderAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnManageProviderAdmin.setText("Manage Provider Admin");
        btnManageProviderAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProviderAdminActionPerformed(evt);
            }
        });

        btnManageSHAdmin.setBackground(new java.awt.Color(0, 0, 102));
        btnManageSHAdmin.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnManageSHAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnManageSHAdmin.setText("Manage State Health Admin");
        btnManageSHAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSHAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMangeFDAAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMangeDistributorAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManageProviderAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageSHAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(107, Short.MAX_VALUE))
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnManageProviderAdmin, btnManageSHAdmin, btnMangeDistributorAdmin, btnMangeFDAAdmin});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMangeFDAAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(btnManageSHAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMangeDistributorAdmin)
                    .addComponent(btnManageProviderAdmin))
                .addContainerGap(281, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnManageProviderAdmin, btnMangeDistributorAdmin, btnMangeFDAAdmin});

    }// </editor-fold>//GEN-END:initComponents

    private void btnManageProviderAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProviderAdminActionPerformed
        // TODO add your handling code here:
        ManageProviderAdminUserAccountJPanel panel = new ManageProviderAdminUserAccountJPanel(workContainer, business);
        workContainer.add("ManageProviderUserAccountJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_btnManageProviderAdminActionPerformed

    private void btnManageSHAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageSHAdminActionPerformed
        // TODO add your handling code here:
        ManageSHDAdminUserAccount panel = new ManageSHDAdminUserAccount(workContainer, business);
        workContainer.add("ManagePublicHealthDepartmentUserAccountJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_btnManageSHAdminActionPerformed

    private void btnMangeFDAAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMangeFDAAdminActionPerformed
        // TODO add your handling code here:
         ManageFDAAdminUserAccountJPanel panel = new ManageFDAAdminUserAccountJPanel(workContainer, business);
        workContainer.add("ManageCDCUserAccountJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_btnMangeFDAAdminActionPerformed

    private void btnMangeDistributorAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMangeDistributorAdminActionPerformed
        // TODO add your handling code here:
        ManageDistributorAdminUserAccountJPanel panel = new ManageDistributorAdminUserAccountJPanel(workContainer, business);
        workContainer.add("ManageDistributorUserAccountJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_btnMangeDistributorAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageProviderAdmin;
    private javax.swing.JButton btnManageSHAdmin;
    private javax.swing.JButton btnMangeDistributorAdmin;
    private javax.swing.JButton btnMangeFDAAdmin;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
