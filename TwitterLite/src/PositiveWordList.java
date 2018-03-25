import java.util.ArrayList;

public class PositiveWordList extends ArrayList<String> {

    //test
    public final static String[]testWords = {"Good", "Great", "Excellent"};

    public PositiveWordList(){

    }

    //test
    public void addTestWords(){
        addPositiveWords(testWords);
    }

    /**
     * Adds a positive word to this
     * @param word
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
     * @param posWord
     * @return
     */
    public boolean isPositive(String posWord){
        return contains(posWord);
    }

}
