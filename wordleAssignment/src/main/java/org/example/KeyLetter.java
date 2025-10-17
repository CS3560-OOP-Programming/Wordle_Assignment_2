package org.example;

import javax.swing.*;
import java.awt.*;

public class KeyLetter extends JButton{
    private char letter;
    private boolean used;
    private LetterState state;

    public KeyLetter(char letter){
        //we inherit from the JButton class
        //this constructor passes the letter value to the button
        //so the key object will be created with the appropriate letter text
        super(String.valueOf(letter));
        this.letter = letter;
        used = false;
        state = LetterState.UNUSED;
    }

    public void changeColor(){
        switch(state){
            case CORRECT:
                setBackground(Color.GREEN);
                break;
            case IN_WORD:
                setBackground(Color.YELLOW);
                break;
            case NOT_IN_WORD:
                setBackground(Color.DARK_GRAY);
                break;
            default:
                setBackground(Color.GRAY);
                break;
        }
    }

    public char getLetter(){
        return letter;
    }

    public LetterState getState(){
        return state;
    }

    public void setState(LetterState state){
        this.state = state;
        changeColor();
    }
}
