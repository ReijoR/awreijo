/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Populate {
    @Value("${spring.datasource.url}")
    String url; 
    @Value("${spring.datasource.username}")
    String user; 
    @Value("${spring.datasource.password}")
    String psw; 
    
    public Connection getConnection(){
        try{
            Connection con=DriverManager.getConnection(url,user,psw);
            return con;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Connection getRootConnection(){
        try{
            int i=url.lastIndexOf("/");
            String rootUrl=url.substring(0,i);
            Connection con=DriverManager.getConnection(rootUrl,user,psw);
            return con;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    private void ensureDatabase(){
        try{
            Connection rootCon=getRootConnection();
            if (rootCon==null){
                System.out.println("Cannot get root connection");
                return;
            }
            System.out.println("Trying to create database");
            Statement stm=rootCon.createStatement();
            stm.execute("CREATE DATABASE books");
            stm.close();
            rootCon.close();
        }
        catch(Exception ex){
            System.out.println("Tietokantaa ei luotu");
            ex.printStackTrace();
        }
    }
    
    private void dropCreate(Connection con,String table,String create){
        try{
            Statement stm=con.createStatement();
            stm.execute("DROP TABLE "+table);
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Not dropped: "+table);
        }
        try{
            Statement stm=con.createStatement();
            stm.execute("CREATE TABLE "+table+create);
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Not created: "+table);
        }
    }

    @PostConstruct
    private void createTables(){
        ensureDatabase();
        Connection con=getConnection();
        dropCreate(con,"painting","(id int primary key not null auto_increment,name varchar(32), artist varchar(32))");
        try(Statement stm=con.createStatement()){
            stm.addBatch("insert into painting values(null,'Mona Lisa','Leonardo Da Vinci')");
            stm.addBatch("insert into painting values(null,'Tähtikirkas yö','Vincent Van Gogh')");
            stm.addBatch("insert into painting values(null,'Muiston pysyvyys','Salvador Dali')");
            stm.addBatch("insert into painting values(null,'Impressio auringonnoususta','Claude Monet')");
            stm.addBatch("insert into painting values(null,'Vanha kitaristi','Pablo Picasso')");
            stm.executeBatch();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println("Virhe luodessa taulua");
            ex.printStackTrace();
        }
        try{
            con.close();
        }
        catch(SQLException ex){
        //    ex.printStackTrace();
        }
    }
    
    
    
}
