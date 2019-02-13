/*
 * Name:        Nathanael Nading
 * Date:        01.15.2019
 * Description: Program for a game of hangman
 */

import java.util.Scanner;
import java.util.Random;

//an enum for the different categories of words in the hangman game
enum Categories
{
    MATH, SCIENCE, ENGLISH, HISTORY, ART, ERROR;
}

public class Hangman
{
    private static final Random randomNumbers = new Random();   //for assigning variables random values
    private static int categoriesAmount = 5;                    //records the amount of categories
    private static int wordsAmount = 10;                        //holds the number of words per category
    
    public static void main(String args[])
    {
        //variables
        Scanner input = new Scanner(System.in);             //allows for user input
        int wordNum = randomNumbers.nextInt(wordsAmount);   //each word in each category has a number. This variable selects one of those numbers.
        int numOfTeams = 0;                                 //will hold the number of teams playing
        
        //arrays
        int winCount[];                                     //records how many times a team has won
        String mathWords[] = new String[wordsAmount];       //will hold the math category words
        String scienceWords[] = new String[wordsAmount];    //will hold the science category words
        String englishWords[] = new String[wordsAmount];    //will hold the english category words
        String historyWords[] = new String[wordsAmount];    //will hold the history category words
        String artWords[] = new String[wordsAmount];        //will hold the art category words
        
        //fills the arrays with the words in each category
        fillArray(mathWords, Categories.MATH);          //puts the math words in the math array
        fillArray(scienceWords, Categories.SCIENCE);    //puts the science words in the science array
        fillArray(englishWords, Categories.ENGLISH);    //puts the english words in the english array
        fillArray(historyWords, Categories.HISTORY);    //puts the history words in the history array
        fillArray(artWords, Categories.ART);            //puts the art words in the art array
        
        //finds out the number of teams playing
        System.out.print("Enter the number of teams playing: ");
        
        //in case the user enters an amount less than is possible
        while (numOfTeams <= 1)
        {
            numOfTeams = input.nextInt();
            if (numOfTeams <= 1)    //if the user enters a number at or less than one, it asks them to re-enter a number
            {
                System.out.printf("%nPlease enter a number above 1: ");
            }
        }
        System.out.printf("%n%d teams playing.%n", numOfTeams);
        
        //sets the size of the win count array to the number of teams playing
        winCount = new int[numOfTeams];
        
        playHangman(numOfTeams, mathWords, scienceWords, englishWords, historyWords, artWords, wordNum, input, winCount);
    }
    
