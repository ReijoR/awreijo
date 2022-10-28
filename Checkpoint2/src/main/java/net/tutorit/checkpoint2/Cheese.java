/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Reijo
 */
public abstract class Cheese implements Priced{
    private String name;
    private double price;

    public Cheese(String juusto, double b) {
        this.name = juusto;
        this.price = b;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public Object getPrice(){
        return price;
    }
    
}
