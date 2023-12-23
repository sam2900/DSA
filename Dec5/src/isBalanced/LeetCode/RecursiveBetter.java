package isBalanced.LeetCode;

public class RecursiveBetter {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return helper(root).isBal;
    }

    public isBalancedReturn helper(TreeNode root){
        //if we are at leaf node's null then height for that node is 0 and it is balanced
        if(root==null) return new isBalancedReturn(0,true);
        //now we need to recursively go to left and right leaf node first
        isBalancedReturn left=helper(root.left);
        isBalancedReturn right=helper(root.right);

        //now first we compute the height
        int height=1+Math.max(left.height,right.height);
        boolean bal=true;
        //now we check, at this particular node the left and right subtrees are balanced or not
        if(Math.abs(left.height-right.height)>1) bal=false;
        //or if they are already not balanced
        if(!left.isBal || !right.isBal) bal=false;

        //return the height and isBal
        return new isBalancedReturn(height,bal);
    }
}
class isBalancedReturn{
    int height;
    boolean isBal;

    public isBalancedReturn(int height, boolean isBal){
        this.height=height;
        this.isBal=isBal;
    }
}
/**
 * Approach 2:
 * here basically at each node we ask 2 things, give me your height and tell me whether you are balanced or not
 * so we need 2 things to return so we create a class
 * we recursively go to left leaf node, and start asking from there, from below to top
 */

/**
 here we first go to the leaf node, then from there at each node we ask 2 things, give height and whether u r balanced or not, so for this we create a class.
 now at the leaf node, we compute height and then we check whether left height and right height holds the condition or not, and after this we check whether the left isbalanced and right isbalanced or not
 and then return the object */
