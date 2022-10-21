/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint1;

/**
 *
 * @author Reijo
 */
public class Television implements Merchandise {
    private String name;
    private int price;
    
    public Television (String name, int price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public String getName(){
        return name;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPrice(){
        return String.valueOf(price);
    }
}
