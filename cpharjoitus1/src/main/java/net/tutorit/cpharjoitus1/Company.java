/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jyrki
 */
public class Company {
    private String name;
    private ArrayList<Person> employees=new ArrayList<>();
    
    public Company(String name){
        this.name=name;
    }

    public void addEmployee(String name, LocalDate start) {
        employees.add(new Person(name,start));
    }

    public void addEmployee(String name, LocalDate start, LocalDate end) {
        employees.add(new Person(name,start,end));
    }

    public String getEmployeeInfo(String name) {
        
        for(Person p:employees){
            if (p.getName().equals(name)) {
                if (p.getEnd()==null) return p.getName()+" aloitti "+p.getStart()+" ja työsuhde jatkuu vielä";
                return p.getName()+" aloitti "+p.getStart()+" ja lopetti "+p.getEnd();
            }
        }
        return name+" ei ole työntekijärekisterissä";
    }

    List<Person> getAll() {
        employees.sort((a,b) -> a.getName().compareTo(b.getName()));
        
        return employees;
    }

    List<Person> getStillEmployed() {
        
        return employees.stream()
                .filter(p -> p.getEnd()==null)
                .sorted((a,b) -> a.getStart().compareTo(b.getStart()))
                .collect(Collectors.toList()); 
    }

    void exportEmployees(String fn) throws FileNotFoundException {
        try(PrintWriter fw=new PrintWriter(fn)) {
            for(Person p: employees){
                String s=this.getEmployeeInfo(p.getName());
                fw.println(s);
            }
            fw.close();
        }
    }
}
