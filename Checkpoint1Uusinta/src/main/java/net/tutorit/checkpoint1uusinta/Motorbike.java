/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint1uusinta;

/**
 *
 * @author Reijo
 */
public class Motorbike implements Vehicle {
    private final String owner;
    private String type = "moottoripyörä";
    
    /**
     *
     * @param owner
     */
    public Motorbike (String owner){
        this.owner = owner;
        
        
    }

    
    

    /**
     *
     * @return
     */
    @Override
    public String getOwner(){
        return owner;
    }
    @Override
    public String getType(){
        return type;
    }

    
    
}
