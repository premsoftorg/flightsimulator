Name: Flight Booking Simulator
Application type : Microservice API
Build dependency management using : Maven
Produces: Json Response

Swagger URL : http://localhost:8080/swagger-ui.html#/search-controller

Sample-Request:

http://localhost:8080/search?travelDate=15-08-2020&source=Chennai&destination=delhi&returnDate=18-08-2020

Sample Response :


{
    "onwardsFlights": [
        {
            "durationinSeconds": 1000,
            "noOfStops": 3,
            "price": 2436,
            "departureTime": "2020-08-09 00:16:40",
            "arrivalTime": "2020-08-09 00:33:20",
            "flightNumber": "FL601",
            "airlineName": "Indico Airlines"
        },
        {
            "durationinSeconds": 2000,
            "noOfStops": 3,
            "price": 3294,
            "departureTime": "2020-08-09 00:33:20",
            "arrivalTime": "2020-08-09 01:06:40",
            "flightNumber": "FL24",
            "airlineName": "Indico Airlines"
        },
        {
            "durationinSeconds": 3000,
            "noOfStops": 3,
            "price": 20,
            "departureTime": "2020-08-09 00:50:00",
            "arrivalTime": "2020-08-09 01:40:00",
            "flightNumber": "FL751",
            "airlineName": "Indico Airlines"
        },
        {
            "durationinSeconds": 4000,
            "noOfStops": 2,
            "price": 640,
            "departureTime": "2020-08-09 01:06:40",
            "arrivalTime": "2020-08-09 02:13:20",
            "flightNumber": "FL391",
            "airlineName": "Indico Airlines"
        },
        {
            "durationinSeconds": 5000,
            "noOfStops": 0,
            "price": 3866,
            "departureTime": "2020-08-09 01:23:20",
            "arrivalTime": "2020-08-09 02:46:40",
            "flightNumber": "FL857",
            "airlineName": "Indico Airlines"
        },
        {
            "durationinSeconds": 6000,
            "noOfStops": 1,
            "price": 2306,
            "departureTime": "2020-08-09 01:40:00",
            "arrivalTime": "2020-08-09 03:20:00",
            "flightNumber": "FL614",
            "airlineName": "Indico Airlines"
        },
        {
            "durationinSeconds": 7000,
            "noOfStops": 2,
            "price": 1284,
            "departureTime": "2020-08-09 01:56:40",
            "arrivalTime": "2020-08-09 03:53:20",
            "flightNumber": "FL630",
            "airlineName": "Indico Airlines"
        },
        {
            "durationinSeconds": 8000,
            "noOfStops": 1,
            "price": 280,
            "departureTime": "2020-08-09 02:13:20",
            "arrivalTime": "2020-08-09 04:26:40",
            "flightNumber": "FL643",
            "airlineName": "Indico Airlines"
        }
    ],
    "returnFlights": [
        {
            "durationinSeconds": 1000,
            "noOfStops": 2,
            "price": 966,
            "departureTime": "2020-08-09 00:16:40",
            "arrivalTime": "2020-08-09 00:33:20",
            "flightNumber": "FL669",
            "airlineName": "Indico Airlines"
        },
        {
            "durationinSeconds": 2000,
            "noOfStops": 4,
            "price": 3128,
            "departureTime": "2020-08-09 00:33:20",
            "arrivalTime": "2020-08-09 01:06:40",
            "flightNumber": "FL399",
            "airlineName": "Indico Airlines"
        },
        {
            "durationinSeconds": 3000,
            "noOfStops": 1,
            "price": 1406,
            "departureTime": "2020-08-09 00:50:00",
            "arrivalTime": "2020-08-09 01:40:00",
            "flightNumber": "FL555",
            "airlineName": "Indico Airlines"
        }
    ],
    "onwardFlightCount": 8,
    "returnFlightCount": 3
}
