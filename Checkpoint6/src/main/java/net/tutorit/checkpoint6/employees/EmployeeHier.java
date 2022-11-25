/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint6.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;

/**
 *
 * @author Reijo
 */
public class EmployeeHier {
    private Integer id;
    @JsonIgnore
    private String employeeId;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<EmployeeHier> superiorId;
 
    public EmployeeHier(){}
    
    public EmployeeHier(Employee e){
        this.id=e.getId();
        this.employeeId=e.getEmployeeId();
        this.name=e.getName();
    }
    public void addSuperiorId(EmployeeHier child) {
        if (superiorId==null) superiorId=new ArrayList<EmployeeHier>();
        superiorId.add(child);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the superiorId
     */
    public ArrayList<EmployeeHier> getSuperiorId() {
        return superiorId;
    }

    /**
     * @param superiorId the superiorId to set
    
     */
    public void setSuperiorId(ArrayList<EmployeeHier> superiorId) {
        this.superiorId = superiorId;
    }

    
}





