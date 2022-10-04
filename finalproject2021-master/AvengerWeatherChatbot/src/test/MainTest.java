package avenger.weather.test;

import java.io.IOException;

import avenger.weather.api.apiRequest;
import avenger.weather.weatherRequested.Location;
import avenger.weather.weatherRequested.Request;
import avenger.weather.weatherRequested.Weather;

public class MainTest {
	
    public static void main(String[] args) throws IOException, InterruptedException{
    	Weather weatherInfo = null;
        Request req = new Request();

        weatherInfo = req.weatherRequest();
        
        if(weatherInfo != null) {
        	System.out.println("Location: " + weatherInfo.getLocation().getCity() + ", " + weatherInfo.getLocation().getCountry());
            System.out.println("Current Temperature: " + weatherInfo.getTemp());
            System.out.println("Feels Like: " + weatherInfo.getFeelsLike());
            System.out.println("Max: " + weatherInfo.getMax());
            System.out.println("Min: " + weatherInfo.getMin());
            System.out.println("Wind Speed: " + weatherInfo.getWindSpeed());
        } else {
        	System.out.println("Sorry we are unable to locate help you right now!");
        }

    }

}
