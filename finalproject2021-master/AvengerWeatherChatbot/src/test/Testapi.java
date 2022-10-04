package avenger.weather.api;


import java.io.IOException;


public class Testapi {

	
	public static void main(String[] args) throws IOException, InterruptedException{
		String city=new String("Dublin");
		String country=new String("Ireland");
		System.out.println(apiRequest.HTTPrequest(city, country));
	}

}
