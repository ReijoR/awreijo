/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.assessment1.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Reijo
 */
@Path("dates")
public class DateResource {
    
    @GET 
    @Produces("text/plain")
    @Path("{date}")
    
    public String dates1(@PathParam(value="date") String date, @QueryParam(value="plusdays") int plusdays) {
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    LocalDate localDate = LocalDate.parse(date);
    LocalDate plusDays = localDate.plusDays(plusdays);
    
    String plusDaysString = plusDays.toString();
    return plusDaysString;
    
    
    } 
    @POST
    
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("meeting")
    public ZonedDateTime dates2(@QueryParam(value="locale") String locale, @QueryParam(value="hours") int hours, String date) {
    
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
    localDateTime.plusHours(hours);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(locale));

    ZonedDateTime zonedDateTimeInFinland = zonedDateTime.withZoneSameInstant(ZoneOffset.ofHours(2));
    return zonedDateTimeInFinland;
        //return zonedDateTimeInFinland;
        
        //DateFormat t = new SimpleDateFormat("yyyy-MM-dd" + " " +" HH:mm:ss");
        //t.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        
        //return t.format(Date.from(localDateTime.toInstant(ZoneOffset.of("+02:00"))));
        
        //public String dates4(@QueryParam(value="loc", required=true) String loc, @QueryParam(value="hours", required=true) int hours, String date) {    
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String date = "2022-05-02 15:21:45";
        //LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        
    }
    
}
