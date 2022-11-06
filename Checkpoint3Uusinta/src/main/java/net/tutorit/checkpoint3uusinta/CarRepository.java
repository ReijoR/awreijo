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
public interface CarRepository extends CrudRepository<Car,Integer>{
    
    
    @Query("SELECT * FROM Car WHERE Car.regcity = 'Helsinki'")
    List<Car> findCarsFromHelsinki();
    
}
