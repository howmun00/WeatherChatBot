package avenger.weather.chatbot;

import java.util.*;
 
public class TestBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        AvengerBot chatbot = new AvengerBot();
 
        while(!userInput.equalsIgnoreCase("stop it")) {
            userInput = chatbot.userInput(sc);
            chatbot.answer(sc, userInput);
        }
        sc.close();
    }

}