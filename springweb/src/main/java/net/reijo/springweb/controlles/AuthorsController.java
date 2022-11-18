/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.springweb.controlles;

import java.util.List;
import net.reijo.springweb.entities.Author;
import net.reijo.springweb.repositories.AuthorRepository;
import org.apache.coyote.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Reijo
 */
@RestController
@RequestMapping("authors")
public class AuthorsController {
    
    @Autowired
    AuthorRepository repo;
    
    @GetMapping
    List<Author> getAll(){
    
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    Author get(@PathVariable int id){
    Author a=repo.findById(id).orElse(null);
    if (a==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
    
    return a;
    
    }
    
    @PostMapping
    Author create(@RequestBody Author a){
        repo.saveAndFlush(a);
            return a;
    }
    @PutMapping("/{id}")
    Author save(@PathVariable int id, @RequestBody Author a){
    repo.saveAndFlush(a);
        return a;
    }
    @DeleteMapping("/{id}")
    RequestInfo delete(@PathVariable int id){
    Author a=repo.findById(id).orElse(null);
    if (a==null) throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Foo Not Found");
    repo.deleteById(id);
    return new RequestInfo(null);
    }
    @GetMapping("/all")
    List<Author> getAll (@RequestParam(defaultValue="") String filter) {
    return repo.findFiltered ("%"+filter+"%");
    }
    @GetMapping("/persons")
    public Person[] getPersons(RestTemplate rt){
        Person[] pa=rt.getForObject("http://localhost:8080BooksWeb/services/person",Person[].class);
        return pa;
    }   
}