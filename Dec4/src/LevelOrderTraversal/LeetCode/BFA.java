package LevelOrderTraversal.LeetCode;

public class BFA {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //create a list of list
        List<List<Integer>> list=new ArrayList<>();
        //if root is null return the empty list
        if(root==null) return list;
        //create a Q for BFT
        Queue<TreeNode> q=new LinkedList<>();
        //add the root
        q.offer(root);
        //now run the while loop till q is not empty
        //for each iteration, the current q size will be the number of nodes at that particular level
        while(!q.isEmpty()){
            //create a new list for a particular level
            List<Integer> level=new ArrayList<>();
            int size=q.size();
            //this size is the number of nodes present at the current level
            //run a for loop and add all the elements
            for(int i=0;i<size;i++){
                TreeNode currNode=q.poll();
                level.add(currNode.val);
                if(currNode.left!=null) q.offer(currNode.left);
                if(currNode.right!=null) q.offer(currNode.right);
            }
            //add the level list into the main list
            list.add(level);
        }
        return list;
    }
}
