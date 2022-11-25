/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.booksweb.ejb;

import jakarta.ejb.Stateless;

/**
 *
 * @author Reijo
 */

    
@Stateless
public class TestBeanImpl implements TestBeanLocal {

    @Override
    public String sayHello() {
        return "Hello";
    }
    
}
    
