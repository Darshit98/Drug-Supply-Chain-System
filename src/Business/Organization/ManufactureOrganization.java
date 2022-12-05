/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Organization;

import Business.Role.ManufacturerRole;
import Business.Role.Role;
import Business.Vaccine.VaccineProductCatalog;
import java.util.ArrayList;

/**
 *
 * @author riyavirani
 */

public class ManufactureOrganization extends Organization {
    
    private VaccineProductCatalog vaccineProductCatalog;
    
    public ManufactureOrganization() {
        super(OrganizationType.ManufactureOrg.getValue());
        vaccineProductCatalog = new VaccineProductCatalog();
    }

    public VaccineProductCatalog getVaccineProductCatalog() {
        return vaccineProductCatalog;
    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ManufacturerRole());
        return roles;
    }
    
}