    //plays through every wanted game of hangman
    public static void playHangman(int numOfTeams, String mathWords[], String scienceWords[], String englishWords[], String historyWords[], String artWords[], int wordNum, Scanner input, int winCount[])
    {
        Boolean playAgain = true;                           //keeps track of whether the user wants to play again
        int inCount = 0;                                    //counts the number of players who haven't lost
        String teamNames[] = new String[numOfTeams];        //will hold the names of the teams
        
        //finds out the names of the teams
        for (int i = 0; i < numOfTeams; i++)
        {
            System.out.printf("Enter the name of team %d (will take first word inputted): ", i + 1);
            teamNames[i] = input.next();                                //records the names in the array teamNames
            input.nextLine();                                           //prints out a new line instead of inserting it in the next input.next()
            System.out.println();
        }
        
        //sets up the category and word. If the user wants to play again, they'll 
        while (playAgain)
        {
            //this section up until the next while loop resets all of the values for a new round
            Categories category;                            //records the category
            Boolean end = false;                            //records whether the round has ended or not
            int currentTeam = 1;                            //records whose turn it is
            char lettersGuessed[] = new char[26];           //records the letters guessed
            char correctLetters[];                          //records the letters guessed correctly
            char word[];                                    //records the word
            int numIncorrect[] = new int[numOfTeams];       //records the number of incorrect guesses per team
            Boolean teamsLost[] = new Boolean[numOfTeams];  //records which teams have lost
            
            //sets it so that no teams have lost
            for (int i = 0; i < numOfTeams; i++)
            {
                teamsLost[i] = false;
            }
            
            //selects a category at random
            System.out.printf("%nSelecting category...%n");
            category = selectCategory();
            System.out.println("Selected Category: "+ category);
            
            //selects the word and puts it into a char array
            if (category == Categories.MATH)                    //if the category is math, makes the word a word from the math array
            {
                word = mathWords[wordNum].toCharArray();
            }
            else if (category == Categories.SCIENCE)            //if the category is science, makes the word a word from the science array
            {
                word = scienceWords[wordNum].toCharArray();
            }
            else if (category == Categories.ENGLISH)            //if the category is english, makes the word a word from the english array
            {
                word = englishWords[wordNum].toCharArray();
            }
            else if (category == Categories.HISTORY)            //if the category is history, makes the word a word from the history array
            {
                word = historyWords[wordNum].toCharArray();
            }
            else if (category == Categories.ART)                //if the category is art, makes the word a word from the art array
            {
                word = artWords[wordNum].toCharArray();
            }
            else                                                //if the category is error, sets word to be empty
            {
                word = new char[10];
            }
            
            //sets the correct letters to all being underscores
            correctLetters = new char[word.length];
            for (int i = 0; i < word.length; i++)
            {
                correctLetters[i] = '_';
            }
            
            //sets the lettersGuessed to n, which stands for not guessed
            for (int i = 0; i < 26; i++)
            {
                lettersGuessed[i] = 'n';
            }
            
            //sets the number of incorrect guesses for each team to 0
            for (int i = 0; i < numOfTeams; i++)
            {
                numIncorrect[i] = 0;
            }
            
            //this while loop is a round of hangman. It ends when end is true.
            while (end == false)
            {
                //if the current team has lost the game, it skips their turn in the else statement
                if (!teamsLost[currentTeam - 1])
                {
                    //variables
                    char guess = ' ';                   //holds the user's guess
                    Boolean correct = false;            //used to record if the user has guessed correctly and therefore whether it is another person's turn or not
                    Boolean alreadyGuessed = true;      //checks to make sure the user entered a lettter that was not already guessed
                    end = true;                         //sets the end of the game to true. This will change if the game is not ended.
                    inCount = 0;                        //resets the amount of people still in for use later to count the actual number
                    
                    //prints out the hangman screen
                    System.out.printf("%n%nTeam %s, it is your turn!%n%n", teamNames[currentTeam - 1]);
                    printGuessed(lettersGuessed);                                                       //prints out the letters which someone has guessed
                    printHangman(numIncorrect, currentTeam);                                            //print out the hangman picture
                    printSpaces(correctLetters);                                                        //prints out the word as it has been guessed

                    System.out.print("Please enter your letter guess: ");
                    
                    //in case the user enteres a letter already guessed
                    while (alreadyGuessed)
                    {
                        alreadyGuessed = false;
                        
                        //records the user's guess
                        guess = input.next(".").charAt(0);
                        input.nextLine();
                        System.out.printf("%n%n");
                        guess = Character.toUpperCase(guess);
                        
                        //checks to ensure the user has not guessed a letter already guessed
                        for (int i = 0; i < lettersGuessed.length; i++)
                        {
                            //if the guess has already been guessed, then it resets the top while loop
                            if (guess == lettersGuessed[i])
                            {
                                alreadyGuessed = true;
                                System.out.printf("That letter has already been guessed. Please try again: ");
                            }
                        }
                    }
                    
                    //checks to see if the user has guessed a word correctly
                    for (int i = 0; i < word.length; i++)
                    {
                        //if the user guessed a word correctly, it tells the suer and adds it to the correct letters array
                        if (guess == word[i])
                        {
                            correctLetters[i] = guess;
                            System.out.println("Correct! " + correctLetters[i] + " is the " + (i + 1) + " number!");
                            correct = true;
                        }
                    }
                    
                    //if the user didn't guess any correctly
                    if (!correct)
                    {
                        System.out.println("Sorry, no letters match your guess.");
                        numIncorrect[currentTeam - 1]++;                            //records the team guessed incorrectly
                        
                        //if the team has guessed to many times incorrectly, it has them lose and checks to see if a winner can be determined or not
                        if (numIncorrect[currentTeam - 1] == 6)
                        {
                            printHangman(numIncorrect, currentTeam);
                            System.out.println("Team " + teamNames[currentTeam - 1] + ", you lose!");
                            teamsLost[currentTeam - 1] = true;
                            
                            //goes through all of the teams...
                            for (int i = 0; i < numOfTeams; i++)
                            {
                                //...and counts the number of teams still in
                                if (!teamsLost[i])
                                {
                                    inCount++;
                                }
                            }
                        }
                        
                        //sets the team to the next one in line, noting whether this would be the next highest number or team number 1
                        if (numOfTeams == currentTeam)  //if the current team is the highest number team, goes back down to team number 1
                        {
                            currentTeam = 1;
                        }
                        else                            //if the current team is not the highest number team, goes on to the next highest team
                        {
                            currentTeam++;
                        }
                    }
                    
                    //records the guessed letter in the letters guessed array
                    recordGuess(lettersGuessed, guess);
                    
                    //checks through to see if the person who guessed guessed all of the letters
                    for (int i = 0; i < correctLetters.length; i++)
                    {
                        //if the user did not guess the last letter, sets the end to false.
                        if (correctLetters[i] == '_')
                        {
                            end = false;
                        }
                    }
                    
                    //if there is only 1 team left in the game, then the end is true
                    if (inCount == 1)
                    {
                        end = true;
                    }
                }
                else    //if the current team has lost already
                {
                    if (numOfTeams == currentTeam)  //if the current team is the highest number team, goes back down to team number 1
                    {
                        currentTeam = 1;
                    }
                    else                            //if the current team is not the highest number team, goes on to the next highest team
                    {
                        currentTeam++;
                    }
                }
            }
            
            //if the game was ended because every player lost except for 1
            if (inCount == 1)
            {
                //looks through the teams and finds which one has not lost
                for (int i = 0; i < numOfTeams; i++)
                {
                    //if the team has not lost, put it as the current team
                    if (!teamsLost[i])
                    {
                        currentTeam = i + 1;
                    }
                }
            }
            
            //prints out the team which won and records it.
            System.out.println("Congratulations, Team " + teamNames[currentTeam - 1] + ", you win!");
            winCount[currentTeam - 1]++;
            
            //prints out the current standings
            System.out.printf("%nCurrent Standings:%n%n");
            for (int i = 0; i < numOfTeams; i++)
            {
                System.out.println("Team " + teamNames[i] + ":   " + winCount[i]);
            }
            
            //asks if the user would like to play again and records their answer
            System.out.print("Would you like to play again? (Y for yes, anything else for no): ");
            char continuePlaying = input.next(".").charAt(0);
            continuePlaying = Character.toUpperCase(continuePlaying);
            
            //if they want to play again, resets the game; if not, shuts down the program
            if (continuePlaying == 'Y') //if the player wants to play again, resets the round and goes again
            {
                playAgain = true;
            }
            else                        //if the player doesn't want to play again, the program shuts down
            {
                playAgain = false;
            }
        }
    }
    
