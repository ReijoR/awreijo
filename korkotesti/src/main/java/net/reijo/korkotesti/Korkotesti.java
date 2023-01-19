/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.korkotesti;

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
public class Korkotesti {

    public static void main(String[] args) throws IOException {
        
        URL url = new URL("https://api.api-ninjas.com/v1/interestrate?name=Euribor");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("X-Api-Key", "WH6WAh34f4LjkUqV3S68jw==DWTVZQ85nKza6sD9");
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseStream);
        JsonNode nonCentralBankRates = root.get("non_central_bank_rates");
        for (JsonNode rate : nonCentralBankRates) {
        String name = rate.get("name").textValue();
        double ratePct = rate.get("rate_pct").doubleValue();
        if (name.equals("Euribor - 12 months")) {
        System.out.println(name + ", Rate: " + ratePct);
        }
        }

        
    }
}
