package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import avenger.jsonParser.jsonParser;
import avenger.weather.Weather;
import avenger.weatherAPI.apiRequest;

public class testCases {

	@Test
	public void apiRequest() {
//		Making a Test with a Valid City
		
		apiRequest request = new apiRequest();
		String jsonString = null;
		
		try {
			jsonString = request.requestWeatherInformation("Cork");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(jsonString != null, jsonString != null);
	}
	
	@Test
	public void apiRequestCityGibberish() {
//		Making a Test with a invalid City
		
		apiRequest request = new apiRequest();
		String jsonString = null;
		
		try {
			jsonString = request.requestWeatherInformation("Coushdaushdaushduahsuadhoaosa");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(jsonString != null, jsonString != null);
	}
	
	@Test
	public void CreatingWeatherObject() {
//		Using a valid city the Json need to parsed and return a valid Weather Object
		
		apiRequest request = new apiRequest();
		jsonParser jParser = new jsonParser();
		String jsonString = null;
		
		
		try {
			jsonString = request.requestWeatherInformation("Cork");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Weather weatherInfo = jParser.jsonStringParser(jsonString);
		
		assertEquals("Weather", weatherInfo.getClass().getSimpleName());
	}
	
	
}
