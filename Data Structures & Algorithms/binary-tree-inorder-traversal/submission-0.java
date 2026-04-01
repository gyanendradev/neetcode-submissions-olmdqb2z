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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<TreeNode> remaining = new ArrayList<>();
        if(root == null){
            return ans;
        }
        findleft(root, ans);
        return ans;
    }
    public void findleft(TreeNode node, ArrayList ans){
        if(node.left != null){
            findleft(node.left, ans);
        }
        ans.add(node.val);
        if(node.right != null){
            findleft(node.right, ans);
        }
    }
}