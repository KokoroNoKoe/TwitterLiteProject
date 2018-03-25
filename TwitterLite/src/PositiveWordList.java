import java.util.ArrayList;

public class PositiveWordList extends ArrayList<String> {

    /**
     * Adds a positive word to this
     * @param word
     */
    public void addPosWord(String posWord){
        add(posWord);
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
