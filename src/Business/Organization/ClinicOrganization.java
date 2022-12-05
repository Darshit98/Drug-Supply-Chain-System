/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Organization;

import Business.Role.Role;
import Business.Role.ClinicProviderRole;
import java.util.ArrayList;

/**
 *
 * @author riyavirani
 */
public class ClinicOrganization extends Organization{
    
    private String ClincName;
    
    public ClinicOrganization() {
        super(OrganizationType.ClinicOrganization.getValue());
    }

    public String getClincName() {
        return ClincName;
    }

    public void setClincName(String ClincName) {
        this.ClincName = ClincName;
    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ClinicProviderRole());
        return roles;
    }
    
}
