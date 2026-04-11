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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean dfs(TreeNode node, Integer leftMax, Integer rightMax){
        if(node == null){
            return true;
        }
        boolean left = false;
        boolean right = false;
        if((node.val <= leftMax) ||(node.val >= rightMax)){
            return false;
        }
        left = dfs(node.left, leftMax, node.val);
        right = dfs(node.right, node.val, rightMax);
        return left && right;
    }
}
