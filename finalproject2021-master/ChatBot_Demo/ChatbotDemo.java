import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.JulianFields;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chatbot extends JFrame{
	// Creation of Text area, Text field, Label and Button on Chat bot
	private JTextArea ca = new JTextArea();
	private JTextField cf = new JTextField();
	private JLabel lb = new JLabel();
	private JLabel labelPic = new JLabel();
	private JButton b = new JButton();
	
	// Constructor for Chatbot
	
	ImageIcon image = new ImageIcon("icon.jpeg");
	
	Chatbot (){
		// JFrame is used in order to make the frame for the Chatbot
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(400, 400);
		f.getContentPane().setBackground(Color.blue);
		f.setTitle("Avengers_Weather_Application");
		
		
		// Methods used to add components on JPane
		f.add(ca);
		f.add(cf);
		
	
		ca.setSize(300, 310);
		ca.setLocation(1, 1);
		ca.setBackground(Color.magenta);
		
		
		// Setting up Chat field
		cf.setSize(300, 20);
		cf.setLocation(1, 320);
		
		
		// Setting up buttons on the Chatbot
		f.add(b);
		b.add(lb);
		lb.setText("Enter");
		b.setSize(400, 20);
		b.setLocation(300, 320);
		
		// Setting image on the side of GUI
		f.add(labelPic);
		labelPic.setText("Photo Location");
		labelPic.setIcon(image);
		labelPic.setText(" ");
		labelPic.setSize(300, 305);
		labelPic.setLocation(300, 5);
		
		
		// ActionListerner 
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b) {
					String text = cf.getText().toLowerCase();
					ca.setForeground(Color.green);
					ca.append("User: " + text + "\n");
					cf.setText(" ");
					
					
					if (text.contains("hi")) {
						replyMethod("Hello, There");
					}
					else {
						replyMethod("Sorry I can not understand");
					}
				}
				
			}
		});
	}
		public void replyMethod (String s) {
			ca.append("Chatbot: " + s + "\n");
		}
}



public class ChatbotDemo {
 public static void main (String[] args) {
	 Chatbot a = new Chatbot();
 }
}
