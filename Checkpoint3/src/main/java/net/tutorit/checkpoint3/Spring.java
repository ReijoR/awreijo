/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint3;

import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Spring {
    
    public void listEverything(){
        System.out.println("Listataan kaikki");
        // Esimerkki tiedoston lopussa
    }
    
    public Car getCarOf(int passangerId){
        // Palauta kyseisen matkustajan auto
        return new Car();
    }
    
    public void listAllPeople(){
        System.out.println("Kaikki ihmiset");
        // Listaa kaikki ihmiset (psgtype) nimenmukaisessa järjestyksessä
    }
    
    public void addPassanger(Passanger p){
        // Lisää matkustaja tietokantaan
    }
    
    public void springMain(){
        System.out.println("Spring-luokan testaus alkaa");
        Passanger p=new Passanger("Alfred",null,"ihminen");
        addPassanger(p);
        System.out.println("Lisättiin: "+p);
        listAllPeople();
        Car c=getCarOf(10);
        System.out.println("Matkustajan 10 auto on "+c.getMake());
        listEverything();
    }
}
/*
listEverything esimerkki (Jalankulkijoita ei siis tarvitse olla mukana):
Blechfire Runabout
    Aku,ankka
    Hupu,ankka
    Iines,ankkatar
    Lupu,ankka
    Tupu,ankka    
Batmobil  
    Batman,super
    Robin,apuri
DeLorean          
    Emmet,ihminen
    Marty,ihminen
*/