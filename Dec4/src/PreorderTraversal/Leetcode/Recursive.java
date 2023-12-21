package PreorderTraversal.Leetcode;

public class Recursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
    /**
     so here we create a list and pass it to the helper function so that we can have access to the same
     list through out the recursion calls, and just return that list
     preorder is visiting the root first then the childrens in left to right manner
     */
}
