/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.tutorit.checkpoint5;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jyrki
 */
public interface PaintingRepository extends JpaRepository<Painting,Integer>{
    public List<Painting> findByNameContains(String name);
}
