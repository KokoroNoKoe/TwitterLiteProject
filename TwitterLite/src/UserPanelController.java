import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanelController implements ActionListener {

    private String userId;
    private User user;
    private UserPanel userPanel;

    public UserPanelController() {
        this.userPanel = new UserPanel();
        userPanel.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
    public void update() {

    }
}
