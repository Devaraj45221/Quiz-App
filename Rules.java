package quizpack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Rules extends JFrame implements ActionListener{
	
//		Declaring as global variables
		JButton back,start;
		String name;
		
//		Constructor
	Rules(String name) {
		this.name=name;
		
//		Frame Background
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
//		Frame setting
		setSize(800,650);
		setLocation(350,100);
		setVisible(true);
		
//		Heading along with User name
		JLabel headings=new JLabel("Hello "+name+"  Welcome to QuizApp");
		headings.setBounds(140,60,600,50);
		headings.setFont(new Font("Gabriola",Font.BOLD,30));
		headings.setForeground(new Color(200,144,54));
		add(headings);
		
//		Describing the Rules for Quiz App
		JLabel rule=new JLabel();
		rule.setBounds(100,120,600,400);
		rule.setFont(new Font("Tahoma",Font.PLAIN,15));
		rule.setForeground(new Color(130,144,254));
		rule.setText(
				 "<html>"+ 
			                "1. Here you have mulitle choice option. You will choose only one option." + "<br><br>" +
			                "2. Don't see the other's computer and only one person will attend for this Quiz." + "<br><br>" +
			                "3. Every correct answer will carry 10 marks(Score)." + "<br><br>" +
			                "4. Wrong answers will not effect your score." + "<br><br>" +
			                "5. Do not get nervous if you don't know the answer." + "<br><br>" +
			                "6. Do not disturb other person. Please complete the Quiz quitly." + "<br><br>" +
			                "7. Try to attempt all answers in given time." + "<br><br>" +
			                "8. Click on Start to Play the Quiz and Good Luck." + "<br><br>" +
			            "<html>"
				
				
				);
		add(rule);
		
//		Back button
		back=new JButton("Back");
		back.setBounds(300,520,80,25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.RED);
		back.addActionListener(this);
		add(back);
		
//		Start Button
		start=new JButton("Start");
		start.setBounds(400,520,80,25);
		start.setBackground(Color.BLACK);
		start.setForeground(Color.GREEN);
		start.addActionListener(this);
		add(start);
		
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start) {
//			Calling the Quiz class constructor
			new Quiz(name,0,0,0,0);
//			Closing the current frame
			setVisible(false);
		}
		else if(e.getSource()==back) {
//			Closing the current frame
			setVisible(false);
//			Calling the Login class constructor
			new Login();
		}
		
	}

	public static void main(String[] args) {
//		Calling the Rules class constructor
		new Rules("User");
	}

}
