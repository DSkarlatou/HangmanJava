import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Word {
    private List<String> wordList  = new ArrayList<>();

    public Word(String filename)
    {
        readDictionary(filename);
    }

    public void readDictionary(String filename)
    {
        try {
            this.wordList = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }

    public String getWord()
    {
        Random rand = new Random();
        return this.wordList.get(rand.nextInt(wordList.size()));
    }


}
