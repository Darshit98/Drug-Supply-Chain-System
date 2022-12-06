/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Vaccine.VaccineProductCatalog;
/**
 *
 * @author riyavirani
 */
public class ManufacturerEmployee extends Person{
    
    private int id;
    private static int count = 1;
    //private VaccineProductCatalog vaccineProductCatalog;

    public ManufacturerEmployee() {
        id = count;
        count++;
        this.setLastName(null);
       // this.vaccineProductCatalog = new VaccineProductCatalog();
        
    }
    
    public int getId() {
        return id;
    }
     
    @Override
    public String toString(){
        return this.getFirstName()+" "+this.getLastName();
    }
    
}
