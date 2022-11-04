/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.springtest;

/**
 *
 * @author Reijo
 */
public class CalculationImpl implements Calculation{
    private Util myUtil;
    
    public CalculationImpl(Util u){
        System.out.println("Calculating");
        myUtil = u;
        
    }
    @Override
    public int add (int a, int b){
        myUtil.somethingFun();
        return a+b;
    }
}
