package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow main = new MainWindow();
                main.show();
            }
        });
        //Temporary early exit
        //System.exit(0);
        Scanner scnr = new Scanner(System.in);
        String solution = "Party";
        //String guess;
        System.out.println("Hello and welcome to our wordle game!");
        //guess = inputValidation(scnr);
        //System.out.println("Your guess was: " + guess);
        System.out.println("The correct word was: " + solution);
    }

    public static String inputValidation(Scanner scnr){
        String userInput;
        boolean notChar;
        do{
            notChar = false;
            System.out.println("Enter your guess");
            userInput = scnr.next();
            //Checks if input is 5 chars
            if(userInput.length() != 5){
                System.out.println("Invalid Input! Enter a 5 digit word");
            }

            //Breaks 5 letter string down into characters and checks if they are from a-z
            for(int i = 0; i < userInput.length(); i++){
                //System.out.println(userInput.charAt(i));
                if(!(Character.isLetter(userInput.charAt(i)))){
                    notChar = true;
                }
            }
            if(notChar){
                System.out.println("Invalid input! Values must be from a-z");
            }
        }
        while(userInput.length()!= 5  || (notChar));

        return userInput;
    }
}
