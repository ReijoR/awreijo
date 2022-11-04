/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.bookjdbc;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Reijo
 */
public class BookJDBC {
    
    static void getAllAuthors(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","librarian","test123");
            Statement stm = (Statement) con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * from book");
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
        
            

            rs.close();
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
            

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        //getAllAuthors();
        /*
        AuthorDAO dao = new AuthorDAO();
        Author a = dao.get(1);
        System.out.println(a.getFirstName()+a.getLastName());
        
        Author na = new Author("Andrea", "Camilleri", Date.valueOf("2000-01-01"),Date.valueOf( "2001-01-01"));
        dao.create(na);
        List<Author> authors = dao.getAll();
        for(Author ax:authors){
            System.out.println(ax);
        */ 
        /*
        BookDAO daob = new BookDAO();
        Book b = daob.get(1);
        System.out.println(b);  
        */
        
        
    }
}
