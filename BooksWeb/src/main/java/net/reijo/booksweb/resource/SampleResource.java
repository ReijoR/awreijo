package net.reijo.booksweb.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.Month;

@Path("sample")
public class SampleResource{
    static String tx="Tervehdys";
    
    
    @GET
    @Produces("text/plain")
    public String message() {
        LocalDate dt=LocalDate.of(2020,5, 12);
        return dt.toString();
        //return tx;
    }
    /*
    @GET
    @Produces("application/xml")
    public String messageXml(@QueryParam("joku") String param) {
        LocalDate dt=LocalDate.of(2020,5, 12);
        return dt.toString();
        //return "<"+param+">"+tx+"</"+param+">";
    }
    */
    
    @PUT
    @Produces("text/plain")
    @Consumes("text/plain")
    public String changeMessage(String msg){
        tx+=msg;
        return tx;
    }
    
    @POST
    @Produces("text/plain")
    @Consumes("text/plain")
    public String createMessage(String msg){
        tx=msg;
        return tx;
    }
    
    @DELETE
    @Produces("text/plain")
    public String deleteMessage(){
        tx="Alustettu";
        return tx;
    }
    
    
    @GET
    @Path("toka")
    @Produces("text/plain")
    public String messageMuuta() {
        return "Terve taas";
    }

}