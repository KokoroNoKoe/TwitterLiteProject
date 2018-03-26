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
    public void addUser(String id, UserComponent user, UserGroup group) {
        if (doesIdExist(id)) {
            System.out.println("User name already exist");
        } else {
            allUsersAndGroupsMap.put(id, user);
            numOfUsers++;
            group.addUserComponent(user);
            System.out.printf("User '%s' successfully added!\n", id);

        }
    }


    public void addRoot(UserGroup root){
        allUsersAndGroupsMap.put(root.getId(), root);
    }

    public void addGroup(String id, UserComponent group, UserGroup parentGroup) {
        if (doesIdExist(id)) {
            System.out.println("Id already exists");
        } else {
            allUsersAndGroupsMap.put(id, group);
            numOfGroups++;
            parentGroup.addUserComponent(group);
            System.out.printf("Group '%s' successfully added!\n", id);
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

    public UserGroup findGroup(String groupId) {
        UserComponent group = null;
        if(doesIdExist(groupId)) {
            group = allUsersAndGroupsMap.get(groupId);
        }
        if(group instanceof UserGroup) {   //It can potentially be a User
            return (UserGroup)group;
        }else{
            return null;
        }
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
