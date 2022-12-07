/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.StateNetwork;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Provider.ProviderOperationWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author swinirodrigues
 */
public class ProviderRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state) {
        return new ProviderOperationWorkAreaJPanel(userProcessContainer, account, (HospitalEnterprise)enterprise, (HospitalOrganization)organization, business, state);
    }
    
}
