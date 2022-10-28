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
public class PersonReport extends ReportBase<Person> {
        
    public PersonReport(Reporter rep){
    super(rep);
    }
    protected void addColumns(Reporter reporter){
    reporter.addColumn("Name",20);
    reporter.addColumn("Age",5);
    }
    protected void printData(Reporter reporter, Person p){
    reporter.printData(p.getName());
    reporter.printData(p.getAge());
    }
}
/*
public class PersonReport {
    
    private FileReporter personReporter = new FileReporter("henkilot.txt");
    private ArrayList<Person> persons = new ArrayList<>();
    
    
    
    public PersonReport(Reporter rep){
        personReporter.addColumn("Name", 20);
        personReporter.addColumn("Age" , 5);
        
  
    }

    

    public void addData(Person p) {
        persons.add(p);
        
    }
    
    public void doReport() {
        personReporter.beginReport();
        //personReporter.printColumns();
        for(Person p:persons){
            personReporter.printData(p.getName());
            personReporter.printData(p.getAge());
            
        }
        personReporter.endReport();
         
    }

}
*/