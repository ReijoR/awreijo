/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.tutorit.checkpoint3uusinta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author jyrki
 */
@SpringBootApplication
public class Checkpoint3Uusinta {
    
    @Bean
    public CommandLineRunner springStart(Jdbc jdbc,Spring spring,Populate populate){
        return args -> {
            System.out.println("Sovellus on käynnistynyt");
            populate.init();
            jdbc.jdbcMain();
            spring.springMain();
            System.out.println("Kopioi sovelluksen tulosteet vastaukseksi Canvakseen");
        };
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Checkpoint3Uusinta.class, args);
    }
}
