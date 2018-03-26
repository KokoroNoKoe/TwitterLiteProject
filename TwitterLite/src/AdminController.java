import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController implements ActionListener{
    private static AdminController instance = null;

    private AdminControlPanel adminControlPanel;
    private UserComponentFactory userComponentFactory = new UserComponentFactory();
    private UserDatabase userDatabase = new UserDatabase();

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
    }





    public void openUserView(String id) {

    }

    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();


        switch (source) {

            case (OPEN_USER_VIEW_BUTTON):
                    new UserPanelController();
                break;
            case (SHOW_USER_TTL_BUTTON):
                System.out.println("TOTAL USERS: " + userDatabase.getNumOfUsers());
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
                String userId = adminControlPanel.getUserId();
                userDatabase.addUser(userId,userComponentFactory.createUser(userId));
                break;
            case (ADD_GROUP):
                String groupId = adminControlPanel.getGroupId();
                userDatabase.addGroup(groupId,userComponentFactory.createGroup(groupId));
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
