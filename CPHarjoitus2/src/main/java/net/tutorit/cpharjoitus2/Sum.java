/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus2;

/**
 *
 * @author Reijo
 */
public class Sum extends CalcBase {

    public Sum(int a, int b) {
        super(a,b,'+');
    }

    public int result() {
        return a+b;
    }
    
}
