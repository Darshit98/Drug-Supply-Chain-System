/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
