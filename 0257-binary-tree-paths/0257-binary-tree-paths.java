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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        if(root == null) return ans;

        helper(root, "", ans);

        return ans;
    }

    public void helper(TreeNode root, String path, List<String> ans){
        path += Integer.toString(root.val);

        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }

        path += "->";

        if(root.left != null) helper(root.left, path, ans);
        if(root.right != null) helper(root.right, path, ans);
    }
}