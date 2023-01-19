/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.hslapitesti;

/**
 *
 * @author Reijo
 */
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import java.util.Collections;

public class HSLApiTesti {

    public static void main(String[] args) {
        
        ApolloClient apolloClient = ApolloClient.builder()
                .serverUrl("https://your-graphql-endpoint.com/graphql")
                .build();

        YourQuery query = YourQuery.builder().build();

        apolloClient.query(query).enqueue(new ApolloCall.Callback<YourQuery.Data>() {
            @Override
            
            public void onResponse(@NotNull Response<YourQuery.Data> response) {
                // handle the response data
                // response.data() will contain the query result
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                // handle the error
            }
        });
    }
}
        