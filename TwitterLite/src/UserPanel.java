import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class UserPanel extends JPanel {

    private JPanel currentFollowingsPanel, newsFeedPanel;
    private JScrollPane followingScrollPane, newsFeedScrollPane;
    private JLabel followingsLabel, newsFeedLabel;
    private JTextArea userIdTextArea, tweetTextArea;
    private JButton followBtn, postBtn;

    private Color bluish = new Color(179,230,255),
                greenish = new Color(204,255,153),
                purplish = new Color(153,51,255);

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
        followingsLabel.setBorder(BorderFactory.createEtchedBorder());
        followingScrollPane = new JScrollPane(followingsLabel);
        followingScrollPane.setPreferredSize(new Dimension(260,140));
        newsFeedPanel = new JPanel();
        newsFeedLabel = new JLabel("News Feed");
        newsFeedLabel.setBorder(BorderFactory.createEtchedBorder());
        newsFeedScrollPane = new JScrollPane(newsFeedLabel);
        newsFeedScrollPane.setPreferredSize(new Dimension(260,140));
        userIdTextArea = new JTextArea("User Id");
        userIdTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        userIdTextArea.setBackground(greenish);
        tweetTextArea = new JTextArea("tweet here");
        tweetTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tweetTextArea.setBackground(greenish);
        followBtn = new JButton("Follow");
        followBtn.setPreferredSize(new Dimension(200,50));
        followBtn.setBorderPainted(true);
        postBtn = new JButton("Post");
        postBtn.setPreferredSize(new Dimension(200,50));

        currentFollowingsPanel.setBackground(bluish);
        newsFeedPanel.setBackground(bluish);
        this.setBackground(purplish);

    }

    private void setLayout() {

        currentFollowingsPanel.add(followingScrollPane);
        newsFeedPanel.add(newsFeedScrollPane);

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
