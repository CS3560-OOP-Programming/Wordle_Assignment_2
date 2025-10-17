package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class KeyboardPanel extends JPanel{
    private static final char[][] keys = {
            {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'},
            {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'},
            {'Z', 'X', 'C', 'V', 'B', 'N', 'M'}
    };
    //Create hashmap to hold pairs of char letters and their corresponding
    //KeyLetter objects that will hold letter state
    private final HashMap<java.lang.Character, KeyLetter> keyboardHashMap = new HashMap<>();

    public KeyboardPanel(MainWindow mainWindow){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        for(char[] row : keys){
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
            for(char singleKey : row){
                KeyLetter keyButton = new KeyLetter(singleKey);
                keyboardHashMap.put(singleKey, keyButton);

                keyButton.addActionListener(e -> {
                    mainWindow.inputKeyboardLetter(singleKey);
                });

                rowPanel.add(keyButton);
            }
            add(rowPanel);
        }
    }

    public void updateKeyState(char letter, LetterState updatedState){
        KeyLetter key = keyboardHashMap.get(Character.toUpperCase(letter));
        //make sure key actually exists on keyboard
        if(key!=null){
            key.setState(updatedState);
            key.changeColor();
        }
    }
}
