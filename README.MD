# Geo IP REST App
Simple REST API application can determine the country's name from an IP address. The application is using an external API ([IpApi](https://ipapi.co/)) to get country's name based on given IP address and than save the result of successful requests in local database. The application is using [H2](https://www.h2database.com/html/main.html) database for simple implementation.

## Build and run the app
1. Clone the repository: `git clone https://github.com/aminhasan/geo-ip.git`
2. Build the app: `mvn clean -DskipTests=true package`
3. Run the app: `java -jar target/geo-ip-0.0.1-SNAPSHOT.jar`

## Test the app
The application is running on localhost:8080 and can be tested either with curl command or in the browser. There are two endpoints available:
1. get the country name of given IP, examples: <br />
`GET http://localhost:8080/country?ip=5.6.7.8` <br />
`GET http://localhost:8080/country?ip=8.8.8.8` <br />
`GET http://localhost:8080/country?ip=1.2.3.4`

2. get the total number of requests (successful and erroneous) <br />
`GET http://localhost:8080/country/requests`

## H2 console
After launching the application you can access the H2 console by opening `http://localhost:8080/h2-console/` in the browser. <br />
***NOTE:*** Make sure that you use `jdbc:h2:mem:testdb` as JDBC URL.
