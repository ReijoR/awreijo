/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint1uusinta;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
class PurchaseOrder {
    private ArrayList<Items> item = new ArrayList<>();
    private String customer;
    private LocalDate orderDate = LocalDate.now();
    private LocalDate deliveryDate = LocalDate.now().plusWeeks(3);
    private double totalCost = 0;
    
    
    
    PurchaseOrder(String customer) {
        this.customer = customer;
        
    }
    
    public void addItem(String name, int quantity, double price) {
        item.add(new Items(name,quantity,price));
       
    }
    /*
    
    }
    public void deliveryDate(){
        LocalDate dd = LocalDate.now().plusWeeks(3);
        System.out.println(dd);
    }
    */
    public void print() {
        System.out.println("Asiakas: " +customer);
        System.out.println("Tilauspäivä: " +orderDate);
        System.out.println("Toimituspäivä: " +deliveryDate);
        for (Items i : item) {
        System.out.println("Tuote: " +i.getName() + " Määrä: " + i.getQuantity() + " Yksikköhinta: " + i.getUnitPrice() + " Kokonaishinta: " + (i.getQuantity()*i.getUnitPrice()));
        totalCost = totalCost + (i.getQuantity()*i.getUnitPrice());
        }
        
    
    
    }
    
    public boolean isUrgent() {
        
        if (totalCost > 50) {
             return true; 
        }else { 
            return false;
        }
    }        
         
        
        
          

}    
      
    
    
    
 
    

