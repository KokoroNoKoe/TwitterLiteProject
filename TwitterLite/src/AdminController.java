import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class AdminController implements ActionListener{
    private static AdminController instance = null;

    private AdminControlPanel adminControlPanel;
    private UserComponentFactory userComponentFactory = new UserComponentFactory();
    private UserDatabase userDatabase = new UserDatabase();
    private UserGroup root = userComponentFactory.createGroup("Root");

    private final String OPEN_USER_VIEW_BUTTON = "Open User View";
    private final String SHOW_USER_TTL_BUTTON = "Show Total Users";
    private final String SHOW_GRP_TTL_BUTTON = "Show Total Groups";
    private final String SHOW_MSG_TTL_BUTTON = "Show Total Messages";
    private final String SHOW_POS_MSG_BUTTON = "Show Total Positives";
    private final String ADD_USER = "Add User";
    private final String ADD_GROUP = "Add Group";


    public AdminController() {
        System.out.println("Admin controller");
        adminControlPanel = AdminControlPanel.getInstance();
        adminControlPanel.setController(this);

        userDatabase.addRoot(root);

    }

    public void openUserView(String id) {

    }

    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();

        String groupId;
        String userId;


        switch (source) {

            case (OPEN_USER_VIEW_BUTTON):
                    new UserPanelController();
                break;
            case (SHOW_USER_TTL_BUTTON):
                System.out.println("TOTAL USERS: " + userDatabase.getNumOfUsers());
                root.print();
                //adminControlPanel.set
                break;
            case (SHOW_GRP_TTL_BUTTON):
                System.out.println("TOTAL GROUPS: " + userDatabase.getNumOfGroups());
                break;
            case (SHOW_MSG_TTL_BUTTON):
                System.out.println("TOTAL MESSAGES: ");
                break;
            case (SHOW_POS_MSG_BUTTON):
                System.out.println("POSITIVE MESSAGES: ");
                break;
            case (ADD_USER):
                userId = adminControlPanel.getUserId();
                groupId = adminControlPanel.getGroupId();
                UserGroup group = userDatabase.findGroup(groupId);
                if (group == null) {
                    System.out.println("Group does not exist");
                } else {
                    userDatabase.addUser(userId, userComponentFactory.createUser(userId),group);
                }
                break;
            case (ADD_GROUP):
                groupId = adminControlPanel.getGroupId();
                System.out.println("Enter a group id :");
                Scanner scan = new Scanner(System.in);
                String parent = scan.nextLine();
                UserGroup parentGroup= userDatabase.findGroup(parent);
                if (parent == null) {
                    System.out.println("Group does not exist");
                } else {
                    userDatabase.addGroup(groupId,userComponentFactory.createGroup(groupId), parentGroup);
                }


                break;

        }
    }


    //Singleton
    public static AdminController getInstance(){
        if(instance == null)
            return new AdminController();
        return instance;
    }

}
