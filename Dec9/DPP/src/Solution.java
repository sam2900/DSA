import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //this is implemented using stacks
        //here we create a stack and a list
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stk=new Stack<>();
        //now we run a infinite loop
        while(true){
            //within loop we check whether the root node is null or not
            if(root!=null){
                //if not, we push the root and move to left, as in inorder left is visited then root then right
                stk.push(root);
                root=root.left;
            }else{
                //if root is null then there are 2 things either the stk is empty or it does not have a left child
                if(stk.isEmpty()) return ans;
                TreeNode top=stk.pop();
                ans.add(top.val);
                //move to right;
                root=top.right;
            }
        }

    }

}
