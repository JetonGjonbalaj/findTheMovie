import java.util.Scanner;

public class findTheMovie
{
    public static void main(String[] args)
    {
        // This is to scan the input
        Scanner cin = new Scanner(System.in);
        // Declaring the game
        Game game = new Game();
        // What user gives us
        char userIn;
        // To track the letters that user found
        int track = 0;
        // To finish the game if the user guessed the word
        boolean gameWon = true;

        // To show the user what words he has guessed
        for (int i = 0; i < game.foundLetters.length; i++)
            if(game.movieToFindAsChar[i] != ' ')
                game.foundLetters[i] = '_';
            else
                game.foundLetters[i] = ' ';

        // The user has still some chances left
        while (game.chances != 0)
        {
            System.out.print("You are guessing: ");

            // This will print 'space' if there's the a space in the movie name
            // else it will print the letter or the underscore
            for (int i = 0; i < game.foundLetters.length; i++)
                if (game.movieToFindAsChar[i] == ' ')
                    System.out.print(' ');
                else
                    System.out.print(game.foundLetters[i]);

            System.out.print("\nYou have guessed (" + (game.wrongLetters.length - game.chances) + ") wrong letters: ");

            // This will print the wrong letters if there are any
            if (game.wrongLetters.length - game.chances != 0)
                for (int i = 0; i < game.wrongLetters.length - game.chances; i++)
                    System.out.print(game.wrongLetters[i] + " ");

            System.out.print("\nGuess a letter: ");
            userIn = cin.next().charAt(0);

            // If the user gave the letter that isn't on the movie then that would go to the wrongLetters and we will have 1 chance less
            // Else it will go at the foundLetters
            if (!charInWord(userIn, game.movieToFindAsChar))
            {
                game.wrongLetters[game.wrongLetters.length - game.chances] = userIn;
                game.chances--;
            }
            else
                for (int i = 0; i < game.movieToFindAsChar.length; i++)
                    if(game.movieToFindAsChar[i] == userIn)
                        game.foundLetters[i] = userIn;

            // If the user found all the letters of the movie that he won
            // Else the game will move on
            for (int i = 0; i < game.movieToFindAsChar.length; i++)
            {
                gameWon = true;
                if (game.foundLetters[i] != game.movieToFindAsChar[i])
                {
                    gameWon = false;
                    break;
                }
            }

            // If the user won than the game will stop
            if(gameWon)
                break;
        }

        // If the user won than we will congratulate him
        // Else we will say that he lost
        if(gameWon)
            System.out.println("Congratulation! You won! You have found " + game.movieToFind + "!");
        else
            System.out.println("You lost!");
    }

    // This function tell if the given character is in the given word
    public static boolean charInWord(char letter, char[] word)
    {
        for (int i = 0; i < word.length; i++)
        {
            if(letter == word[i])
            {
                return true;
            }
        }
        return false;
    }
}
