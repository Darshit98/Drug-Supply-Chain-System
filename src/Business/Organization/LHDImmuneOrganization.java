/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Organization;

import Business.Role.LocalHealthDepartmentRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author riyavirani
 */

public class LHDImmuneOrganization extends Organization{

    public LHDImmuneOrganization() {
        super(OrganizationType.LocalHealthDepartmentOrg.getValue());
    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
          ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LocalHealthDepartmentRole());
        return roles;
    }
    
}
