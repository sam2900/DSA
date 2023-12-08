import javax.swing.tree.TreeNode;

public class OA {
    public String tree2str(TreeNode root) {
        StringBuilder str=new StringBuilder();

        dfs(root,str);
        return str.toString();
    }
    public void dfs(TreeNode root, StringBuilder str){
        if(root==null) return;
        str.append(root.val);
        if(root.left==null && root.right==null){
            return;
        }
        str.append("(");
        dfs(root.left,str);
        str.append(")");
        if(root.right!=null){
            str.append("(");
            dfs(root.right,str);
            str.append(")");
        }

    }
    //here what we do is simply maintain a string (stringBuilder) and do the DFS traversal
    //we first add the root and then check if its a leaf or not, if yes return else
    //according to question, if the node is not leaf, then we need to have parenthesis for left node
    //either with data if exists or empty if not exist, right parenthesis can be omitted

}
