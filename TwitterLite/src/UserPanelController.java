import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanelController implements ActionListener {

    private String userId;
    private User user;
    private UserPanel userPanel;

    private final String FOLLOW_BUTTON = "FOLLOW";
    private final String POST_BUTTON = "POST";


    public UserPanelController(UserPanel userPanel, User user) {
        this.user = user;
        this.userId = user.getId();
        this.userPanel = userPanel;
        userPanel.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String source = e.getActionCommand();

        switch (source) {
            case (FOLLOW_BUTTON):
                followPressed();
                break;

            case (POST_BUTTON):
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
