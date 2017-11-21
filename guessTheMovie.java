import java.util.Scanner;

public class guessTheMovie {
    public static void main(String[] args) {
        // This will start the game
        Game game = new Game();
        game.start();

        // This stores a scanner for inputs
        Scanner cin = new Scanner(System.in);

        // This will store the input of the user
        char usrIn;

        // While the user has chances
        while(game.hasChances()){
            // It displays the length of the movie that the user has to find
            // and the letters if he found any
            System.out.print("You are guessing: ");
            game.displayLetters();
            game.displayWrongLetters();

            // Will ask the user to put a letter and store it on the variable
            System.out.print("Guess a letter: ");
            usrIn = cin.next().charAt(0);

            // If the user found a letter
            if(game.guessedLetter(usrIn))
                game.updateFoundLetters(usrIn); // It will update what the user has found
            else
                game.updateWrongLetters(usrIn); // It will update what the user has guessed wrong

            // If the game is won it will break out of the looop
            if (game.won()) break;
            // Else it will condole the user
            else if(!game.hasChances())
                System.out.println("\nBetter luck next time!");
        }
    }
}
