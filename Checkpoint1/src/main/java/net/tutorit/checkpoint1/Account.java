/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint1;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Reijo
 */
public class Account {
    private String name;
    private double amount;

    Account(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    void transaction(double d, LocalDate of) {
        
    }

    
    

    void export(String "tapahtumat.txt") {
         
    }

    List<Transaction> getAll() {
        transanctions.sort((a,b) -> {
            return a.getDate().compareTo(b.getDate());
        });
        
        return transanctions;
    }
    
}
