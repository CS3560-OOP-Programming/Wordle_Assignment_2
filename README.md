# Wordle_Assignment_2

## Team Members
- Alex Auyon  
- Garrison Gibson  

## How to Run
1. Clone repository: `git clone [URL]`  
2. Open in IntelliJ/Eclipse or any other IDE  
3. Run `Main.java`  

## Features Implemented
- **Guess Input**: Using the submit button, the program accepts guesses from the user  
- **Feedback System**: Letters on both the keyboard and the main panel holding the rows of guesses are updated to green, yellow, or dark grey
  - Green: Letter is in the solution and in the correct spot
  - Yellow: Letter is in the solution and in the wrong spot
  - Dark Grey: Letter is not in the solution and has been used by the player
- **Dictionary Validation**: Only valid 5 letter english words are accepted
- **Win/Lose Feature**: The player loses once they use up their 6 guesses without submitting the solution
- **Visual Keyboard**: Keyboard interface on the wordle window reflects each letters' state

## Controls
- Enter each letter slot by slot using the implemented *keyboard interface* or your own *keyboard*
- Delete a letter using *backspace*
- Press the *"submit guess" button* to enter a guess

## Known Issues  
As of now, there are no known issues, however below are some of the issues we have since fixed.  
- **Issue 1**: Keyboard keys on the interface were being updated (to green, yellow, dark grey) when invalid words were being submitted.
  Due to the structure of the code, the *key state* and therefore color was being updated before we checked if the guess was a valid  
  english word. Re-organizing the code to make sure the dictionary contained the guess before any key and letter states were updated fixed this issue. 

- **Issue 2**: Letter state/color was being overwritten on the visual keyboard in the cases where the solution and guess had two instances of one letter. For example, if the solution was "bongo"  
  and the user guessed the word "booms," the color for the "o" keyboard key would be overwritten and displayed as yellow instead of green because the second instance of the "o" in the guess word
  was in the wrong spot. However, in the original Wordle, once a letter is set to green, the color should stay as green regardless of the results from other instances of the letter. Including checks so
  that the function for updating a key's state would mirror this logic fixed the issue. 

## External Libraries
- None were used

## Credits
- Txt file of valid 5 letter words sourced from https://github.com/darkermango/5-Letter-words.git
