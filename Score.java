package quizpack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Score extends JFrame implements ActionListener{

//	Declaring as global variables
	JButton play,login,exit;
	int score,correct,wrong;
	String name;
	Score(int score,String name,int correct,int wrong) {
		this.score=score;
		this.name=name;
		this.correct=correct;
		this.wrong=wrong;
//		Set the frame
		getContentPane().setBackground(Color.WHITE);
		
		setSize(1000,550);
		setLocation(350,150);
		setVisible(true);
		setLayout(null);
		
//		Heading with user name
		JLabel heading = new JLabel(name+" Thank You For Played");
		heading.setBounds(100,60,900,50);
		heading.setFont(new Font("Lucida Calligraphy",Font.BOLD,35));
		heading.setForeground(new Color(20,184,154));
		add(heading);
		
//		Display the score
		JLabel score_label = new JLabel("Your Score is : "+score + " out of 100.");
		score_label.setBounds(250,180,500,30);
		score_label.setFont(new Font("Tahoma",Font.BOLD,25));
		score_label.setForeground(Color.GREEN);
		add(score_label);
		
//		Display the correct answers
		JLabel correct_answers = new JLabel("No. of Correct Answers : "+correct+".");
		correct_answers.setBounds(250,250,500,30);
		correct_answers.setFont(new Font("Tahoma",Font.BOLD,16));
		correct_answers.setForeground(Color.MAGENTA);
		add(correct_answers);
		
//		Display the wrong answers
		JLabel wrong_answers = new JLabel("No. of Wrong Answers : "+wrong+".");
		wrong_answers.setBounds(250,300,500,30);
		wrong_answers.setFont(new Font("Tahoma",Font.BOLD,16));
		wrong_answers.setForeground(Color.RED);
		add(wrong_answers);
		
//		Play again button
		play = new JButton("Play Again");
		play.setBounds(120,400,100,25);
		play.setBackground(new Color(0,0,0));
		play.setForeground(Color.GREEN);
		play.addActionListener(this);
		add(play);
		
//		Go to login page button
		login = new JButton("Login Again");
		login.setBounds(300,400,100,25);
		login.setBackground(new Color(0,0,0));
		login.setForeground(Color.YELLOW);
		login.addActionListener(this);
		add(login);
		
//		Exit button
		exit = new JButton("EXIT");
		exit.setBounds(480,400,100,25);
		exit.setBackground(new Color(0,0,0));
		exit.setForeground(Color.RED);
		exit.addActionListener(this);
		add(exit);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		if user clicks play again button 
		if(e.getSource()==play) {
//			closing the current frame
			setVisible(false);
//			calling the Quiz class
			new Quiz("User",0,0,0,0);
			
		}
//		if user clicks login again button
		else if(e.getSource()==login){
//			closing the current frame
			setVisible(false);
//			Calling the Login class
			new Login();
			
		}
//		if user clicks exit button
		else if(e.getSource()==exit){
//			Closing the current frame
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
//		Calling the Score class constructor with parameter
		new Score(0,"User",0,0);
		
	}
	

}
