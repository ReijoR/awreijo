/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Reijo
 */
public abstract class Juice implements Priced {
    private String name;
    private Object price;

    public Juice(String mehu, Object a) {
        this.name = mehu;
        this.price = a;
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
