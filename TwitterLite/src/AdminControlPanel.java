import com.sun.deploy.uitoolkit.impl.awt.ui.SwingConsoleWindow;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AdminControlPanel extends JPanel {

    public static AdminControlPanel instance = null;

    private JPanel treeViewPanel;
    private JScrollPane treeScrollPane;
    private JTree userTree;

    private JButton addUserBtn, addGroupBtn, openUserViewBtn,
            showUserTotalBtn, showGroupTotalBtn, showMsgTotalBtn, showPosMsgNumBtn;

    private JTextArea userIdTextArea, groupITextArea;

    private JLabel infoLabel;

    private AdminControlPanel(DefaultMutableTreeNode root) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(500, 500));
        createComponents(root);
        setLayout();


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

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


    public String getUserId() {
        return userIdTextArea.getText();
    }

    public String getGroupId() {
        return groupITextArea.getText();
    }

    public JTree getUserTree() {
        return userTree;
    }

    public void setInfoLabel(String msg) {
        infoLabel.setText(msg);
    }

    public void createTree(DefaultMutableTreeNode treeNode) {
        DefaultTreeModel model = (DefaultTreeModel) userTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.add(treeNode);
        model.reload(root);
        // treeScrollPane = new JScrollPane();
        //treeScrollPane.getViewport().setView(userTree);

        //treeViewPanel.add(treeScrollPane);
    }
/*
    public void updateTreeOld(DefaultMutableTreeNode treeNode){
        DefaultTreeModel model = (DefaultTreeModel) userTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        root.add(treeNode);
        model.reload(root);
    }
    */

    public void updateTree() {
        DefaultTreeModel model = (DefaultTreeModel) userTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        model.reload(root);
    }

    private void createComponents(DefaultMutableTreeNode root) {

        treeViewPanel = new JPanel();
        treeViewPanel.setPreferredSize(new Dimension(200, 200));
        treeScrollPane = new JScrollPane();

        //DefaultMutableTreeNode yuki = new DefaultMutableTreeNode("Yuki");
        //root.add(yuki);

        userTree = new JTree(root);

        treeScrollPane.getViewport().setView(userTree);
        treeScrollPane.setPreferredSize(new Dimension(100, 190));

        treeViewPanel.add(treeScrollPane);


        addUserBtn = new JButton("Add User");
        addGroupBtn = new JButton("Add Group");
        openUserViewBtn = new JButton("Open User View");
        showUserTotalBtn = new JButton("Show Total Users");
        showGroupTotalBtn = new JButton("Show Total Groups");
        showMsgTotalBtn = new JButton("Show Total Messages");
        showPosMsgNumBtn = new JButton("Show Total Positives");

        userIdTextArea = new JTextArea("idName");
        groupITextArea = new JTextArea("Root");

        infoLabel = new JLabel("App Info");

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
