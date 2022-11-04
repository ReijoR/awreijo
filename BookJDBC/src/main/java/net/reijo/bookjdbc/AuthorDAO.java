/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.bookjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reijo
 */
public class AuthorDAO {
    
    private Connection getConnection() throws SQLException{
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/books","librarian","test123");
        
        return con;
    }
    private Author authorFromResultSet(ResultSet rs) throws SQLException{
        Author a = new Author();
        a.setId(rs.getInt("id"));
        a.setFirstName(rs.getString("firstName"));
        a.setLastName(rs.getString("lastName"));
        a.setBirthDay(rs.getDate("birthday"));
        a.setDeathDate(rs.getDate("deathdate"));
        return a;
    }
    public Author get(int id) {
        try {
            Connection con = getConnection();
            String sql = "SELECT * FROM author where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                Author a = authorFromResultSet(rs);
                rs.close();
                stm.close();
                con.close();
                return a;
            }
            
        }
        catch(SQLException ex){
            System.out.println("Haku epäonnistui");
            ex.printStackTrace();
        }   
        return null;
            
        
        
        
    }
    public List<Author> getAll() throws SQLException{
        ArrayList<Author> al = new ArrayList<>();
        
        
        try (Connection con = getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM author")) {
           
            while (rs.next()){
                al.add(authorFromResultSet(rs));
            }
        }
            return al;
    }
    public Author update(Author a){
              try {
            Connection con = getConnection();
            String sql = "SELECT * FROM author where id=?";
            PreparedStatement stm = con.prepareStatement(sql,ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            stm.setInt(1,a.getId());
            ResultSet rs = stm.executeQuery();
            Author aret = null;
            if (rs.next()){
                rs.updateString("firstName",a.getFirstName());
                rs.updateString("lastName",a.getLastName());
                rs.updateDate("birthday",a.getBirthDay());
                rs.updateDate("deathdate",a.getDeathDate());
                rs.updateRow();
                aret = authorFromResultSet(rs);
            }
            rs.close();
            stm.close();
            con.close();
            return aret;
        }
        catch(SQLException ex){
            
            ex.printStackTrace();
        }   
        return null;
        
    }
    public Author create(Author a) throws SQLException{
        
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO Author(firstName, lastName, birthday, deathdate) values(?,?,?,?)";
            try (PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                stm.setString(1, a.getFirstName());
                stm.setString(2, a.getLastName());
                stm.setDate(3, a.getBirthDay());
                stm.setDate(4,a.getDeathDate());
                
                //int rowsAffected = stm.executeUpdate();
                ResultSet keys = stm.getGeneratedKeys();
                if (keys.next()){
                    int id = keys.getInt(1);
                    stm.close();
                    con.close();
                    keys.close();
                    return this.get(id);
                }
            stm.close();
            con.close();
            
            }
        }
        
        
        
        return null;
    }
    
}
