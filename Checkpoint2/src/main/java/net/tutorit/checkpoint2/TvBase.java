/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Reijo
 */
public class TvBase {
    protected String name;
    protected int duration;
    
    public TvBase(String name, int duration){
        this.name = name;
        this.duration = duration;
    }
    public void print (){
        System.out.println(name + " " + "duration " + duration + " minutes");
    }
}

