import java.util.ArrayList;

public class User extends UserComponent implements Subject, Observer {
    private String id;
    private ArrayList<String> followers = new ArrayList<>();
    private ArrayList<String> followings = new ArrayList<>();
    private ArrayList<Tweet> feedList = new ArrayList<>();

    private DebugDisplay debugger = new DebugDisplay();//debugging

    public User(String id) {
        this.id = id;
    }


    public void follow(String id) {
        //System.out.println("follow called");
        followings.add(id); //does not see the news feed before it follows

    }

    public void post(String msg) {

        //System.out.println("post called");


    }

    public void addFeed(String msg) {
        Tweet tweet = Tweet.createTweet(getId(), msg);
        feedList.add(tweet);
        //System.out.printf("addFeed in User is called\n%s\n", tweet);
    }

    public String getId() {
        return id;
    }


    public String getEveryNewsfeed() {
        String everyMsg = "<html>";
        for (Tweet msg : feedList) {
            everyMsg += msg + "<br>";
        }
        everyMsg += "<html/>";
        return everyMsg;
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
