/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.booksweb.ejb;

import jakarta.ejb.Local;

/**
 *
 * @author Reijo
 */

@Local
public interface TestBeanLocal {
    public String sayHello();

    
}
