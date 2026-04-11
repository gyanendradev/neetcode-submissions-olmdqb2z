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
    public int ans = -1;
    public int kth;
    public int kthSmallest(TreeNode root, int k) {
        this.kth = k;
        dfs(root, k);
        return this.ans;
    }
    public void dfs(TreeNode node, int k){
        if(node == null){
            return;
        }
        dfs(node.left, this.kth);
        this.kth -= 1;
        if(this.kth == 0){
            this.ans = node.val;
            return ;
        }
        dfs(node.right, this.kth);
    }
}
