/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.tutorit.checkpoint1uusinta;

/**
 *
 * @author jyrki
 */
public class Checkpoint1Uusinta {

    /* 
        Toteuta tarvittavat luokat, jotta alla oleva funktio lähtee toimimaan 
        kuvatulla tapaa.
    */
    
    static void testPurchaseOrder(){
        
        //System.out.println("Tilausjärjestelmä");
        // Tilausta muodostettaessa parametrinä menee asiakas
        // Tilauksella täytyy olla kentät orderDate (Tilauspvm) ja deliveryDate (toimituspvm)
        // Tilauspäivä=nykyinen päivä, toimituspäivä on kolmen viikon päässä tilauspäivästä
        PurchaseOrder po=new PurchaseOrder("Asiakas Oy");
        // Tilaukseen voidaan lisätä tilausrivejä
        // näiden täytyy tallettua tilauksella olevaan kokoelmaan
        po.addItem("Sakset",2,15.3);  //Tilatun tuotten nimi, kappalemäärä ja yksikköhinta
        po.addItem("Kopiopaperi",1,2.3); //Tilatun tuotten nimi, kappalemäärä ja yksikköhinta
        po.print();
        // tulostetaan:
        // Asiakkaan nimi
        // Tilauspvm: tilauspvm suomalaisittain muotoiltuna
        // Toimituspvm: toimituspvm suomalaisittain muotoiltuna
        // Kaikki tilausrivit: 
        //  tuotteen nimi, yksikköhinta, kappalemäärä ja kokonaishinta(=kpl*yksikköhinta)
        System.out.println("Tuote on kiireellinen, jos tilauksen kokonaishinta > 50"+po.isUrgent());
        // Tässä siis laskettava yhteen kaikkien rivien kokonaishinnat
        // isUrgent palauttaa vain true/false -tiedon
        po.addItem("Liima",1,50.3);
        System.out.println("Tuote on kiireellinen, jos tilauksen kokonaishinta > 50"+po.isUrgent());
        
        
    }
    
    /*
        Toteuta tarvittavat käsitteet, jotta alla olevat kaksi funktiota tuottavat
        kommenteissa mainitut tulosteet
    */
    
    static void doService(Vehicle vehicle){
        System.out.println(vehicle.getOwner()+"n "+vehicle.getType()+" kävi öljynvaihdossa");
    }
    
    static void testServiceable(){
        
        Motorbike mb=new Motorbike("Mia");
        Car c=new Car("Tuomo");
        doService(mb); // -> Mian moottoripyörä kävi öljynvaihdossa
        doService(c); // -> Tuomon auto kävi öljynvaihdossa
        
    }
    
    public static void main(String[] args) {
        //testServiceable();
        testPurchaseOrder();
    }
}
