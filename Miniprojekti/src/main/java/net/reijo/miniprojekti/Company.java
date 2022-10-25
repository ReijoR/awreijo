/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.miniprojekti;

/**
 *
 * @author Reijo
 */
public class Company {
    private String company;
    private String phone;
    private String email;
    
    public Company(String company, String phone, String email){
       this.company = company;
       this.phone = phone;
       this.email = email;
    
    }
    public String getCompany(){
        return company;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
}
