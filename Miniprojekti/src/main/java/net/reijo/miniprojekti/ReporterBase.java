/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.miniprojekti;


import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author Reijo
 */
abstract public class ReporterBase implements Reporter {
    private ArrayList<ColumnDef> titleAndWidth = new ArrayList<>();
    private int counter = 0;
    private PrintWriter writer = null;
    abstract protected PrintWriter getWriter();
    abstract protected void closeWriter(PrintWriter pw);

  
    
    public void printData(String name) {
        if (writer==null) return;
        writer.printf("%-" + titleAndWidth.get(this.counter).getWidth() + "s", name);
        this.counter++;
        
        if(this.counter >= titleAndWidth.size()) {
            this.counter = 0;
            writer.println("");
         
        }
    }
    public void printData(int i) {
        printData(""+i);
    }
    
    public void printColumns() {
        if (writer == null) return;
        for (int i= 0; i < titleAndWidth.size(); i++){
        writer.printf( "%-" + titleAndWidth.get(i).getWidth() +"s", titleAndWidth.get(i).getColumnTitle());
        
        }
        writer.println("");
    }        
    public void addColumn(String title, int width) {
        titleAndWidth.add(new ColumnDef(title, width));
        
    }
    
     public void beginReport(){
        writer=getWriter();
        printColumns();
    }
    
    public void endReport() {
        writer.flush();
        closeWriter(writer);
    }
    
}   
