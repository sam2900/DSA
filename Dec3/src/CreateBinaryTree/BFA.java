package CreateBinaryTree;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BFA {
    public static Node createTree(int[] arr){
        //we will perform a bfs/level order traversal
        //since we are given an array and we need to create a bt from it

        Queue<Node> pendingNodes=new LinkedList<>();
        //the queue will be used to store the nodes for which we haven't connected the childrens
        //now first we create the root node, present at the 0th index
        Node root=new Node(arr[0]);
        //now we will put it into the q and run the bfs traversal
        pendingNodes.offer(root);
        //also for indices, we need to maintain an i variable
        int i=0;
        while(!pendingNodes.isEmpty()){
            Node currNode=pendingNodes.poll();
            //extract the front node, get its left and right child using formula
            Node left=new Node(arr[2*i+1]);
            Node right=new Node(arr[2*i+2]);
            //these will give left and right child, now connect them and put into q
            currNode.left=left;
            currNode.right=right;
            pendingNodes.offer(left);
            pendingNodes.offer(right);
            //now increase the pointer i
            i++;
        }
        return root;
    }
}

/**
 * basically here we use bfs/level order traversal
 * we are given an array of 7 elements and from that we need to make a binary tree
 * the concept we use is learnt from Rouf sir and heaps concept
 * that in an array, if a node root is present at ith index, then its left and right children
 * are available at 2*i+1 and 2*i+2 indices respectively
 *
 * so we create a queue for bft and then add the root and for indices we create
 * a variable i
 * for a particular front node in q
 * we use i to get the left and right child
 * then increment the i
 *
 */
