public class UserDBMS {

    /**
     * This class allows Users to query the UserDatabase.
     * User class does not have a direct reference to UserDatabase, but UserDBMS.
     *
     * @author Yuki Yamada
     * @author Aleix Molla
     * @version 2018/03/30
     */
    private static UserDBMS instance = null;
    private UserDatabase userDatabase;

    //Constructor
    private UserDBMS(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

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

    //Singleton
    public static UserDBMS getInstance(UserDatabase database) {
        if (instance == null)
            return new UserDBMS(database);
        return instance;
    }
}
