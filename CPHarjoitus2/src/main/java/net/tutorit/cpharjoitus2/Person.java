/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Reijo
 */
class Person implements Named{
    private String name;

    public Person(String pe) {
        this.name = pe;
    }
    @Override
    public String getName(){
        return name;
    }
    
}
