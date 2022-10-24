/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint1;

import java.time.LocalDate;


/**
 *
 * @author Reijo
 */
public class Transaction {
    LocalDate date;
    double amount;
    
    public Transaction(LocalDate dt, double am){
            
        date = dt;
        amount = am;
        
    }       
    

    LocalDate getDate() {
        return date;
        
    }

    public double getAmount() {
        
        return amount;
    }
    /*String getDescription() {
        String tx="Pano";
        if (amount<0) tx="Otto";
        return tx+" "+date+" "+amount;
    }
    */
    /*void add(Transaction transaction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    */
}
