import java.util.ArrayList;

/**
 * Represents a User. User is a UserComponent
 * User also implements Subject, Observer, and Acceptor.
 *
 * @author Yuki Yamada
 * @author Aleix Molla
 * @version 2018/03/30
 */
public class User extends UserComponent implements Subject, Observer, Acceptor {
    private String id;
    private ArrayList<String> followers = new ArrayList<>();
    private ArrayList<String> followings = new ArrayList<>();
    private ArrayList<Tweet> feedList = new ArrayList<>();
    private UserDBMS userDBMS = null;
    private Tweet last; //The last post of this user


    /**
     * Constructor
     * @param id
     */
    public User(String id) {
        this.id = id;
    }

    /**
     * @return id of this user
     */
    public String getId() {
        return id;
    }

    /**
     * This method concatenate every tweet messages and
     * return them as a single String.
     * @return String concatenated all the messages from the news feed.
     */
    public String getEveryNewsFeed() {
        String everyMsg = "<html>";
        for (Tweet msg : feedList) {
            everyMsg += msg + "<br>";
        }
        everyMsg += "<html/>";
        return everyMsg;
    }

    /**
     * This method concatenate every followings' IDs and
     * return them as a single String.
     * @return String concatenated all user IDs of followings.
     */
    public String getEveryFollowingsString() {
        String users = "<html>";
        for (String userId : followings) {
            users += userId + "<br>";
        }
        users += "<html/>";
        return users;
    }

    /**
     * This method is called when this instance User is followed by
     * another user. This User adds a new follower into the ArrayList
     * @param follower the User who followed you.
     */
    public void getFollowed(String follower){
        followers.add(follower);
    }

    /**
     * Sets a UserDBMS to this instance when it is null.
     * @param userDBMS UserDBMS instance.
     */
    public void setUserDBMS(UserDBMS userDBMS) {
        if (this.userDBMS == null)
            this.userDBMS = userDBMS;
    }

    /**
     * Add a new User in the following list if it is new.
     * @param id the user ID to follow
     * @return true is the user is followed successfully
     */
    public boolean follow(String id) {
        if (userDBMS.doesUserIdExist(id) && !followings.contains(id) && !id.equals(this.id)) {
            followings.add(id); //does not see the news feed before it follows
            System.out.println("Followed " + id);
            User following = userDBMS.getUserFromDatabase(id);
            following.getFollowed(this.id);//observer?
            return true;
        } else {
            System.out.println("failed");
            return false;
        }
    }

    /**
     * Creates a new Tweet instance from a given message,
     * adds the instance into the news feed list,
     * and notify all the observers (followings)
     * @param msg
     */
    public void post(String msg) {
        Tweet tweet = Tweet.createTweet(getId(), msg);
        last = tweet;
        addFeed(tweet);
        userDBMS.addNewTweet(tweet);
        notifyObservers();
    }

    /**
     * Adds a Tweet in the news feed list
     * @param tweet a Tweet to add to the list
     */
    public void addFeed(Tweet tweet) {
        feedList.add(tweet);
    }

    @Override
    public void update(Tweet tweet) {
        addFeed(tweet);
    }

    @Override //observers are followers
    public void notifyObservers() {
        for(String followerId: followers ){
            userDBMS.getUserFromDatabase(followerId).update(last);

        }
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void print() {
        System.out.print(" \"" + getId() + "\"");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
