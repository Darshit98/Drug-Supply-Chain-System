/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import Business.Order.OrderHistory;

/**
 *
 * @author swinirodrigues
 */
public class Provider extends Person {
     
    private OrderHistory orderHistory;
     private int id;
    private static int count = 1;

    public Provider() {
        id = count;
        count++;
    }
    
    public int getId() {
        return id;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

        @Override
    public String toString(){
        return this.getFirstName()+ " " + this.getLastName();
    }

}
