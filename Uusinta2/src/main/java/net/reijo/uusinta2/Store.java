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
    
    
    public Store(){
        
        
    }
    
    public void addProduct(Product  p) {
        product.add(p);

    }

    /**
     *
     */
    public void print() {
        
        for (Product p : product) {
        
        }
        
        
        
        //Maito vanhenee....
        
    }

    ArrayList<Product> getBestBefore(LocalDate what) {
        return null;
    }

    
    
    
}