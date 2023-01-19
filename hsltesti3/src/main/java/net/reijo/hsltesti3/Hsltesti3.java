/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.hsltesti3;

/**
 *
 * @author Reijo
 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;


public class Hsltesti3 {

    public static void main(String[] args) throws UnsupportedEncodingException, JSONException, IOException {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pysäkki: ");
        String name = scanner.nextLine();

        String query = "{\n" +
"  stops(name: \"" + name + "\") {\n" +
"    name\n" +
"    stoptimesWithoutPatterns (numberOfDepartures: 5) {\n" +
"      realtimeDeparture\n" +
"      trip {\n" +
"      	route {\n" +
"        	shortName\n" +
"        }\n" +
"      }\n" +
"      headsign\n" +
"    }\n" +
"  }\n" +
"}";

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.digitransit.fi/routing/v1/routers/hsl/index/graphql");
        post.setHeader("Content-Type", "application/graphql");
        post.setEntity(new StringEntity(query));

        CloseableHttpResponse response = httpClient.execute(post);
        
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            System.err.println("Error occurred, status code: " + statusCode);
            return;
        }
        
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, Charset.defaultCharset());

        //String responseString = response.getData().toString();

        /* tää toimii JSONObject json = new JSONObject(responseString);
           System.out.println(json);
        */
        
        
        JSONObject parsedJson = new JSONObject(responseString);

    // Access the `data` key
        JSONObject data = parsedJson.getJSONObject("data");

    // Access the `stops` key
        JSONArray stops = data.getJSONArray("stops");
        
        for (int i = 0; i < stops.length(); i++) {
        JSONObject stop = stops.getJSONObject(i);
        String stopName = stop.getString("name");
        JSONArray stoptimesWithoutPatterns = stop.getJSONArray("stoptimesWithoutPatterns");
    // Iterate over the stoptimesWithoutPatterns
    for (int j = 0; j < stoptimesWithoutPatterns.length(); j++) {
        JSONObject stoptime = stoptimesWithoutPatterns.getJSONObject(j);
        String headsign = stoptime.getString("headsign");
        JSONObject trip = stoptime.getJSONObject("trip");
        JSONObject route = trip.getJSONObject("route");
        String shortName = route.getString("shortName");
        int realtimeDeparture = stoptime.getInt("realtimeDeparture");

        LocalTime time = LocalTime.ofSecondOfDay(realtimeDeparture);

        String formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm"));
        // Print the information
        
        System.out.println(stopName +  "    " + formattedTime + " " + headsign + " " + shortName);
    }
}






    }
}

