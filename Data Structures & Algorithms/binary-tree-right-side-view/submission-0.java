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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        queue.add(root);
        while(queue.size() > 0){
            int n = queue.size();
            int last = 0;
            for(int i = 0; i< n; i++){
                TreeNode node = queue.remove(0);
                if(node.left != null ){
                    queue.add(node.left);
                }
                if(node.right != null ){
                    queue.add(node.right);
                }
                last = node.val;
            }
            ans.add(last);
        }
        return ans;
    }
}
