package org.example;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class keyInputValidation implements KeyListener {
    private JTextField gChar;
    public keyInputValidation(JTextField gChar){
        this.gChar = gChar;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        char x = e.getKeyChar();
        if((!validInput(String.valueOf(x))) || (!gChar.getText().isEmpty() && e.getKeyChar() != KeyEvent.VK_BACK_SPACE && e.getKeyChar() != KeyEvent.VK_DELETE)){
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private static boolean validInput(String input){
        return input.matches("[A-Za-z]");
    }
}



