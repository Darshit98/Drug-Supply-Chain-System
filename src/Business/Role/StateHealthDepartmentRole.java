/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.StateHealthDepartment;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Organization.SHDImmuneOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.StateHealthDepartment.StateHealthDepartmentEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author riyavirani
 */
public class StateHealthDepartmentRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state) {
        return new StateHealthDepartmentEmployeeWorkAreaJPanel(userProcessContainer, account, (StateHealthDepartment)enterprise, (SHDImmuneOrganization)organization, business, state);
    }
  
}