    //records the user's guess in the letters guessed array
    private static void recordGuess(char lettersGuessed[], char guess)
    {
        //puts the value of guess into a certain part of the letters guessed array dependent on what letter it is.
        switch (guess)
        {
            case 'A':
                lettersGuessed[0] = guess;
                break;
            
            case 'B':
                lettersGuessed[1] = guess;
                break;
            
            case 'C':
                lettersGuessed[2] = guess;
                break;
            
            case 'D':
                lettersGuessed[3] = guess;
                break;
            
            case 'E':
                lettersGuessed[4] = guess;
                break;
            
            case 'F':
                lettersGuessed[5] = guess;
                break;
            
            case 'G':
                lettersGuessed[6] = guess;
                break;
            
            case 'H':
                lettersGuessed[7] = guess;
                break;
            
            case 'I':
                lettersGuessed[8] = guess;
                break;
            
            case 'J':
                lettersGuessed[9] = guess;
                break;
            
            case 'K':
                lettersGuessed[10] = guess;
                break;
            
            case 'L':
                lettersGuessed[11] = guess;
                break;
            
            case 'M':
                lettersGuessed[12] = guess;
                break;
            
            case 'N':
                lettersGuessed[13] = guess;
                break;
            
            case 'O':
                lettersGuessed[14] = guess;
                break;
            
            case 'P':
                lettersGuessed[15] = guess;
                break;
            
            case 'Q':
                lettersGuessed[16] = guess;
                break;
            
            case 'R':
                lettersGuessed[17] = guess;
                break;
            
            case 'S':
                lettersGuessed[18] = guess;
                break;
            
            case 'T':
                lettersGuessed[19] = guess;
                break;
            
            case 'U':
                lettersGuessed[20] = guess;
                break;
            
            case 'V':
                lettersGuessed[21] = guess;
                break;
            
            case 'W':
                lettersGuessed[22] = guess;
                break;
            
            case 'X':
                lettersGuessed[23] = guess;
                break;
            
            case 'Y':
                lettersGuessed[24] = guess;
                break;
            
            case 'Z':
                lettersGuessed[25] = guess;
                break;
        }
    }
    
