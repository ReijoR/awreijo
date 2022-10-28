/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

import java.util.ArrayList;

/**
 *
 * @author jyrki
 */
public class NewspaperList extends Pool {
    //private ArrayList<Newspaper> listing=new ArrayList<>();
    
    
    public void listThem(){
        System.out.println("Newspapers");
        for(Object p:super.listing){
            System.out.println();
        }
    }

    
    
}
