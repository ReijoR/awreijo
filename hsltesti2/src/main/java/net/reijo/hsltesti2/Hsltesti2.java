/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.hsltesti2;

/**
 *
 * @author Reijo
 */
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import java.net.URL;

import graphql.example.type.CustomTypeQuery;

public class Hsltesti2 {

    public static void main(String[] args) {
        
        try {
      ApolloClient apolloClient = ApolloClient.builder()
        .serverUrl(new URL("https://your-graphql-endpoint.com/graphql"))
        .build();

      apolloClient
        .query(CustomTypeQuery.builder().build())
        .enqueue(new ApolloCall.Callback<CustomTypeQuery.Data>() {
          @Override
          public void onResponse(@Nonnull Response<CustomTypeQuery.Data> response) {
            // handle the response
            System.out.println(response.data());
          }
          @Override
          public void onFailure(@Nonnull ApolloException e) {
            // handle failure
            e.printStackTrace();
          }
        });
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    }
}
