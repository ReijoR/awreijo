/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.springtest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Reijo
 */
public class UsingUtilImpls implements UsingUtil{
    //@Autowired
    Util util;

    @Override
    public void doWork() {
        System.out.println("Jotain hauskaa");
        util.somethingFun();
    }
    
    
}
