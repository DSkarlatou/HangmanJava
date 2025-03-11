import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int wordLength;
    private String board = "";
    private final String word;
    StringBuilder sb;
    private List<String> usedChars = new ArrayList<String>();

    public Board(String word) {
        this.wordLength = word.length();
        this.word = word;
        init();
    }

    public void init()
    {
        for(int i = 0; i < this.wordLength; i++)
            this.board += "_";
        display();
    }

    public boolean update(char guess)
    {
        String prevBoard = this.board;
        //boolean flag = updateUsedCharsList(guess);
        if(!updateUsedCharsList(guess))
            return true;

        sb = new StringBuilder(this.board);
        for (int i = 0; i < this.wordLength; i++)
            if(guess == word.charAt(i))
                sb.setCharAt(i, guess);

        this.board = sb.toString();

        display();
        if(this.board.equals(prevBoard))
           return false;

        return true;
    }

    public boolean updateUsedCharsList(char s) {
        String str = String.valueOf(s);

        if(usedChars.contains(str)) {
            System.out.println("You've already used this character");
            return false;
        }

        usedChars.add(str);
        System.out.println("Used letters: " + usedChars);
        return true;
    }

    public boolean gameResult()
    {
        return this.board.equals(this.word);
    }

    public void display()
    {
        System.out.println(board);
    }

    public void displayHangman(int i)
    {
        if(i == 0) {
            System.out.println("__________");
            System.out.println("|         ");
            System.out.println("|         ");
            System.out.println("|         ");
            System.out.println("|         ");
        }

        if(i == 1) {
            System.out.println("__________");
            System.out.println("|          ");
            System.out.println("|        O  ");
            System.out.println("|        ");
            System.out.println("|       ");
        }

        if(i == 2) {
            System.out.println("__________");
            System.out.println("|          ");
            System.out.println("|        O  ");
            System.out.println("|        | ");
            System.out.println("|       ");
        }

        if(i == 3) {
            System.out.println("__________");
            System.out.println("|          ");
            System.out.println("|        O  ");
            System.out.println("|       /| ");
            System.out.println("|       ");
        }

        if(i == 4) {
            System.out.println("__________");
            System.out.println("|          ");
            System.out.println("|        O  ");
            System.out.println("|       /|\\ ");
            System.out.println("|       ");
        }

        if(i == 5) {
            System.out.println("__________");
            System.out.println("|          ");
            System.out.println("|        O  ");
            System.out.println("|       /|\\ ");
            System.out.println("|       / ");
        }


        if(i == 6) {
            System.out.println("__________");
            System.out.println("|         ");
            System.out.println("|        O  ");
            System.out.println("|       /|\\ ");
            System.out.println("|       / \\ ");
        }

        if(i == 7) {
            System.out.println("__________");
            System.out.println("|        |  ");
            System.out.println("|        O  ");
            System.out.println("|       /|\\ ");
            System.out.println("|       / \\ ");
        }

    }

    public String getWord()
    {
        return word;
    }

}
