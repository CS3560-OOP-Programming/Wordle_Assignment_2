package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow {
    //encapsulation
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JLabel w1;
    private JLabel w2;
    private JLabel w3;
    private JLabel w4;
    private JLabel w5;
    private JLabel w6;


    public MainWindow(){
        frame = new JFrame();
        frame.setTitle("Wordle.exe");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(9, 1, 0, 20));
        frame.add(panel, BorderLayout.CENTER);

        label = new JLabel("Wordle", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 32));
        panel.add(label);
        w1 = new JLabel("___ ___ ___ ___ ___", SwingConstants.CENTER);
        panel.add(w1);

        w2 = new JLabel("___ ___ ___ ___ ___", SwingConstants.CENTER);
        panel.add(w2);

        w3 = new JLabel("___ ___ ___ ___ ___", SwingConstants.CENTER);
        panel.add(w3);

        w4 = new JLabel("___ ___ ___ ___ ___", SwingConstants.CENTER);
        panel.add(w4);

        w5 = new JLabel("___ ___ ___ ___ ___", SwingConstants.CENTER);
        panel.add(w5);

        w6 = new JLabel("___ ___ ___ ___ ___", SwingConstants.CENTER);
        panel.add(w6);

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
        //old redundant code below
        //JTextField gChar2 = new JTextField(1);
        //JTextField gChar3 = new JTextField(1);
        //JTextField gChar4 = new JTextField(1);
        //JTextField gChar5 = new JTextField(1);
        //guess.setFont(new Font("Arial", Font.PLAIN, 24));
        //textPanel.setPreferredSize(new Dimension(200, 40));
        /**
         gChar1.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        char x = e.getKeyChar();
        if((!validInput(String.valueOf(x))) || (!gChar1.getText().isEmpty() && e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_DELETE)){
        e.consume();
        }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
        });
         **/
        textPanel.add(gChar2);
        textPanel.add(gChar3);
        textPanel.add(gChar4);
        textPanel.add(gChar5);
        panel.add(textPanel);
    }

    public void show(){
        frame.setVisible(true);
    }
    //checks if character entered is a letter with regex
    private static boolean validInput(String input){
        return input.matches("[A-Za-z]");
    }
}