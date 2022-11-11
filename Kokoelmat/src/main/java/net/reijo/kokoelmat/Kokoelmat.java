/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.kokoelmat;

import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
public class Kokoelmat {
    static ArrayList<Person> personlist = new ArrayList<>();
    
    
    static {
        personlist.add(new Person(1,"Matti"));
        personlist.add(new Person(2,"Pekka"));
        personlist.add(new Person(4,"Aaro"));
        personlist.add(new Person(3,"Maija"));
        personlist.add(new Person(5,"Kaija"));
        
         
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
}
