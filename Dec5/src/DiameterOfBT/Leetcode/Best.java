package DiameterOfBT.Leetcode;

import javax.swing.tree.TreeNode;

public class Best {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] d=new int[1];
        dfs(root,d);
        //if root is null then by default d is initialise as 0
        return d[0];
    }
    public int dfs(TreeNode root,int[] d){
        if(root==null) return 0;
        //here basically for each node, we compute left and right height
        //compare it to the d
        //and then return the height of the present node
        int leftHeight=dfs(root.left,d);
        int rightHeight=dfs(root.right,d);
        //compare the diameter
        d[0]=Math.max(d[0],leftHeight+rightHeight);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
/**
 *Approach 3:
 * here basically we are doing the same thing, we are computing height, but this time in a DFS/Postorder fashion
 * we recursively go to the left and right node, get the height and for each recursion call we maintain a universal element
 * so if, the farthest nodes are present in any of the subtrees, their compution anyhow happens with height only, but in their
 * recursive call they will be considered as max  */

/**
 if they ask not to use another class then, we use post order dfs way
 here we maintain a universal arr of size 1 to store the maximum diameter at each call
 we basically use the height concept only, but maintaining a universal element helps
 we compute height from bottom to top, then we check whethe this lh+rh > prvs found max diameter or not
 and update accordingly and return the present height */
