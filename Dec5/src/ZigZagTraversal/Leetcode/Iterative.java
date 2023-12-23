package ZigZagTraversal.Leetcode;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Iterative {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> pendingNodes=new LinkedList<>();
        List<Integer> list;
        if(root==null) return ans;
        pendingNodes.offer(root);
        int level=0;
        while(!pendingNodes.isEmpty()){
            list=new ArrayList<>();
            int size=pendingNodes.size();
            for(int i=0;i<size;i++){
                TreeNode currNode=pendingNodes.poll();
                list.add(currNode.val);
                if(currNode.left!=null) pendingNodes.offer(currNode.left);
                if(currNode.right!=null) pendingNodes.offer(currNode.right);
            }
            if(level%2!=0) Collections.reverse(list);
            level++;
            ans.add(list);
        }
        return ans;
    }
}
