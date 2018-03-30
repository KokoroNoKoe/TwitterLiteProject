import javax.swing.tree.DefaultMutableTreeNode;

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
