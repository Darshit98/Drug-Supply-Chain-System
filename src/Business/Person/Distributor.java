/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;


/**
 *
 * @author riyavirani
 */
public class Distributor extends Person {
    
    private int id;
    private static int count = 1;

    public Distributor() {
        id = count;
        count++;
        this.setLastName(null);
        
    }
    
      public int getId() {
        return id;
    }
      
      @Override
    public String toString(){
        return this.getFirstName()+" "+this.getLastName();
    }
    
    
}
