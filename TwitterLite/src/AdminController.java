import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AdminController implements ActionListener, TreeSelectionListener, Acceptor {
    private static AdminController instance = null;

    private AdminControlPanel adminControlPanel;
    private UserDatabase userDatabase = UserDatabase.getInstance();
    private UserDBMS userDBMS = UserDBMS.getInstance(userDatabase);
    private UserComponentFactory userComponentFactory = new UserComponentFactory(userDBMS);
    private UserGroup root;
    private String currentSelectedNodeId;

    private final String OPEN_USER_VIEW_BUTTON = "Open User View";
    private final String SHOW_USER_TTL_BUTTON = "Show Total Users";
    private final String SHOW_GRP_TTL_BUTTON = "Show Total Groups";
    private final String SHOW_MSG_TTL_BUTTON = "Show Total Messages";
    private final String SHOW_POS_MSG_BUTTON = "Show Total Positives";
    private final String ADD_USER = "Add User";
    private final String ADD_GROUP = "Add Group";


    public AdminController() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
        System.out.println("Admin controller");
        adminControlPanel = AdminControlPanel.getInstance(rootNode);
        adminControlPanel.setController(this);
        adminControlPanel.setUserFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                adminControlPanel.focusUserTextArea();
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (adminControlPanel.getUserId().equals(""))
                    adminControlPanel.unfocusUserTextArea();
            }
        });
        adminControlPanel.setGroupFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                adminControlPanel.focusGroupTextArea();
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (adminControlPanel.getGroupId().equals(""))
                    adminControlPanel.unfocusGroupTextArea();
            }
        });
        root = userComponentFactory.createGroup("Root", rootNode);


        userDatabase.addRoot(root);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();

        switch (source) {

            case (OPEN_USER_VIEW_BUTTON):
                openUserViewButtonPressed();
                break;

            case (SHOW_USER_TTL_BUTTON):
                adminControlPanel.setInfoLabel("<html>TOTAL<br>USERS:  " + userDatabase.getNumOfUsers() + "</html>");
                root.print();
                System.out.println();
                break;

            case (SHOW_GRP_TTL_BUTTON):
                adminControlPanel.setInfoLabel("<html>TOTAL<br>GROUPS:  " + userDatabase.getNumOfGroups() + "</html>");
                break;

            case (SHOW_MSG_TTL_BUTTON):
                adminControlPanel.setInfoLabel("<html>TOTAL<br>MESSAGE:  " + userDatabase.getNumOfTweets() + "</html>");
                break;

            case (SHOW_POS_MSG_BUTTON):
                adminControlPanel.setInfoLabel("<html>POSITIVE<br>MESSAGE:  " + userDatabase.getNumOfPositiveMsg() + "</html>");
                break;

            case (ADD_USER):
                addUser();
                adminControlPanel.unfocusUserTextArea();
                break;

            case (ADD_GROUP):
                addGroup();
                adminControlPanel.unfocusGroupTextArea();
                break;

        }

    }

    @Override // JTree listener
    public void valueChanged(TreeSelectionEvent e) {
        Object obj = e.getPath().getLastPathComponent(); // Look here!
        if (obj instanceof DefaultMutableTreeNode) {
            currentSelectedNodeId = (String) ((DefaultMutableTreeNode) obj).getUserObject();
        }
    }

    public void openUserViewButtonPressed() {
        String userId = currentSelectedNodeId;
        User user = userDatabase.getUserFromDatabase(userId);
        if (user == null) {
            adminControlPanel.setInfoLabel("The user does not exist");
        } else {
            new UserPanelController(new UserPanel(user.getId()), user);

        }
    }

    public void addUser() {
        String userId = adminControlPanel.getUserId();
        String groupId = currentSelectedNodeId;
        UserGroup group = userDatabase.findGroup(groupId);
        if (group == null) {
            adminControlPanel.setInfoLabel("Group does not exist");
        } else {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(userId);
            User user = userComponentFactory.createUser(userId, node);

            if (userDatabase.addUser(userId, user, group)) {
                adminControlPanel.updateTree();
            }
        }
    }

    public void addGroup() {
        String groupId = adminControlPanel.getGroupId();
        String parent = currentSelectedNodeId;
        if (parent.equals("Root"))
            parent = "Root";
        UserGroup parentGroup = userDatabase.findGroup(parent);
        if (parent == null) {
            adminControlPanel.setInfoLabel("Group does not exist");
        } else {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(groupId);
            UserGroup group = userComponentFactory.createGroup(groupId, node);//creates a group
            if (userDatabase.addGroup(groupId, group, parentGroup)) {
                adminControlPanel.updateTree();
            }
        }
    }

    //Singleton
    public static AdminController getInstance() {
        if (instance == null)
            return new AdminController();
        return instance;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
