/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Vaccine.AdministeredVaccineDetails;
import java.util.ArrayList;

/**
 *
 * @author swinirodrigues
 */
public class Patient extends Person {
    
     private int id;
    private static int count = 1;
    private ArrayList<AdministeredVaccineDetails> administeredVaccineList ;
    

    public Patient() {
        id = count;
        count++;
        administeredVaccineList = new ArrayList<>();
    }

    public ArrayList<AdministeredVaccineDetails> getAdministeredVaccineList() {
        return administeredVaccineList;
    }
    
    public AdministeredVaccineDetails addNewAdministeredVaccine(){
        AdministeredVaccineDetails avd = new AdministeredVaccineDetails();
        administeredVaccineList.add(avd);
        return avd;
        
    }
    
    public int getId() {
        return id;
    }

    
        @Override
    public String toString(){
        return this.getFirstName()+ " " + this.getLastName();
    }

}
