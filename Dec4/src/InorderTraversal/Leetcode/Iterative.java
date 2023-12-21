package InorderTraversal.Leetcode;

public class Iterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        //first we create a stack and a list
        Stack<TreeNode> stk=new Stack<>();
        List<Integer> list=new ArrayList<>();

        //now wwe will run a infinite loop
        while(true){
            //we check if root is null or not
            if(root!=null){
                //we add it into the stack and move left, since we need left first
                stk.push(root);
                root=root.left;
            }else{
                //now root is null, so this has 2 possibility
                //1 if the stack is empty, then there is no node left to visit so we can return the ans
                if(stk.isEmpty()) return list;
                //if root is null and the stack is not empty then we need to move to the parent/root
                TreeNode top=stk.pop();
                list.add(top.val);
                //now make the pointer move to the right of the root/parent node
                root=top.right;
            }
        }
        // return list;
    }
}

/**
 * approach is, we create a stack and a list, and we don't add a null check as that is added as the break point
 * for the infinite loop
 * after creation we run an infinite loop and check if root is null or not, if not, we add the current node into the stack
 * and move to left side, we keep on moving on the left until we reach the leaf's node left null
 * when we see null, we move to else part, there we check if stack is not empty, then the top most element in the stack
 * will be the parent of the current null, which is the left most leaf node
 * so we add it into the list/print it and then move right from there

 * if the stack is empty in the else part, this means we have visited all the nodes from left to right and now
 * currently we are at the right most null of the right leaf node
 * so we return
 */
/**
 here also we have 2 ways 1 is recursion 2 is stack (iterative)
 we will use the iterative approach
 * here what we do is create a list and a stack to store the treeNode,
 * then we run a while loop(true), here we check if the root is null or not, if no,
 * then we add the root and move to its left child, when we encounter a null,
 * then we move back to the parent, add it into the list,
 * and then again start traversing to the right of it and repeat the steps
 */

//recursive approach is same as we  have learned