/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Reijo
 */
class Some {
    private String txt;
    
    public Some(String t){
        txt=t;
    }
    
    public void print(){
        System.out.println(this+" "+txt);
    }
    
    
    public String toString(){
        return "Some";
    }
}