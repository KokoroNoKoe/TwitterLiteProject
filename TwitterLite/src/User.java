import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class User extends UserComponent implements Subject, Observer {
    private String id;
    private ArrayList<String> followers = new ArrayList<>();
    private ArrayList<String> followings = new ArrayList<>();
    private ArrayList<Tweet> feedList = new ArrayList<>();


    private UserDBMS userDBMS = null;

    public User(String id) {
        this.id = id;
        this.treeNode = new DefaultMutableTreeNode(id);
    }

    public String getId() {
        return id;
    }

    public void setUserDBMS(UserDBMS userDBMS) {
        if (this.userDBMS == null)
            this.userDBMS = userDBMS;
    }

    public String getEveryNewsfeed() {
        String everyMsg = "<html>";
        for (Tweet msg : feedList) {
            everyMsg += msg + "<br>";
        }
        everyMsg += "<html/>";
        return everyMsg;
    }

    public String getEveryFollowingsString() {
        String users = "<html>";
        for (String userId : followings) {
            users += userId + "<br>";
        }
        users += "<html/>";
        return users;
    }


    public boolean follow(String id) {
        if (userDBMS.doesUserIdExist(id) && !followings.contains(id)) {
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

    public void getFollowed(String follower){
        followers.add(follower);
    }

    public void post(String msg) {
        Tweet tweet = Tweet.createTweet(getId(), msg);
        last = tweet;
        addFeed(tweet);
        userDBMS.addNewTweet(tweet);
        notifyObservers();
        //System.out.println("post called");


    }

    public void addFeed(Tweet tweet) {
        feedList.add(tweet);
    }


    @Override
    public void update(Tweet tweet) {
        addFeed(tweet);
    }

    private Tweet last;//the latest your post

    @Override //observesrs are followers
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


}
