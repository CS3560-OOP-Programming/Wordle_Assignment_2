package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow {
    //encapsulation
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JLabel[][] w;
    private JLabel w1, w2, w3, w4, w5, w6;
    private JButton enterButton;
    private int guessNum = 1;
    final String solution = "Party";


    public MainWindow(){
        frame = new JFrame();
        frame.setTitle("Wordle.exe");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);

        //initializing array
        //switched to array to allow for personalization of chars
        w = new JLabel[6][6];
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(9, 1, 0, 20));
        frame.add(panel, BorderLayout.CENTER);

        label = new JLabel("Wordle", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        panel.add(label);

        //Code below makes a text panel for each 6 guesses
        //Subject to optimization
        JPanel gTextPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        for(int i = 0; i < 5; i++){
            w[0][i] = new JLabel("_1__");
            gTextPanel1.add(w[0][i]);
        }
        panel.add(gTextPanel1);

        JPanel gTextPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        for(int i = 0; i < 5; i++){
            w[1][i] = new JLabel("_2__");
            gTextPanel2.add(w[1][i]);
        }
        panel.add(gTextPanel2);

        JPanel gTextPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        for(int i = 0; i < 5; i++){
            w[2][i] = new JLabel("_3__");
            gTextPanel3.add(w[2][i]);
        }
        panel.add(gTextPanel3);

        JPanel gTextPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        for(int i = 0; i < 5; i++){
            w[3][i] = new JLabel("_4__");
            gTextPanel4.add(w[3][i]);
        }
        panel.add(gTextPanel4);

        JPanel gTextPanel5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        for(int i = 0; i < 5; i++){
            w[4][i] = new JLabel("_5__");
            gTextPanel5.add(w[4][i]);
        }
        panel.add(gTextPanel5);

        JPanel gTextPanel6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel6.setLayout(new FlowLayout(FlowLayout.CENTER));
        for(int i = 0; i < 5; i++){
            w[5][i] = new JLabel("_6__");
            gTextPanel6.add(w[5][i]);
        }
        panel.add(gTextPanel6);

        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        //Initializing each individual guess character with max length 1, font type, and size(subject to OOP changes?)
        //Also calls keyInputValidation to prevent digits and non alphabet chars from being called
        JTextField gChar1 = new JTextField(1);
        gChar1.setFont(new Font("Arial", Font.BOLD, 22));
        gChar1.setHorizontalAlignment(JTextField.CENTER);
        gChar1.setPreferredSize(new Dimension(40,40));
        textPanel.add(gChar1);
        gChar1.addKeyListener(new keyInputValidation(gChar1));


        JTextField gChar2 = new JTextField(1);
        gChar2.setFont(new Font("Arial", Font.BOLD, 22));
        gChar2.setHorizontalAlignment(JTextField.CENTER);
        gChar2.setPreferredSize(new Dimension(40,40));
        textPanel.add(gChar2);
        gChar2.addKeyListener(new keyInputValidation(gChar2));

        JTextField gChar3 = new JTextField(1);
        gChar3.setFont(new Font("Arial", Font.BOLD, 22));
        gChar3.setHorizontalAlignment(JTextField.CENTER);
        gChar3.setPreferredSize(new Dimension(40,40));
        textPanel.add(gChar3);
        gChar3.addKeyListener(new keyInputValidation(gChar3));

        JTextField gChar4 = new JTextField(1);
        gChar4.setFont(new Font("Arial", Font.BOLD, 22));
        gChar4.setHorizontalAlignment(JTextField.CENTER);
        gChar4.setPreferredSize(new Dimension(40,40));
        textPanel.add(gChar4);
        gChar4.addKeyListener(new keyInputValidation(gChar4));

        JTextField gChar5 = new JTextField(1);
        gChar5.setFont(new Font("Arial", Font.BOLD, 22));
        gChar5.setHorizontalAlignment(JTextField.CENTER);
        gChar5.setPreferredSize(new Dimension(40,40));
        textPanel.add(gChar5);
        gChar5.addKeyListener(new keyInputValidation(gChar5));

        JButton enterButton = new JButton("Submit guess");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < solution.length(); i++){
                    //no need to repeat 5 times, make optimal later
                    //each initializes the string verision of the solution char
                    //compares it to the input char
                    String gC1 = String.valueOf(solution.charAt(i));
                    if(gC1.equalsIgnoreCase(gChar1.getText())){
                        System.out.println("Match");
                        //gChar1.setFont(new Font("Arial", Font.BOLD, 43));
                    }
                    String gC2 = String.valueOf(solution.charAt(i));
                    if(gC2.equalsIgnoreCase(gChar2.getText())){
                        gChar2.setForeground(Color.GREEN);
                        System.out.println("Match");
                    }
                    String gC3 = String.valueOf(solution.charAt(i));
                    if(gC3.equalsIgnoreCase(gChar3.getText())){
                        System.out.println("Match");
                    }
                    String gC4 = String.valueOf(solution.charAt(i));
                    if(gC4.equalsIgnoreCase(gChar4.getText())){
                        System.out.println("Match");
                    }
                    String gC5 = String.valueOf(solution.charAt(i));
                    if(gC5.equalsIgnoreCase(gChar5.getText())){
                        System.out.println("Match");
                    }
                    //System.out.println(Character.toUpperCase(solution.charAt(i)));
                    //System.out.println(Character.toUpperCase(gChar1.getText()));
                    //System.out.println(gC1);
                }
                String gWord = gChar1.getText() + gChar2.getText() + gChar3.getText() + gChar4.getText() + gChar5.getText();
                System.out.println(gWord);
                //Want to make it so that after it checks if the word is an actual dictionary word it  continues and updates the guess num
                //Switch statement below takes the guess num and outputs it with the guess string(with designated colors)
                switch(guessNum){
                    case 1:
                        w[0][3].setForeground(Color.GREEN);
                        //w1.setForeground(Color.GREEN);
                        break;
                    case 2:
                        w2.setText(gWord);
                        break;
                    case 3:
                        w3.setText(gWord);
                        break;
                    case 4:
                        w4.setText(gWord);
                        break;
                    case 5:
                        w5.setText(gWord);
                        break;
                    case 6:
                        w6.setText(gWord);
                        break;
                    default:
                        System.out.println("You've exceeded your guesses");
                        System.exit(0);
                }

                System.out.println("guess " + guessNum);
                guessNum++;
            }
        });

        panel.add(textPanel);
        panel.add(enterButton);
    }

    public void show(){
        frame.setVisible(true);
    }
    //checks if character entered is a letter with regex
    private static boolean validInput(String input){
        return input.matches("[A-Za-z]");
    }
}