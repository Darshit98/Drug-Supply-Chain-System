/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author swinirodrigues
 */
public class LocalHealthDepartment extends Enterprise {

    public LocalHealthDepartment(String stateName) {
        super(stateName, EnterpriseType.LocalHealthDepartment);
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
