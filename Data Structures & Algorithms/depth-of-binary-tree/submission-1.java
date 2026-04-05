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
    public int maxDepth(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        int ans = 0;
        if(root == null){
            return 0;
        }
        queue.add(root);
        while(queue.size() > 0){
            ans += 1;
            int n = queue.size();
            for(int i = 0 ; i < n; i++){
                TreeNode node = queue.remove(0);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }
}
