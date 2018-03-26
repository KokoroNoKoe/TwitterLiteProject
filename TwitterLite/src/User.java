import java.util.ArrayList;

public class User extends UserComponent implements Subject, Observer {
    private String id;
    private ArrayList<String> followers = new ArrayList<>();
    private ArrayList<String> followings = new ArrayList<>();

    private DebugDisplay debugger = new DebugDisplay();

   public User(String id) {
        this.id = id;
    }


    public void follow(String id) {

    }

    public void post(String msg) {

    }

    public void addFeed(Tweet tweet) {

    }

    public String getId() {
        return id;
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
       System.out.print(" "+ getId());
    }


}
