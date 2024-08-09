package quizpack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

//		Declaring as global variables
		JTextField nameBox;
		JButton start,exit;
	Login() {
//		for visible the frame
		setVisible(true);
//		frame size length and width
		setSize(1000,500);
//		appear location on desktop x and y axis direction
		setLocation(250,150);
//		background color is white
		getContentPane().setBackground(Color.WHITE);
//		Set our own layout on frame 
		setLayout(null);
		
//		For Image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
		Image i=i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i);
		
		JLabel image=new JLabel(i2);
		image.setBounds(450, 0, 550, 500);
		add(image);
		
	        
//		For Heading 
		JLabel heading= new JLabel("QUIZ TEST");
		heading.setBounds(150, 60, 300, 45);
		heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
		heading.setForeground(Color.BLUE);
		add(heading);
		
//		For Text box Understanding purpose just like as a label
		JLabel name= new JLabel("Enter Your Name");
		name.setBounds(140, 150, 300, 20);
		name.setFont(new Font("Baskerville Old Face",Font.BOLD,18));
		name.setForeground(Color.GREEN);
		add(name);
		
//		Text Box
		nameBox = new JTextField();
		nameBox.setBounds(140,200,200,25);
		nameBox.setFont(new Font("Calibri",Font.PLAIN,18));
		add(nameBox);
		
//		Start Button
		start=new JButton("START");
		start.setBounds(280,280,80,25);
		start.setBackground(new Color(0,0,0));
		start.setForeground(Color.GREEN);
		start.addActionListener(this);
		add(start);
		
//		Exit Button 
		exit=new JButton("EXIT");
		exit.setBounds(100,280,80,25);
		exit.setBackground(new Color(0,0,0));
		exit.setForeground(Color.RED);
		exit.addActionListener(this);
		add(exit);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		if user click start button
		if(e.getSource()==start) {
//			Carrying the text into Rules class and passing as an argument
			String name =nameBox.getText();
//			Closing the current frame and open the Rules Class Frame
			setVisible(false);
//			Rules Class constructor
			new Rules(name);
		}
//		if user click Exit button
		else if(e.getSource()==exit){
//			Closing the current frame
			setVisible(false);
		}
		
	}

	public static void main(String[] args) throws NullPointerException {
//		Calling the Login class constructor
		new Login();
	}
	
}
