public class Main {
    public static void main(String[] args) {
        Word word = new Word("words.txt");
        Board board = new Board(word.getWord());
        Player player = new Player();

        player.play(board);
    }
}