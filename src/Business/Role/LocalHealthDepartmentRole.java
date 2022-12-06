/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LocalHealthDepartment;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Organization.LHDImmuneOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.LocalHealthDepartment.LHDEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author riyavirani
 */
public class LocalHealthDepartmentRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state) {
        return new LHDEmployeeWorkAreaJPanel(userProcessContainer, account, (LocalHealthDepartment)enterprise, (LHDImmuneOrganization)organization, business, state);
    }
  
}
