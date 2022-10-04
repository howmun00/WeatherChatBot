package avenger.weather.jsonParser;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import avenger.weather.weatherRequested.Weather;

@RunWith(Parameterized.class)
public class Testjson  {
 Weather test;
 Map<String, Object> map;
 
	private jsonParser testjson=new jsonParser(); 
	private  Map<String, Object> respMap;
	private  Map<String, Object> mainMap;
	private Map<String, Object> windMap;
	private Map<String, Object> weatherMap;
	
	
	@Before
	   public void initialize() {
	      jsonParser tests= new jsonParser();
	   }
	
	public Testjson(Map<String, Object> respMap, Map<String, Object> mainMap, Map<String, Object> windMap, Map<String, Object> weatherMap) {
	      this.respMap = respMap;
	      this.mainMap = mainMap;
	      this.windMap = windMap;
	      this.weatherMap = weatherMap;
	   }
	
	public  Map<String, Object> getrespmap() {
		return respMap;
	}
	
	public Map<String, Object> getmainmap() {
		return mainMap;
	}
	
	public Map<String, Object> getwindmap() {
		return windMap;
	}
	
	public Map<String, Object> getweathermap() {
		return weatherMap;
	}
	
	
	public Map<String, Object> RespMap() {
		Map<String, Object> respMap= Testjson.this.getrespmap();
		return respMap;
	}
	
	
	public  Map<String, Object> MainMap() {
		Map<String, Object> mainMap= Testjson.this.getmainmap();
		return mainMap;
	}
	
	
	public  Map<String, Object> WindMap() {
		Map<String, Object> windMap= Testjson.this.getwindmap();
		return windMap;
	}
	
	
	public  Map<String, Object> WeatherMap() {
		Map<String, Object> weatherMap= Testjson.this.getweathermap();
		return weatherMap;
	}
		
	@Test
	   public void testrespmap() throws IOException {
	      System.out.println(Testjson.this.RespMap());
	      assertEquals("error", Testjson.this.RespMap());
	   }
	
	@Test
	   public void testmainmap() throws IOException {
	      System.out.println(Testjson.this.MainMap());
	      assertEquals("error", Testjson.this.MainMap());
	   }
	
	@Test
	   public void testwindmap() throws IOException {
	      System.out.println(Testjson.this.WindMap());
	      assertEquals("error", Testjson.this.WindMap());
	   }
	
	@Test
	   public void testweathermap() throws IOException{
	      System.out.println(Testjson.this.WeatherMap());
	      assertEquals("error", Testjson.this.WeatherMap());
	   }
	
	@Ignore
	@Test(expected=NullPointerException.class)
    public void nullException() {
        String a = null;
        testjson.jsonStringParser(a);
    }
	
	
}
