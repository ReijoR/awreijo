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
/*
    private ArrayList<ColumnDef> informations;
    String heading1 = "Name";
    String heading2 = "Age";
    
    public ScreenReporter() {
        this.informations = new ArrayList<>();
        
    }

    public void addColumn(String title, int width) {
        informations.add(new ColumnDef(title, width));   
    }

    public void printColumns() {
        System.out.printf("%-20s %5s %n", heading1, heading2);          //printf() metodia käytetään formatoidun muodon printtaukseen. 
    }

    public void printData(int age) {
        System.out.printf("%5s\n", age);
    }

    public void printData(String name) {
        System.out.printf("%-20s", name);
        
    }

}
*/ 


    //private String name;
    //private int age;
    private ArrayList<ColumnDef> titleAndWidth = new ArrayList<>();
    private int counter = 0;
    
    public ScreenReporter() {
        this.titleAndWidth = new ArrayList<>();
    }
    

    public void addColumn(String title, int width) {
        titleAndWidth.add(new ColumnDef(title, width));
        
    }

    public void printColumns() {
        
        for (int i= 0; i < titleAndWidth.size(); i++){
        System.out.printf( "%-" + titleAndWidth.get(i).getWidth() +"s", titleAndWidth.get(i).getColumnTitle());
        
        }
        System.out.println("");
    }        

    public void printData(String name) {
        //System.out.printf("%-20s", name);
        //ColumnDef cd = titleAndWidth.get(this.counter);
        System.out.printf("%-" + titleAndWidth.get(this.counter).getWidth() + "s", name);
        this.counter++;
        
        if(this.counter >= titleAndWidth.size()) {
            this.counter = 0;
            System.out.println("");
            
        }
    
        
    }

    public void printData(int age) {
        //System.out.printf("%5s\n", age);
        printData(""+ age);
        
            
        
    }

    
    
    
}
