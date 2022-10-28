/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.techniques.exceptions;

/**
 *
 * @author Reijo
 */
public class ExceptionTests {
    
    /* 
      Toteuta tämä metodi siten, että käytät try-catchia tarkasti ja lähellä kohdetta,
      jossa poikkeus voi aiheutua
    */
    static int calculateWithExceptions(String calc){
        return 0;
    }

    /*
      Totauta tämä metodi siten, että metodin rungossa voi tapahtua mahdollisimman 
      vähän virheitä. Voit ensin palauttaa nollan, havaittuasi virheen.
      Sen jälkeen toteuta oma poikkeusluokka (CalculateException, 
      jolla viestit havaitsemastasi virheestä
    */
    static int calculateWithLessExceptions(String calc){
        
        
        
        return 0;
    }
    
    static public void testExceptions(){
        try {
            System.out.println("Correct "+calculateWithExceptions("1 + 2"));
            System.out.println("Correct "+calculateWithExceptions("1 + a"));
            System.out.println("Correct "+calculateWithExceptions("1 +"));
            System.out.println("Correct "+calculateWithExceptions(null));
            System.out.println("Correct "+calculateWithLessExceptions("1 + 2"));
            System.out.println("Correct "+calculateWithLessExceptions("1 + a"));
            System.out.println("Correct "+calculateWithLessExceptions("1 +"));
            System.out.println("Correct "+calculateWithLessExceptions(null));
        }
        catch(Exception ex){
            System.out.println("Jotain meni pieleen, tänne ei pitäisi tulla");
            System.out.println(ex.getMessage());
        }
    }
}
    
