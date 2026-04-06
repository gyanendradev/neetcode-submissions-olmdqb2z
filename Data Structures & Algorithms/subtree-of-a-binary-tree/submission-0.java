/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean ans = false;
        boolean result1 = false;
        boolean result2 = false;
        boolean result3 = false;
        if(root != null){
            result1 = isSameTree(root, subRoot);
        }
        if(root.left != null){
            result2 = isSameTree(root.left, subRoot) || isSubtree(root.left, subRoot);
        }
        if(root.right != null){
            result3 = isSameTree(root.right, subRoot) || isSubtree(root.right, subRoot);
        }
        return result1 || result2 || result3;
    }
    public boolean isSameTree(TreeNode tree1, TreeNode tree2){
        if((tree1 == null && tree2 == null)){
            return true;
        }
        if((tree1 != null && tree2 == null) || (tree2 != null && tree1 == null) ){
            return false;
        }
        if(tree1.val != tree2.val){
            return false;
        }else{
            return isSameTree(tree1.left,tree2.left) && isSameTree(tree1.right, tree2.right);
        }

    }
}
