/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.bookjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Reijo
 */
public class BookDAO {
    
    private Connection getConnection() throws SQLException{
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/books","librarian","test123");
        
        return con;
    }
    private Book bookFromResultSet(ResultSet rs) throws SQLException
    {
        Book b = new Book();
        b.setId(rs.getInt("id"));
        b.setAuthorId(rs.getInt("author_id"));
        b.setTitle(rs.getString("title"));
        
        return b;
    }
    public Book get(int id) {
        try {
            Connection con = getConnection();
            String sql = "SELECT * FROM book where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                Book b = bookFromResultSet(rs);
                rs.close();
                stm.close();
                con.close();
                return b;
            }
        }    
        
        catch(SQLException ex){
            System.out.println("Haku epäonnistui");
            ex.printStackTrace();
        }   
        return null;
    } 
    
    public Book getAuthorOfBook(String author){
        try {
            Connection con = getConnection();
            String sql = "SELECT b.* FROM book b, author a where a.id=b.id";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,author);
            ResultSet rs = stm.executeQuery();
            Book b = null;
            if (rs.next()){
                b = bookFromResultSet(rs);
                
                return b;
            }
        }    
        
        catch(SQLException ex){
            System.out.println("Haku epäonnistui");
            ex.printStackTrace();
        }   
        return null;
            
        
    }
}
