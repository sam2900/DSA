package PostorderTraversal.Leetcode;

public class TwoStacks {
    public List<Integer> postorderTraversal(TreeNode root) {
        //first we create a list
        List<Integer> list=new ArrayList<>();
        //check if root is null return the empty list
        if(root==null) return list;
        //else create 2 stacks, for postOrder
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        //now in stack1 we add the root node and run a while loop
        //in while loop we take the top element of stack 1 and push it into stack 2
        //and go to left and right child and add it into stack 1
        //this way, in stack 1 the elements will be root,left,right
        //in stack 2 -> root,right,left
        //so on poping stack 2 we get post order traversal
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode top=s1.pop();
            s2.push(top);
            if(top.left!=null) s1.push(top.left);
            if(top.right!=null) s1.push(top.right);
        }
        while(!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;
    }
}
