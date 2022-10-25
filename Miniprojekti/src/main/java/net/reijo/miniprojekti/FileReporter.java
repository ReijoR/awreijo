/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.miniprojekti;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
public class FileReporter {
    private ArrayList<ColumnDef> titleAndWidth = new ArrayList<>();
    private int counter = 0;
    private String fileName;
   
    
    private PrintWriter writer;
    
    public FileReporter(String fn) {
        fileName=fn;
        
    }
   
    public void beginReport() {
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        }catch (IOException e){
            writer.println("Tiedoston avaaminen epäonnistui");
        }
  
    }
    
    public void endReport(){
       writer.flush();
       writer.close();
        
    }

    public void addColumn(String title, int width) {
        titleAndWidth.add(new ColumnDef(title, width));
        
    }

    public void printColumns() {
        
        for (int i= 0; i < titleAndWidth.size(); i++){
        writer.printf( "%-" + titleAndWidth.get(i).getWidth() +"s", titleAndWidth.get(i).getColumnTitle());
        
        }
        writer.println("");
    }        

    public void printData(String name) {
        
        writer.printf("%-" + titleAndWidth.get(this.counter).getWidth() + "s", name);
        this.counter++;
        
        if(this.counter >= titleAndWidth.size()) {
            this.counter = 0;
            writer.println("");
            
        }
    
        
    }

    public void printData(int age) {
        
        printData(""+ age);
        
            
        
    }

    
    
    
}

    

