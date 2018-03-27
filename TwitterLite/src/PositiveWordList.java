import java.util.ArrayList;

public class PositiveWordList extends ArrayList<String> {

    //test
    public final static String[]testWords = {"Good", "Great", "Excellent"};

    /**
     * Constructor
     */
    public PositiveWordList(){
        addTestWords();//add the test words to this
    }

    //test
    public void addTestWords(){
        addPositiveWords(testWords);
    }

    /**
     * Adds a positive word to this
     * @param
     */
    public void addAPositiveWord(String posWord){
        add(posWord);
    }

    public void addPositiveWords(String[]posWords){
        for(String word: posWords){
            add(word);
        }
    }





    /**
     * Checks if this PositiveWordList contains the word given
     * @param
     * @return
     */
    public boolean isPositive(String msg){
        System.out.println(msg);
        for(String stored: this) {
            System.out.println(stored + "\n");
            return msg.toLowerCase().contains(stored.toLowerCase());
        }
        return false;
    }

}
