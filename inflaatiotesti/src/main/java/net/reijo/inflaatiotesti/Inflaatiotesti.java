/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.inflaatiotesti;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
/**
 *
 * @author Reijo
 */
public class Inflaatiotesti {

    public static void main(String[] args) throws IOException {
         
        URL url = new URL("https://api.api-ninjas.com/v1/inflation?country=finland");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("X-Api-Key", "WH6WAh34f4LjkUqV3S68jw==DWTVZQ85nKza6sD9");
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseStream);
        JsonNode firstNode = root.get(0);
        String country = firstNode.get("country").asText();
        double monthlyInflation = firstNode.get("monthly_rate_pct").asDouble();
        double yearlyInflation = firstNode.get("yearly_rate_pct").asDouble();
        String period = firstNode.get("period").asText();
        System.out.println(country);
        System.out.println(period + ": " + monthlyInflation);
        System.out.println("Yearly inflation: " + yearlyInflation);
        
        
        


    }
}
