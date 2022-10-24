/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.miniprojekti;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
public class ScreenReporter {
    //private String name;
    //private int age;
    private ArrayList<ColumnDef> informations = new ArrayList<>();
    //private String heading1 = "Name";
    //private String heading2 = "Age";

    public ScreenReporter() {
        this.informations = new ArrayList<>();
    }
    

    public void addColumn(String title, int width) {
        informations.add(new ColumnDef(title, width));
        
    }

    public void printColumns() {
        
        for (int i= 0; i < informations.size(); i++){
        System.out.printf( "%-" + informations.get(i).getWidth()"s", informations.get(i).getColumnTitle());


        
    }

    public void printData(String name) {
        System.out.printf("%-20s", name);
         

    
    }

    public void printData(int age) {
        System.out.printf("%5s\n", age);
    }

    
    
    
}
