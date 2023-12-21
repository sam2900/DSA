package HeightOfTree.LeetCode;

public class Recursive {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        //this is using recursion, in post order manner
        //we ask the left and right subtrees to give their height and then we return the maximum of these + 1
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
/**
 * at leaf node what happens is, it call on left null and right null, both of them returns 0
 * now at the leaf node the max will be 0 + 1 -> this we return and this keeps on happening
 * TC: O(n) as we visit each node exactly once */
