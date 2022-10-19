/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.techniques.interfaces;

/**
 *
 * @author Reijo
 */
public class Person implements Cloneable,Customer,Worker,Comparable {
    public String name="Reijo";
    private int age=26;
    
    public Person(){}
    
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    
    @Override
    public String toString(){
        return name+" on "+age+" vuotias";
    }
    
    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Person clone() throws CloneNotSupportedException{
        try{
            return (Person)super.clone();
        }
        catch(CloneNotSupportedException ex){
            System.out.println("Ei sallitu");
        }
        return null;
    }

    @Override
    public void makePurchase(double amount) {
        System.out.println(getName()+" ostaa "+amount);
    }

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
        System.out.println(name+" is payed "+amount+" EUR and "+amount*0.25+" as social security fees");
    }
    
    @Override
    public boolean equals(Object o){
        System.out.println("equals");
        if (o.getClass()!=this.getClass()) return false;
        Person p=(Person)o;
        if (!this.name.equals(p.getName())) return false;
        return true;
    }
    
    @Override
    public int hashCode(){
        System.out.println("hashCode");
        return name.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        Person p=(Person)o;
        return this.name.compareTo(p.name);
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

}
