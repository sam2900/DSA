package DiameterOfBT.Leetcode;

import javax.swing.tree.TreeNode;

public class RecursiveBetter {
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).diameter;
        //this function will return an object, so we need to get the diameter from it
    }
    public DiameterReturn helper(TreeNode root){
        //if root is null, then height is 0 and diameter is also 0
        if(root==null) return new DiameterReturn(0,0);
        //now we call recursively to left and right, to reach last node and start computation from there
        DiameterReturn left=helper(root.left);
        DiameterReturn right=helper(root.right);
        //now we compute the diameter using the left height and right height

        int d=left.height+right.height;
        //now the diameter can be either this, or it can be present on either subtrees
        d=Math.max(d,Math.max(left.diameter,right.diameter));
        //now we have the diameter which we need to return, so we now need to compute the height for this present node
        int height=Math.max(left.height,right.height)+1;
        return new DiameterReturn(height,d);
    }
}
class DiameterReturn{
    int height;
    int diameter;

    public DiameterReturn(int height, int diameter){
        this.height=height;
        this.diameter=diameter;
    }
}

/**
 basically there are 2 things, either left height + right height or the diameter is on either side of the tree
 before we used bfa to visit each node and calculate height
 this time we use dfs way, we reach the leaf left node, and from below we start calculating the height as well as diameter, and return the max to the callee */
