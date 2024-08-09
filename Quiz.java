package quizpack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
//	Declaring the global variables
//	For Questions
    String questions[][] = new String[10][5];
//    For Answers
    String answers[][] = new String[10][2];
//    For User answers
    String useranswers[][] = new String[10][1];
    int correct=0,wrong=0;
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
 
    
    String name;
    int count,score;
//    Constructor
    Quiz(String name,int count,int score,int correct,int wrong) {
        this.name = name;
        this.count=count;
        this.score=score;
        this.correct=correct;
		this.wrong=wrong;
//       Frame size
        setSize(1000,600);
//		appear location on desktop x and y axis direction
		setLocation(300,150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        
//        Question no. label
        qno = new JLabel();
        qno.setBounds(100, 100, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(qno);
        
//        Question 
        question = new JLabel();
        question.setBounds(150, 100, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(question);
        
//        All Question and answers are storing in an array
        questions[0][0] = "Number of primitive data types in Java are ?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";

        questions[1][0] = "Automatic type conversion is possible in which of the possible case ?";
        questions[1][1] = "Byte to int";
        questions[1][2] = "Int to long";
        questions[1][3] = "Long to int";
        questions[1][4] = "Short to int";

        questions[2][0] = "Select the valid statement?";
        questions[2][1] = "char[] ch = new char(5)";
        questions[2][2] = "char[] ch = new char[5]";
        questions[2][3] = "char[] ch = new char()";
        questions[2][4] = "char[] ch = new char[]";

        questions[3][0] = "When an array is passed to a method, what does the method receive?";
        questions[3][1] = "A copy of the array";
        questions[3][2] = "The reference of the array";
        questions[3][3] = "Length of the array";
        questions[3][4] = "Copy of first element";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Select the valid statement to declare and initialize an array ?";
        questions[5][1] = "int[] A = {}";
        questions[5][2] = "int[] A = {1,2,3}";
        questions[5][3] = "int[] A = (1,2,3)";
        questions[5][4] = "int[][] A = {1,2,3}";

        questions[6][0] = "Arrays in Java are ?";
        questions[6][1] = "Object reference";
        questions[6][2] = "Objects";
        questions[6][3] = "Primitive data type";
        questions[6][4] = "None";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "When is the object created with New keyword?";
        questions[9][1] = "At run time";
        questions[9][2] = "At compile time";
        questions[9][3] = "Depends on the code";
        questions[9][4] = "None";
        
        answers[0][1] = "8";
        answers[1][1] = "Int to long";
        answers[2][1] = "char[] ch = new char[5]";
        answers[3][1] = "The reference of the array";
        answers[4][1] = "Heap memory";
        answers[5][1] = "int[] A = {1,2,3}";
        answers[6][1] = "Objects";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "At run time";
        
//        Radio buttons for choosing an option
        opt1 = new JRadioButton();
        opt1.setBounds(170, 180, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 220, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 260, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 300, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
//        Grouping the radio buttons for Choosing only one option
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
//        Next button
        next = new JButton("Next");
        next.setBounds(150, 440, 120, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(0,0,0));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
//        Life line button for skip any 2 wrong answers
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(320, 440, 150, 30);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lifeline.setBackground(new Color(0,0,0));
        lifeline.setForeground(Color.YELLOW);
        lifeline.addActionListener(this);
        add(lifeline);
        
//        Submit button
        submit = new JButton("Submit");
        submit.setBounds(520, 440, 120, 30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(0,0,0));
        submit.setForeground(Color.GREEN);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
//        Calling the start method with parameter
        start(count); //count=0
        
    }
//    implementing abstract method
    public void actionPerformed(ActionEvent ae) {
    	
//        If user clicks next button
    	if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
//            if user won't choose any option
            	if (groupoptions.getSelection() == null) {
            		useranswers[count][0] = "";
            	} 
//            	if user choose an option
            	else {
            		useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            	}
            
            	if (count == 8) {
            		next.setEnabled(false);
            		submit.setEnabled(true);
            	}
//            increasing the count to iterate the loop
            count++;
//            Calling the start method with parameter
            start(count); //count=0
            
        } 
//        If user clicks life line
        else if (ae.getSource() == lifeline) {
//        	the question no. is equals to following  question
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } 
            else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
//            If life line is clicked once 
            lifeline.setEnabled(false);
            
        } 
//    	if user clicks submit button
        else if (ae.getSource() == submit) {
        	
            ans_given = 1;
//            if user won't choose any option
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } 
            else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

//            calculating the score based on answer
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                    correct++;
                } else {
                    score += 0;
                    wrong++;
                }
            }
//            Closing the current frame
            setVisible(false);
//            Calling the Score Class constructor
            new Score(score, name,correct,wrong);
        }
    }

//    implementing the abstract method
    public void paint(Graphics g) {
        super.paint(g);
//        Display the time
        String time = "Time :- " + timer + " seconds left"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 20));
        
//        Checking the time
        if (timer > 0) { 
            g.drawString(time, 700, 200);
        } 
        else {
            g.drawString("Times up!!", 700, 200);
        }
        
//        Decreasing the time By using thread.sleep method
        timer--; // 14
        
        try {
            Thread.sleep(1000);
//            repaint the time in current frame
            repaint();
        } 
        catch (Exception e) {
//        	Printing the exception
            e.printStackTrace();
        }
//        if answer is chosen the timer will be 15 again 
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } 
        else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
//            	Disable the next button
                next.setEnabled(false);
//            	Enable the submit button
                submit.setEnabled(true);
            }
            
//            if user clicks submit button
            if (count == 9) { 
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
//                Checking correct answers and changing the score 
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                        correct++;
                    } else {
                        score += 0;
                        wrong++;
                    }
                }
//                Closing current frame
                setVisible(false);
//                Calling the Score class constructor 
                new Score(score, name,correct,wrong);
            } 
//           if user clicks next button 
            else {  
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 to 1
//                calling the start method with parameter
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
//    	Set the qno. and questions with options
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
// if the option is chosen then next question option will not select by default by following previous option 
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
//    	Calling the constructor
        new Quiz("User",0,0,0,0);
    }
}