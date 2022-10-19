/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.techniques.interfaces;

/**
 *
 * @author Reijo
 */
public class Company implements Worker{
    private String name="Coders unlimited";

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void pay(double amount) {
        System.out.println(name+" invoices "+amount+"EUR + VAT "+amount*0.24+"EUR");
    }
}
