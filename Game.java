public class Game {
    private String movies[] = {"Star Wars", "Spider Man", "Strange Things", "Jigsaw",
                                "Game of thrones", "Wonder Woman", "You get me"};
    private String movieToFind = movies[(int) (Math.floor(Math.random() * movies.length))];

    private char movieToFindAsChar[] = movieToFind.toCharArray();
    private char foundLetters[] = new char[movieToFindAsChar.length];
    private char wrongLetters[] = new char[10];

    private int chances = 10;

    // This will start the game
    public void start() {
        for (int i = 0; i < this.movieToFindAsChar.length; i++)
            if (this.movieToFindAsChar[i] == ' ')
                this.foundLetters[i] = ' ';
            else
                this.foundLetters[i] = '_';
    }

    // It will display the letters to find on the screen
    public void displayLetters() {
        System.out.println(this.foundLetters);
    }

    // It will display the wrong letters that user gave
    public void displayWrongLetters() {
        System.out.print("You have guessed " + (this.wrongLetters.length - this.chances) + " wrong letters: ");

        if (this.wrongLetters.length - this.chances != 0)
            for (int i = 0; i < this.wrongLetters.length - this.chances; i++)
                System.out.print(this.wrongLetters[i] + " ");

        System.out.println();
    }

    // Updates the found letters if the user was right
    public void updateFoundLetters(char letter) {
        for(int i = 0; i < this.foundLetters.length; i++)
            if (this.movieToFindAsChar[i] == letter)
                this.foundLetters[i] = letter;
    }

    // Updates the found letters if the user was wrong
    public void updateWrongLetters(char letter) {
        this.wrongLetters[this.wrongLetters.length - this.chances] = letter;
        this.chances--;
    }

    // It checks if there are still chences left
    public boolean hasChances() {
        if (this.chances != 0) return true;
        else return false;
    }

    // It checks if the game is won
    public boolean won() {
        for (int i = 0; i < this.movieToFindAsChar.length; i++)
            if (this.foundLetters[i] != this.movieToFindAsChar[i]) return false;

        System.out.println("\nCONGRATULATIONS! You have found the \"" + this.movieToFind + "\" !");
        return true;
    }

    // It checks if user found a letter
    public boolean guessedLetter(char letter) {
        for (int i = 0; i < this.movieToFindAsChar.length; i++)
            if (letter == this.movieToFindAsChar[i])  return true;

        return false;
    }
}
