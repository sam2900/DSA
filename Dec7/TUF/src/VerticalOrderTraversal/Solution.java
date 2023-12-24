/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //to solve this, we need a map, for verticals (x values), which maps to the levels for that particular vertical
        //and store the nodes values in sorted order
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> verticals=new TreeMap<>();
        //this is like x->y->values
        //now for each node, we need 3 things, its value and its x,y
        //so we create a q of type node, and store this information
        Queue<Node> q=new LinkedList<>();
        //now we add the root first
        q.offer(new Node(root,0,0));
        //now we run a while loop
        while(!q.isEmpty()){
            Node front=q.poll();
            TreeNode currNode=front.node;
            int x=front.vertical;
            int y=front.level;
            //now we check whether we have this particular vertical/x coord in the map or not
            if(!verticals.containsKey(x)){
                verticals.put(x,new TreeMap<>());
            }
            //now check if the particular vertical has the level or not
            if(!verticals.get(x).containsKey(y)){
                verticals.get(x).put(y,new PriorityQueue<>());
            }
            //now in the verticals map, we have the current vertical with its level and the pq to store values
            verticals.get(x).get(y).offer(currNode.val);
            //now the same manner, we add the left and right nodes into the q
            if(currNode.left!=null) q.offer(new Node(currNode.left,x-1,y+1));
            if(currNode.right!=null) q.offer(new Node(currNode.right,x+1,y+1));
        }

        //now the verticals map, contains the ans, so we now create a list of lists
        List<List<Integer>> ans=new ArrayList<>();
        //now we traverse each vertical, and for each vertical, we traverse its levels, and add the nodes
        for(TreeMap<Integer,PriorityQueue<Integer>> levels:verticals.values()){
            //now we have the levels for a particular vertical in increasing order
            //and each level will have its own pq, and we need to add all of them to a single list, individual to a level
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq:levels.values()){
                //here the levels will give us different pqs, of each level for a particular vertical
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }
        return ans;
    }
}

class Node{
    TreeNode node;
    int vertical;
    int level;

    public Node(TreeNode node,int vertical,int level){
        this.node=node;
        this.vertical=vertical;
        this.level=level;
    }
}

