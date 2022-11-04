


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.cpharjoitus3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Component;

/**
 *
 * @author jyrki
 */


@Component
public class Jdbc {
    
    /*
    private void report2(int teacherId){
        // Tulosta kaikki annetun opettajan oppilaat eval-daten mukaisessa järjestyksessä
        // Anssi,Taina,2022-10-26
    }
    */
    private void report(){
        // Katso ohje tämän tiedoston lopusta
        // Kristian,6.10.2022,1B,Anssi
        System.out.println("Tulosta raportti tämän tiedoston lopussa olevan ohjeen mukaan");
        try{
            String sql="SELECT s.*,c.classname,c.teacher";
            sql+=" FROM student s,class c WHERE c.id=s.class_id";
            sql+=" ORDER by c.teacher,s.name";
            Connection con=Populate.getConnection();
            if (con==null) return ;
            PreparedStatement stm=con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while (rs.next()){
                String row=rs.getInt("id")+", "+rs.getString("name");
                //row+=", "+rs.getDate("evaldate");
                //row+=", "+rs.getString("classname");
                //row+=", "+rs.getString("teacher");
                System.out.println(row);
            }
            rs.close();
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }
    
    private void listStudentsOfTeacher(int teacherId){
        
    }
    
    private void evalAfterOct15(){
        // Tulosta niiden oppilaiden nimi, joiden arviointiäivä on 15.10 jälkeen
        System.out.println("Tulosta näytölle ne oppilaat, joiden evaldate on 15.10 jälkeen");
        try{
            String sql="SELECT * FROM student where evaldate>'2022-10-15'";
            Connection con=Populate.getConnection();
            if (con==null) return ;
            PreparedStatement stm=con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private Student getStudent(int id){
        Student s=null;
        try{
            String sql="SELECT * FROM student where id=?";
            Connection con=Populate.getConnection();
            if (con==null) return null;
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            if (rs.next()){
                s=new Student(rs.getString("name"),rs.getInt("class_id"),rs.getDate("evaldate"));
                s.setId(rs.getInt("id"));
            }
            rs.close();
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return s;
    }
    
    private void updateStudent(Student s){
        // Päivitä mutokset tietokantaan
    }
    
    private int addStudent(Student s){
        // Lisää parametrinä tullut oppilas tietokantaan
        // Palauta sen primary key
        try{
            Connection con=Populate.getConnection();
            if (con==null) return 0;
            String sql="INSERT INTO student(class_id,name,evaldate) values(?,?,?)";
            PreparedStatement stm=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, s.getClassId());
            stm.setString(2, s.getName());
            stm.setDate(3, s.getEvalDate());
            int rowsAffected=stm.executeUpdate(); 
            ResultSet keys=stm.getGeneratedKeys();
            if (keys.next()) {
                int id=keys.getInt(1);
                stm.close();
                keys.close();
                con.close();
                return id;
            }
            
            stm.close();
            con.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
    public void jdbcMain(){
        System.out.println("Jdbc-luokan testaus alkaa");
        Student s1=new Student("Untamo",1,Date.valueOf("2022-10-21"));
        Student s2=new Student("Alarik",2,Date.valueOf("2022-10-13"));
        int p1=addStudent(s1);
        int p2=addStudent(s2);
        System.out.println("Haettiin oppilas 10: "+getStudent(10));
        System.out.println("Haettiin oppilas "+p1+": "+getStudent(p1));
        System.out.println("Haettiin oppilas "+p2+": "+getStudent(p2));
        Student sm=getStudent(8);
        sm.setName("Muutettu");
        updateStudent(sm);
        listStudentsOfTeacher(1);
        evalAfterOct15();
        report();
        //report2(1);
        System.out.println("Jdbc-luokan testaus loppuu");
    }
}

/*
Tulostettava näytölle alla kuvatun kaltainen raportti
Raportissa rivien muotoilu ei ole tärkeä. 
Kelpaa vaikka ihan pilkulla erotellut arvot.
Päivämäärän muotoilu ei myöskään ole oleellinen seikka
Rivi voidaan siis esittää vaikka muodossa:
Kristian,6.10.2022,1B,Anssi

- Sarakkeina oppilaan nimi, arviointipäivä, luokannimi ja opettajan nimi
- Järjestys ensisijaisesti opettajan nimen mukaan, sitten oppilaan nimen mukaan


+----------+------------+-----------+---------+
| name     | evaldate   | classname | teacher |
+----------+------------+-----------+---------+
| Kristian | 2022-10-06 | 1B        | Anssi   |
| Mikko    | 2022-10-18 | 1B        | Anssi   |
| Reijo    | 2022-10-04 | 1B        | Anssi   |
| Sakari   | 2022-10-20 | 1B        | Anssi   |
| Solja    | 2022-10-22 | 1B        | Anssi   |
| Susanna  | 2022-10-24 | 1B        | Anssi   |
| Taina    | 2022-10-26 | 1B        | Anssi   |
| Taito    | 2022-10-28 | 1B        | Anssi   |
| Aapo     | 2022-10-12 | 1A        | Jyrki   |
| Henri    | 2022-10-10 | 1A        | Jyrki   |
| Joel     | 2022-10-08 | 1A        | Jyrki   |
| Kasperi  | 2022-10-14 | 1A        | Jyrki   |
| Kia      | 2022-10-16 | 1A        | Jyrki   |
| Monica   | 2022-10-02 | 1A        | Jyrki   |

*/