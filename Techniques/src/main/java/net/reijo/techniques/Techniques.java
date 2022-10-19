/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */



package net.reijo.techniques;



import net.reijo.techniques.dates.DateTests;
import java.lang.reflect.Method;
import net.reijo.techniques.collections.CollectionsTests;

import net.reijo.techniques.interfaces.Company;
import net.reijo.techniques.interfaces.Customer;
import net.reijo.techniques.interfaces.Person;
import net.reijo.techniques.interfaces.Worker;






/**
 *
 * @author Reijo
 */
public class Techniques {
    
    static void shop(Customer c){
        c.makePurchase(2000);
    }
    
    static void finances(Worker w, double amount){
        System.out.println("Finances is processing worker.....");
        w.pay(amount);
        System.out.println("....done with it");
    }
    
    public static void main(String[] args) {
        /*finances(a -> System.out.println("Pimeää työtä "+a),8000);
        
        finances((double a) -> {
            System.out.println("Pimeää työtä "+a);
        },8000);

        Person p=new Person();
        finances(p,2000);

        CollectionsTests.personArrayTests();
        CollectionsTests.setTests();
        
        CollectionsTests.mapTests();
        //Person p=new Person();
        Company c=new Company();
        
        finances(p,3000);
        finances(c,2000);
        
        Person p2=p.clone();
        p.name="Taavi";
        System.out.println(p2.name);
        
        shop(p);
        */
        //System.out.println("Hello World!");
        //DateTests.firstTest();
        //DateTests.showCurrent();
        //DateTests.someCalculations();
        //DateTests.howManyDays();
        //DateTests.localeTest();
        //DateTests.differentOffices();
        CollectionsTests.personArrayTests();
        
        
    }
}
        
