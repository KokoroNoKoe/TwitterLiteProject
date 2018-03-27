import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class UserPanel extends JPanel {

    private JPanel currentFollowingsPanel, newsFeedPanel;
    private JLabel followingsLabel, newsFeedLabel;
    private JTextArea userIdTextArea, tweetTextArea;
    private JButton followBtn, postBtn;



    public UserPanel(String title) {
        createComponents();

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(400, 400));
        createComponents();
        setLayout();

        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2,dim.height/2-frame.getSize().height/2);
    }

    public void setController(ActionListener controller){
        followBtn.addActionListener(controller);
        postBtn.addActionListener(controller);
    }


    public String getUserId(){
        return userIdTextArea.getText();
    }

    public String getTweetToPost(){
        return tweetTextArea.getText();
    }


    public void updateFollowings(String followingsList){
        followingsLabel.setText(followingsList);
    }

    public void updateNewsFeed(String newsFeed) {
        newsFeedLabel.setText(newsFeed);
    }


    private void createComponents() {
        currentFollowingsPanel = new JPanel();
        followingsLabel = new JLabel("Followings");
        newsFeedPanel = new JPanel();
        newsFeedLabel = new JLabel("News Feed");
        userIdTextArea = new JTextArea("User Id");
        tweetTextArea = new JTextArea("tweet here");
        followBtn = new JButton("Follow");
        postBtn = new JButton("Post");


        currentFollowingsPanel.setBackground(Color.CYAN);
        newsFeedPanel.setBackground(Color.CYAN);


    }

    private void setLayout() {

        currentFollowingsPanel.add(followingsLabel);
        newsFeedPanel.add(newsFeedLabel);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(userIdTextArea)
                                .addComponent(currentFollowingsPanel)
                                .addComponent(tweetTextArea)
                                .addComponent(newsFeedPanel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(followBtn)
                                .addComponent(postBtn)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(userIdTextArea)
                                .addComponent(followBtn))
                        .addComponent(currentFollowingsPanel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(tweetTextArea)
                                .addComponent(postBtn))
                        .addComponent(newsFeedPanel)
        );
    }
}
