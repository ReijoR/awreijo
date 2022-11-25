/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.springweb.repositories;



import net.reijo.springweb.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author Reijo
 */
public interface ParentRepository extends JpaRepository<Parent,Integer>{
    
}
