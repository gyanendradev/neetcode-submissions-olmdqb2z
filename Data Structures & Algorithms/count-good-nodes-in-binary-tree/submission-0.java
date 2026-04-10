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
    public int totalGoodNodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, root.val);
        return totalGoodNodes;
    }
    public void dfs(TreeNode node, int maxTillNow){
        if(node == null){
            return;
        }
        if(node.val >= maxTillNow){
            this.totalGoodNodes += 1;
        }
        dfs(node.left, Math.max(node.val, maxTillNow));
        dfs(node.right, Math.max(node.val, maxTillNow));
    }
}
