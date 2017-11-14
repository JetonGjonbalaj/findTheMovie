public class Game
{
    public String movies[] = {"Star Wars", "Spider Man", "Strange Things", "Jigsaw",
                                "Game of thrones", "Wonder Woman", "You get me"};
    public String movieToFind = movies[(int) (Math.floor(Math.random() * movies.length))];

    public char movieToFindAsChar[] = movieToFind.toCharArray();
    public char foundLetters[] = new char[movieToFindAsChar.length];
    public char wrongLetters[] = new char[10];

    public int chances = 10;
}
