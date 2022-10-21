/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint1;

/**
 *
 * @author Reijo
 */
public class Microwave implements Merchandise{
    private String name;
    private int price;
    
    public Microwave (String name, int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public String getPrice(){
        return String.valueOf(price);
    }
}
