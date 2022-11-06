/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.checkpoint3uusinta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */
@Component
public class Jdbc {
    
    private static void query(String sql)
    {
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","librarian","test123");
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            ResultSetMetaData rmd=rs.getMetaData();
            for(int i=1;i<=rmd.getColumnCount();i++){
                System.out.print(rmd.getColumnName(i));
                if (i==rmd.getColumnCount()) System.out.println();
                else System.out.print(", ");
            }
            while(rs.next()){
                for(int i=1;i<=rmd.getColumnCount();i++){
                    System.out.print(rs.getString(i));
                    if (i==rmd.getColumnCount()) System.out.println();
                    else System.out.print(", ");
                }
            }
            rs.close();
            stm.close();
            con.close();
        }
        catch(SQLException sex){
            sex.printStackTrace();
        }
    }
   
    
    
    public void jdbcMain(){
        // Tällä kertaa siis vain toteutat Canvaksessa määritelly SQL-lauseet
        // ja annat ne parametrinä query-metodille
        // Kopioi näiden tulosteet canvakseen vastaukseksi
        System.out.println("JDBC testi1____");
        query("SELECT name FROM passanger where car_id=1 or car_id=3");
        System.out.println("JDBC testi2____");
        
        query("SELECT car.id, car.make, passanger.name FROM car LEFT JOIN passanger ON passanger.car_id = car.id;");
        System.out.println("JDBC testi3____");
        query("SELECT passanger.id, passanger.name, car.make FROM car RIGHT JOIN passanger ON car.id = passanger.car_id WHERE car.regcity = 'Helsinki' OR passanger.car_id IS NULL");
        System.out.println("JDBC testit loppu------------------------");
    }
}
