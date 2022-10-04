package avenger.chatbot;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import avenger.weather.Location;
import avenger.weather.Weather;
import avenger.weather.WeatherCookie;

// Class that implement a ChatBot using Swing Class
public class ChatBot extends JFrame implements KeyListener{
	
//	The main will call the chatbot to start
	public static void main(String[] args){
		new ChatBot();
	}

//	Initialising some Swing variables to create the GUI interface
	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,50);
	JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);
	
//	This HashMap will store some basic quotes for interaction with the user
//	When the Key is activate the HashMap will have a appropriate answer 
	private static HashMap<String, String> knowledge = new HashMap<String, String>();

//	This response store in each state the conversation is in the moment
//	0 - SmallTalk, 1 - Weather confirmation, 2 - inform Weather, 3 - Clothes
	private static int response=0;
	
//	The Weather Location if the user ask
	private Location city;
	
//	This is the constructor, will give the chatbox a size, set the listener and the dictionary 
	public ChatBot(){
//		Chatbox Size and Listener
		super("Avenger Chat Bot");
		setSize(600,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		dialog.setEditable(false);
		input.addKeyListener(this);
		p.add(scroll);
		p.add(input);
		p.setBackground(new Color(255,200,0));
		add(p);
		setVisible(true);
//		Creating the Dictionary
		chatbotInteligence();	
	}
	
//	This method is used to get what the user is texting
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
//			Grab Quote
			String quote=input.getText();
			input.setText("");
			addText("-->You:\t"+quote);
			quote = quote.trim();
			while(
				quote.charAt(quote.length()-1)=='!' ||
				quote.charAt(quote.length()-1)=='.' ||
				quote.charAt(quote.length()-1)=='?'
			){
				quote=quote.substring(0,quote.length()-1);
			}
//			The quote will be trimmed and transformed in LowerCase
			quote = quote.trim().toLowerCase();
			
//			Depending the state of the Response the conversation will follow a specific path
			if(response == 3)
				avengerSuggestClothes(quote);
			if(response == 2)
				avengerWeather(quote);
			if(response == 1)
				askCity(quote);
			if(response == 0) 
				avengerSmallTalk(quote);
		}
	}
			
//	Depending on the Weather the ChatBot will suggest user cloaths
	private void avengerSuggestClothes(String quote) {
		if(quote.contains("yes")) {
			response = 0;
			WeatherCookie c = new WeatherCookie();
			Weather weather = c.getCookie();
			if(weather.getFeelsLike() > 20)
				addText("\nAvenger: You are going for a treat use sunscreen and ligth clothes today is HOT!");
			else if (weather.getFeelsLike() > 14 && weather.getFeelsLike() < 20)
				addText("\nAvenger: Today is a good day, use some sunscreen, ligth clothes and a light jacket just in case.");
			else if (weather.getFeelsLike() > 10 && weather.getFeelsLike() < 14)
				addText("\nAvenger: Oh just a typical day, use your hoodie or sweather and my god help us with some sunshine");
			else 
				addText("\nAvenger: Why you so surprised ? It's cold use everything you have or just stay home enjoy a cup of tea!");
    		addText("\n");
		} else {
			response = 0;
			addText("\nAvenger: If you change your mind let me know");
    		addText("\n");
		}
		
	}

//	The chatbot will call an API to inform the user the weather
	private void avengerWeather(String quote) {
//		In case the response is in state 2, the API will called to get the weather information.		
			String weather = getWeatherApi(quote);
			city = new Location(quote);
			addText(weather);
//			After the weather be send with success the user will be if he/she want advice about clothes
			if(weather.contains("weather information")) {
				response = 3;
				addText("Avenger: Do you want to know which clothes to wear ?\n");
			}	
	}
	
//	The method will conform with the user and ask about which city is necessary to know the weather
	private void askCity(String quote) {
			if(quote.contains("yes")) {
				response = 2;
				addText("\nAvenger: Please let me know the name of the city ?");
	    		addText("\n");
			} else {
				addText("\nAvenger: Oh ok, I am here if you need later.\n");
				response = 0;}
		}


//	Create a request to the Weather API
	private String getWeatherApi(String quote) {
		RequestWeatherInfo req = new RequestWeatherInfo();
//		Return the info about Weather and updating the WeatherInfo reference
		return req.weatherRequest(quote);
	}

//	Give small talk with the user
	public void avengerSmallTalk(String quote) {
		Set<String> keys = knowledge.keySet();
	    for (String key : keys){
	    	if (key.toLowerCase().contains(quote)) {
	    		addText("\nAvenger: " + knowledge.get(key));
	    		addText("\n");
	    		break;
	    	}
		}if(quote.contains("weather")) {
    		addText("\nAvenger: Do you really wanna know the weather ?");
    		addText("\n");
    		response = 1;
    		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
//	Throw text in the chatBOX
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
//	Dictionary for small talk with user
	private static void chatbotInteligence() {
		knowledge.put("Hi", "Hello... Please to meet you!");
	    knowledge.put("Hello", "Hi yo");
	    knowledge.put("how are you?", "Great! I hope you well!");
	    knowledge.put("what time is it", "Look at your watch!");
	}
	

}