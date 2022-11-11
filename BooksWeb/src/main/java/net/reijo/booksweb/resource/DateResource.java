/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.booksweb.resource;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author jyrki
 */
@Path("dates")
public class DateResource {
    
    
    /*
    @GET
    @Produces("text/plain")
    //http://localhost:8080/BooksWeb/services/dates?year=2000&month=3&day=1
    public String getDate(@QueryParam("year") @DefaultValue("2022") int y, 
                          @QueryParam("month")@DefaultValue("1") int m,
                          @QueryParam("day") @DefaultValue("1") int d){
        if (m>13) throw new WebApplicationException("Paha kuu", Response.Status.BAD_REQUEST);
        return LocalDate.of(y,m,d).toString();
    }
    
    @GET
    @Produces("text/plain")
    //http://localhost:8080/BooksWeb/services/dates/2020/5/1
    @Path("{year}/{month}/{day}")
    public Response getDateFromPath(@PathParam("year") int y, 
                                  @PathParam("month") int m, 
                                  @PathParam("day") int d){
        if (m>12) return Response.status(Response.Status.BAD_REQUEST)
                .header("x-virhe","paivamaara")
                .entity("Paha kuu").build();
        return Response.ok(LocalDate.of(y,m,d).toString()).build();
    
    }
    */
    /*
    Päivämäärät
    - Tee merkkijonosta ”2022-05-02” LocalDate-objekti,
      lisää siihen 3 päivää ja tulosta päivämäärä
    - Tee merkkijonosta ”2.5.2022” (fi) LocalDate-objekti,
      lisää siihen 3 päivää ja tulosta päivämäärä.
    - Tee merkkijonosta ”5/2/2022” (en/US) LocalDate-objekti,
      lisää siihen 3 päivää ja tulosta päivämäärä
    - Tulosta yllä mainittujen esimerkkien päivämäärät eri muotoiluilla
      (fi,jp,en/US)
    */
    
    @GET 
    @Produces("text/plain")
    @Path("JAPAN")
    public String dates1(){
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String date = "2022-05-02";
    LocalDate localDate = LocalDate.parse(date);
    LocalDate plusThreeDays = localDate.plusDays(3);
    
    String plusThreeDaysString = plusThreeDays.toString();
    return plusThreeDaysString;
    //convert String to LocalDate
    
    } 
    
    
    @GET 
    @Produces("text/plain")
    @Path("FIN")
    public String dates2(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy"/*,Locale.forLanguageTag("fi")*/);
    String date = "2.5.2022";
    LocalDate localDate = LocalDate.parse(date,formatter);
    LocalDate plusThreeDays = localDate.plusDays(3);
    
    //String formattedThreeDays = plusThreeDays.format(formatter);
    return plusThreeDays.format(formatter);
    //String plusThreeDaysString= plusThreeDays.toString();
    //return plusThreeDaysString;
    }
    
    
    @GET 
    @Produces("text/plain")
    @Path("USA")
    public String dates3(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    String date = "5/2/2022";
    LocalDate localDate = LocalDate.parse(date,formatter);
    LocalDate plusThreeDays = localDate.plusDays(3);
    
    //String plusThreeDaysString = plusThreeDays.toString();
    return plusThreeDays.format(formatter);
    }
    
    /*
    Näitä kannattaa testailla ihan konsoli-sovelluksella
    - Tee merkkijonosta 2022-05-02T15:21:45 LocalDateTime-objekti ja tulosta se
    - Ajattele, että kyseinen päiväys on muodostetu Suomessa (”Europe/Helsinki”)
    o Mitä kello on samaan aikaan Japanissa ("Asia/Tokyo")
    o Mitä kello on samaan aikaan New Yorkissa ("America/New_York")
    */
    
    @GET
    @Produces("text/plain")
    @Path("localdatetime")
    public String dates4(){
        
        /*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = "2022-05-02 15:21:45";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        LocalDateTime japan = localDateTime.plusHours(7);
        return japan.format(formatter);
        */
        /*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = "2022-05-02 15:21:45";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        DateFormat t = new SimpleDateFormat("yyyy-MM-dd" + " " +" HH:mm:ss");
        t.setTimeZone(TimeZone.getTimeZone("Japan"));
        return t.format(localDateTime);
        */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = "2022-05-02 15:21:45";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        
        DateFormat t = new SimpleDateFormat("yyyy-MM-dd" + " " +" HH:mm:ss");
        t.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        
        DateFormat n = new SimpleDateFormat("yyyy-MM-dd" +'T'+" HH:mm:ss");
        n.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        
        return t.format(Date.from(localDateTime.toInstant(ZoneOffset.of("+02:00"))))+n.format(Date.from(localDateTime.toInstant(ZoneOffset.of("+02:00"))));
        
        
        
        
    }
    
    
    
}