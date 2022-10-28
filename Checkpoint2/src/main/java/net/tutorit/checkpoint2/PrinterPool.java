/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jyrki
 */
public class PrinterPool extends Pool {
    //private ArrayList<Printer> printers=new ArrayList<>();
    
    
    public void showPool(){
        System.out.println("Printers");
        for (Iterator it = super.printers.iterator(); it.hasNext();) {
            Object p = it.next();
            System.out.println(p);
        }
    }
}
