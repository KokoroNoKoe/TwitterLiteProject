import java.util.ArrayList;
import java.util.Iterator;

public class UserGroup extends UserComponent {
    private String id;
    private ArrayList<UserComponent> userList  = new ArrayList<>();
    ;


    public UserGroup(String id) {
        this.id = id;
    }

    public void addUserComponent(UserComponent user) {
        userList.add(user);
    }

    public String getId() {
        return id;
    }

    @Override
    public void print() {
        System.out.print(" (["+ getId() + "]");
        Iterator<UserComponent> iterator = userList.iterator();
        while (iterator.hasNext()){
            UserComponent userComponent = (UserComponent)iterator.next();
            userComponent.print();
        }
        System.out.print(")");
    }
}

