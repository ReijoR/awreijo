/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.uusinta2;

import java.time.LocalDate;

/**
 *
 * @author Reijo
 */
public class Milk implements Product {
    private String name;
    private LocalDate bestBefore;
    
    public Milk (String Maito, LocalDate bestBefore){
            this.name = Maito;
            this.bestBefore=LocalDate.now().plusDays(7);
    }                

    @Override
    public String getName() {
        return name;
        
    }

    @Override
    public LocalDate getBestBefore() {
        return bestBefore;
    }
}
