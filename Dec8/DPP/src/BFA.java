import javax.swing.tree.TreeNode;

public class BFA {
    public String tree2str(TreeNode root) {
        return helper(root);
    }
    public String helper(TreeNode root){
        if(root==null) return "";
        String left=helper(root.left);
        String right=helper(root.right);
        String s="" + root.val;
        if(root.left==null && root.right==null){
            return s;
        }
        if(root.left==null && root.right!=null){
            s=s+"()"+"("+right+")";
            return s;
        }
        if(root.left !=null && root.right==null){
            return s +"(" +left+")";
        }
        return s+ "(" + left + ")" + "(" +right + ")";
    }
}
