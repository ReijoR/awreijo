/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.springweb.repositories;

import java.util.List;
import net.reijo.springweb.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Reijo
 */
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    
    @Query("SELECT a FROM Author a WHERE concat (lastname,' ',firstname) like :filt ORDER BY a.lastName")

    List<Author> findFiltered (String filt);
}
