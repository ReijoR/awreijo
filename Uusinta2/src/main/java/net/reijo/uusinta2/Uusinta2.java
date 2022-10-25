/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.uusinta2;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
public class Uusinta2 {

    public static void main(String[] args) {
        
    
        Store s=new Store();
        s.add(new Milk());
        s.add(new Meat());
        s.add(new Milk());
        s.add(new Meat());
        s.print();

        ArrayList<Product> pl=s.getBestBefore(LocalDate.of(2022,10,30));

        for(Product p:pl) System.out.println(p.getName()+" "+p.getBestBefore());
        
    
    }
}
