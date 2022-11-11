/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.booksweb.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import static java.util.Comparator.comparingInt;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.reijo.booksweb.entities.ErrorInfo;
import net.reijo.booksweb.entities.Person;

/**
 *
 * @author Reijo
 */

@Path("person")
public class PersonService {
    static ArrayList<Person> personlist = new ArrayList<>();
    
    
    static {
        personlist.add(new Person(1,"Matti"));
        personlist.add(new Person(2, "Pekka"));
        personlist.add(new Person(4,"Aaro"));
        personlist.add(new Person(3,"Maija"));
        personlist.add(new Person(5, "Josefina"));
         
    }
    /*
    @GET
    @Produces("application/json")
    public List<Person> getPersons(){
        return personlist;
    }
    */
    @GET
    @Produces({"application/json","application/xml"})
    public List<Person> getPersons(@QueryParam("sort") @DefaultValue("id") String sort,
            @QueryParam("filter") @DefaultValue("") String filter){
        Stream<Person> ps=personlist.stream();
        if (sort.equals("id")) ps=ps.sorted((a,b) -> a.getId()-b.getId());
        else ps=ps.sorted((a,b) -> a.getName().compareTo(b.getName()));
        List<Person> pl=ps.filter(p -> p.getName().contains(filter)).collect(Collectors.toList());
        return pl;
    
    }
    /*
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Response getPerson(@PathParam("id") int id){
        Person pf=personlist.stream().filter(p -> p.getId()==id).findFirst().orElse(null);
        if (pf==null) return Response.status(Response.Status.NOT_FOUND).entity(new ErrorInfo(id,"Ei löydy")).build();
        return Response.ok(pf).build();
    }
    */
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Response getPerson(@PathParam("id") int id){
        Person pf=personlist.stream().filter(p -> p.getId()==id).findFirst().orElse(null);
        //if (pf==null) return null;
        return Response.ok(pf).build();
    
    }    

    
    @GET
    @Produces("application/json")
    @Path("jono")
    public Response findByNameContains(@PathParam("jono")String part) { 
    
                   List<Person> pf = personlist.stream().filter(p -> p.getName().contains("i")).collect(Collectors.toList());
                   return Response.ok(pf).build();
    }
    @GET
    @Produces("application/json")
    @Path("names")
    public Response findNames(@PathParam("names")String name){
        List<String> names = personlist.stream().map(Person::getName) .collect(Collectors.toList());
        return Response.ok(names).build();
    }
    @GET
    @Produces("application/json")
    @Path("ids")
    public Response findNames(@PathParam("ids")int id){
        List<Integer> ids = personlist.stream().map(Person::getId) .collect(Collectors.toList());
        return Response.ok(ids).build();
    
    }
    
    @GET
    @Produces
    @Path("longest")
    public Response longestName(@PathParam("longest") String name){
        Person ps = personlist.stream()
        .max(comparingInt(p -> p.getName().length())).get();
        return Response.ok(ps).build();
    }   
    
    @GET
    @Produces
    @Path("highest")
    public Response highestId(@PathParam("highest") int id){
        Person ps = personlist.stream()
        .max(comparingInt(p -> p.getId())).get();
        return Response.ok(ps).build();
                
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response createPerson(Person p){
        if (p.getName().equals("")) return Response.status(Response.Status.BAD_REQUEST)
        .entity(new ErrorInfo(0,"Aika lyhyt nimi")).build();
        /*
        Optional<Person> pf=plist.stream().max((a,b) -> a.getId()-b.getId());
        int newId=1;
        if (pf.isPresent()) newId=pf.get().getId()+1;
        p.setId(newId);
        plist.add(p);
        
        */
        
        
        return Response.ok(p).build();
    }
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{id}")
    public Response savePerson(@PathParam("id") int id, Person p){
    if (p.getName().equals("")) return Response.status(Response.Status.BAD_REQUEST).
        entity(new ErrorInfo(id,"Aika lyhyt nimi")).build();
        
    /*
        if (p.getId()!=id) return Response.status(Response.Status.BAD_REQUEST)
        .entity(new ErrorInfo(id,"ID Mismatch")).build();
    */
        Person pf=personlist.stream().filter(px -> px.getId()==id).findFirst().orElse(null);
        if (pf==null) return Response.status(Response.Status.NOT_FOUND)
        .entity(new ErrorInfo(id,"Ei löydy")).build();
        pf.setName(p.getName());
        return Response.ok(personlist).build();
    }
    @DELETE
    @Path("{id}")
    public Response deletePerson(@PathParam("id") int id){
        Person pf=personlist.stream().filter(px -> px.getId()==id).findFirst().orElse(null);
        if (pf==null) return Response.status(Response.Status.NOT_FOUND)
        .entity(new ErrorInfo(id,"Kokeile toista nimeä")).build();
        return Response.ok(new ErrorInfo(0,"Onnistui")).build();
    }
}