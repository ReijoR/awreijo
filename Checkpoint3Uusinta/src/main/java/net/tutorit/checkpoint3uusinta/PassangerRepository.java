/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.tutorit.checkpoint3uusinta;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Reijo
 */
public interface PassangerRepository extends CrudRepository<Passanger,Integer>{
    
    
    
    @Query("SELECT * FROM passanger WHERE passanger.name='Iines' GROUP BY passanger.car_id")
    List<Passanger> findPassangersWithSameCarAsIines();
    
    
    /*
    @Query("SELECT * FROM Passanger WHERE car_id (SELECT car_id FROM Passanger WHERE name = 'Iines')")
    List<Passanger> findPassangersWithSameCarAsIines();
    */
}
