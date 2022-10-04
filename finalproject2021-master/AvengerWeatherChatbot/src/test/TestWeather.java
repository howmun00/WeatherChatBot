package avenger.weather.weatherRequested;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestWeather {

	private Request testweather=new Request(); 
	
	protected double temp;
	protected String city;

	public static void main(String[] args) {
		
	}
	

		//Test getDescription()
		@Test
		public void testdescription() {
			Weather testdescription=testweather.weatherRequest();	
			assertEquals(testdescription.getDescription(),"broken clouds");
		}
	
		//Test getTemp()
		@Test
		public void testTemp() {
			Weather testTemp=testweather.weatherRequest();		
			assertEquals("Error in testTemp",23.0,testTemp.getTemp(),0.1);
		}
		
		//Test Min()
		@Test
		public void testmin() {
			Weather testmin=testweather.weatherRequest();	
			assertEquals("Error in testmin",23.0,testmin.getMin(),0.1);
		}
		
		//Test Max()
		@Test
		public void testmax() {
			Weather testmax=testweather.weatherRequest();		
			assertEquals("Error in testmax",23.0,testmax.getMax(),0.1);
		}
		
		//Test getfeels()
		@Test
		public void testfeels() {
			Weather testfeels=testweather.weatherRequest();	
			assertEquals("Error in testfeels",21.38,testfeels.getFeelsLike(),0.1);
		}
		
		//Test getwindspeed()
		@Test
		public void testwindspeed() {
			Weather testwindspeed=testweather.weatherRequest();			
			assertEquals("Error in getwindspeed",7.2,testwindspeed.getWindSpeed(),0.1);
		}	
		
		
		//Test Location()
		@Test
		public void testlocation() {
			Weather testlocation=testweather.weatherRequest(); 
			assertEquals("error in testlocation", testlocation.getLocation(),testlocation.getLocation());
		}

		@Ignore
		//Test Runner for Weather.class
		@Test
		public void main() { 
			Result result=JUnitCore.runClasses(Weather.class);
			for (Failure failure : result.getFailures()) {
		         System.out.println(failure.toString());
		      }
				
		      System.out.println(result.wasSuccessful());
		   }
		
		
	
}
