package PreorderTraversal.Leetcode;

public class Iterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        //first we create a list
        List<Integer> list=new ArrayList<>();
        //now we check if root is null then return the empty list
        if(root==null) return list;
        //else create a stack of type TreeNode and add the root node, since it is not null
        Stack<TreeNode> stk=new Stack<>();
        stk.push(root);
        //now this is preOrder, so we need the root first, then left child and right child
        //now we run a while loop till it is not empty
        //its same as q while its not empty, which indicates untill we have visited all the nodes
        while(!stk.isEmpty()){
            //we take out the topmost element, which will be root at 1st iteration
            //and put it into the list, or print it
            TreeNode top=stk.pop();
            list.add(top.val);
            //now we need left child first and right child later, and stack works in LIFO fashion
            //so we need to push right first then left
            if(top.right!=null) stk.push(top.right);
            if(top.left!=null) stk.push(top.left);
        }
        return list;
        //this way in stack, on poping we will get the result in preOrder fashion
    }
}
