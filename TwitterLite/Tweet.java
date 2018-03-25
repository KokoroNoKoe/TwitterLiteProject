
/**
 * Write a description of class Tweet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tweet
{
    private String message;

    public boolean isPositive()
    {
        if(message.contains("good") ||message.contains("great")||message.contains("excellent"))
            return true;
        return false;
    }
}
