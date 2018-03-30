import java.util.ArrayList;

/**
 * PositiveWordList is an ArrayList. This PositiveWordList is held by UserDatabase.
 * This has boolean isPositive method to check if a given String contains a positive word or not.
 *
 * @author Yuki Yamada
 * @author Aleix Molla
 * @version 2018/03/30
 */
public class PositiveWordList extends ArrayList<String> {

    //test
    private final static String[] TEST_WORDS = {"Good", "Great", "Excellent", "Easy", "Happy", "Lucky"};

    /**
     * Constructor
     */
    public PositiveWordList() {
        addTestWords();//add the test words to this
    }

    //test
    public void addTestWords() {
        addPositiveWords(TEST_WORDS);
    }

    /**
     * Adds a positive word to this
     *
     * @param
     */
    public void addPositiveWords(String[] posWords) {
        for (String word : posWords) {
            add(word);
        }
    }

    /**
     * Checks if this PositiveWordList contains the word given
     *
     * @param
     * @return
     */
    public boolean isPositive(String msg) {
        for (String stored : this) {
            if (msg.toLowerCase().contains(stored.toLowerCase()))
                return true;
        }
        return false;
    }

}
