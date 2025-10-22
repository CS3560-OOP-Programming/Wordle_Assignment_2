# Project Report
## Design Decisions

### Architecture
Explain your MVC structure:
- How did you separate model, view, and controller?
  - Model
    - Input validation
    - Word found in dictionary
    - Coloring logic
  - View
    - Main panel output
    - Guess outputs
    - Guess input
    - Win message
    - Lose message
  - Controller
    - Handles button presses
    - Handles submit button press
    
- What interfaces/abstractions did you create?
  - Key listener is an interface that keyInputValidation implements
   
- Why did you choose Swing vs JavaFX?
  - We ended up choosing Swing due to its accessibility in IntelliJ and Java
   
### Data Structures
- How do you represent game state? (arrays, maps, objects?)
  - Arrays:  
    - Hold the text characters for each of the 6 guesses(guess)
    - Hold each of the guess characters(w)
    - Hold color layout values(colorLayout)
    - Hold duplicate handling array(lUsed)
    - Hold valid words(validWords)
  - Hash Sets: 
    - We used a hash set to hold and draw values from the valid word text document
        
- Why did you choose these structures?
  - Static arrays provide simplicity and an easy way to reserve space on the stack
  - Hash sets provide speed, especially with large files   
          
### Algorithms
- Key algorithms implemented (e.g., collision detection, word validation)
  - Word validation
  - Green coloring
  - Yellow coloring
  - Guess list
- Complexity analysis:  
   - Overall, our program has an average time complexity of O(1) during the runtime of the game. Filling the hash map that holds the valid words and converting that hash map into an array of Strings takes O(n) time but these processes occur once and only during set up. When evaluating each guess and checking each character, these processes occur a fixed number of times leading to constant time. The method *isInDictionary(String s)* also utilizes the *contains* method available for hash maps which allows us to directly check if an element is contained for O(1) time.   

## Challenges Faced
1. **Challenge 1:** Limited prior Java Swing experience
   - **Solution:** How you overcame it
     - Using Java Swing overall was a challenge for us, as we both had minimal experience working with it in the past. We overcame these challenges by reading Java Swing documentation and utilizing video Java Swing tutorials. Overcoming this challenge also involved researching Java Swing features and making ourselves aware of the functions available to us.

2. **Challenge 2:** Ensuring the color of letters, especially yellow, were being set correctly. 
   - **Solution:** How you overcame it
     - The issue of word coloring was a recurring one. The green coloring had minimal issues and was implemented quickly and easily. Implementing the base yellow coloring code didn’t prove too challenging, with a large part concerning the relationship between the yellow and green letters. However, the yellow coloring had additional problems, especially with duplicate letters. For example, if the solution word was “BEARS”, the program would handle the guess “GREEN” with both E’s flagged as yellow. This problem was solved with an extra loop, a boolean value, and a used letter array.

## What We Learned
- OOP concepts reinforced
  - Encapsulation was a big part of the project, especially how Java Swing encourages private fields. These usages of these private fields helped to restrict unnecessary access to these variables. 

- Design patterns discovered
  - We learned about an alternate design pattern to check if a word is valid. This new method of carrying data on a .txt file has many applications in future projects and assignments, as one can save and carry data between program iterations.
        
- Testing insights
  - We ended up building the infrastructure for testing but not utilizing it. What we found/learned from this project is that you can still conduct tests on GUI functions by feeding output to the terminal for debugging.
         
## If We Had More Time
- Features we'd add:
  - Dark mode
  - Hints
  - Multiple games
  - Saved stats
  - Pvp
  - Person v machine 
- Refactoring we'd do:
  - Minimizing redundant code
  - Making more arrays/objects
- Performance improvements:
  - Reducing for loops
