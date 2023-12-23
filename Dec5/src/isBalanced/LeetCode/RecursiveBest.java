package isBalanced.LeetCode;

public class RecursiveBest {
    public boolean isBalanced(TreeNode root) {
        return dft(root)!=-1;
    }
    public int dft(TreeNode root){
        //if there is no node, or at null, the height is 0 and the node is balanced
        if(root==null) return 0;
        //else we go postorder, dfs way, move to the last leftmost node
        int left=dft(root.left);
        //now basically, the left variable will hold, either the height of the left subtree or it will hold -1 if the node is
        //not balanced
        if(left==-1) return -1;
        //if the left is not balanced return -1, this indicated false as the tree is not balanced
        //similarly go for right
        int right=dft(root.right);
        if(right==-1) return -1;
        //now we check if both the left and right are balanced at this node or not
        if(Math.abs(left-right)>1) return -1;
        //else return the height
        return 1+Math.max(left,right);
    }
}

/**
 * Approach 3:
 * basically instead of returning a object from down, and as in the approach 1 we went from top to bottom computing height
 * we start from below and return the height, and check the condition in dfs manner
 */
/**
 now we will use the post order way
 we calculate height at each node and return to its previous call, from below
 as we call the recursion before computations

 *basically its a dfs way, we reach to the deepmost node, and then from there we return left and right height, and if the isBal condition is not followed we return -1. else we return the height of the tree
 */
