{
  nearest(lat: 60.247995, lon: 24.862295, maxDistance: 500, filterByPlaceTypes: DEPARTURE_ROW) {
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