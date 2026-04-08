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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        if(root == null){
            return ans;
        }
        queue.add(root);
        while(queue.size() > 0){
            int n = queue.size();
            ArrayList<Integer> subAns = new ArrayList<Integer>();
            for(int i =0; i<n ; i++){
                TreeNode node = queue.remove(0);
                subAns.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(subAns);
        }
        return ans;
    }
}
