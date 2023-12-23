package isBalanced.LeetCode;

public class RecursiveBFA {
    public boolean isBalanced(TreeNode root) {
        //if root is null then the tree is bydefault balanced
        if(root==null) return true;
        //else we compute the left node height and right node height and check whether they are balanced or not, if not return false
        if(Math.abs(height(root.left)-height(root.right))>1) return false;

        //now we need to recursively check on each node
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }
}

/**
 * Approach 1:
 * here basically at root, we first calculate the left subtree height and right subtree height and check if they are balanced
 * or not, if not return false, else, we call recursion to check whether every node holds this condition or not
 * isBalanced is basically at each node of the binary tree the absolute difference between left and right height should be
 * <=1
 */

/**
 so in this appraoch we calculate the height of left and riht subtrees and if there absolute diff
 is >1 return false, else we check for each node whether it holds the condition or not
 as for isBalanced each node of the tree should be balanced not only the root

 here we call the height function at each node, o(n)
 there are n nodes hence o(n2) tc */
