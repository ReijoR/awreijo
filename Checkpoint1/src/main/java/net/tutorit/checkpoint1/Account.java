/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reijo
 */
class Account {
    String owner;
    double initialAmount;
    ArrayList<Transaction> transactions = new ArrayList();

    public Account(String owner, double initialAmount) {
        this.owner = owner;
        this.initialAmount = initialAmount;
    }

    void transaction(double amount, LocalDate date) {
        
        transactions.add(new Transaction(date,amount));
        
    }
    void transaction(Transaction transaction){
        transactions.add(transaction);
    }

    /*void export(String "tapahtumat.txt") {
         
    }

    List<Transaction> getAll() {
        transanctions.sort((a,b) -> {
            return a.getDate().compareTo(b.getDate());
        });
        
        return transanctions;
    }
    */

    List<Transaction> getAll() {
        ArrayList<Transaction> ret = new ArrayList<>();
        for(Transaction t:transactions){
            ret.add(t);
        }
        return ret;
    }
    void export(String fn) {
        try(PrintWriter pw=new PrintWriter(new FileWriter(fn))){
            pw.println(owner);
            pw.println(initialAmount);
            double finalBalance=initialAmount;
            for(Transaction t:transactions){
                finalBalance+=t.getAmount();
                pw.println(t.getDate()+" "+t.getAmount());
                //pw.println(t.getDescription());
            }
            pw.println("Loppusaldo "+finalBalance);
        }
        catch(IOException ex){
            System.out.println("Export epäonnistui");
        }
   }
}

