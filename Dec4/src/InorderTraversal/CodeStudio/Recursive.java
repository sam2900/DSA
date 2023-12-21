package InorderTraversal.CodeStudio;

public class Recursive {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        return inorder;
    }

    public static void inOrder(TreeNode node , List<Integer> list ){
        if(node == null) return;
        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);
    }
}
