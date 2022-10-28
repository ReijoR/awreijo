/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
public class Pool <T> {
    protected ArrayList<T> listing = new ArrayList <>();
    Iterable<Printer> printers;
    
    public void add (T p){
        listing.add(p);
    }
    public void print(){
        System.out.println("");
        for (T o:listing){
            System.out.println("");
        }
    }
}
