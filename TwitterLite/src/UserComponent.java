import javax.swing.tree.DefaultMutableTreeNode;

public abstract class UserComponent {

    protected DefaultMutableTreeNode treeNode;

    public DefaultMutableTreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(DefaultMutableTreeNode node){
        this.treeNode = node;
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
