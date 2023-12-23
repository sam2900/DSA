package DiameterOfBT.Leetcode;

public class RecursiveBFA {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        //the diameter is 0
        //compute the left height+right height diameter
        int d=height(root.left)+height(root.right);
        //get the diameters on the left and right subtrees
        int diam=Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));

        //return the max of these
        return Math.max(d,diam);
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
/**
 * Approach 1:
 * here basically the answer will be either, left + right height, or there can be a possibility the farthest nodes are present
 * in the left or right subtrees, so we consider left and right diameter too
 * so we need to compute height and recursively go to each node, and then ask the diameter
 * tc: O(N2) */

/**
 here basically we are calling both height and diameter function at each node so the TC increases better way can be we start from bottom, like we reach the bottom most leaf node and start calculation from there */

