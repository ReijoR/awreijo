/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint3uusinta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Spring {
    @Autowired
    PassangerRepository repo;
    @Autowired
    CarRepository carRepo;
    
    
    public void springMain(){
        System.out.println("Spring testit___");
        // Tähän väliin tulosteita Canvaksen ohjeiden mukaan
        
        //1
        //INSERT INTO passanger (name, car_id, psgtype) VALUES ("Untamo", 2, "ihminen");
        Passanger p = new Passanger();
        p.setId(11);
        p.setName("Untamo");
        p.setCarId(2);
        p.setPassangerType("ihminen");
        repo.save(p);
        
        //2
        Passanger robin = repo.findById(7).get();
        robin.setPassangerType("super");
        repo.save(robin);
        
        //3
        List<Passanger> passangers = (List<Passanger>) repo.findAll();
        System.out.println(passangers);
        
        //4
        System.out.println(carRepo.findCarsFromHelsinki());
        
        
        //5
        
        System.out.println(repo.findPassangersWithSameCarAsIines());
        
        
        System.out.println("Spring testit loppuu");
    }
}
