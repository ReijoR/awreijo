/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint5;

import java.util.List;
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
 * @author jyrki
 */
@RestController
@RequestMapping("paintings")
public class PaintingController {
    @Autowired
    PaintingRepository repo;
    
    @GetMapping
    List<Painting> getAll(@RequestParam(defaultValue="") String filter) {
        return repo.findByNameContains(filter);
    }    
    
    
    @GetMapping("/{id}")
    Painting get(@PathVariable int id){
        Painting a=repo.findById(id).orElse(null);
        if (a==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
        return a;
    }
    
    @PostMapping
    Painting create(@RequestBody Painting a){
        repo.saveAndFlush(a);
        return a;
    }
    
    @PutMapping("/{id}")
    Painting save(@PathVariable int id, @RequestBody Painting a){
        repo.saveAndFlush(a);
        return a;
    }
    
    @DeleteMapping("/{id}")
    RequestInfo delete(@PathVariable int id){
        Painting a=repo.findById(id).orElse(null);
        if (a==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
        repo.deleteById(id);
        return new RequestInfo();
    }
    
}
