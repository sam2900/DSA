package BoundaryTraversal;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


public class CodeStudio {
        public static List<Integer> traverseBoundary(TreeNode root){
            // Write your code here.
            List<Integer> ans= new ArrayList<>();
            ans.add(root.data);
            leftBoundary(root, ans);
            addLeafs(root, ans);
            rightBoundary(root, ans);
            return ans;
        }

        public static boolean isLeaf(TreeNode root){
            return root.left==null && root.right==null;
        }
        public static void leftBoundary(TreeNode root, List<Integer> ans){
            root=root.left;
            while(root!=null){
                //check if its leaf or not
                if(!isLeaf(root)) ans.add(root.data);
                //check if it has a left child or not
                if(root.left!=null) {
                    root=root.left;
                }else {
                    root=root.right;
                }
            }
        }

        public static void addLeafs(TreeNode root, List<Integer> ans){
            //first we check whether root is a leaf or not
            if(isLeaf(root)){
                ans.add(root.data);
                return;
            }
            //call on left and right
            if(root.left!=null) addLeafs(root.left, ans);
            if(root.right!=null) addLeafs(root.right, ans);
        }

        public static void rightBoundary(TreeNode root, List<Integer> ans){
            List<Integer> temp = new ArrayList<>();
            //we make root point to its right
            root=root.right;
            //now we run a while loop till its not null
            while(root!=null){
                //now we first check if its not null then add it to list, else make it point to right then left
                if(!isLeaf(root)) temp.add(root.data);
                if(root.right!=null){
                    root=root.right;
                }else{
                    root=root.left;
                }
            }
            for(int i=temp.size()-1;i>=0;i--){
                ans.add(temp.get(i));
            }
        }

}
