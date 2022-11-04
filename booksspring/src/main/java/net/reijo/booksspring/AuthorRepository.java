/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.reijo.booksspring;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Reijo
 */
public interface AuthorRepository extends CrudRepository<Author, Integer>{
    //@Query("SELECT * from author a WHERE a.firstName LIKE :namePart")

    public List<Author> findByFirstNameContains(String namePart);
    
}
