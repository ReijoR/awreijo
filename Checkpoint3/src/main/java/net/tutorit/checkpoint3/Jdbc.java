package net.tutorit.checkpoint3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Jdbc {
    
    
    public static Connection getConnection(){
        try{
            Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/books", "librarian", "test123");
            return con;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
  
     
    // Populate-luokka on nyt Spring-bean, joka siis voidaan injektoida tässä
    // Huomaa, että getConnection ei ole enää staattinen metodi.
    // Jos siis haluat käyttää Populate-luokan getConnection:ia, nitn se tehdään vähän erilaisella tapaa
    // Mikäli populate-beanin käyttö tuntuu vaikealta, joudut toteuttamaan tähän luokkaan oman getConnection-apumetodin
    
    private void extra(){
        // Jätä tämä aivan viimeiseksi....
        // Listaa autot ja tieto siitä, vieläkö siihen voidaan ottaa uusi matkustaja
        // Kaikien autojen maksimimatkustajamäärä on 5
        System.out.println("Lisätehtävää ei ole suoritettu");
    }
    
    private void listAllWithCars(){
        System.out.println("Kaikki matkustajat autoineen paitsi .....");
        // Tulosta kaikki Passangerit nimen ja tyypin mukaisessa järjestyksessä
        // mukana myös auton auton tietoja (merkki ja käyttöönottopäivä)
        // Rajaa haku kuitenkin koskemaan vain 1.1.1950 jälkeen käyttöönotettuja autoja
        // Jalankulkijoiden (autoa ei asetettu) pitää olla mukana listauksessa
        // Esim:
        // Hannu,hanhi,ei ajoneuvoa
        // Hupu,ankka,Blechfire Runabout,1952-03-13
        // jne
    }
    
    private void listPedestrians(){
        System.out.println("Jalankulkijat");
        // Listaa jalankulkijoiden nimet (autoa ei ole asetettu) aakkosjärjestyksessä
        try{
            String sql="SELECT name from passanger WHERE car_id = NULL";
            Connection con=getConnection();
            if (con==null);
            PreparedStatement stm=con.prepareStatement(sql);
            
            ResultSet rs=stm.executeQuery();
            
            
            
            rs.close();
            stm.close();
            con.close();
            
            System.out.println(rs.getString("name"));
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
    }
        
    
    private void changeType(Passanger p, String newPassangerType){
        // Vaihda annetun matkustajan tyyppi
        
        try{
            String sql="UPDATE passenger SET psgtype = " + newPassangerType + " WHERE id = " + p.getId();
            Connection con=getConnection();
            if (con==null);
            PreparedStatement stm=con.prepareStatement(sql);
            
            ResultSet rs=stm.executeQuery();


            rs.close();
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
    }
    
    private Passanger getPassanger(int id){
        // Palauta id:tä vastaava Passanger-objekti
        Passanger p=null;
        try{
            String sql="SELECT * FROM passanger where id=?";
            Connection con=getConnection();
            if (con==null) return null;
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            if (rs.next()){
                p = new Passanger(rs.getString("name"), Integer.valueOf(rs.getString("car_id")), rs.getString("psgType"));
                
                p.setId(rs.getInt("id"));
            }
            rs.close();
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return p;
        
    }
    
    public void jdbcMain(){
        System.out.println("Jdbc-luokan testaus alkaa");
        Passanger p=getPassanger(6);
        System.out.println("Haettiin 6: "+p);
        changeType(p,"ihminen");
        if (p!=null) System.out.println(p.getName()+" tyyppi vaihtui: "+getPassanger(6));
        listPedestrians();
        listAllWithCars();
        extra();
        System.out.println("Jdbc-luokan testaus loppuu");
    }
}
