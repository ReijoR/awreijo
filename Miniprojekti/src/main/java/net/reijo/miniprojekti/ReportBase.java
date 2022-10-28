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
abstract public class ReportBase <T> {
abstract protected void addColumns (Reporter rep);
abstract protected void printData(Reporter reporter, T d);
    private Reporter reporter;
    ArrayList<T> list = new ArrayList<>();
    
    public ReportBase(Reporter rep){
  
        reporter = rep;
        addColumns(reporter);
    }

    
        
    void addData(T p) {
        list.add(p);
        
    }
    
    void doReport() {
        reporter.beginReport();
        for(T d:list){
           printData(reporter, d);
        }
        reporter.endReport();
    }       
    
    
}
