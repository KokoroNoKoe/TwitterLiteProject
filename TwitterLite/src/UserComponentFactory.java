import javax.swing.tree.DefaultMutableTreeNode;

/**
 * This class produces an instance of a User or a Group.
 * The creation method accepts an id and the DefaultMutableTreeNode which has the id in it.
 *
 * @author Yuki Yamada
 * @author Aleix Molla
 * @version 2018/03/30
 */
public class UserComponentFactory {

    private UserDBMS userDBMS;

    public UserComponentFactory(UserDBMS userDBMS) {
        this.userDBMS = userDBMS;
    }

    public User createUser(String id, DefaultMutableTreeNode node) {
        User user = new User(id);
        user.setUserDBMS(userDBMS);
        user.setTreeNode(node);
        return user;
    }

    public UserGroup createGroup(String id, DefaultMutableTreeNode node) {
        UserGroup group = new UserGroup(id);
        group.setTreeNode(node);
        return group;
    }

}
