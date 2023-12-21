package CNTreeTraversal;

public class BFA {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        inOrder(root,inorder);
        preOrder(root,preorder);
        postOrder(root,postorder);
        ans.add(inorder);
        ans.add(preorder);
        ans.add(postorder);
        return ans;
    }

    public static void inOrder(TreeNode root,List<Integer> inorder ){
        if(root==null) return;
        inOrder(root.left,inorder);
        inorder.add(root.data);
        inOrder(root.right, inorder);

    }
    public static void preOrder(TreeNode root,List<Integer> preorder ){
        if(root==null) return;
        preorder.add(root.data);
        preOrder(root.left, preorder);
        preOrder(root.right, preorder);

    }
    public static void postOrder(TreeNode root,List<Integer> postorder ){
        if(root==null) return;
        postOrder(root.left, postorder);
        postOrder(root.right, postorder);
        postorder.add(root.data);

    }
}
