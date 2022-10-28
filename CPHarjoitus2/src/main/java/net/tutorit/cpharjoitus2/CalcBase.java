/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Reijo
 */
abstract public class CalcBase {
    public abstract int result();
    protected int a;
    protected int b;
    char operator;
    
    public CalcBase(int a, int b, char operator){
        this.a = a;
        this.b = b;
        this.operator = operator;
    }
    public void print (){
        System.out.println("" +a+operator+b+"="+result());
    }
}
