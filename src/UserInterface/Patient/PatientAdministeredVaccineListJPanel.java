/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Patient;

import Business.Enterprise.HospitalEnterprise;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Person.Patient;
import Business.UserAccount.UserAccount;
import Business.Vaccine.AdministeredVaccineDetails;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author darsh
 */
public class PatientAdministeredVaccineListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdministeredVaccineListJPanel
     */
    private final JPanel workContainer;
    private final HospitalEnterprise enterprise;
    private final UserAccount userAccount;
    
    DefaultTableModel tblmodel;
    
    
    public PatientAdministeredVaccineListJPanel(JPanel workContainer,HospitalEnterprise enterprise, UserAccount userAccount ) {
        initComponents();
        this.workContainer = workContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        populatePatientTable();
    }
    
    private void populatePatientTable()
    {
        
         int rowCount = tblImmunizationRecord.getRowCount();
        tblmodel = (DefaultTableModel)tblImmunizationRecord.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            tblmodel.removeRow(i);
        }
        Patient patient =(Patient)userAccount.getPerson();
        
        
             for(Organization organize: enterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(organize instanceof HospitalOrganization)
            {
                HospitalOrganization hospitalOrg = (HospitalOrganization)organize;
                for(AdministeredVaccineDetails vaccine: hospitalOrg.getClinic().getAdministeredVaccineList())
                {     
                    if(!(vaccine.getVaccineProduct()== null) && !(vaccine.getPatient()==null) && vaccine.getPatient().equals(patient))
                    {Object[] rowData = new Object[9];
                    rowData[0]=vaccine.getVaccineProduct();
                    rowData[1]=vaccine;
                    rowData[2]=vaccine.getVaccineProduct().getManufacturerName();
                    rowData[3]=vaccine.getVaccineProduct().getBatchId();
                    rowData[4]=vaccine.getVaccineProduct().getVaccineId();
                    rowData[5]=vaccine.getDate();
                    rowData[6]=vaccine.getSiteRoute();
                    rowData[7]=vaccine.getDoseNumber();
                    rowData[8]=vaccine.getshotstatus();
                    tblmodel.addRow(rowData);
                    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblImmunizationRecord = new javax.swing.JTable();
        btnref = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Immunization Record");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 996, -1));

        tblImmunizationRecord.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblImmunizationRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Brand", "Batch Number", "Vaccine Id", "Date", "SiteRoute", "Dose Number", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImmunizationRecord.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblImmunizationRecord);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1000, 154));

        btnref.setBackground(new java.awt.Color(0, 0, 102));
        btnref.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnref.setForeground(new java.awt.Color(255, 255, 255));
        btnref.setText("Refresh");
        btnref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefActionPerformed(evt);
            }
        });
        add(btnref, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 90, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Download Certificate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 300, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefActionPerformed
        // TODO add your handling code here:
        populatePatientTable();
    }//GEN-LAST:event_btnrefActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String path = "";
        JFileChooser jFile = new JFileChooser();
        jFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = jFile.showSaveDialog(this);
        
        if(x == JFileChooser.APPROVE_OPTION)
        {
            path = jFile.getSelectedFile().getPath();
        }
        
        Document doc = new Document();
        try {
            //PdfWriter.getInstance(doc, new FileOutputStream(path+"/certificate.pdf"));
            
            doc.open();
            
            MessageFormat header=new MessageFormat("Immunization Certificate");
            MessageFormat footer=new MessageFormat("page{0,number,integer}");
            
            
            tblImmunizationRecord.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
            PdfPTable tblcertificate = new PdfPTable(9);
            
            //Adding Headers
            
            tblcertificate.addCell("Vaccine Code");
            tblcertificate.addCell("Vaccine Name");
            tblcertificate.addCell("Branch");
            tblcertificate.addCell("Batch Number");
            tblcertificate.addCell("Vaccine ID");
            tblcertificate.addCell("Date");
            tblcertificate.addCell("Site Route");
            tblcertificate.addCell("Dose Number");
            tblcertificate.addCell("Status");
            
            for(int i=0; i< tblImmunizationRecord.getRowCount(); i++)
            {
                String VaccineCode = tblImmunizationRecord.getValueAt(i, 0).toString();
                String VaccineName = tblImmunizationRecord.getValueAt(i, 1).toString();
                String Branch = tblImmunizationRecord.getValueAt(i, 2).toString();
                String BatchNumber = tblImmunizationRecord.getValueAt(i, 3).toString();
                String VaccineID = tblImmunizationRecord.getValueAt(i, 4).toString();
                String Date = tblImmunizationRecord.getValueAt(i, 5).toString();
                String SiteRoute = tblImmunizationRecord.getValueAt(i, 6).toString();
                String DoseNumber = tblImmunizationRecord.getValueAt(i, 7).toString();
                String status = tblImmunizationRecord.getValueAt(i, 8).toString();
                
                tblcertificate.addCell(VaccineCode);
                tblcertificate.addCell(VaccineName);
                tblcertificate.addCell(Branch);
                tblcertificate.addCell(BatchNumber);
                tblcertificate.addCell(VaccineID);
                tblcertificate.addCell(Date);
                tblcertificate.addCell(SiteRoute);
                tblcertificate.addCell(DoseNumber);
                tblcertificate.addCell(status);
            }
            
            doc.add(tblcertificate);
            
            
            
            
        } catch (DocumentException ex) {
            Logger.getLogger(PatientAdministeredVaccineListJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PrinterException ex) {
            Logger.getLogger(PatientAdministeredVaccineListJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnref;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblImmunizationRecord;
    // End of variables declaration//GEN-END:variables
}
