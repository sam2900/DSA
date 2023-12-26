public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        /**
        here basically we create a list of lists first, then add a empty list and call inorder()
        now in inorder, we add the nodes at list(0)
        and then add another list, and call preorder and so on
        */
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());
        inorder(root,list);
        list.add(new ArrayList<>());
        preorder(root,list);
        list.add(new ArrayList<>());
        postorder(root,list);
        return list;
    }   

    public static void inorder(TreeNode root, List<List<Integer>> list){
        if(root==null) return;
        inorder(root.left,list);
        list.get(0).add(root.data);
        inorder(root.right,list);
    }
    public static void preorder(TreeNode root, List<List<Integer>> list){
        if(root==null) return;
        list.get(1).add(root.data);
        preorder(root.left,list);
        preorder(root.right,list);
    }
    public static void postorder(TreeNode root, List<List<Integer>> list){
        if(root==null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.get(2).add(root.data);
    }
}
