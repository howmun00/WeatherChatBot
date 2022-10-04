package avenger.weatherAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//This class will create a HTTP request with the weather API
//The request will be made it will receive a JSON string with the weather information
public class apiRequest {
	
//	This method it will call the HTTPRequest, receive 
	public String requestWeatherInformation(String city) throws IOException, InterruptedException {

//      Create a request with the city of user choice and Receive the Json String
        String jsonString = HTTPrequest(city, "Ireland");
        return jsonString;
	}
	
	
// The HTTPrequest it will receive the parameters as City and Country in order to request its weather data
	public static String HTTPrequest(String city, String country) throws IOException, InterruptedException{
		
//		This will build the request to the API, informing the City, Country and other informations necessary
		HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://community-open-weather-map.p.rapidapi.com/weather?q=" + city + "%2C%20" +
                 country + "&lang=null&units=metric"))
                .header("x-rapidapi-key", "57aadda58fmshfad23212a5b5ccfp19eeb6jsnfa87a94f744e")
                .header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();	
//		Send the request and receive the HTTPresponse
		 HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		 The method now will return the JSON response in a string format
		 return response.body();
		
	}
}