    //prints out the word as is found out at that point
    public static void printSpaces(char correctLetters[])
    {
        //goes through the correct letters array and prints it out
        for (int i = 0; i < correctLetters.length; i++)
        {
            System.out.print(correctLetters[i] + " ");
        }
        
        System.out.println();
    }
    
    //selects a random category and returns it
    private static Categories selectCategory()
    {
        int randCategory = randomNumbers.nextInt(categoriesAmount);
        
        switch (randCategory)
        {
            case 0:
                return Categories.MATH;     //returns math category
            
            case 1:
                return Categories.SCIENCE;  //returns science category
            
            case 2:
                return Categories.ENGLISH;  //returns english category
            
            case 3:
                return Categories.HISTORY;  //returns history category
            
            case 4:
                return Categories.ART;      //returns art category
            
            default:
                return Categories.ERROR;    //returns error
        }
    }
    
    //fills the array with the words in its category
    private static void fillArray(String categoryWords[], Categories arrayInit)
    {        
        if (arrayInit == Categories.MATH)           //category is math
        {
            categoryWords[0] = "ADDITION";
            categoryWords[1] = "SUBTRACTION";
            categoryWords[2] = "MULTIPLICATION";
            categoryWords[3] = "DIVISION";
            categoryWords[4] = "SQUARE";
            categoryWords[5] = "ALGEBRA";
            categoryWords[6] = "TRIGONOMETRY";
            categoryWords[7] = "LOGARITHM";
            categoryWords[8] = "MATRIX";
            categoryWords[9] = "VARIABLE";
        }
        else if (arrayInit == Categories.SCIENCE)   //category is science
        {
            categoryWords[0] = "HYPOTHESIS";
            categoryWords[1] = "EXPERIMENT";
            categoryWords[2] = "ENTROPY";
            categoryWords[3] = "ENERGY";
            categoryWords[4] = "BIOLOGY";
            categoryWords[5] = "CHEMISTRY";
            categoryWords[6] = "BEAKER";
            categoryWords[7] = "SCALE";
            categoryWords[8] = "METRIC";
            categoryWords[9] = "CONTROL";
        }
        else if (arrayInit == Categories.ENGLISH)   //category is english
        {
            categoryWords[0] = "HAWTHORNE";
            categoryWords[1] = "PREPOSITION";
            categoryWords[2] = "GRAMMAR";
            categoryWords[3] = "LITERATURE";
            categoryWords[4] = "INGALLS";
            categoryWords[5] = "SENTENCE";
            categoryWords[6] = "ADJECTIVE";
            categoryWords[7] = "FRAGMENT";
            categoryWords[8] = "PRONOUN";
            categoryWords[9] = "PHRASE";
        }
        else if (arrayInit == Categories.HISTORY)   //category is history
        {
            categoryWords[0] = "AMERICA";
            categoryWords[1] = "ARMADA";
            categoryWords[2] = "ELIZABETH";
            categoryWords[3] = "REVOLUTION";
            categoryWords[4] = "VINCI";
            categoryWords[5] = "COLUMBUS";
            categoryWords[6] = "CHARLEMAGNE";
            categoryWords[7] = "WASHINGTON";
            categoryWords[8] = "LINCOLN";
            categoryWords[9] = "CHURCHILL";
        }
        else if (arrayInit == Categories.ART)   //category is art
        {
            categoryWords[0] = "PICASSO";
            categoryWords[1] = "SKETCH";
            categoryWords[2] = "PAINTING";
            categoryWords[3] = "MEDIA";
            categoryWords[4] = "MUSIC";
            categoryWords[5] = "ARTIST";
            categoryWords[6] = "STYLE";
            categoryWords[7] = "FOUNTAIN";
            categoryWords[8] = "ANNUNCIATION";
            categoryWords[9] = "HALLELUJAH";
        }
        else                                    //category is NULL or error
        {
            //shows there is an error without crashing the program
            for (int i = 0; i < wordsAmount; i++)
            {
                categoryWords[i] = "ERROR:CATEGORYNOTFOUND";
            }
        }
    }
    
