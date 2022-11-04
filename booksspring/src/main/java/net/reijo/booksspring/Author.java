/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.booksspring;

import java.util.Date;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

/**
 *
 * @author Reijo
 */
public class Author {
    @Id
    
    private Integer id;
    private Date birthday;
    private Date deathdate;
    @Column ("lastName")
    private String lastName;
    @Column ("firstName")
    private String firstName;

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
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the deathdate
     */
    public Date getDeathdate() {
        return deathdate;
    }

    /**
     * @param deathdate the deathdate to set
     */
    public void setDeathdate(Date deathdate) {
        this.deathdate = deathdate;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String toString(){
        return firstName;
    }
    
    
}
