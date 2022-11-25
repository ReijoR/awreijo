/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.springweb.controlles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.reijo.springweb.entities.ParentHier;
import net.reijo.springweb.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reijo
 */
@RestController
@RequestMapping("parents")
public class ParentsController {
    @Autowired
    ParentRepository repo;
    
    @GetMapping
    public List<ParentHier> getAll(){
        ArrayList<ParentHier> ret=new ArrayList<>();
        List<ParentHier> pl=repo.findAll().stream()
                .map(p -> new ParentHier(p)).collect(Collectors.toList());
        
        pl.stream().forEach(child -> {
            ParentHier parent=pl.stream()
                    .filter(p -> p.getId().equals(child.getParentId()))
                    .findFirst().orElse(null);
            if (parent!=null) parent.addChild(child);
            else ret.add(child);
        });
        
        return ret;
    }
}