import java.util.Scanner;

public class Player {
    private final Scanner sc = new Scanner(System.in);
    private final int chances = 7;
    public Player() {}

    public void play(Board board)
    {
        int i = 0;
        while(i < chances)
        {
            board.displayHangman(i);
            if(board.gameResult()) {
                System.out.println("You win! The word was: " + board.getWord());
                return;
            }
            char currChar = guess();
            if(!board.update(currChar))
                i++;
        }
        board.displayHangman(chances);
        System.out.println("You lost! The word was: " + board.getWord());
    }

    public char guess()
    {
        System.out.println("Choose a letter:");
        String guess;
        while(true)
        {
            guess = sc.nextLine();
            if(guess.length() == 1 && Character.isLowerCase(guess.charAt(0)))
                break;
            else
                System.out.println("Invalid input, only 1 lowercase alphabet character is allowed, \n" +
                                   "Choose a letter:");
        }
        return guess.charAt(0);

    }
}
