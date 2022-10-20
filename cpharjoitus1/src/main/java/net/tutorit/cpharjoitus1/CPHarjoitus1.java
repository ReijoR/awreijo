/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.tutorit.cpharjoitus1;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author jyrki
 */
public class CPHarjoitus1 {
    /*
    Koodia kannattaa lukea alhaalta ylöspäin
    */
    
    /*
        Seuraavakin funktio pitäisi saada toimimaan.
        Joudut siis tekemään vielä pari luokkaa
    */
    /*    
    static void companyTester(){
        Company c=new Company("Testers United");
        c.addEmployee("Tuomas",LocalDate.of(2000,5,1));
        System.out.println(c.getEmployeeInfo("Tuomas"));
        // Pitäisi tulostua: Tuomas aloitti 1.5.2000, työsuhde jatkuu vielä
        c.addEmployee("Simeoni",LocalDate.of(2010, 9, 2),LocalDate.of(2015,2,3));
        System.out.println(c.getEmployeeInfo("Simeoni"));
        // Pitäisi tulostua: Simeoni aloitti 2.9.2010 ja lopetti 3.2.2015
        c.addEmployee("Aapo",LocalDate.of(2014,5));
        // addEmployee:lle siis parametrinä nimi sekä työsuhteen alkupäivä sekä mahdollisesti lopetuspäivä
        List<Person> all=c.getAll();
        // Tulosta kaikki työntekijät (myös ne joiden työsuhde ei enää jatku) nimen mukaisessa aakkosjärjestyksessä
        for(Person p: all){
            System.out.println(c.getEmployeeInfo(p.getName()));
        }
        List<Person> still=c.getStillEmployed();
        // Tulosta voimassa olevat työsuhteet alkamispäivän mukaisessa järjestyksessä
        for(Person p:still){
            System.out.println(c.getEmployeeInfo(p.getName()));
        }
        // Kaikki työntekijät tiedostoon
        c.exportEmployees("employees.txt");
    }
    */
        
    /*
    Laajenna koodia siten, että saat alla olevat kaksi metodia toimimaan
    */
    
    static void veterinarianTreats(Pet p){
        System.out.println("Sairaskertomus: "+p.getBasicInfo()); // Sekarotuinen (Hurtta) tai Norjalainen metsäkissa (Misu)
    }
    
    static void veterinarianTester(){
        Dog d=new Dog("Hurtta");
        Cat c=new Cat("Misu");
        veterinarianTreats(d);
        veterinarianTreats(c);
    }
    
    static String justDate(LocalDateTime dt){
        return dt.toLocalDate().toString();
        
    }
    
    static boolean isDateAfter(LocalDateTime dt,int year,int month, int day){
        LocalDate dt2 = LocalDate.of(year,month,day);
        LocalDate dt3 = dt.toLocalDate();
        
        return dt2.isAfter(dt3);
    }
    
    static LocalDateTime nextWednesdayAtNine(){
        LocalDateTime dt = LocalDateTime.now().withHour(9).withMinute(0).withSecond(0);
        while (true){
            dt = dt.plusDays(1);
            if (dt.getDayOfWeek()==DayOfWeek.WEDNESDAY)
                break;
        }
        return dt;
    }
    
    static LocalDate askForDate(){
        // Lue käyttäjän syöte (suomalaisittain) "20.10.2022" ja palauta se LocalDate:na
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(new Locale("fi"));
        LocalDate dt = LocalDate.parse(s, pattern);
        

  //convert String to LocalDate
        
        return dt;
    }
    
    public static void main(String[] args) {
        LocalDate dt=askForDate();
        System.out.println("Käyttäjä antoi päivämäärän: "+dt);
        System.out.println("Seuraava keskiviikko kello 9.00: "+nextWednesdayAtNine());
        System.out.println("On 20.10.2020 jälkeen: "+isDateAfter(nextWednesdayAtNine(),2020,10,20));
        System.out.println("On 1.6.2023 jälkeen: "+isDateAfter(nextWednesdayAtNine(),2023,6,1));
        System.out.println("Pelkkä päivämäärä: "+justDate(nextWednesdayAtNine()));
        // Myös seuraavat pitäisi saada pois kommenteista....
        veterinarianTester();
        //companyTester();
    }
}
