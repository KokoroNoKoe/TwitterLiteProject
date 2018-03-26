public class UserDBMS {
    public static UserDBMS instance = null;
    private UserDatabase userDatabase;


    private UserDBMS(UserDatabase userDatabase){
        this.userDatabase = userDatabase;
    }

    //Singleton
    public static UserDBMS getInstance(UserDatabase database) {
        if (instance == null)
            return new UserDBMS(database);
        return instance;
    }
}
