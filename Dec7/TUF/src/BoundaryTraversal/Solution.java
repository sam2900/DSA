import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        //basically here we divide the problem into 3 parts
        //left boundary, all leafs and right boundary
        //now we need a universal list, with root init as to avoid confusion from the boundary traversals
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        //add the root
        list.add(root.data);
        //now we need to get the left boundary first
        leftBoundary(root,list);
        //now we need to get the leaf nodes
        getLeafs(root,list);
        //now the right boundary in reverse fashion
        rightBoundary(root,list);
        return list;
    }

    //first we write a function which will return a boolean, whether the curr node is leaf or not
    public static boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    //now we write the function for leftBoundary
    public static void leftBoundary(TreeNode root,List<Integer> list){
        if(root==null) return;
        //now we need to start from the left child, so make curr point to left
        TreeNode curr=root.left;
        //now while curr is not equal to null we keep on traversing in the dfs fashion for left childs
        while(curr!=null){
            //check if curr is a leaf node or not, if not add it into the list
            //we ignore leaf nodes, because they are considered in another function
            if(!isLeaf(curr)){
                list.add(curr.data);
            }
            //check if curr has a left child then move left or move right only if it doesn't
            if(curr.left!=null){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
    }
    //now we write function for aadding all the leaf nodes, in preorder fashion
    public static void getLeafs(TreeNode root,List<Integer> list){
        if(root==null) return;
        //check if curr node is leaf or not, if it is, add it into the leaf
        if(isLeaf(root)){
            list.add(root.data);
            //now since it is a leaf, then it wont have any left or right child so we return
            return;
        }
        if(root.left!=null) getLeafs(root.left, list);
        if(root.right!=null) getLeafs(root.right, list);

    }

    //now we write the function for right boundary 
    public static void rightBoundary(TreeNode root,List<Integer> list){
        if(root==null) return;
        //make curr point to right child
        TreeNode curr=root.right;
        //create a stack, as we want the traversal in reverse order
        Stack<Integer> stk=new Stack<>();
        //run a while loop until curr is not null
        while(curr!=null){
            //if curr is not a leaf add it into the stack
            if(!isLeaf(curr)){
                stk.push(curr.data);
            }
            //if curr's right is not null we move right, else left
            if(curr.right!=null){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }

        //now we need to add the traversal in reverse order
        while(!stk.isEmpty()){
            list.add(stk.pop());
        }
    }
}
