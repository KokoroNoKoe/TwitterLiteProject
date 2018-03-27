import javax.swing.tree.DefaultMutableTreeNode;

public abstract class UserComponent {
    //nothing
    //just for Composite Pattern

    protected DefaultMutableTreeNode treeNode;

    public DefaultMutableTreeNode getTreeNode() {
        return treeNode;
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}