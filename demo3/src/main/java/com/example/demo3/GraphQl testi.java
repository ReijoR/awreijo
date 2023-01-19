import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        // your code to build the schema
        {
            nearest(lat: 60.161084, lon: 24.921560, maxDistance: 500, filterByPlaceTypes: DEPARTURE_ROW) {
              edges {
                node {
                  place {
                    ...on DepartureRow {
                      stop {
                        lat
                        lon
                        name
                      }
                      stoptimes {
                        serviceDay
                        scheduledDeparture
                        realtimeDeparture
                        trip {
                          route {
                            shortName
                            longName
                          }
                        }
                        headsign
                      }
                    }
                  }
                  distance
                }
              }
            }
          }
    }
}
