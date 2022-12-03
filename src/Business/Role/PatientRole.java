/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;


import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.Patient.PatientWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author swinirodrigues
 */
public class PatientRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state) {
        return new PatientWorkAreaJPanel(userProcessContainer, account, (HospitalEnterprise)enterprise, (PatientOrganization)organization, business);
    }
    
    
}
