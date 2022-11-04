/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.springtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Reijo
 */
@SpringBootApplication
public class SpringTest {
    
    
    
    @Bean
    public CommandLineRunner jokuVaan(Util u, UsingUtil uu, Calculation calc){
        return args -> {
            System.out.println("Now we are running");
            
            u.somethingFun();
            uu.doWork();
            //utilHereToo.somethingFun();
            System.out.println("Calculations");
            int c = calc.add(4,6);
            System.out.println("Done");
            
        };
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(SpringTest.class,args);
    }
}
