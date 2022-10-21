/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus1;

import java.time.LocalDate;

/**
 *
 * @author jyrki
 */
public class Person {
    private String name;
    private LocalDate start;
    private LocalDate end;

    public Person(String name,LocalDate start){
        this.name=name;
        this.start=start;
        this.end=null;
    }


    public Person(String name,LocalDate start,LocalDate end){
        this.name=name;
        this.start=start;
        this.end=end;
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

    /**
     * @return the start
     */
    public LocalDate getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(LocalDate start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
