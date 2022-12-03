/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

/**
 *
 * @author riyavirani
 */
public class EnterpriseAdminPerson extends Person{
    
    private int id;
    private static int count = 1;

    public EnterpriseAdminPerson() {
        id = count;
        count++;
    }
    
     public int getId() {
        return id;
    }
    
    
    
    @Override
    public String toString(){
        return this.getFirstName()+" "+this.getLastName();
    }
    
    
}
