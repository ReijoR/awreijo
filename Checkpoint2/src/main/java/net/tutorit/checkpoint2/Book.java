/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint2;

/**
 *
 * @author Reijo
 */
public class Book {
    private Object book;

    public Book(Object t) {
        this.book = t;
        
    }
    public void print(){
        System.out.println(this+" ");
    }
    public String toString(){
        return "In a hole in the ground there lived a hobbit";
    }

    String getTitle() {
        return "Hobbit";
    }
}
