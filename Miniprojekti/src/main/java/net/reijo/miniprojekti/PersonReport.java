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
public class PersonReport {
    
    private FileReporter personReporter = new FileReporter("henkilot.txt");
    private ArrayList<Person> persons = new ArrayList<>();
    
    
    
    public PersonReport(){
        personReporter.addColumn("Name", 20);
        personReporter.addColumn("Age" , 5);
        //this.age = age;
  
    }

    public void addData(Person p) {
        persons.add(p);
        
    }
    
    public void doReport() {
        personReporter.beginReport();
        personReporter.printColumns();
        for(Person p:persons){
            personReporter.printData(p.getName());
            personReporter.printData(p.getAge());
            
        }
        personReporter.endReport();
         
    }

}
