
        
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.numbergame;

import java.util.Scanner;

/**
 *
 * @author Reijo
 */
public class Numbergame {

    
    
    public static void main(String[] args) {
        
        Scanner scanner =  new Scanner(System.in);
        int secret=(int)(Math.random()*100+1);
        int guess = 0;
            while (secret != guess) {
            System.out.println("Number guess 1-100");
            guess = scanner.nextInt();
            if (guess > secret)
                System.out.println("Number is lower");
            if (guess < secret)
                System.out.println("Number is higher");
            
            
            
                
        }
            System.out.println("Right answer!");
    }
}
