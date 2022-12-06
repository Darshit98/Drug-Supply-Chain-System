/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.NationalEnterprise.CDC;
import Business.NationalEnterprise.Distributor;
import Business.NationalEnterprise.Manufacturer;
import java.util.ArrayList;

/**
 *
 * @author swinirodrigues
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseDirectory;

    public EnterpriseDirectory() {
        enterpriseDirectory = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    
    public Enterprise addEnterprise(String name, Enterprise.EnterpriseType type){
        
        Enterprise enterprise = null;
        
        
        if(type == Enterprise.EnterpriseType.Hospital){
            
            enterprise = new HospitalEnterprise(name);
            enterpriseDirectory.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.CDC){
            
            enterprise = new CDC(name);
            enterpriseDirectory.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Distributor){
            
            enterprise = new Distributor(name);
            enterpriseDirectory.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Manufacturer){
            
            enterprise = new Manufacturer(name);
            enterpriseDirectory.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.LocalHealthDepartment){
            
            enterprise = new LocalHealthDepartment(name);
            enterpriseDirectory.add(enterprise);
        }
        return enterprise;
    }
    
    public void removeEnterprise(Enterprise enterprise){
        
        enterpriseDirectory.remove(enterprise);
    }
    
}
