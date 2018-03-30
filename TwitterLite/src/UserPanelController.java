import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class UserPanelController implements ActionListener, Acceptor {

    private String userId;
    private User user;
    private UserPanel userPanel;

    private final String FOLLOW_BUTTON = "Follow";
    private final String POST_BUTTON = "Post";
    private final String TRICK = "class javax.swing.JTextArea";


    public UserPanelController(UserPanel userPanel, User user) {
        this.user = user;
        this.userId = user.getId();
        this.userPanel = userPanel;
        this.userPanel.setController(this);
        this.userPanel.setFocusFollowListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                userPanel.focusUserId();
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (userPanel.getUserIdTextArea().equals(""))
                    userPanel.unfocusUserId();
            }
        });
        this.userPanel.setFocusTweetListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                userPanel.focusTweet();
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (userPanel.getTweetTextArea().equals(""))
                    userPanel.unfocusTweer();
            }
        });

        startTimer();
    }

    public void startTimer() {


        class TimerListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                userPanel.updateNewsFeed(user.getEveryNewsFeed());
                userPanel.updateFollowings(user.getEveryFollowingsString());
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
                userPanel.unfocusUserId();
                break;

            case (POST_BUTTON):
                postPressed();
                break;
        }
    }

    public void followPressed(){
        user.follow(userPanel.getUserId());
        userPanel.updateFollowings(user.getEveryFollowingsString());
        userPanel.unfocusUserId();
    }

    public void postPressed(){
        user.post(userPanel.getTweetToPost());
        userPanel.updateNewsFeed(user.getEveryNewsFeed());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
