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
public class CompanyReport {
    private ScreenReporter reporter = new ScreenReporter();
    private ArrayList<Company> companies = new ArrayList<>();
    
    
    public CompanyReport(){
        reporter.addColumn("Company", 20);
        reporter.addColumn("Phone" , 15);
        reporter.addColumn("Contact email", 30);
    }
    public void addData(Company c){
       companies.add(c);
    }
    public void doReport(){
        reporter.printColumns();
        for(Company c:companies){
            reporter.printData(c.getCompany());
            reporter.printData(c.getPhone());
            reporter.printData(c.getEmail());
        }
    }
}
