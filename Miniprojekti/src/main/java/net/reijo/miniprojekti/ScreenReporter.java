/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.miniprojekti;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
public class ScreenReporter extends ReporterBase{

    protected PrintWriter getWriter(){
        return new PrintWriter(System.out);
    }
    
    protected void closeWriter(PrintWriter pw){
    }
}
