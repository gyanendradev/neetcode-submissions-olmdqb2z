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
    Integer maxAns = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        searchDeep(root, 1);
        return maxAns;        
    }
    public void searchDeep(TreeNode node, int curr){
        if(curr > maxAns){
            maxAns = curr;
        }
        if(node.left != null){
            searchDeep(node.left, curr+1);
        }
        if(node.right != null){
            searchDeep(node.right, curr+1);
        }
    }
}