    //prints out the hangman
    public static void printHangman(int numIncorrect[], int currentTeam)
    {
        //the hangman picture looks different based on how many guesses have been incorrect by that team
        if (numIncorrect[currentTeam - 1] == 0)         //no incorrect guesses
        {
            System.out.println("     __________");
            System.out.println("     |        |");
            System.out.println("     |        |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("           -------");
        }
        else if (numIncorrect[currentTeam - 1] == 1)    //one incorrect guess
        {
            System.out.println("     __________");
            System.out.println("     |        |");
            System.out.println("     |        |");
            System.out.println("   _____      |");
            System.out.println("   |   |      |");
            System.out.println("   -----      |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("           -------");
        }
        else if (numIncorrect[currentTeam - 1] == 2)    //two incorrect guesses
        {
            System.out.println("     __________");
            System.out.println("     |        |");
            System.out.println("     |        |");
            System.out.println("   _____      |");
            System.out.println("   |   |      |");
            System.out.println("   -----      |");
            System.out.println("     |        |");
            System.out.println("     |        |");
            System.out.println("     |        |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("           -------");
        }
        else if (numIncorrect[currentTeam - 1] == 3)    //three incorrect guesses
        {
            System.out.println("     __________");
            System.out.println("     |        |");
            System.out.println("     |        |");
            System.out.println("   _____      |");
            System.out.println("   |   |      |");
            System.out.println("   -----      |");
            System.out.println("     |_       |");
            System.out.println("     | \\      |");
            System.out.println("     |        |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("           -------");
        }
        else if (numIncorrect[currentTeam - 1] == 4)    //four incorrect guesses
        {
            System.out.println("     __________");
            System.out.println("     |        |");
            System.out.println("     |        |");
            System.out.println("   _____      |");
            System.out.println("   |   |      |");
            System.out.println("   -----      |");
            System.out.println("    _|_       |");
            System.out.println("   / | \\      |");
            System.out.println("     |        |");
            System.out.println("              |");
            System.out.println("              |");
            System.out.println("           -------");
        }
        else if (numIncorrect[currentTeam - 1] == 5)    //five incorrect guesses
        {
            System.out.println("     __________");
            System.out.println("     |        |");
            System.out.println("     |        |");
            System.out.println("   _____      |");
            System.out.println("   |   |      |");
            System.out.println("   -----      |");
            System.out.println("    _|_       |");
            System.out.println("   / | \\      |");
            System.out.println("     |        |");
            System.out.println("      \\       |");
            System.out.println("       \\      |");
            System.out.println("           -------");
        }
        else if (numIncorrect[currentTeam - 1] == 6)    //six incorrect guesses
        {
            System.out.println("     __________");
            System.out.println("     |        |");
            System.out.println("     |        |");
            System.out.println("   _____      |");
            System.out.println("   |   |      |");
            System.out.println("   -----      |");
            System.out.println("    _|_       |");
            System.out.println("   / | \\      |");
            System.out.println("     |        |");
            System.out.println("    / \\       |");
            System.out.println("   /   \\      |");
            System.out.println("           -------");
        }
    }
    
    //prints out the letters which have been guessed
    public static void printGuessed(char lettersGuessed[])
    {
        //goes through the letters guessed array and prints it out
        for (int i = 0; i < 26; i++)
        {
            //if the value is n, then the letter hasn't been guessed yet
            if (lettersGuessed[i] != 'n')
            {
                System.out.print(lettersGuessed[i] + " ");
            }
        }
        
        System.out.printf("%n%n");
    }
}