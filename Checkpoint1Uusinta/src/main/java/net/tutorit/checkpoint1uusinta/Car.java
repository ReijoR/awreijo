/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint1uusinta;

/**
 *
 * @author Reijo
 */
public class Car implements Vehicle {
    private final String owner;
    private String type = "auto";
    
    /**
     *
     * @param owner
     */
    public Car (String owner){
        this.owner = owner;
        
    }

    


    
       
    

    

    
    @Override
    public String getOwner(){
        return owner;
    }

    /**
     *
     * @return
     */
    @Override
    public String getType(){
        return type;
    }
    
}
