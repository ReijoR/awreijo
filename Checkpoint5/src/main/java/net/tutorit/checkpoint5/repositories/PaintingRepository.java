/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint5.repositories;

import java.util.List;
import net.tutorit.checkpoint5.entities.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Reijo
 */
@Repository
public interface PaintingRepository extends JpaRepository<Painting,Integer> {
    
    

    @Override
    List<Painting> findAll();
}