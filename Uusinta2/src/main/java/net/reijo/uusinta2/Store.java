/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.uusinta2;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
public class Store {
    private ArrayList<Product> product = new ArrayList<>();
    
   
    public Store(ArrayList product){
        this.product=product;
        
    }
   
    
    public void addProduct(String name, LocalDate bestBefore) {
        
        
    }

    public void print(String item, LocalDate bestBefore) {
        
        
        
        //Milk gets old 2.11.2022
        //Meat gets old 28.10.2022
    }

    ArrayList<Product> getBestBefore(LocalDate what) {
        
    }
    
}