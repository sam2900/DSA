package ZigZagTraversal.Leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursive {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //this time we will use recursive approach of level order traversal
        //this can be used only when we need to represent a list of levels
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        //call recursion with root, list, and level
        helper(root,list,0);
        //now for the list at each odd index we need to reverse the list
        for(int i=0;i<list.size();i++){
            if(i%2!=0){
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }
    public void helper(TreeNode root, List<List<Integer>> list, int level){
        if(root==null) return;
        //now we need to check the size, basically here the index of list is the list for the level
        //so if size==level then we need that level to be as index, so we add a new list into the main list
        if(list.size()==level){
            list.add(new ArrayList<>());
        }
        //now at the level index we add the current node and call on left and right with level+1;
        list.get(level).add(root.val);
        helper(root.left,list,level+1);
        helper(root.right,list,level+1);
    }
}
