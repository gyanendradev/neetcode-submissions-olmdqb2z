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
    public int maxAns = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return this.maxAns;
    }
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left + right > this.maxAns){
            this.maxAns = left + right;
        }
        return 1 + Math.max(left, right);
    }
}
