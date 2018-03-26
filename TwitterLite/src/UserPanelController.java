import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanelController implements ActionListener {

    private String userId;
    private User user;
    private UserPanel userPanel;

    private final String FOLLOW_BUTTON = "FOLLOW";
    private final String POST_BUTTON = "POST";


    public UserPanelController() {
        userPanel = new UserPanel();
        userPanel.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String source = e.getActionCommand();

        switch (source) {
            case (FOLLOW_BUTTON):

                break;
            case (POST_BUTTON):

                break;
        }


    }
    public void update() {

    }


}
