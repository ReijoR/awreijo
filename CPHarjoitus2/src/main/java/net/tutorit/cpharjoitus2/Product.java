/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Reijo
 */
abstract class Product implements Named {
    private String product;

    public Product(String p) {
        this.product = p;
    }
    @Override
    public String getName(){
        return product;
    }
    @Override
    public String getExtra(){
        return "Salt";
    }
    
}
