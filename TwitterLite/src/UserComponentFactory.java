


public class UserComponentFactory {

    public User createUser(String id){
            return new User(id);
    }

    public UserGroup createGroup(String id){
            return new UserGroup(id);
    }



  //
}
