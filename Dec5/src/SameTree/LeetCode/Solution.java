package SameTree.LeetCode;

import javax.swing.tree.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //first we check whether either of the trees root is null
        if(p==null && q!=null || p!=null && q==null) return false;
        //if both of their root is null return true
        if(p==null && q==null) return true;
        //if their data is not same return false, else call recursion to do the same work
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
