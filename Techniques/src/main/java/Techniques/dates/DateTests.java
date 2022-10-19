


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Techniques.dates;


import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.TimeZone;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;




/**
 *
 * @author Reijo
 */
public class DateTests {
    
    public static void localeTest(){
        
        Locale fi= new Locale("fi");
        Locale en = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getNumberInstance(fi);
        System.out.println(nf.format(-234567890));
        NumberFormat nf2 = NumberFormat.getNumberInstance(en);
        System.out.println(nf2.format(-234567890));
        nf = NumberFormat.getCurrencyInstance(fi);
        System.out.println(nf.format(234567890));
        

}
    public static void differentOffices(){
    Scanner scanner = new Scanner(System.in);    
    String city;
    Date Helsinki = new Date();
    Date Tokyo = new Date();
    Date NewYork = new Date ();
    DateFormat t = new SimpleDateFormat("dd/MM/yyyy" + " " +" HH:mm:ss");
    DateFormat n = new SimpleDateFormat("dd/MM/yyyy" + " " +" HH:mm:ss");
    DateFormat h = new SimpleDateFormat("dd/MM/yyyy" + " " +" HH:mm:ss");
    t.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
    n.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    h.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
    
        while (true){
        
        System.out.println("Office Location?: Helsinki, Tokyo or New York ");
        city = scanner.nextLine();
    
        switch(city){
            case "Helsinki":
                System.out.println("Your time: " + h.format(Helsinki));
                System.out.println("Time in Tokyo: " + t.format(Tokyo));
                System.out.println("Time in New York: " + n.format(NewYork));
                return;
            case "Tokyo":
                System.out.println("Your time: " + t.format(Tokyo));
                System.out.println("Time in Helsinki : " + h.format(Helsinki));
                System.out.println("Time in New York: " + n.format(NewYork));
                return;
            case "New York":
                System.out.println("Your time: " + n.format(NewYork));
                System.out.println("Time in Tokyo: " + t.format(Tokyo));
                System.out.println("Time in Helsinki : " + h.format(Helsinki));
                return;
            default:
                System.out.println("Location not found.");
                break;
        }   
        
    }
        
    
    
        /*if ((city.equals("Helsinki"))){
        
            System.out.println("Your time: " + h.format(Helsinki));
            System.out.println("Time in Tokyo: " + j.format(Tokyo));
            System.out.println("Time in New York: " + n.format(NewYork));
            
        } else if ((city.equals("Tokyo"))){
            System.out.println("Your time: " + j.format(Tokyo));
            System.out.println("Time in Helsinki : " + h.format(Helsinki));
            System.out.println("Time in New York: " + n.format(NewYork));
            
        } else if ((city.equals("New York"))){
            System.out.println("Your time: " + n.format(NewYork));
            System.out.println("Time in Tokyo: " + j.format(Tokyo));
            System.out.println("Time in Helsinki : " + h.format(Helsinki));
        } else if ((city.isEmpty())){
            return;
        */   
    }
        
        
       
    
    public static void howManyDays(){
        LocalDate current=LocalDate.now();
        LocalDate christmas=current.withMonth(12).withDayOfMonth(24);
        long days = current.until(christmas, ChronoUnit.DAYS);
        
        System.out.println("Until christmas " +days);
        
        LocalDate friday = current.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while(friday.getDayOfMonth()!=13){
            friday=friday.plusDays(7);
        }
        System.out.println("Next Friday the 13th "+friday);
        System.out.println("   until "+current.until(friday,ChronoUnit.DAYS));
       
        }
        
       
    
    
    public static void someCalculations(){
        LocalDate current=LocalDate.now();
        Duration dur=Duration.ofDays(35);
        System.out.println("Duration "+dur);
        
        LocalDateTime dt=current.atStartOfDay().withHour(9).plusDays(dur.toDays());
        System.out.println("35 days from now "+dt);
    }
    
    
    public static void showCurrent(){
        LocalDate current=LocalDate.now();
        System.out.println("Current date: "+current);
        LocalTime time=LocalTime.now();
        System.out.println("Current time: "+time);
    }
    
    public static void firstTest(){
        System.out.println("First test");
    }

 
}
    
    