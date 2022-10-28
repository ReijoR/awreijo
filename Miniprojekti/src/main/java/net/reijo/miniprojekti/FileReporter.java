/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.miniprojekti;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Reijo
 */
public class FileReporter extends ReporterBase {
    //private ArrayList<ColumnDef> titleAndWidth = new ArrayList<>();
    //private int counter = 0;
    private String fileName;
   
    
    public FileReporter(String fn) {
        fileName=fn;
        
    }
    protected PrintWriter getWriter(){
        try{
            return new PrintWriter(new FileWriter(fileName));
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    protected void closeWriter(PrintWriter pw){
        pw.close();
    }
   
}

    

