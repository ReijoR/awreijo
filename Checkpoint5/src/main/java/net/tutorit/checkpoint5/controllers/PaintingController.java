/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint5.controllers;

import java.util.List;
import net.tutorit.checkpoint5.entities.Painting;
import net.tutorit.checkpoint5.entities.RequestInfo;
import net.tutorit.checkpoint5.repositories.PaintingRepository;
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
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Reijo
 */
@RestController
@RequestMapping("paintings")
public class PaintingController {
    
    private PaintingRepository repo;
    
    public PaintingController(PaintingRepository r){
        repo=r;
    }
    
    @GetMapping
    List<Painting> getAll(@RequestParam(defaultValue="") String filter) {
        return repo.findAll();
        
    }    
    
    @GetMapping("/{id}")
    Painting get(@PathVariable int id){
        Painting p=repo.findById(id).orElse(null);
        if (p==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
        return p;
    }
    
    @PostMapping
    Painting create(@RequestBody Painting p){
        repo.saveAndFlush(p);
        return p;
    }
    
    @PutMapping("/{id}")
    Painting save(@PathVariable int id, @RequestBody Painting p){
        repo.saveAndFlush(p);
        return p;
    }
    
    @DeleteMapping("/{id}")
    RequestInfo delete(@PathVariable int id){
        Painting p=repo.findById(id).orElse(null);
        if (p==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
        repo.deleteById(id);
        return new RequestInfo();
    }
    
    
}
