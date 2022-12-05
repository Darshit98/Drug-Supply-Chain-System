/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Order.OrderHistory;
import Business.Role.CDCEmployeeRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author riyavirani
 */

public class CDCOrganization extends Organization{
    
    private OrderHistory distributorOrders;
    public CDCOrganization() {
        super(OrganizationType.CDCOrg.getValue());
        distributorOrders = new OrderHistory();
    }

    public OrderHistory getDistributorOrders() {
        return distributorOrders;
    }

    public void setDistributorOrders(OrderHistory distributorOrders) {
        this.distributorOrders = distributorOrders;
    }
    
    
    
        
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CDCEmployeeRole());
        return roles;
    }
    
}
