package cookieClicker;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class cookieMain {
	
	//getting the label
	
	JLabel counterLabel, perSecLabel;
	
	JButton button1, button2, button3, button4;
	
	int cookieCounter, timerSpeed, cursorNumber, cursorPrice;
	
	int grandpaNumber = 0;
	int grandpaPrice = 100;
	boolean grandpaUnlocked = false;
	
	double perSecond;
	boolean timerOn;
	
	Font font1, font2;
	
	CookieHandler cHandler = new CookieHandler();
	
	//Timer
	
	Timer timer;
	
	JTextArea messageText;
	
	MouseHandler mHandler = new MouseHandler();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new cookieMain();

	}
	
	//Constructor
	
	public cookieMain() {
		
		timerOn = false;
		
		perSecond = 0;
		
		cookieCounter = 0;
		
		cursorNumber = 0;
		
		cursorPrice = 10;
		
		createFont();
		
		createUI();
		
				
	}
	//making custom font label
	
	public void createFont() {
		
		font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
		font2 = new Font("Comic Sans MS", Font.PLAIN, 15);
		
	}
	
	//Creating window 
	
	public void createUI() {
	//window layout
		
		JFrame window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.BLACK);
		window.setLayout(null);
		
		//image
		
		JPanel cookiePanel = new JPanel();
		cookiePanel.setBounds(100,220,200,200);
		cookiePanel.setBackground(Color.black);
		window.add(cookiePanel);
		
		//Get the image from the resource folder
		
		ImageIcon cookie = new ImageIcon(getClass().getClassLoader().getResource("newCookie.png"));
		
		//Button using the image
		
		JButton cookieButton = new JButton();
		cookieButton.setBackground(Color.black);
		cookieButton.setFocusPainted(false);
		cookieButton.setBorder(null);
		cookieButton.setIcon(cookie);
		
		//When you click the cookieHandler method this is being called
		cookieButton.addActionListener(cHandler);
		
		cookieButton.setActionCommand("cookie");
		cookiePanel.add(cookieButton);
		
		
		//Counter
		
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100,100,200,100);
		counterPanel.setBackground(Color.black);
		counterPanel.setLayout(new GridLayout(2,1));
		window.add(counterPanel);
		
		//initializing the label
		
		counterLabel = new JLabel(cookieCounter + " cookies");
		counterLabel.setForeground(Color.white);
		//calling the font label 
		counterLabel.setFont(font1);
		counterPanel.add(counterLabel);
		
		perSecLabel = new JLabel();
		perSecLabel.setForeground(Color.white);
		perSecLabel.setFont(font2);
		counterPanel.add(perSecLabel);
		
		//item panel
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(500,170,250,250);
		itemPanel.setBackground(Color.black);
		itemPanel.setLayout(new GridLayout(4,1));
		window.add(itemPanel);
		
		//Initializing JButtons
		//Button1
		
		button1 = new JButton("Cursor");
		button1.setFont(font1);
		button1.setFocusPainted(false);
		button1.addActionListener(cHandler);
		//setActionCommand(String) = sets the command name for the action event fired by this button
		button1.setActionCommand("Cursor");
		button1.addMouseListener(mHandler);
		itemPanel.add(button1);
			
		//Button2
		
		button2 = new JButton("?");
		button2.setFont(font1);
		button2.setFocusPainted(false);
		button2.addActionListener(cHandler);
		button2.setActionCommand("Grandpa");
		button2.addMouseListener(mHandler);
		itemPanel.add(button2);
		
		//Button3 
		
		button3 = new JButton("?");
		button3.setFont(font1);
		button3.setFocusPainted(false);
		button3.addActionListener(cHandler);
		button3.setActionCommand("Grandpa");
		button3.addMouseListener(mHandler);
		itemPanel.add(button3);
		
		//Button4
		
		button4 = new JButton("?");
		button4.setFont(font1);
		button4.setFocusPainted(false);
		button4.addActionListener(cHandler);
		button4.setActionCommand("Grandpa");
		button4.addMouseListener(mHandler);
		itemPanel.add(button4);
		
		
		//message panel
		
		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(500,70,250,250);
		messagePanel.setBackground(Color.black);
		window.add(messagePanel);
		
		//Displays text
		messageText = new JTextArea();
		messageText.setBounds(500,70,250,150);
		messageText.setForeground(Color.white);
		messageText.setBackground(Color.black);
		messageText.setFont(font2);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setEditable(false);
		messagePanel.add(messageText);
		
		
		window.setVisible(true);
		
	}
	
	public void setTimer() {
		
		//speed of timer
		timer = new Timer(timerSpeed, new ActionListener() {
			
			//what happens when timer is activated 
			//repeats action performed every 1 second

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				cookieCounter++;
				counterLabel.setText(cookieCounter + " cookies");
				
				if(grandpaUnlocked == false) {
					if(cookieCounter >= 100) {
						grandpaUnlocked = true;
						
						button2.setText("Grandpa " + "(" + grandpaNumber + ")");
					}
				}
				
			}
			
			
		});

	
	
	}
	
	//timerUpdate method
	//speed increases every 10 second
	
	public void timerUpdate() {
		
		if(timerOn == false) {
			timerOn = false;
		}
		
		else if(timerOn == true) {
			timer.stop();
		}
		
		double speed = 1/perSecond * 1000;
		timerSpeed = (int)Math.round(speed);
		
		//shows only 2 decimal point
		String s = String.format("%.1f", perSecond);
		
		perSecLabel.setText("per second: " + s);
		
		setTimer();
		timer.start();
		
	}
	

	//To tap the cookie button
	
	public class CookieHandler implements ActionListener {

	
		public void actionPerformed(ActionEvent event) {
			
			String action = event.getActionCommand();
			
			switch(action) {
			
			case "cookie":
				cookieCounter++;
				counterLabel.setText(cookieCounter + " cookies");
				break;
			case "Cursor":
				if(cookieCounter >= cursorPrice) {
				cookieCounter = cookieCounter - cursorPrice;
				cursorPrice = cursorPrice + 5;
				counterLabel.setText(cookieCounter + " cookies");
				
				cursorNumber++;
				button1.setText("Cursor " + "("+ cursorNumber +")");
				perSecond = perSecond + 0.1;
				timerUpdate();
				
				} else {
					messageText.setText("You need more cookies");
				}
				break;
				
			case "Grandpa":
				if(cookieCounter >= grandpaPrice) {
					cookieCounter = cookieCounter - grandpaPrice;
					grandpaPrice = grandpaPrice + 50;
					counterLabel.setText(cookieCounter + " cookies");
					
					grandpaNumber++;
					button2.setText("Grandpa " + "("+ grandpaNumber +")");
					messageText.setText("Grandpa \n[price: " + grandpaPrice + "]\n Each grandpa produces 1 cookie per second");
					perSecond = perSecond + 1;
					timerUpdate();
					
					} else {
						messageText.setText("You need more cookies");
					}
					break;
				
				
				
			}
			
			
			
			
		}
		
	}
	
	//Mouse hover
	
	public class MouseHandler implements MouseListener {
		


		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			//When mouse placed on something
			
			JButton button = (JButton)e.getSource();
			
			if(button == button1) {
				messageText.setText("Cursor\n[Price: $"+cursorPrice + "] \nAutoclicks once every 10 seconds.");
			}
			else if(button == button2) {
				messageText.setText("This item is currently locked");
				if(grandpaUnlocked == false) {
					messageText.setText("This item is currenly locked");
				}
				else {
					messageText.setText("Grandpa \n[price: " + grandpaPrice + "]\n Each grandpa produces 1 cookie per second");
				}
				
			}
			else if(button == button3) {
				messageText.setText("This item is currently locked");
				
		
			}
			else if(button == button4) {
				messageText.setText("This item is currently locked");
		}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
			JButton button = (JButton)e.getSource();
			
			if(button == button1) {
				
				messageText.setText(null);
				
			}
			if(button == button2) {
							
							messageText.setText(null);
							
						}
			if(button == button3) {
				
				messageText.setText(null);
				
			}
			if(button == button4) {
				
				messageText.setText(null);
				
			}
			
			
		}
	}

}

