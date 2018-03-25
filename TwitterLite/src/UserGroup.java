import java.util.ArrayList;

public class UserGroup extends UserComponent {
    private String id;
    private ArrayList<UserComponent> userList;


    public UserGroup(String id) {
        this.id = id;
    }

    public void addUserComponent(UserComponent user) {
        userList.add(user);
    }

}

