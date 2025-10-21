package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class MainWindow {
    //encapsulation
    private JFrame frame;
    private JPanel panel;
    private KeyboardPanel keyboard;
    private JLabel label;
    private JLabel[][] w;
    private int guessNum = 1;
    private Dictionary dictionary;
    private final String solution;
    private JTextField gChar1, gChar2, gChar3, gChar4, gChar5;


    public MainWindow() {
        dictionary = new Dictionary("wordleAssignment/ValidWords.txt");

        //Setting solution to a random word in the validWords file
        String[] validWords = dictionary.getValidWords().toArray(new String[dictionary.size()]);
        Random rndm = new Random();
        int rndmIndex = rndm.nextInt(dictionary.size());
        solution = validWords[rndmIndex];
        //solution = "bears";
        System.out.println("The solution is set to: " + solution);

        frame = new JFrame();
        frame.setTitle("Wordle.exe");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);

        //initializing array
        //switched to array to allow for personalization of chars
        w = new JLabel[6][6];

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); //bottom was 10
        panel.setLayout(new GridLayout(9, 1, 0, 10)); //vgap was 20
        //frame.add(panel, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);

        label = new JLabel("Wordle", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        panel.add(label);

        //Code below makes a text panel for each 6 guesses
        //Subject to optimization
        JPanel gTextPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        for (int i = 0; i < 5; i++) {
            w[0][i] = new JLabel("___");
            gTextPanel1.add(w[0][i]);
        }
        panel.add(gTextPanel1);

        JPanel gTextPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        for (int i = 0; i < 5; i++) {
            w[1][i] = new JLabel("___");
            gTextPanel2.add(w[1][i]);
        }
        panel.add(gTextPanel2);

        JPanel gTextPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        for (int i = 0; i < 5; i++) {
            w[2][i] = new JLabel("___");
            gTextPanel3.add(w[2][i]);
        }
        panel.add(gTextPanel3);

        JPanel gTextPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        for (int i = 0; i < 5; i++) {
            w[3][i] = new JLabel("___");
            gTextPanel4.add(w[3][i]);
        }
        panel.add(gTextPanel4);

        JPanel gTextPanel5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        for (int i = 0; i < 5; i++) {
            w[4][i] = new JLabel("___");
            gTextPanel5.add(w[4][i]);
        }
        panel.add(gTextPanel5);

        JPanel gTextPanel6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        gTextPanel6.setLayout(new FlowLayout(FlowLayout.CENTER));
        for (int i = 0; i < 5; i++) {
            w[5][i] = new JLabel("___");
            gTextPanel6.add(w[5][i]);
        }
        panel.add(gTextPanel6);

        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        keyboard = new KeyboardPanel(this);
        JPanel keyboardWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        keyboardWrapper.setBackground(Color.WHITE);
        keyboardWrapper.add(keyboard);

        frame.add(keyboardWrapper, BorderLayout.SOUTH);

        gChar1 = new JTextField(1);
        gChar1.setFont(new Font("Arial", Font.BOLD, 22));
        gChar1.setHorizontalAlignment(JTextField.CENTER);
        gChar1.setPreferredSize(new Dimension(40, 40));
        textPanel.add(gChar1);
        gChar1.addKeyListener(new keyInputValidation(gChar1));


        gChar2 = new JTextField(1);
        gChar2.setFont(new Font("Arial", Font.BOLD, 22));
        gChar2.setHorizontalAlignment(JTextField.CENTER);
        gChar2.setPreferredSize(new Dimension(40, 40));
        textPanel.add(gChar2);
        gChar2.addKeyListener(new keyInputValidation(gChar2));

        gChar3 = new JTextField(1);
        gChar3.setFont(new Font("Arial", Font.BOLD, 22));
        gChar3.setHorizontalAlignment(JTextField.CENTER);
        gChar3.setPreferredSize(new Dimension(40, 40));
        textPanel.add(gChar3);
        gChar3.addKeyListener(new keyInputValidation(gChar3));

        gChar4 = new JTextField(1);
        gChar4.setFont(new Font("Arial", Font.BOLD, 22));
        gChar4.setHorizontalAlignment(JTextField.CENTER);
        gChar4.setPreferredSize(new Dimension(40, 40));
        textPanel.add(gChar4);
        gChar4.addKeyListener(new keyInputValidation(gChar4));

        gChar5 = new JTextField(1);
        gChar5.setFont(new Font("Arial", Font.BOLD, 22));
        gChar5.setHorizontalAlignment(JTextField.CENTER);
        gChar5.setPreferredSize(new Dimension(40, 40));
        textPanel.add(gChar5);
        gChar5.addKeyListener(new keyInputValidation(gChar5));

        JButton enterButton = new JButton("Submit guess");
        enterButton.addActionListener(new ActionListener() {
            //int accumulator = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                //array for letters used to solve duplicate bug
                int lUsed[] = new int[solution.length()];

                //solution = solution.toUpperCase();
                int[] colorLayout = new int[5];
                String[] guess = {gChar1.getText(), gChar2.getText(), gChar3.getText(), gChar4.getText(), gChar5.getText()};
                String gWord = gChar1.getText() + gChar2.getText() + gChar3.getText() + gChar4.getText() + gChar5.getText();

                //Make sure word is in lower case and has no trailing spaces so we can check if the dictionary contains it
                String modifiedGWord = gWord.trim().toLowerCase();

                if (!dictionary.isInDictionary(modifiedGWord)) {
                    JOptionPane.showMessageDialog(frame, "That is not a valid word entry.");
                    return;
                }

                //Green coloring logic here
                for (int i = 0; i < solution.length(); i++) {
                    //each initializes the string version of the solution char
                    //compares it to the input char
                    //initializes guess character
                    char guessC = Character.toUpperCase(guess[i].charAt(0));
                    //initializes solution char
                    char soluC = Character.toUpperCase(solution.charAt(i));
                    //if they equal each other print set color to green
                    if (guessC == soluC) {
                        //System.out.println("Match");
                        colorLayout[i] = 1;
                        lUsed[i] = 1;
                        keyboard.updateKeyState(guessC, LetterState.CORRECT);
                    }
                }
                //yellow coloring
                for (int i = 0; i < solution.length(); i++) {
                    if (colorLayout[i] == 1) {
                        continue;
                    }
                    char guessC = Character.toUpperCase(guess[i].charAt(0));
                    for (int j = 0; j < solution.length(); j++) {
                        char soluC = Character.toUpperCase(solution.charAt(j));
                        if ((lUsed[j] != 1) && (guessC == soluC)) {
                            colorLayout[i] = 2;
                            lUsed[j] = 1;
                            if (colorLayout[i] == 2) {
                                keyboard.updateKeyState(guessC, LetterState.IN_WORD);
                            } else if (colorLayout[i] == 0) {
                                keyboard.updateKeyState(guessC, LetterState.NOT_IN_WORD);
                            }

                        }
                    }
                }

                //grey coloring
                for(int i = 0; i < solution.length(); i++){
                    char guessC = Character.toUpperCase(guess[i].charAt(0));
                    if (colorLayout[i] == 0){
                        keyboard.updateKeyState(guessC, LetterState.NOT_IN_WORD);
                    }
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println(colorLayout[i]);
                }

                //Prints solution to console!
                System.out.println(modifiedGWord);

                //Want to make it so that after it checks if the word is an actual dictionary word it  continues and updates the guess num
                //Switch statement below takes the guess num and outputs it with the guess string(with designated colors)
                //could be made into a for or something to make code more compact
                switch (guessNum) {
                    case 1:

                        //Code below sets the characters to the users guess(green implementation)
                        for (int i = 0; i < 5; i++) {
                            if (colorLayout[i] == 1) {
                                w[guessNum - 1][i].setForeground(Color.GREEN);
                            } else if (colorLayout[i] == 2) {
                                w[guessNum - 1][i].setForeground(new Color(225, 225, 0));
                            }
                        }
                        //redundant code, can be optimized
                        w[guessNum - 1][0].setText(gChar1.getText());
                        w[guessNum - 1][0].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][1].setText(gChar2.getText());
                        w[guessNum - 1][1].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][2].setText(gChar3.getText());
                        w[guessNum - 1][2].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][3].setText(gChar4.getText());
                        w[guessNum - 1][3].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][4].setText(gChar5.getText());
                        w[guessNum - 1][4].setFont(new Font("Arial", Font.BOLD, 32));

                        break;
                    case 2:
                        for (int i = 0; i < 5; i++) {
                            if (colorLayout[i] == 1) {
                                w[guessNum - 1][i].setForeground(Color.GREEN);
                            } else if (colorLayout[i] == 2) {
                                w[guessNum - 1][i].setForeground(new Color(225, 225, 0));
                            }
                        }
                        w[guessNum - 1][0].setText(gChar1.getText());
                        w[guessNum - 1][0].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][1].setText(gChar2.getText());
                        w[guessNum - 1][1].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][2].setText(gChar3.getText());
                        w[guessNum - 1][2].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][3].setText(gChar4.getText());
                        w[guessNum - 1][3].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][4].setText(gChar5.getText());
                        w[guessNum - 1][4].setFont(new Font("Arial", Font.BOLD, 32));
                        break;
                    case 3:
                        for (int i = 0; i < 5; i++) {
                            if (colorLayout[i] == 1) {
                                w[guessNum - 1][i].setForeground(Color.GREEN);
                            } else if (colorLayout[i] == 2) {
                                w[guessNum - 1][i].setForeground(new Color(225, 225, 0));
                            }
                        }
                        w[guessNum - 1][0].setText(gChar1.getText());
                        w[guessNum - 1][0].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][1].setText(gChar2.getText());
                        w[guessNum - 1][1].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][2].setText(gChar3.getText());
                        w[guessNum - 1][2].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][3].setText(gChar4.getText());
                        w[guessNum - 1][3].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][4].setText(gChar5.getText());
                        w[guessNum - 1][4].setFont(new Font("Arial", Font.BOLD, 32));
                        break;
                    case 4:
                        for (int i = 0; i < 5; i++) {
                            if (colorLayout[i] == 1) {
                                w[guessNum - 1][i].setForeground(Color.GREEN);
                            } else if (colorLayout[i] == 2) {
                                w[guessNum - 1][i].setForeground(new Color(225, 225, 0));
                            }
                        }
                        w[guessNum - 1][0].setText(gChar1.getText());
                        w[guessNum - 1][0].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][1].setText(gChar2.getText());
                        w[guessNum - 1][1].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][2].setText(gChar3.getText());
                        w[guessNum - 1][2].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][3].setText(gChar4.getText());
                        w[guessNum - 1][3].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][4].setText(gChar5.getText());
                        w[guessNum - 1][4].setFont(new Font("Arial", Font.BOLD, 32));
                        break;
                    case 5:
                        for (int i = 0; i < 5; i++) {
                            if (colorLayout[i] == 1) {
                                w[guessNum - 1][i].setForeground(Color.GREEN);
                            } else if (colorLayout[i] == 2) {
                                w[guessNum - 1][i].setForeground(new Color(225, 225, 0));
                            }
                        }
                        w[guessNum - 1][0].setText(gChar1.getText());
                        w[guessNum - 1][0].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][1].setText(gChar2.getText());
                        w[guessNum - 1][1].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][2].setText(gChar3.getText());
                        w[guessNum - 1][2].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][3].setText(gChar4.getText());
                        w[guessNum - 1][3].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][4].setText(gChar5.getText());
                        w[guessNum - 1][4].setFont(new Font("Arial", Font.BOLD, 32));
                        break;
                    case 6:
                        for (int i = 0; i < 5; i++) {
                            if (colorLayout[i] == 1) {
                                w[guessNum - 1][i].setForeground(Color.GREEN);
                            } else if (colorLayout[i] == 2) {
                                w[guessNum - 1][i].setForeground(new Color(225, 225, 0));
                            }
                        }
                        w[guessNum - 1][0].setText(gChar1.getText());
                        w[guessNum - 1][0].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][1].setText(gChar2.getText());
                        w[guessNum - 1][1].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][2].setText(gChar3.getText());
                        w[guessNum - 1][2].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][3].setText(gChar4.getText());
                        w[guessNum - 1][3].setFont(new Font("Arial", Font.BOLD, 32));
                        w[guessNum - 1][4].setText(gChar5.getText());
                        w[guessNum - 1][4].setFont(new Font("Arial", Font.BOLD, 32));
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "You ran out of guesses!", "You lost...", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                        System.exit(0);
                }

                System.out.println("guess " + guessNum);
                guessNum++;
            }
        });

        panel.add(textPanel);
        panel.add(enterButton);
    }

    public void inputKeyboardLetter(char letter) {
        JTextField[] fields = {gChar1, gChar2, gChar3, gChar4, gChar5};
        for (JTextField field : fields) {
            if (field.getText().isEmpty()) {
                field.setText(String.valueOf(letter).toLowerCase());
                break;
            }
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    //checks if character entered is a letter with regex
    private static boolean validInput(String input) {
        return input.matches("[A-Za-z]");
    }
}