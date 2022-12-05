/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Organization;

import Business.Role.DistributorRole;
import Business.Role.Role;
import Business.Warehouse.WarehouseDirectory;
import java.util.ArrayList;

/**
 *
 * @author riyavirani
 */
public class DistributorOrganization extends Organization{
    
    private WarehouseDirectory warehouseDir;
    
    public DistributorOrganization() {
        super(OrganizationType.DistributorOrg.getValue());
        warehouseDir = new WarehouseDirectory();
    }

    public WarehouseDirectory getWarehouseDir() {
        return warehouseDir;
    }
    
    
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DistributorRole());
        return roles;
    }
    
}
