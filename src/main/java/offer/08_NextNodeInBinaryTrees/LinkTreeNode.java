/**
 * Definition for a binary tree node.
 *
 * @author lisong@cestc.cn
 * @date 2021/7/8
 */
public class LinkTreeNode {
    int val;
    LinkTreeNode left;
    LinkTreeNode right;
    LinkTreeNode parent;

    public LinkTreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkTreeNode getLeft() {
        return left;
    }

    public void setLeft(LinkTreeNode left) {
        this.left = left;
    }

    public LinkTreeNode getRight() {
        return right;
    }

    public void setRight(LinkTreeNode right) {
        this.right = right;
    }

    public LinkTreeNode getParent() {
        return parent;
    }

    public void setParent(LinkTreeNode parent) {
        this.parent = parent;
    }
}
