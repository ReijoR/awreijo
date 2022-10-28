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

public class CompanyReport extends ReportBase<Company> {
    
    public CompanyReport(Reporter rep){
        super(rep);
    }
    protected void addColumns (Reporter reporter){
        reporter.addColumn("Company", 20);
        reporter.addColumn("Phone" , 15);
        reporter.addColumn("Contact email", 30);
    }
    protected void printData (Reporter reporter, Company c){
        reporter.printData(c.getCompany());
        reporter.printData(c.getPhone());
        reporter.printData(c.getEmail());
    }
}
/*
    
public class CompanyReport {
    
    private FileReporter companyReporter = new FileReporter("yritykset.txt");
    private ArrayList<Company> companies = new ArrayList<>();
    
    
    public CompanyReport(Reporter rep){
        companyReporter.addColumn("Company", 20);
        companyReporter.addColumn("Phone" , 15);
        companyReporter.addColumn("Contact email", 30);
    }
    public void addData(Company c){
       companies.add(c);
    }
    public void doReport(){
        companyReporter.beginReport();
        //companyReporter.printColumns();
        for(Company c:companies){
            companyReporter.printData(c.getCompany());
            companyReporter.printData(c.getPhone());
            companyReporter.printData(c.getEmail());
        }
        companyReporter.endReport();
    }
}
*/