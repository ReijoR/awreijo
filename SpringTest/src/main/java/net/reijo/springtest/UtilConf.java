/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.springtest;

import org.springframework.context.annotation.Bean;

/**
 *
 * @author Reijo
 */
public class UtilConf {
    
    @Bean
    public UsingUtil doWork(){
        return new UsingUtilImpls();
    }
    
}
