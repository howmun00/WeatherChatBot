package avenger.weather;

public class WeatherCookie {
	public static Weather weatherCookie;

	public void setCookie(Weather cookie) {
		WeatherCookie.weatherCookie = cookie;
	}
	
	public Weather getCookie() {
		return weatherCookie;
	}

}
