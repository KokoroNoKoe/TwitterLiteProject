import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserPanelController implements ActionListener{

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
        startTimer();
    }

    public void startTimer() {


        class TimerListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                userPanel.updateNewsFeed(user.getEveryNewsfeed());
            }
        }

        Timer t = new Timer(1000 , new TimerListener() );
        t.start();
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
        userPanel.updateFollowings(user.getEveryFollowingsString());
    }

    public void postPressed(){
        user.post(userPanel.getTweetToPost());
        userPanel.updateNewsFeed(user.getEveryNewsfeed());
    }

}
