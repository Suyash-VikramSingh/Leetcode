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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(root, targetSum, ans, new ArrayList<>());

        return ans;
    }

    public void helper(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path){
        if(root == null) return;

        path.add(root.val);

        if(root.left == null && root.right == null){
            if(targetSum == root.val) {
                ans.add(new ArrayList(path));
            }
            return;
        }

        if(root.left != null) {
            helper(root.left, targetSum - root.val, ans, path);
            path.remove(path.size() - 1);
        }
        if(root.right != null) {
            helper(root.right, targetSum - root.val, ans, path);
            path.remove(path.size() - 1);
        }
    }
}