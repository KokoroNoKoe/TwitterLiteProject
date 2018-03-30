import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AdminControlPanel extends JPanel {

    private static AdminControlPanel instance = null;

    private JPanel treeViewPanel;
    private JTree userTree;
    private JScrollPane treeScrollPane;
    private JButton addUserBtn, addGroupBtn, openUserViewBtn,
            showUserTotalBtn, showGroupTotalBtn, showMsgTotalBtn, showPosMsgNumBtn;
    private JTextArea userIdTextArea, groupITextArea;
    private JLabel infoLabel;
    private Color bluish = new Color(179,230,255),
            greenish = new Color(204,255,153);

    private AdminControlPanel(DefaultMutableTreeNode root) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(530, 500));
        createComponents(root);
        setLayout();


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

    }

    public String getUserId() {
        return userIdTextArea.getText();
    }

    public String getGroupId() {
        return groupITextArea.getText();
    }

    public void setInfoLabel(String msg) {
        infoLabel.setText(msg);
    }

    public void setController(ActionListener listener) {
        addUserBtn.addActionListener(listener);
        addGroupBtn.addActionListener(listener);
        openUserViewBtn.addActionListener(listener);
        showUserTotalBtn.addActionListener(listener);
        showGroupTotalBtn.addActionListener(listener);
        showMsgTotalBtn.addActionListener(listener);
        showPosMsgNumBtn.addActionListener(listener);

        userTree.addTreeSelectionListener((TreeSelectionListener)listener);

    }

    public void setUserFocusListener(FocusListener listener) {
        userIdTextArea.addFocusListener(listener);
    }

    public void setGroupFocusListener(FocusListener listener) {
        groupITextArea.addFocusListener(listener);
    }

    public void focusUserTextArea() {
        userIdTextArea.setText("");
    }

    public void unfocusUserTextArea() {
        userIdTextArea.setText("Enter a new user name...");
    }

    public void focusGroupTextArea() {
        groupITextArea.setText("");
    }

    public void unfocusGroupTextArea() {
        groupITextArea.setText("Enter a new group name...");
    }

    public void updateTree() {
        DefaultTreeModel model = (DefaultTreeModel) userTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        model.reload(root);
    }

    private void createComponents(DefaultMutableTreeNode root) {

        treeViewPanel = new JPanel();
        treeViewPanel.setPreferredSize(new Dimension(200, 200));
        treeScrollPane = new JScrollPane();

        userTree = new JTree(root);
        userTree.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        userTree.setBackground(greenish);

        treeScrollPane.getViewport().setView(userTree);
        treeScrollPane.setPreferredSize(new Dimension(130, 260));

        treeViewPanel.add(treeScrollPane);

        addUserBtn = new JButton("Add User");
        addGroupBtn = new JButton("Add Group");
        openUserViewBtn = new JButton("Open User View");
        showUserTotalBtn = new JButton("Show Total Users");
        showGroupTotalBtn = new JButton("Show Total Groups");
        showMsgTotalBtn = new JButton("Show Total Messages");
        showPosMsgNumBtn = new JButton("Show Total Positives");

        userIdTextArea = new JTextArea("Enter a new user name...");
        userIdTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        userIdTextArea.setBackground(greenish);
        groupITextArea = new JTextArea("Enter a new group name...");
        groupITextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        groupITextArea.setBackground(greenish);

        infoLabel = new JLabel("App Info");
        infoLabel.setBorder(BorderFactory.createEtchedBorder());

        this.setBackground(bluish);

    }

    private void setLayout() {

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(treeViewPanel)
                                .addComponent(infoLabel))
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
                                .addComponent(infoLabel)
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
    public static AdminControlPanel getInstance(DefaultMutableTreeNode node) {
        if (instance == null)
            return new AdminControlPanel(node);
        return instance;
    }
}
