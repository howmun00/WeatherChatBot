package avenger.weather.weatherRequested;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestRequest {

	private Request testrequest=new Request(); 

	//Test the Class is not null
	@Test
	public void test() {
		assertNotNull(Request.class);
	}

	//Test for weatherRequest()
	@Test
	public void testweatherRequest() {
		Double request=23.0;
		Weather testRequest=testrequest.weatherRequest();
		assertEquals(request,testRequest.getTemp(),0.1);
	}
	
	//Test Runner for Request.class
	@Test
	public void main() {
		Result result=JUnitCore.runClasses(Request.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());	         
	      }
			
	      System.out.println("Successful");
	   }
	
	
	
	}
	
	
	
	
	
	
	
	
	

