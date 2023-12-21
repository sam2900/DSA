package LevelOrderTraversal.CodeStudio;

public class BFA {
    public static List<Integer> levelOrder(TreeNode<Integer> root){
        // Write your code here.
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode<Integer> currNode=q.poll();
            list.add(currNode.data);
            if(currNode.left!=null) q.offer(currNode.left);
            if(currNode.right!=null) q.offer(currNode.right);
        }
        return list;

    }
}
