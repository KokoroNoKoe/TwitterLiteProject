import com.sun.deploy.uitoolkit.impl.awt.ui.SwingConsoleWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AdminControlPanel extends JPanel {

    public static AdminControlPanel instance = null;

    private JPanel treeViewPanel;
    private JTree treeView;

    private JButton addUserBtn, addGroupBtn, openUserViewBtn,
            showUserTotalBtn, showGroupTotalBtn, showMsgTotalBtn, showPosMsgNumBtn;

    private JTextArea userIdTextArea, groupITextArea;


    private AdminControlPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(400,400));
        createComponents();
        setLayout();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

    }

    public void setController(ActionListener listener){
        addUserBtn.addActionListener(listener);
        addGroupBtn.addActionListener(listener);
        openUserViewBtn.addActionListener(listener);
        showUserTotalBtn.addActionListener(listener);
        showGroupTotalBtn.addActionListener(listener);
        showMsgTotalBtn.addActionListener(listener);
        showPosMsgNumBtn.addActionListener(listener);

    }


    private void createComponents() {

        treeViewPanel = new JPanel();
        treeViewPanel.setPreferredSize(new Dimension(75,400));

        addUserBtn = new JButton("Add User");
        addGroupBtn = new JButton("Add Group");
        openUserViewBtn = new JButton("Open User View");
        showUserTotalBtn = new JButton("Show Total Users");
        showGroupTotalBtn = new JButton("Show Total Groups");
        showMsgTotalBtn = new JButton("Show Total Messages");
        showPosMsgNumBtn = new JButton("Show Total Positives");

        userIdTextArea = new JTextArea("enter user id");
        groupITextArea = new JTextArea("enter group id");

    }


    private void setLayout() {

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);


        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(treeViewPanel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(userIdTextArea)
                                .addComponent(groupITextArea)
                                .addComponent(openUserViewBtn)
                                .addComponent(showUserTotalBtn)
                                .addComponent(showMsgTotalBtn))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(addUserBtn)
                                .addComponent(addGroupBtn)
                                .addComponent(showGroupTotalBtn)
                                .addComponent(showPosMsgNumBtn))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, showGroupTotalBtn, showMsgTotalBtn, showPosMsgNumBtn, showUserTotalBtn, openUserViewBtn);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(treeViewPanel)
                                .addComponent(userIdTextArea)
                                .addComponent(addUserBtn))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(groupITextArea)
                                .addComponent(addGroupBtn))
                        .addComponent(openUserViewBtn)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(showUserTotalBtn)
                                .addComponent(showGroupTotalBtn))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(showMsgTotalBtn)
                                .addComponent(showPosMsgNumBtn))
        );

    }


    //Singleton
    public static AdminControlPanel getInstance() {
        if (instance == null)
            return new AdminControlPanel();
        return instance;
    }
}
