package VerticalOrderTraversal;

import javax.swing.tree.TreeNode;
import java.util.*;

public class TUF {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //now we first need to maintain a TreeMap to store vertical, then level and node values in sorted order
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        //now we need a q to store the node as we will be doing the level order traversal
        Queue<Tuple> pendingNodes=new LinkedList<>();
        //we first add the root node with vertical=0,level=0 and the node value
        pendingNodes.offer(new Tuple(root,0,0));
        //now we do the bft
        while(!pendingNodes.isEmpty()){
            Tuple front=pendingNodes.poll();
            TreeNode node=front.node;
            int x=front.x;
            int y=front.y;
            //now we check whether our map contains the vertical x or not, if not add it
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            //now we check if the map contains the level y for vertical x or not, if not add it
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<Integer>());
            }
            //now we need to just add the value of node at the vertical and the level
            map.get(x).get(y).offer(node.val);
            //now we just visit the left and right
            //for left x=x-1 and y=y+1 && for right x=x+1 and y=y+1
            if(node.left!=null) pendingNodes.add(new Tuple(node.left,x-1,y+1));
            if(node.right!=null) pendingNodes.add(new Tuple(node.right,x+1,y+1));
        }
        //now our map contains the ans
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> levels:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:levels.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                    //add the shortest value of pq in the current level of the list
                }
            }
        }
        return ans;
    }


//since for every node we need 3 things, the node, the x(vertical) and the y(level)
class Tuple{
    TreeNode node;
    int x;
    int y;

    public Tuple(TreeNode node, int x, int y){
        this.node=node;
        this.x=x;
        this.y=y;
    }
}
}
