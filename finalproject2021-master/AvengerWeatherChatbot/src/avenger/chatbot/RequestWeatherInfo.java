package avenger.chatbot;

import java.io.IOException;
import java.util.Scanner;

import avenger.jsonParser.jsonParser;
import avenger.weather.*;
import avenger.weatherAPI.apiRequest;

public class RequestWeatherInfo{
	
public String weatherRequest(String city) {
	apiRequest request = new apiRequest();
	jsonParser jParser = new jsonParser();
	Weather weatherInfo = null;
	WeatherCookie c = new WeatherCookie();
	
		try {
			String jsonString = request.requestWeatherInformation(city);
//			Check if the limit of requests to the API have been achieved
			if(limitExceeded(jsonString)) {
				return "\nAvenger: Sorry I can't help you right.";
			}
			else if(jsonString != null) {
				weatherInfo = jParser.jsonStringParser(jsonString);
				weatherInfo.setLocation(city);
				c.setCookie(weatherInfo);
				return theWeather(weatherInfo);
			}
		}
//		Catch the error and give back the error message
		catch(IOException an) {
			return cityNotFound();}
		catch(InterruptedException an) {
			return connectionError();}
		catch(NullPointerException e) {
			return cityNotFound();}
		return "Something wrong happened";
		} 
	

private String theWeather(Weather weatherInfo) {
	String string  = "\nAvenger: I got the weather information in " + weatherInfo.getLocation().getCity() + ", " 
			+ weatherInfo.getLocation().getCountry() + " for you!\n"
			+ "The current Temperature is " + weatherInfo.getTemp() 
			+ " Celsius, However feels like " + weatherInfo.getFeelsLike() + " Celsius.\n"
			+ "The max will be " + weatherInfo.getMax() + " Celsius, and the minimun will be " + weatherInfo.getMin() + " Celsius.\n";
	return string;
}

//	Check if the limit of requests to the API have been achieved
	private boolean limitExceeded(String jsonString) {
		String string = ("{\"message\":\"You have exceeded the rate limit per minute for your plan, BASIC, by the API provider\"}");
		return jsonString.equals(string);
	}
// Return an statement about city not found
	private String cityNotFound(){
		return ("Sorry we can't find this city.\n"
				+ "Could you please the spelling and write the name again");
		}
//	Return an statement about error Connection
	private String connectionError(){
		return ("Sorry we are having a little trouble with the connection \n"
					+ "Please try again later.");
	}

}
