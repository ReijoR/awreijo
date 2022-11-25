package net.tutorit.checkpoint6.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jyrki
 */
@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository repo;
    
    @GetMapping
    public List<Employee> getAll(){
        return repo.findAll();
    }
    @PostMapping
    Employee create(@RequestBody Employee e){
        repo.saveAndFlush(e);
            return e;
    }
    @GetMapping
    @RequestMapping("/hierarchy")
    public List<EmployeeHier> getHier(){
        ArrayList<EmployeeHier> ret=new ArrayList<>();
        List<EmployeeHier> pl=repo.findAll().stream()
                .map(e -> new EmployeeHier(e)).collect(Collectors.toList());
        
        pl.stream().forEach(child -> {
            EmployeeHier parent=pl.stream()
                    .filter(e -> e.getId().equals(child.getEmployeeId()))
                    .findFirst().orElse(null);
            if (parent!=null) parent.addSuperiorId(child);
            else ret.add(child);
        });
        
        return ret;
    }
}
