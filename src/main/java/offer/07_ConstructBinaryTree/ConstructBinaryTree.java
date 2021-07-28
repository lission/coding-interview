import java.util.HashMap;

/**
 * TODO
 *
 * @author lisong@cestc.cn
 * @date 2021/7/8
 */
public class ConstructBinaryTree {

    /*
     * 前序遍历第一个值是根节点，
     * 在中序遍历中，根节点在序列中间，左子树节点的值在根节点左侧，右子树节点的值在根节点右侧。
     * 在前序遍历中，同样可以确定左子树节点和右子树节点的值。
     * 分别找到了左、右子树的前序遍历序列和中序遍历序列，可以采用递归的方法去分别构建左、右子树
     */

    public static void main(String[] args) {
        ConstructBinaryTree binaryTree = new ConstructBinaryTree();
        TreeNode treeNode = binaryTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //传参有效性校验
        if (preorder == null || preorder.length <= 0 || inorder == null || inorder.length <= 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        //中序遍历定位根节点位置,缓存中序遍历，方便获取根节点位置
        HashMap<Integer, Integer> hashMap = new HashMap<>(inorder.length);

        for (int i=0;i<inorder.length;i++) {
            hashMap.put(inorder[i],i);
        }
        return constructCore(hashMap,preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode constructCore(HashMap<Integer, Integer> hashMap, int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
        if (startPre > endPre) {
            return null;
        }
        //前序遍历第一个数字为根节点值
        int rootValue = preorder[startPre];
        TreeNode rootNode = new TreeNode(rootValue);
        rootNode.left = null;
        rootNode.right = null;
        //中序遍历定位根节点位置
        int inorderRoot = hashMap.get(rootValue);
        //得到左子树节点数目
        int leftSize = inorderRoot - startIn;
        //递归构造左子树，并连接到根节点
        //前序左子树，中序左子树
        rootNode.left = constructCore(hashMap,preorder, startPre + 1, startPre + leftSize, inorder, startIn, inorderRoot - 1);
        //递归构造右子树，并连接到根节点
        //前序右子树，中序右子树
        rootNode.right = constructCore(hashMap,preorder, startPre + leftSize + 1, endPre, inorder, inorderRoot+1, endIn);
        return rootNode;
    }
}
