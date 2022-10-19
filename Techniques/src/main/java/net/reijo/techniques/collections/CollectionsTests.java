/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.techniques.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;
import net.reijo.techniques.interfaces.Person;
/**
 *
 * @author Reijo
 */
public class CollectionsTests {
    static final ArrayList<Person> persons=new ArrayList<>();
    
    static{
        persons.add(new Person());
        persons.add(new Person("Paavo",19));
        persons.add(new Person("Aulis",32));
    }
    public static void personArrayTests(){
        persons.stream().sorted((a,b)-> a.getAge()-b.getAge()).forEach(System.out::println);
        persons.stream()
                .filter(a->a.getAge()>20)
                .forEach(p->System.out.println(p.getName()));
        persons.stream()
                .filter(a->a.getAge()>20)
                .sorted((a,b)-> a.getName().compareTo(b.getName()))
                .forEach(System.out::println);
        
        
        showPersons();
        persons.sort((a,b) -> a.getName().compareTo(b.getName()));
        showPersons();
        persons.sort((a,b) -> a.getAge()-b.getAge());
        showPersons();
        
    }
    
    public static void showPersons(){
        System.out.println("Henkilöt_______");
        for(Person p:persons){
            System.out.println(p);
        }
    }
    
    
        
    
    
    public static void mapTests(){
        System.out.println("Mappien testailua");
        HashMap<String,Person> phm=new HashMap<>();
        Person p1=new Person();
        Person p2=new Person();
        p1.setName("Joonas");
        p2.setName("Tuomas");
        phm.put("123123-345",new Person());
        phm.put("666123-345",p1);
        phm.put("777123-345",p2);
        
        for(Entry<String,Person> pe:phm.entrySet()){
            System.out.println(pe.getKey()+" ==> "+pe.getValue().getName());
        }
        for(String key:phm.keySet()){
            System.out.println(key + " ===> "+phm.get(key).getName());
        }
        for(Person p:phm.values()){
            System.out.println(p.getName());
        }
        
        Person who=phm.get("666123-345");
        System.out.println(who.getName());
        
        Map<Integer,Integer> im=new HashMap<>();
        for(int i=0;i<1000;i++){
            int random=(int)(Math.random()*37+1);
            int prev=im.getOrDefault(random, 0);
            im.put(random, prev+1);
        }
        for(int i:im.keySet()){
            System.out.println("Luku "+i+" arvottiin "+im.get(i)+" kertaa");
        }
    }
    
    
    public static void setTests(){
        System.out.println("Settien testailua");
        Set<String> hs=new TreeSet<>();
        hs.add("Monday");
        hs.add("Tuesday");
        hs.add("Wednesday");
        hs.add("Thursday");
        hs.add("Friday");
        hs.add("Saturday");
        hs.add("Sunday");
        hs.add("Monday");
        for(String s:hs){
            System.out.println(s);
        }
        
        Set<Person> ps=new TreeSet<>();
        Person person=new Person();
        person.setName("Auvo");
        ps.add(new Person());
        ps.add(new Person());
        ps.add(person);
        //ps.add(person);
        for(Person p:ps){
            System.out.println(p.getName());
        }
    }
}


