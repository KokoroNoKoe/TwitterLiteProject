import java.util.*;
/**
 * Write a description of class IdFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IdFactory
{
   private ArrayList<String> userIds;

   public boolean isValidUserId(String newId) //check if the user id is unique
   {
      return userIds.contains(newId);
   }
   
   public String createId(){
       System.out.println("enter a user name");
       Scanner s = new Scanner(System.in);
       //asks a use to enter an id, and returns the id if it is valid
       //This uer interaction should happen in GUI later
       return "";
    }
}
