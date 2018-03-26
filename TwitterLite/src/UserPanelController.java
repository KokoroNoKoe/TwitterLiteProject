import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanelController implements ActionListener {

    private String userId;
    private User user;
    private UserPanel userPanel;

    private final String FOLLOW_BUTTON = "Follow";
    private final String POST_BUTTON = "Post";


    public UserPanelController(UserPanel userPanel, User user) {
        this.user = user;
        this.userId = user.getId();
        this.userPanel = userPanel;
        this.userPanel.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String source = e.getActionCommand();
        System.out.println(source);
        System.out.println("action performed");

        switch (source) {
            case (FOLLOW_BUTTON):
                System.out.println(FOLLOW_BUTTON);
                followPressed();
                break;

            case (POST_BUTTON):
                System.out.println(POST_BUTTON);
                postPressed();
                break;
        }

    }

    public void followPressed(){
        user.follow(userPanel.getUserId());
    }

    public void postPressed(){
        user.addFeed(userPanel.getTweetToPost());
    }




    public void update() {

    }


}
