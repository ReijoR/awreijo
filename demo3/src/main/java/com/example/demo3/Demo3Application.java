package com.example.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo3Application {
        
    @RequestMapping("/")
    public String home() {
        Connection connect = null;
        Statement s = null; 
        
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://reijodatatukikohta2.cioobuqaakgw.eu-north-1.rds.amazonaws.com:3306/mmkisat", "admin","adminadmin");
            
            s = connect.createStatement();
            
            String sql = "INSERT INTO teams (id,name) VALUES (2, 'Spain')";
            
                s.execute(sql);
                
                System.out.println(sql);
                return ("Valmis?");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "jee";
    } 
    
    public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
    }

}
