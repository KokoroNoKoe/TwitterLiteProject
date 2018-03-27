public class UserDBMS {

    public static UserDBMS instance = null;
    private UserDatabase userDatabase;


    public boolean doesUserIdExist(String userId) {
        User user = userDatabase.getUserFromDatabase(userId);
        if (user == null) {
            return false;
        }
        return true;
    }

    public User getUserFromDatabase(String userId){
        User user = userDatabase.getUserFromDatabase(userId);
        if (user == null) {
            return null;
        }
        return user;
    }

    public void addNewTweet(Tweet tweet){
        userDatabase.addTweet(tweet);
    }

    //Constructor
    private UserDBMS(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    //Singleton
    public static UserDBMS getInstance(UserDatabase database) {
        if (instance == null)
            return new UserDBMS(database);
        return instance;
    }
}
