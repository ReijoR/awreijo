/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.hsltesti;

/**
 *
 * @author Reijo
 */
import org.springframework.web.client.RestTemplate;

public class Hsltesti {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String query = "{\"query\":\"{stop(id:\\\"HSL:1173434\\\"){name,lat,lon}}\"}";
        String result = restTemplate.postForObject("https://api.digitransit.fi/graphiql/hsl", query, String.class);
        System.out.println(result);
    }
}
    
        