/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.miniprojekti;

import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
public class PersonReport {
    
    private ArrayList<ColumnDef> informations = new ArrayList<>();
    private String name;
    private int age;
    
    public PersonReport(String name, int age){
        
        
}


    public void addData(String name, int age) {
        
        
    }
    public void printColumns() {
        
        for (int i= 0; i < informations.size(); i++){
        System.out.printf( "%-" + informations.get(i).getWidth()"s", informations.get(i).getColumnTitle());
        }
    }
    /**
     *
     */
    public void doReport() {
         
    }

}
