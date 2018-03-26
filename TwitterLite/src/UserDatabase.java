import java.util.ArrayList;
import java.util.HashMap;

public class UserDatabase {
    private int numOfUsers;
    private int numOfGroups;
    private int numOfTweets;
    private int numOfPositiveMsg;
    private ArrayList<Tweet> allTweets;
    private HashMap<String, UserComponent> allUsersAndGroupsMap = new HashMap<>();


    /**
     * add an user to a HashMap
     *
     * @param id
     * @param user
     */
    public void addUser(String id, UserComponent user) {
        if (doesIdExist(id)) {
            System.out.println("User name already exist");
        } else {
            allUsersAndGroupsMap.put(id, user);
            numOfUsers++;
        }
    }

    /**
     * Adds a group to a hash map
     *
     * @param id
     * @param group
     */
    public void addGroup(String id, UserComponent group) {
        if (doesIdExist(id)) {
            System.out.println("Id already exists");
        } else {
            allUsersAndGroupsMap.put(id, group);
            numOfGroups++;
        }
    }


    public void addTweet(Tweet tweet) {
        allTweets.add(tweet);
        numOfTweets++;
    }

    private boolean doesIdExist(String id) {
        UserComponent user = allUsersAndGroupsMap.get(id);
        if (user == null)
            return false;
        return true;
    }

    //getters
    public int getNumOfUsers() {
        return numOfUsers;
    }

    public int getNumOfGroups() {
        return numOfGroups;
    }

    public int getNumOfTweets() {
        return numOfTweets;
    }

    public int getNumOfPositiveMsg() {
        return numOfPositiveMsg;
    }
}
