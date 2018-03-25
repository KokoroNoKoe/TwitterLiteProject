import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class UserPanel extends JPanel {

    private JPanel currentFollowingsPanel, newsFeedPanel;
    private JTextArea userIdTextArea, tweetTextArea;
    private JButton followBtn, postBtn;

    public UserPanel() {
        createComponents();

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(400, 400));
        createComponents();
        setLayout();

        JFrame frame = new JFrame();
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

    }

    public void setController(ActionListener controller){
        followBtn.addActionListener(controller);
        postBtn.addActionListener(controller);
    }

    private void createComponents() {
        currentFollowingsPanel = new JPanel();
        newsFeedPanel = new JPanel();
        userIdTextArea = new JTextArea("User Id");
        tweetTextArea = new JTextArea("tweet here");
        followBtn = new JButton("Follow");
        postBtn = new JButton("Post");

        currentFollowingsPanel.setBackground(Color.BLUE);
        newsFeedPanel.setBackground(Color.RED);


    }



    public void setLayout() {

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
