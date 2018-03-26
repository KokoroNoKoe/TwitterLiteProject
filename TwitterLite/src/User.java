import java.util.ArrayList;

public class User extends UserComponent implements Subject, Observer {
    private String id;
    private ArrayList<String> followers = new ArrayList<>();
    private ArrayList<String> followings = new ArrayList<>();
    private ArrayList<Tweet> feedList = new ArrayList<>();

    private UserDBMS userDBMS = null;


    public User(String id) {
        this.id = id;
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
        if (userDBMS.doesUserIdExist(id)) {
            followings.add(id); //does not see the news feed before it follows
            System.out.println("Followed " + id);
            return true;
        } else {
            System.out.println(id + " does not exist");
            return false;
        }

    }

    public void post(String msg) {

        //System.out.println("post called");


    }

    public void addFeed(String msg) {
        Tweet tweet = Tweet.createTweet(getId(), msg);
        feedList.add(tweet);
        //System.out.printf("addFeed in User is called\n%s\n", tweet);
    }

    @Override
    public void update() {

    }

    @Override
    public void notifyObservers() {

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
