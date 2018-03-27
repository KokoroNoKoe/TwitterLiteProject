


public class UserComponentFactory {

    private UserDBMS userDBMS;

    public UserComponentFactory(UserDBMS userDBMS) {
        this.userDBMS = userDBMS;
    }

    public User createUser(String id) {
        User user = new User(id);
        user.setUserDBMS(userDBMS);
        return user;
    }

    public UserGroup createGroup(String id) {
        return new UserGroup(id);
    }


}
