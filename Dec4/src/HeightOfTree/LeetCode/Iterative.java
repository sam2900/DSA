package HeightOfTree.LeetCode;

public class Iterative {
    public int maxDepth(TreeNode root) {
        //another approach can be counting number of levels, using BFT
        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode front=q.poll();
                if(front.left!=null) q.offer(front.left);
                if(front.right!=null) q.offer(front.right);
            }
            level++;
        }
        return level;
    }
}

/**
 * basically here we do a level order or bf traversal, in which we calculate the number of levels by fixing the size
 * for each iteration and running a loop for that size after the inner loop, 1 level is completed
 * TC: O(n) + SC: O(n) -> q */

