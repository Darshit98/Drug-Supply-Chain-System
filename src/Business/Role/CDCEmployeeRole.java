/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.CDC;
import Business.Network.StateNetwork;
import Business.Organization.CDCOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CDC.FDAEmployee;
import javax.swing.JPanel;

/**
 *
 * @author swinirodrigues
 */
public class CDCEmployeeRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state) {
        return new FDAEmployee(userProcessContainer, account, (CDC)enterprise, (CDCOrganization)organization, business);
    }
    
}
