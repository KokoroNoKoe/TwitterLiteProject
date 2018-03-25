import java.util.ArrayList;
import java.util.HashMap;

public class UserComponentFactory {
    private HashMap<String, UserComponent> userComponentMap = new HashMap<>();
    private ArrayList<String> idList = new ArrayList<>();

    public User createUser(String id){
        if(!doesIdExist(id))
            return new User(id);
        return null;//exception
    }

    public UserGroup createGroup(String id){
        if(!doesIdExist(id))
            return new UserGroup(id);
        return null;//exception
    }

    private boolean doesIdExist(String id){
        UserComponent user = userComponentMap.get(id);
        if(user!=null)
            return true;
        return false;


    }
}
