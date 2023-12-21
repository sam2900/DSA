package PreorderTraversal.CodeStudio;

public class Iterative {
    public static void preOrder(BinaryTreeNode<Integer> root) {
        //Your code goes here
        //there are 2 ways to implement this 1 by using recursion and second by using stack
        //we will implement by using stack , iterative approach
        //here we don't need to return anything just print
        //first check if root is null or not
        if(root==null) return;
        //create stack
        Stack<BinaryTreeNode<Integer>> stk=new Stack<>();
        //we add the root into the stack and then run a while loop
        stk.push(root);
        while(!stk.isEmpty()){
            BinaryTreeNode<Integer> top=stk.pop();
            System.out.print(top.data + " ");
            if(top.right!=null) stk.push(top.right);
            if(top.left!=null) stk.push(top.left);
        }
    }

}
