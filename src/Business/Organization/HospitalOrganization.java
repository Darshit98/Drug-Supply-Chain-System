/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Organization;

import Business.Clinic.Clinic;
import Business.Order.OrderHistory;
import Business.Role.ProviderRole;
import Business.Role.Role;
import Business.Vaccine.ProviderVaccineInventory;
import java.util.ArrayList;

/**
 *
 * @author riyavirani
 */

public class HospitalOrganization extends Organization{
    
    private ProviderVaccineInventory vaccineInventory;
    private OrderHistory oc;
    private Clinic clinic;
    
    public HospitalOrganization() {
        
        super(OrganizationType.HospitalOrg.getValue());
        vaccineInventory = new ProviderVaccineInventory();
        this.clinic = new Clinic();
        this.oc = new OrderHistory();
    }

    public OrderHistory getOc() {
        return oc;
    }

    public void setOc(OrderHistory oc) {
        this.oc = oc;
    }
    
    
    public ProviderVaccineInventory getVaccineInventory() {
        return vaccineInventory;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
    

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ProviderRole());
        return roles;
    }
    
}
