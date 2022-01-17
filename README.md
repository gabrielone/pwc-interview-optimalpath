# pwc-interview-optimalpath

### Backend Developer Test:

```
Your task is to create a simple Spring Boot service, that is able to calculate any possible land
route from pwc country to another. The objective is to take a list of country data in JSON format
and calculate the route by utilizing individual countries border information.
Specifications:
● Spring Boot, Maven
● Data link: https://raw.githubusercontent.com/mledoze/countries/master/countries.json
● The application exposes REST endpoint /routing/{origin}/{destination} that
returns a list of border crossings to get from origin to destination
● Single route is returned if the journey is possible
● Algorithm needs to be efficient
● If there is no land crossing, the endpoint returns HTTP 400
● Countries are identified by cca3 field in country data
● HTTP request sample (land route from Czech Republic to Italy):
    ○ GET /routing/CZE/ITA HTTP/1.0 :
        {
        "route": ["CZE", "AUT", "ITA"]
        }
        
Expected deliveries:
1. Source code
2. Instructions on how to build and run the application
```

### Solution

I have created a simple Spring Boot application exposing a REST endpoint with a logic of routing between countries. A
list of countries with borders is available at another endpoint.

### How to build and run the application:

You must have a JAVA_HOME environment variable set pointing to an existing Java installation directory

Linux/OS X:

```
./mvnw clean install spring-boot:run
```

Windows:

```
mvnw clean install spring-boot:run
```

Command line in Postman or Insomnia:

```
curl --request GET \
--url http://localhost:8080/routing/CZE/ITA
```

Application runs on localhost port 8080. Example URL for request:

```
http://localhost:8080/routing/CZE/ITA
```

If we try some combinations:

```
http://localhost:8080/routing/CZE/ITA  results in "CZE","AUT","ITA"

http://localhost:8080/routing/LSO/MYS  results in  "LSO","ZAF","BWA","ZMB","COD",
"CAF","SDN","EGY","ISR","JOR","IRQ","IRN","AFG","CHN","MMR","THA","MYS"

http://localhost:8080/routing/routing/GBR/IRL results in "GBR","IRL"

http://localhost:8080/routing/routing/GBL/GRL results in "GBR","IRL"
```

**Algorithm :** The algorithm is Dijkstra Shortest Path. I chose him because stands out from the rest due to its ability
to find the shortest path from one node to every other node within the same graph data structure. This means, that
rather than just finding the shortest path from the starting node to another specific node, the algorithm works to find
the shortest path to every single reachable node – provided the graph doesn’t change.

The algorithm runs until all of the reachable nodes have been visited. Therefore, you would only need to run Dijkstra’s
algorithm once, and save the results to be used again and again without re-running the algorithm – again, unless the
graph data structure changed in any way.

In the case of a change in the graph, you would need to rerun the graph to ensure you have the most updated shortest
paths for your data structure.



